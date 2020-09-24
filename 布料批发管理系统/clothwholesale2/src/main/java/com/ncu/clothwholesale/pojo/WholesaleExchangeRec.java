package com.ncu.clothwholesale.pojo;

public class WholesaleExchangeRec {
    private Long exchangeRecNum;

    private String adminCode;

    private String wholesaleItemCode;

    private Integer exchangeNum;

    private String reason;

    private String backShipCode;

    private String resendShipCode;

    private String recordState;

    private String state;

    private String remark;

    public Long getExchangeRecNum() {
        return exchangeRecNum;
    }

    public void setExchangeRecNum(Long exchangeRecNum) {
        this.exchangeRecNum = exchangeRecNum;
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

    public Integer getExchangeNum() {
        return exchangeNum;
    }

    public void setExchangeNum(Integer exchangeNum) {
        this.exchangeNum = exchangeNum;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getBackShipCode() {
        return backShipCode;
    }

    public void setBackShipCode(String backShipCode) {
        this.backShipCode = backShipCode == null ? null : backShipCode.trim();
    }

    public String getResendShipCode() {
        return resendShipCode;
    }

    public void setResendShipCode(String resendShipCode) {
        this.resendShipCode = resendShipCode == null ? null : resendShipCode.trim();
    }

    public String getRecordState() {
        return recordState;
    }

    public void setRecordState(String recordState) {
        this.recordState = recordState == null ? null : recordState.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}