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

    @Autowired
    private AuditLogService auditLogService;

    /**
     * Save or update a product.
     * Before persisting, upload any slab-piece images that arrive as base64
     * to Cloudinary and replace imageBase64 with the returned imageUrl.
     * Every save is recorded to the audit log (CREATE or UPDATE) — this is
     * the single choke point for all Block/Slab writes (manual edits, status
     * changes like Sold/Process, approvals), so hooking in here catches all
     * of them without duplicating the call at every call site.
     */
    public Product saveProduct(Product product, String performedBy) {
        validateUniqueCode(product);
        processSlabPieceImages(product);

        Product existing = product.getId() != null
                ? productRepository.findById(product.getId()).orElse(null)
                : null;

        assignCreatedAt(product, existing);
        Product saved = productRepository.save(product);

        recordAudit(existing == null ? "CREATE" : "UPDATE", existing, saved, performedBy);
        return saved;
    }

    /** Audit logging must never block or fail the actual save/delete. */
    private void recordAudit(String action, Product before, Product after, String performedBy) {
        try {
            auditLogService.recordProductChange(action, before, after, performedBy);
        } catch (Exception e) {
            System.err.println("Audit logging failed: " + e.getMessage());
        }
    }

    /**
     * Block Number (productCode, within Blocks) and Slab Number (slabNumber,
     * within Slabs) must each be unique within their own category — two
     * blocks can't share a block number, and two slabs can't share a slab
     * number, but a block and a slab may otherwise reuse the same string.
     * Blank values are exempt (slabNumber is optional) and a product is
     * always allowed to keep its own existing code when just being updated.
     */
    private void validateUniqueCode(Product product) {
        if ("Block".equalsIgnoreCase(product.getCategory())) {
            String code = product.getProductCode();
            if (code != null && !code.isBlank()
                    && productRepository.findByCategoryAndProductCode("Block", code).stream()
                            .anyMatch(p -> !p.getId().equals(product.getId()))) {
                throw new IllegalArgumentException("Block Number \"" + code + "\" is already in use by another block.");
            }
        } else if ("Slab".equalsIgnoreCase(product.getCategory())) {
            String slabNumber = product.getSlabNumber();
            if (slabNumber != null && !slabNumber.isBlank()
                    && productRepository.findByCategoryAndSlabNumber("Slab", slabNumber).stream()
                            .anyMatch(p -> !p.getId().equals(product.getId()))) {
                throw new IllegalArgumentException("Slab Number \"" + slabNumber + "\" is already in use by another slab.");
            }
        }
    }

    /**
     * Stamp createdAt once, on first insert, and keep it stable across later
     * status/detail updates (which re-post the full product via the same
     * upsert endpoint) so "recently added" ordering reflects creation time,
     * not last edit time.
     */
    private void assignCreatedAt(Product product, Product existing) {
        if (product.getCreatedAt() != null) return;

        Long existingCreatedAt = existing != null ? existing.getCreatedAt() : null;
        product.setCreatedAt(existingCreatedAt != null ? existingCreatedAt : System.currentTimeMillis());
    }

    /**
     * Delete a product by ID.
     * Cleans up the block-level image and every slab-piece image from Cloudinary.
     */
    public void deleteProduct(String productId, String performedBy) {
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
        recordAudit("DELETE", product, null, performedBy);
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