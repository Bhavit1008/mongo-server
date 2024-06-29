package com.backend.server.model;

public class SlabDetails {
    // { id: 1, size: '12*36', sqft: '3' }
    private String id;

    private String length;

    private String width;
    private String sqft;

    public SlabDetails() {
    }

    public SlabDetails(String id, String length, String width, String sqft) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.sqft = sqft;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSqft() {
        return sqft;
    }

    public void setSqft(String sqft) {
        this.sqft = sqft;
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
}
