package com.backend.server.model;

import jdk.jfr.DataAmount;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Order")
public class Order {
    @Id
    private String id;

    private String productCategory;

    private String partyName;

    private String deliveryCity;

    private String productCode;

    private String productDescription;

    private String size;

    private String quantity;

    private String quality;

    private String polish;

    private String shape;

    private String deliveryDate;

    private String color;

    private String creationDate;

    private String primaryManager;

    private String secondaryManager;

    private String dispatchedQuantity;

    private String leftQuantity;

    private String status;

    public String getDispatchedQuantity() {
        return dispatchedQuantity;
    }

    public void setDispatchedQuantity(String dispatchedQuantity) {
        this.dispatchedQuantity = dispatchedQuantity;
    }

    public String getLeftQuantity() {
        return leftQuantity;
    }

    public void setLeftQuantity(String leftQuantity) {
        this.leftQuantity = leftQuantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order(String id, String productCategory, String partyName, String deliveryCity, String productCode, String productDescription, String size, String quantity, String quality, String polish, String shape, String deliveryDate, String color, String creationDate, String primaryManager, String secondaryManager, String dispatchedQuantity, String leftQuantity, String status) {
        this.id = id;
        this.productCategory = productCategory;
        this.partyName = partyName;
        this.deliveryCity = deliveryCity;
        this.productCode = productCode;
        this.productDescription = productDescription;
        this.size = size;
        this.quantity = quantity;
        this.quality = quality;
        this.polish = polish;
        this.shape = shape;
        this.deliveryDate = deliveryDate;
        this.color = color;
        this.creationDate = creationDate;
        this.primaryManager = primaryManager;
        this.secondaryManager = secondaryManager;
        this.dispatchedQuantity = dispatchedQuantity;
        this.leftQuantity = leftQuantity;
        this.status = status;
    }

    public Order() {
    }

    public Order(String id, String productCategory, String partyName, String deliveryCity, String productCode, String productDescription, String size, String quantity, String quality, String polish, String shape, String deliveryDate, String color, String creationDate, String primaryManager, String secondaryManager) {
        this.id = id;
        this.productCategory = productCategory;
        this.partyName = partyName;
        this.deliveryCity = deliveryCity;
        this.productCode = productCode;
        this.productDescription = productDescription;
        this.size = size;
        this.quantity = quantity;
        this.quality = quality;
        this.polish = polish;
        this.shape = shape;
        this.deliveryDate = deliveryDate;
        this.color = color;
        this.creationDate = creationDate;
        this.primaryManager = primaryManager;
        this.secondaryManager = secondaryManager;
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

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public String getDeliveryCity() {
        return deliveryCity;
    }

    public void setDeliveryCity(String deliveryCity) {
        this.deliveryCity = deliveryCity;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getPolish() {
        return polish;
    }

    public void setPolish(String polish) {
        this.polish = polish;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getPrimaryManager() {
        return primaryManager;
    }

    public void setPrimaryManager(String primaryManager) {
        this.primaryManager = primaryManager;
    }

    public String getSecondaryManager() {
        return secondaryManager;
    }

    public void setSecondaryManager(String secondaryManager) {
        this.secondaryManager = secondaryManager;
    }
}
