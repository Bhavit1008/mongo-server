package com.backend.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Slab")
public class Block {
    @Id
    private String id;
    private String productCode;
    private String productLength;
    private String productWidth;
    private String productHeight;
    private String productWeight;
    private String remarks;

    public Block() {
    }

    public Block(String id, String productCode, String productLength, String productWidth, String productHeight, String productWeight, String remarks) {
        this.id = id;
        this.productCode = productCode;
        this.productLength = productLength;
        this.productWidth = productWidth;
        this.productHeight = productHeight;
        this.productWeight = productWeight;
        this.remarks = remarks;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductLength() {
        return productLength;
    }

    public void setProductLength(String productLength) {
        this.productLength = productLength;
    }

    public String getProductWidth() {
        return productWidth;
    }

    public void setProductWidth(String productWidth) {
        this.productWidth = productWidth;
    }

    public String getProductHeight() {
        return productHeight;
    }

    public void setProductHeight(String productHeight) {
        this.productHeight = productHeight;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}

