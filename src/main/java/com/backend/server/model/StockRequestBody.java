package com.backend.server.model;

public class StockRequestBody {

    private String category;
    private String color;
    private String price;
    public StockRequestBody() {
    }

    public StockRequestBody(String category, String color, String price) {
        this.category = category;
        this.color = color;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
