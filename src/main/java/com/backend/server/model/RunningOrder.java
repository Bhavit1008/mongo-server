package com.backend.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Runningorder")
public class RunningOrder {
    @Id
    private String id;

    private String productCategory;

    private String partyName;

    private String productCode;

    private String productDescription;

    private String size;

    private String quantity;

    private String dispatchedQuantty;

    private String leftQuantity;

    private String status;

    public RunningOrder() {
    }

    public RunningOrder(String id, String productCategory, String partyName, String productCode, String productDescription, String size, String quantity, String dispatchedQuantty, String leftQuantity, String status) {
        this.id = id;
        this.productCategory = productCategory;
        this.partyName = partyName;
        this.productCode = productCode;
        this.productDescription = productDescription;
        this.size = size;
        this.quantity = quantity;
        this.dispatchedQuantty = dispatchedQuantty;
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

    public String getDispatchedQuantty() {
        return dispatchedQuantty;
    }

    public void setDispatchedQuantty(String dispatchedQuantty) {
        this.dispatchedQuantty = dispatchedQuantty;
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
