package com.ncu.clothwholesale.pojo;

public class PurchaseItem {
    private String purchaseItemCode;

    private String purchaseOrdCode;

    private String modelCode;

    private Integer totalNum;

    private Float orignalPrice;

    private Double totalPrice;

    private String state;

    public String getPurchaseItemCode() {
        return purchaseItemCode;
    }

    public void setPurchaseItemCode(String purchaseItemCode) {
        this.purchaseItemCode = purchaseItemCode == null ? null : purchaseItemCode.trim();
    }

    public String getPurchaseOrdCode() {
        return purchaseOrdCode;
    }

    public void setPurchaseOrdCode(String purchaseOrdCode) {
        this.purchaseOrdCode = purchaseOrdCode == null ? null : purchaseOrdCode.trim();
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

    public Float getOrignalPrice() {
        return orignalPrice;
    }

    public void setOrignalPrice(Float orignalPrice) {
        this.orignalPrice = orignalPrice;
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
}