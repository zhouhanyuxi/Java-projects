package com.ncu.clothwholesale.pojo;

import java.util.Date;

public class ComMonIORecord {
    private String comIORecCode;

    private String adminCode;

    private String reason;

    private String IOmark;

    private Date time;

    private Double amount;

    private String ordCode;

    private String remark;

    public String getComIORecCode() {
        return comIORecCode;
    }

    public void setComIORecCode(String comIORecCode) {
        this.comIORecCode = comIORecCode == null ? null : comIORecCode.trim();
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode == null ? null : adminCode.trim();
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getIOmark() {
        return IOmark;
    }

    public void setIOmark(String IOmark) {
        this.IOmark = IOmark == null ? null : IOmark.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getOrdCode() {
        return ordCode;
    }

    public void setOrdCode(String ordCode) {
        this.ordCode = ordCode == null ? null : ordCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}