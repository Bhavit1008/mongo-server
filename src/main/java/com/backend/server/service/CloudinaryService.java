package com.backend.server.service;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

@Service
public class CloudinaryService {

    @Autowired
    private Cloudinary cloudinary;

    /**
     * Upload a MultipartFile (used by the existing /upload-image endpoint).
     */
    public String uploadImage(MultipartFile file) {
        try {
            Map<?, ?> uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap());
            return (String) uploadResult.get("secure_url");
        } catch (IOException e) {
            throw new RuntimeException("Image upload failed", e);
        }
    }

    /**
     * Upload a base64 data-URL string (e.g. "data:image/jpeg;base64,/9j/4AAQ...")
     * directly to Cloudinary and return the secure URL.
     * Used for slab-piece images that arrive inside the Product JSON.
     */
    public String uploadBase64Image(String base64DataUrl) {
        try {
            Map<?, ?> uploadResult = cloudinary.uploader().upload(
                    base64DataUrl,
                    ObjectUtils.asMap("resource_type", "image")
            );
            return (String) uploadResult.get("secure_url");
        } catch (IOException e) {
            throw new RuntimeException("Base64 image upload failed", e);
        }
    }

    /**
     * Delete an image from Cloudinary by its secure URL.
     * Extracts the public_id from a URL like:
     *   https://res.cloudinary.com/<cloud>/image/upload/v1234567890/abcdef.jpg
     * The public_id is the segment after the last '/' without the file extension.
     */
    public boolean deleteImage(String imageUrl) {
        if (imageUrl == null || imageUrl.isBlank()) return false;
        try {
            String publicId = extractPublicId(imageUrl);
            Map<?, ?> result = cloudinary.uploader().destroy(publicId, ObjectUtils.emptyMap());
            return "ok".equals(result.get("result"));
        } catch (Exception e) {
            // Log but don't throw — deletion failure shouldn't block the main operation
            System.err.println("Cloudinary delete failed for: " + imageUrl + " — " + e.getMessage());
            return false;
        }
    }

    /**
     * Extracts the Cloudinary public_id from a secure_url.
     * Example input:  https://res.cloudinary.com/demo/image/upload/v1234567890/sample.jpg
     * Example output: sample
     *
     * If the image is inside a folder the public_id includes the folder path:
     *   .../upload/v123/folder/sub/image.png  →  folder/sub/image
     */
    private String extractPublicId(String url) {
        // Strip query params if any
        int queryIdx = url.indexOf('?');
        if (queryIdx != -1) url = url.substring(0, queryIdx);

        // Find "/upload/" or "/image/upload/" segment
        String marker = "/upload/";
        int uploadIdx = url.lastIndexOf(marker);
        if (uploadIdx == -1) {
            throw new IllegalArgumentException("Cannot extract public_id from URL: " + url);
        }

        // Everything after "/upload/" — may start with "v<digits>/"
        String tail = url.substring(uploadIdx + marker.length());

        // Strip version prefix (v1234567890/)
        if (tail.matches("^v\\d+/.*")) {
            tail = tail.substring(tail.indexOf('/') + 1);
        }

        // Remove file extension (.jpg, .png, .webp, etc.)
        int dotIdx = tail.lastIndexOf('.');
        if (dotIdx != -1) {
            tail = tail.substring(0, dotIdx);
        }

        return tail;
    }
}