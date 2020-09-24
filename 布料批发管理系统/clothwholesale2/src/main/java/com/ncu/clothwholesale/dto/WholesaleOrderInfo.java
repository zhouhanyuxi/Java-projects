package com.ncu.clothwholesale.dto;

public class WholesaleOrderInfo {
	private Long shippingAddrNum;
	private double sumPrice;
	private String remark;
	private String modelCode;
	private int totalNum;
	private float price;
	
	public WholesaleOrderInfo(){}
	
	public WholesaleOrderInfo(Long shippingAddrNum, double sumPrice,
			String remark, String modelCode, int totalNum, float price) {
		super();
		this.shippingAddrNum = shippingAddrNum;
		this.sumPrice = sumPrice;
		this.remark = remark;
		this.modelCode = modelCode;
		this.totalNum = totalNum;
		this.price = price;
	}
	public Long getShippingAddrNum() {
		return shippingAddrNum;
	}
	public void setShippingAddrNum(Long shippingAddrNum) {
		this.shippingAddrNum = shippingAddrNum;
	}
	public double getSumPrice() {
		return sumPrice;
	}
	public void setSumPrice(double sumPrice) {
		this.sumPrice = sumPrice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getModelCode() {
		return modelCode;
	}
	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}
	public int getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "WholesaleOrderInfo [shippingAddrNum=" + shippingAddrNum
				+ ", sumPrice=" + sumPrice + ", remark=" + remark
				+ ", modelCode=" + modelCode + ", totalNum=" + totalNum
				+ ", price=" + price + "]";
	}
	
}
