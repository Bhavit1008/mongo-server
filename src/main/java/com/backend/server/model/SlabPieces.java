package com.backend.server.model;

public class SlabPieces {
    private int id;
    private float length;
    private float width;
    private float lessLength;
    private float lessWidth;
    private float totalArea;
    private boolean editable = true;
    private String remark;
    private String imageBase64;
    private String imageUrl;

    // Sold-recheck fields — set only when this piece goes through the Sold Slab Details form.
    private boolean sold = false;
    private float recheckedLength;
    private float recheckedWidth;
    private float recheckedTotalArea;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public float getLength() { return length; }
    public void setLength(float length) { this.length = length; }

    public float getWidth() { return width; }
    public void setWidth(float width) { this.width = width; }

    public float getLessLength() { return lessLength; }
    public void setLessLength(float lessLength) { this.lessLength = lessLength; }

    public float getLessWidth() { return lessWidth; }
    public void setLessWidth(float lessWidth) { this.lessWidth = lessWidth; }

    public float getTotalArea() { return totalArea; }
    public void setTotalArea(float totalArea) { this.totalArea = totalArea; }

    public boolean isEditable() { return editable; }
    public void setEditable(boolean editable) { this.editable = editable; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }

    public String getImageBase64() { return imageBase64; }
    public void setImageBase64(String imageBase64) { this.imageBase64 = imageBase64; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public boolean isSold() { return sold; }
    public void setSold(boolean sold) { this.sold = sold; }

    public float getRecheckedLength() { return recheckedLength; }
    public void setRecheckedLength(float recheckedLength) { this.recheckedLength = recheckedLength; }

    public float getRecheckedWidth() { return recheckedWidth; }
    public void setRecheckedWidth(float recheckedWidth) { this.recheckedWidth = recheckedWidth; }

    public float getRecheckedTotalArea() { return recheckedTotalArea; }
    public void setRecheckedTotalArea(float recheckedTotalArea) { this.recheckedTotalArea = recheckedTotalArea; }
}