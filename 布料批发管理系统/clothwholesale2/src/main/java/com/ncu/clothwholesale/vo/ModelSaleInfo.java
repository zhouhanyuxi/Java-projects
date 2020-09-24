package com.ncu.clothwholesale.vo;

public class ModelSaleInfo {
	private String modelCode;
	private String modelName;
	private String productName;
	private String filename;
	private float shippingFee;
	
	public ModelSaleInfo(){}

	
	public ModelSaleInfo(String modelCode, String modelName,
			String productName, String filename, float shippingFee) {
		super();
		this.modelCode = modelCode;
		this.modelName = modelName;
		this.productName = productName;
		this.filename = filename;
		this.shippingFee = shippingFee;
	}


	public String getModelCode() {
		return modelCode;
	}

	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public float getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(float shippingFee) {
		this.shippingFee = shippingFee;
	}

	
	
	
}
