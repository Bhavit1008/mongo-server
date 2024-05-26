package com.backend.server.model;

public class SlabDetails {
    // { id: 1, size: '12*36', sqft: '3' }
    private String id;
    private String size;
    private String sqft;

    public SlabDetails() {
    }

    public SlabDetails(String id, String size, String sqft) {
        this.id = id;
        this.size = size;
        this.sqft = sqft;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getSqft() {
        return sqft;
    }

    public void setSqft(String sqft) {
        this.sqft = sqft;
    }
}
