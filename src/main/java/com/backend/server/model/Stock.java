package com.backend.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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
    private String productLocation;
    private String associatedManager;
    private String relatedParty;
    private String productImage;

    public Stock() {
    }

    public Stock(String id, String productCategory, String productCode, String companyAddress, String productQuantity, String dateOfStocking, String warehouse, String productLocation, String associatedManager, String relatedParty, String productImage) {
        this.id = id;
        this.productCategory = productCategory;
        this.productCode = productCode;
        this.productQuantity = productQuantity;
        this.dateOfStocking = dateOfStocking;
        this.warehouse = warehouse;
        this.productLocation = productLocation;
        this.associatedManager = associatedManager;
        this.relatedParty = relatedParty;
        this.productImage = productImage;
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

    public String getProductLocation() {
        return productLocation;
    }

    public void setProductLocation(String productLocation) {
        this.productLocation = productLocation;
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

}
