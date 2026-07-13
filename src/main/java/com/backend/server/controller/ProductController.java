package com.backend.server.controller;

import java.util.List;

import com.backend.server.model.Intrasit;
import com.backend.server.repository.IntransitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.backend.server.model.Product;
import com.backend.server.repository.ProductRepository;
import com.backend.server.service.CloudinaryService;
import com.backend.server.service.ProductService;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    IntransitRepository intransitRepository;

    @Autowired
    private CloudinaryService cloudinaryService;

    @Autowired
    private ProductService productService;

    // ── Intransit ────────────────────────────────────────────────────────────

    @PostMapping("/addTransit")
    public ResponseEntity<?> addIntransit(@RequestBody Intrasit intrasit) {
        Intrasit intrasitObj = intransitRepository.save(intrasit);
        return new ResponseEntity<>(intrasitObj, HttpStatus.CREATED);
    }

    @PostMapping("/getIntansit")
    public ResponseEntity<?> getIntransit(@RequestBody Product product) {
        List<Intrasit> intrasitObj = intransitRepository.findAll();
        Intrasit intrasit = null;
        for (int i = 0; i < intrasitObj.size(); i++) {
            if (product.getId().equalsIgnoreCase(intrasitObj.get(i).getProductId())) {
                intrasit = intrasitObj.get(i);
            }
        }
        return new ResponseEntity<>(intrasit, HttpStatus.CREATED);
    }

    // ── Product CRUD ─────────────────────────────────────────────────────────

    /**
     * Save or update a product.
     * Now delegates to ProductService which handles slab-piece image uploads
     * to Cloudinary before persisting.
     */
    @PostMapping("/addProduct")
    public ResponseEntity<?> addOrder(@RequestBody Product product) {
        try {
            Product savedProduct = productService.saveProduct(product);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/getAllProducts")
    public List<Product> getBlocks() {
        return productRepository.findAll();
    }

    /**
     * Paginated product listing, newest-first, optionally scoped to a category
     * (e.g. "Block" or "Slab"). Powers the Block Inventory / Slab Inventory pages.
     */
    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getProducts(
            @RequestParam(required = false) String category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdAt"));
        Page<Product> result = (category == null || category.isBlank())
                ? productRepository.findAll(pageable)
                : productRepository.findByCategory(category, pageable);

        return ResponseEntity.ok(result);
    }

    /**
     * Delete a product by ID.
     * Removes the product from MongoDB and deletes all associated images
     * (block-level + slab-piece images) from Cloudinary.
     */
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.ok("Product deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // ── Image upload (block-level, kept for backward compat) ─────────────────

    @PostMapping("/upload-image")
    public ResponseEntity<String> uploadImage(@RequestParam("image") MultipartFile file) {
        String imageUrl = cloudinaryService.uploadImage(file);
        return ResponseEntity.ok(imageUrl);
    }

    // ── Internal use only ────────────────────────────────────────────────────

    @DeleteMapping("/deleteAllProducts")
    public void deleteAllProducts() {
        productRepository.deleteAll();
    }
}