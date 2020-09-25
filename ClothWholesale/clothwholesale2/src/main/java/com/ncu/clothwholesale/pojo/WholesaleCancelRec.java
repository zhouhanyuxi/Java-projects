package com.ncu.clothwholesale.pojo;

public class WholesaleCancelRec {
    private Long cancelRecNum;

    private String adminCode;

    private String wholesaleOrdCode;

    private String reason;

    private String recordState;

    private String moneyState;

    private String remark;

    public Long getCancelRecNum() {
        return cancelRecNum;
    }

    public void setCancelRecNum(Long cancelRecNum) {
        this.cancelRecNum = cancelRecNum;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode == null ? null : adminCode.trim();
    }

    public String getWholesaleOrdCode() {
        return wholesaleOrdCode;
    }

    public void setWholesaleOrdCode(String wholesaleOrdCode) {
        this.wholesaleOrdCode = wholesaleOrdCode == null ? null : wholesaleOrdCode.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getRecordState() {
        return recordState;
    }

    public void setRecordState(String recordState) {
        this.recordState = recordState == null ? null : recordState.trim();
    }

    public String getMoneyState() {
        return moneyState;
    }

    public void setMoneyState(String moneyState) {
        this.moneyState = moneyState == null ? null : moneyState.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}