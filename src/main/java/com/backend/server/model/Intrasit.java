package com.backend.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Intrasit")
public class Intrasit {
    @Id
    private String id;
    private String productId;
    private String productCode;
    private String toLocation;
    private String fromLocation;
    private String productWeight;
    private String challanNumber;
    private String driverContact;
    private String dateOfLoading;
    private String dateCreated;
    private String description;

    public Intrasit() {
    }

    public Intrasit(String id, String productId, String productCode, String toLocation, String fromLocation, String productWeight, String challanNumber, String driverContact, String dateOfLoading, String dateCreated, String description) {
        this.id = id;
        this.productId = productId;
        this.productCode = productCode;
        this.toLocation = toLocation;
        this.fromLocation = fromLocation;
        this.productWeight = productWeight;
        this.challanNumber = challanNumber;
        this.driverContact = driverContact;
        this.dateOfLoading = dateOfLoading;
        this.dateCreated = dateCreated;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getToLocation() {
        return toLocation;
    }

    public void setToLocation(String toLocation) {
        this.toLocation = toLocation;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(String fromLocation) {
        this.fromLocation = fromLocation;
    }

    public String getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(String productWeight) {
        this.productWeight = productWeight;
    }

    public String getChallanNumber() {
        return challanNumber;
    }

    public void setChallanNumber(String challanNumber) {
        this.challanNumber = challanNumber;
    }

    public String getDriverContact() {
        return driverContact;
    }

    public void setDriverContact(String driverContact) {
        this.driverContact = driverContact;
    }

    public String getDateOfLoading() {
        return dateOfLoading;
    }

    public void setDateOfLoading(String dateOfLoading) {
        this.dateOfLoading = dateOfLoading;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
