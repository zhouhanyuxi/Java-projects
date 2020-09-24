package com.ncu.clothwholesale.vo;

public class ProductVO {
	private String supplierCode;
	private String productName;
	private String  originalName;
	private String weight;
	private String width;
	private String ingredient;
	private String thickness;
	private String originalPrice;
	public ProductVO(){}
	
	public ProductVO(String supplierCode, String productName,
			String originalName, String weight, String width,
			String ingredient, String thickness, String originalPrice) {
		super();
		this.supplierCode = supplierCode;
		this.productName = productName;
		this.originalName = originalName;
		this.weight = weight;
		this.width = width;
		this.ingredient = ingredient;
		this.thickness = thickness;
		this.originalPrice = originalPrice;
	}

	public String getSupplierCode() {
		return supplierCode;
	}
	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getOriginalName() {
		return originalName;
	}
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getIngredient() {
		return ingredient;
	}
	public void setIngredient(String ingredient) {
		this.ingredient = ingredient;
	}
	public String getThickness() {
		return thickness;
	}
	public void setThickness(String thickness) {
		this.thickness = thickness;
	}
	public String getOriginalPrice() {
		return originalPrice;
	}
	public void setOriginalPrice(String originalPrice) {
		this.originalPrice = originalPrice;
	}
	
	
	
}
