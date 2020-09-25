package com.ncu.clothwholesale.pojo;

import java.util.Date;

public class PurchaseOrder {
    private String purchaseOrdCode;

    private String supplierCode;

    private String adminCode;

    private Date time;

    private Double sumPrice;

    private Double paidPrice;

    private String remark;

    public String getPurchaseOrdCode() {
        return purchaseOrdCode;
    }

    public void setPurchaseOrdCode(String purchaseOrdCode) {
        this.purchaseOrdCode = purchaseOrdCode == null ? null : purchaseOrdCode.trim();
    }

    public String getSupplierCode() {
        return supplierCode;
    }

    public void setSupplierCode(String supplierCode) {
        this.supplierCode = supplierCode == null ? null : supplierCode.trim();
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode == null ? null : adminCode.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Double getPaidPrice() {
        return paidPrice;
    }

    public void setPaidPrice(Double paidPrice) {
        this.paidPrice = paidPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

	@Override
	public String toString() {
		return "PurchaseOrder [purchaseOrdCode=" + purchaseOrdCode
				+ ", supplierCode=" + supplierCode + ", adminCode=" + adminCode
				+ ", time=" + time + ", sumPrice=" + sumPrice + ", paidPrice="
				+ paidPrice + ", remark=" + remark + "]";
	}
}