package com.backend.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.server.model.Product;
import com.backend.server.model.SlabPieces;
import com.backend.server.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    /**
     * Save or update a product.
     * Before persisting, upload any slab-piece images that arrive as base64
     * to Cloudinary and replace imageBase64 with the returned imageUrl.
     */
    public Product saveProduct(Product product) {
        processSlabPieceImages(product);
        assignCreatedAt(product);
        return productRepository.save(product);
    }

    /**
     * Stamp createdAt once, on first insert, and keep it stable across later
     * status/detail updates (which re-post the full product via the same
     * upsert endpoint) so "recently added" ordering reflects creation time,
     * not last edit time.
     */
    private void assignCreatedAt(Product product) {
        if (product.getCreatedAt() != null) return;

        Long existingCreatedAt = product.getId() != null
                ? productRepository.findById(product.getId()).map(Product::getCreatedAt).orElse(null)
                : null;

        product.setCreatedAt(existingCreatedAt != null ? existingCreatedAt : System.currentTimeMillis());
    }

    /**
     * Delete a product by ID.
     * Cleans up the block-level image and every slab-piece image from Cloudinary.
     */
    public void deleteProduct(String productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found: " + productId));

        // Delete the block-level image from Cloudinary
        if (product.getImageUrl() != null && !product.getImageUrl().isBlank()) {
            cloudinaryService.deleteImage(product.getImageUrl());
        }

        // Delete every slab-piece image from Cloudinary
        if (product.getPieces() != null) {
            for (SlabPieces piece : product.getPieces()) {
                if (piece.getImageUrl() != null && !piece.getImageUrl().isBlank()) {
                    cloudinaryService.deleteImage(piece.getImageUrl());
                }
            }
        }

        productRepository.deleteById(productId);
    }

    /**
     * Iterate through slab pieces:
     *  - If a piece has imageBase64 (a data-URL), upload it to Cloudinary,
     *    set imageUrl to the returned secure_url, and clear imageBase64
     *    so we don't store the large base64 blob in MongoDB.
     *  - If a piece already has an imageUrl and no new imageBase64, leave it.
     */
    private void processSlabPieceImages(Product product) {
        List<SlabPieces> pieces = product.getPieces();
        if (pieces == null || pieces.isEmpty()) return;

        for (SlabPieces piece : pieces) {
            String base64 = piece.getImageBase64();

            if (base64 != null && !base64.isBlank()) {
                // If updating an existing slab that already had an image,
                // delete the old one from Cloudinary first
                if (piece.getImageUrl() != null && !piece.getImageUrl().isBlank()) {
                    cloudinaryService.deleteImage(piece.getImageUrl());
                }

                // Upload new image to Cloudinary
                String uploadedUrl = cloudinaryService.uploadBase64Image(base64);
                piece.setImageUrl(uploadedUrl);

                // Clear base64 so it doesn't bloat MongoDB
                piece.setImageBase64(null);
            }
        }
    }
}