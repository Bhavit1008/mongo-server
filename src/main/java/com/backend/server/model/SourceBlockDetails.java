package com.backend.server.model;

import java.util.List;

/**
 * A frozen snapshot of the source block's own details, captured at the
 * moment it's converted into a slab. The conversion reuses the same
 * document id and overwrites every block-specific field (dimensions,
 * weight, photos) with the slab's own — without this snapshot, that data
 * would be unrecoverable once conversion is saved.
 */
public class SourceBlockDetails {
    private String blockCode;
    private String godownLocation;
    private String productQuality;
    private float productLength;
    private float productWidth;
    private float productHeight;
    private float productWeight;
    private String status;
    private String description;
    private String imageUrl;
    private List<String> imageUrls;
    private Long convertedAt;

    public String getBlockCode() { return blockCode; }
    public void setBlockCode(String blockCode) { this.blockCode = blockCode; }

    public String getGodownLocation() { return godownLocation; }
    public void setGodownLocation(String godownLocation) { this.godownLocation = godownLocation; }

    public String getProductQuality() { return productQuality; }
    public void setProductQuality(String productQuality) { this.productQuality = productQuality; }

    public float getProductLength() { return productLength; }
    public void setProductLength(float productLength) { this.productLength = productLength; }

    public float getProductWidth() { return productWidth; }
    public void setProductWidth(float productWidth) { this.productWidth = productWidth; }

    public float getProductHeight() { return productHeight; }
    public void setProductHeight(float productHeight) { this.productHeight = productHeight; }

    public float getProductWeight() { return productWeight; }
    public void setProductWeight(float productWeight) { this.productWeight = productWeight; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public List<String> getImageUrls() { return imageUrls; }
    public void setImageUrls(List<String> imageUrls) { this.imageUrls = imageUrls; }

    public Long getConvertedAt() { return convertedAt; }
    public void setConvertedAt(Long convertedAt) { this.convertedAt = convertedAt; }
}
