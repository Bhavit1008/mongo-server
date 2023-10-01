package com.backend.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("CompanyDetails")
public class CompanyDetails {
    @Id
    private String id;

    private String companyName;

    private String companyOwnerName;

    private String companyAddress;

    private String state;

    private String zipCode;

    private String gstNumber;

    private String contactNumber;

    private String emailAddress;

    public CompanyDetails() {
    }

    public CompanyDetails(String id, String companyName, String companyOwnerName, String companyAddress, String state, String zipCode, String gstNumber, String contactNumber, String emailAddress) {
        this.id = id;
        this.companyName = companyName;
        this.companyOwnerName = companyOwnerName;
        this.companyAddress = companyAddress;
        this.state = state;
        this.zipCode = zipCode;
        this.gstNumber = gstNumber;
        this.contactNumber = contactNumber;
        this.emailAddress = emailAddress;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyOwnerName() {
        return companyOwnerName;
    }

    public void setCompanyOwnerName(String companyOwnerName) {
        this.companyOwnerName = companyOwnerName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
