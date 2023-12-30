package com.backend.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("User")
public class UserDetails {
    @Id
    private String id;
    private String phoneNumber;
    private String fullName;
    private String emailAddress;
    private String password;
    private String productCategory;
    private String designation;

    public UserDetails() {
    }

    public UserDetails(String id, String phoneNumber, String fullName, String emailAddress, String password, String productCategory, String designation) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.productCategory = productCategory;
        this.designation = designation;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
