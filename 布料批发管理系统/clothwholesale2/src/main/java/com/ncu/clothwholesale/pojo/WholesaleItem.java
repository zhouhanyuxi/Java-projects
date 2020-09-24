package com.ncu.clothwholesale.pojo;

public class WholesaleItem {
    private String wholesaleItemCode;

    private String wholesaleOrdCode;

    private String modelCode;

    private Integer totalNum;

    private Float price;

    private Double totalPrice;

    private String state;

    public String getWholesaleItemCode() {
        return wholesaleItemCode;
    }

    public void setWholesaleItemCode(String wholesaleItemCode) {
        this.wholesaleItemCode = wholesaleItemCode == null ? null : wholesaleItemCode.trim();
    }

    public String getWholesaleOrdCode() {
        return wholesaleOrdCode;
    }

    public void setWholesaleOrdCode(String wholesaleOrdCode) {
        this.wholesaleOrdCode = wholesaleOrdCode == null ? null : wholesaleOrdCode.trim();
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode == null ? null : modelCode.trim();
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

	@Override
	public String toString() {
		return "WholesaleItem [wholesaleItemCode=" + wholesaleItemCode
				+ ", wholesaleOrdCode=" + wholesaleOrdCode + ", modelCode="
				+ modelCode + ", totalNum=" + totalNum + ", price=" + price
				+ ", totalPrice=" + totalPrice + ", state=" + state + "]";
	}
    
    
}