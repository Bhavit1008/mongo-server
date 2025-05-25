package com.backend.server.model;

public class SlabPieces {
    private int id;
    private float length;
    private float width;
    private float lessLength;
    private float lessWidth;
    private float totalArea;
    private String remark;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public float getLength() { return length; }
    public void setLength(float length) { this.length = length; }

    public float getWidth() { return width; }
    public void setWidth(float height) { this.width = height; }

    public float getLessLength() { return lessLength; }
    public void setLessLength(float lessLength) { this.lessLength = lessLength; }

    public float getLessWidth() { return lessWidth; }
    public void setLessWidth(float lessWidth) { this.lessWidth = lessWidth; }

    public float getTotalArea() { return totalArea; }
    public void setTotalArea(float totalArea) { this.totalArea = totalArea; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
}