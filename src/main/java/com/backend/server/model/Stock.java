package com.backend.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("Stock")
public class Stock {
    @Id
    private String id;
    private String productCategory;

    private String product;

    private String quality;

    private String productDescription;

    private String productPolish;
    private String productCode;
    private String productQuantity;
    private String dateOfStocking;
    private String warehouse;
    private String productRate;
    private String associatedManager;
    private String relatedParty;

    private String color;
    private List<SlabDetails> slabDetails;

    private String productImage;

    public Stock() {
    }

    public Stock(String id, String productCategory, String product, String quality, String productDescription, String productPolish, String productCode, String productQuantity, String dateOfStocking, String warehouse, String productRate, String associatedManager, String relatedParty, String color, List<SlabDetails> slabDetails, String productImage) {
        this.id = id;
        this.productCategory = productCategory;
        this.product = product;
        this.quality = quality;
        this.productDescription = productDescription;
        this.productPolish = productPolish;
        this.productCode = productCode;
        this.productQuantity = productQuantity;
        this.dateOfStocking = dateOfStocking;
        this.warehouse = warehouse;
        this.productRate = productRate;
        this.associatedManager = associatedManager;
        this.relatedParty = relatedParty;
        this.color = color;
        this.slabDetails = slabDetails;
        this.productImage = productImage;
    }

    public List<SlabDetails> getSlabDetails() {
        return slabDetails;
    }

    public void setSlabDetails(List<SlabDetails> slabDetails) {
        this.slabDetails = slabDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getDateOfStocking() {
        return dateOfStocking;
    }

    public void setDateOfStocking(String dateOfStocking) {
        this.dateOfStocking = dateOfStocking;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public String getProductRate() {
        return productRate;
    }

    public void setProductRate(String productRate) {
        this.productRate = productRate;
    }

    public String getAssociatedManager() {
        return associatedManager;
    }

    public void setAssociatedManager(String associatedManager) {
        this.associatedManager = associatedManager;
    }

    public String getRelatedParty() {
        return relatedParty;
    }

    public void setRelatedParty(String relatedParty) {
        this.relatedParty = relatedParty;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPolish() {
        return productPolish;
    }

    public void setProductPolish(String productPolish) {
        this.productPolish = productPolish;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
