package com.backend.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Product")
public class Product {

	@Id
    private String id;
	private String category;
    private String productCode;
    private String godownLocation;
    private String productQuality;
    private String productFinished;
    private float productLength;
    private float productHeight;
    private float productThickness;
    private float productWidth;
    private float productWeight;
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

	public Product() {
	}

	public Product(String id, String category, String productCode, String godownLocation, String productQuality, String productFinished, float productLength, float productHeight, float productThickness, float productWidth, float weight, int numberOfPeice, int quantity, double exFactoryCost, double freightCost, double miscellaneousCost, double inHouseCost, double sellingCost, double royaltyCost, String status, String remarks) {
		this.id = id;
		this.category = category;
		this.productCode = productCode;
		this.godownLocation = godownLocation;
		this.productQuality = productQuality;
		this.productFinished = productFinished;
		this.productLength = productLength;
		this.productHeight = productHeight;
		this.productThickness = productThickness;
		this.productWidth = productWidth;
		this.productWeight = weight;
		this.numberOfPeice = numberOfPeice;
		this.quantity = quantity;
		this.exFactoryCost = exFactoryCost;
		this.freightCost = freightCost;
		this.miscellaneousCost = miscellaneousCost;
		this.inHouseCost = inHouseCost;
		this.sellingCost = sellingCost;
		this.royaltyCost = royaltyCost;
		this.status = status;
		this.remarks = remarks;
	}

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
	public String getGodownLocation() {
		return godownLocation;
	}
	public void setGodownLocation(String godownLocation) {
		this.godownLocation = godownLocation;
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
	public float getProductLength() {
		return productLength;
	}
	public void setProductLength(float productLength) {
		this.productLength = productLength;
	}
	public float getProductHeight() {
		return productHeight;
	}
	public void setProductHeight(float productHeight) {
		this.productHeight = productHeight;
	}
	public float getProductThickness() {
		return productThickness;
	}
	public void setProductThickness(float productThickness) {
		this.productThickness = productThickness;
	}
	public float getProductWidth() {
		return productWidth;
	}
	public void setProductWidth(float productWidth) {
		this.productWidth = productWidth;
	}
	public float getProductWeight() {
		return productWeight;
	}
	public void setProductWeight(float productWeight) {
		this.productWeight = productWeight;
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
