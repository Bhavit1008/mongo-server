package com.backend.server.model;

public class StockRequestBody {

    private String category;
    private String startDate;
    private String endDate;
    private String role;

    private String manager;

    public StockRequestBody() {
    }

    public StockRequestBody(String category, String startDate, String endDate) {
        this.category = category;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public StockRequestBody(String category, String startDate, String endDate, String role) {
        this.category = category;
        this.startDate = startDate;
        this.endDate = endDate;
        this.role = role;
    }

    public StockRequestBody(String category, String startDate, String endDate, String role, String manager) {
        this.category = category;
        this.startDate = startDate;
        this.endDate = endDate;
        this.role = role;
        this.manager = manager;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }
}
