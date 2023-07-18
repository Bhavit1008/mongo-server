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

    private String unit;

    private String length;

    private String width;

    private String height;

    private String quantity;

    private String quality;

    private String polish;

    private String shape;

    private String deliveryDate;

    private String color;

    private String creationDate;

    private String primaryManager;

    private String secondaryManager;

    private String developedQuantity;

    private String dispatchedQuantity;

    private String leftQuantity;

    private String status;

    public Order() {
    }

    public Order(String id, String productCategory, String partyName, String deliveryCity, String productCode, String productDescription, String unit, String length, String width, String height, String quantity, String quality, String polish, String shape, String deliveryDate, String color, String creationDate, String primaryManager, String secondaryManager, String developedQuantity, String dispatchedQuantity, String leftQuantity, String status) {
        this.id = id;
        this.productCategory = productCategory;
        this.partyName = partyName;
        this.deliveryCity = deliveryCity;
        this.productCode = productCode;
        this.productDescription = productDescription;
        this.unit = unit;
        this.length = length;
        this.width = width;
        this.height = height;
        this.quantity = quantity;
        this.quality = quality;
        this.polish = polish;
        this.shape = shape;
        this.deliveryDate = deliveryDate;
        this.color = color;
        this.creationDate = creationDate;
        this.primaryManager = primaryManager;
        this.secondaryManager = secondaryManager;
        this.developedQuantity = developedQuantity;
        this.dispatchedQuantity = dispatchedQuantity;
        this.leftQuantity = leftQuantity;
        this.status = status;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
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

    public String getDevelopedQuantity() {
        return developedQuantity;
    }

    public void setDevelopedQuantity(String developedQuantity) {
        this.developedQuantity = developedQuantity;
    }

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
}
