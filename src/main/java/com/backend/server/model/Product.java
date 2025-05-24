package com.backend.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Product")
public class Product {

	@Id
    private String id;
	private String category;
    private String productCode;
    private String location;
    private String productQuality;
    private String productFinished;
    private float length;
    private float height;
    private float thickness;
    private float width;
    private float weight;
    private int numberOfPeice;
    private int quantity;
    
    private double exFactoryCost;
    private double freightCost;
    private double miscellaneousCost;
    private double inHouseCost;
    private double sellingCost;
    private double royaltyCost;
    
    private String status;
    private String remarks;
    
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProductQuality() {
		return productQuality;
	}
	public void setProductQuality(String productQuality) {
		this.productQuality = productQuality;
	}
	public String getProductFinished() {
		return productFinished;
	}
	public void setProductFinished(String productFinished) {
		this.productFinished = productFinished;
	}
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getThickness() {
		return thickness;
	}
	public void setThickness(float thickness) {
		this.thickness = thickness;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public int getNumberOfPeice() {
		return numberOfPeice;
	}
	public void setNumberOfPeice(int numberOfPeice) {
		this.numberOfPeice = numberOfPeice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getExFactoryCost() {
		return exFactoryCost;
	}
	public void setExFactoryCost(double exFactoryCost) {
		this.exFactoryCost = exFactoryCost;
	}
	public double getFreightCost() {
		return freightCost;
	}
	public void setFreightCost(double freightCost) {
		this.freightCost = freightCost;
	}
	public double getMiscellaneousCost() {
		return miscellaneousCost;
	}
	public void setMiscellaneousCost(double miscellaneousCost) {
		this.miscellaneousCost = miscellaneousCost;
	}
	public double getInHouseCost() {
		return inHouseCost;
	}
	public void setInHouseCost(double inHouseCost) {
		this.inHouseCost = inHouseCost;
	}
	public double getSellingCost() {
		return sellingCost;
	}
	public void setSellingCost(double sellingCost) {
		this.sellingCost = sellingCost;
	}
	public double getRoyaltyCost() {
		return royaltyCost;
	}
	public void setRoyaltyCost(double royaltyCost) {
		this.royaltyCost = royaltyCost;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	} 
	
}
