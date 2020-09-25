package com.ncu.clothwholesale.pojo;

public class WholesaleReturnRec {
    private Long returnRecNum;

    private String adminCode;

    private String wholesaleItemCode;

    private Integer returnNum;

    private String reason;

    private String shippingCode;

    private String recordState;

    private String productState;

    private String moneystate;

    private String remark;

    public Long getReturnRecNum() {
        return returnRecNum;
    }

    public void setReturnRecNum(Long returnRecNum) {
        this.returnRecNum = returnRecNum;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode == null ? null : adminCode.trim();
    }

    public String getWholesaleItemCode() {
        return wholesaleItemCode;
    }

    public void setWholesaleItemCode(String wholesaleItemCode) {
        this.wholesaleItemCode = wholesaleItemCode == null ? null : wholesaleItemCode.trim();
    }

    public Integer getReturnNum() {
        return returnNum;
    }

    public void setReturnNum(Integer returnNum) {
        this.returnNum = returnNum;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode == null ? null : shippingCode.trim();
    }

    public String getRecordState() {
        return recordState;
    }

    public void setRecordState(String recordState) {
        this.recordState = recordState == null ? null : recordState.trim();
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState == null ? null : productState.trim();
    }

    public String getMoneystate() {
        return moneystate;
    }

    public void setMoneystate(String moneystate) {
        this.moneystate = moneystate == null ? null : moneystate.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}