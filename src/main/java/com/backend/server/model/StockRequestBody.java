package com.backend.server.model;

public class StockRequestBody {

    private String category;
    private String startDate;
    private String endDate;

    public StockRequestBody() {
    }

    public StockRequestBody(String category, String startDate, String endDate) {
        this.category = category;
        this.startDate = startDate;
        this.endDate = endDate;
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
}
