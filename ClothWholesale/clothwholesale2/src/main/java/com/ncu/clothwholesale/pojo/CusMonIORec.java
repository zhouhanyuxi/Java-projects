package com.ncu.clothwholesale.pojo;

import java.util.Date;

public class CusMonIORec {
    private String cusMonIORecCode;

    private String wholesaleOrdCode;

    private String username;

    private String reason;

    private String IOmark;

    private Date time;

    private Double money;

    private String remark;

    public String getCusMonIORecCode() {
        return cusMonIORecCode;
    }

    public void setCusMonIORecCode(String cusMonIORecCode) {
        this.cusMonIORecCode = cusMonIORecCode == null ? null : cusMonIORecCode.trim();
    }

    public String getWholesaleOrdCode() {
        return wholesaleOrdCode;
    }

    public void setWholesaleOrdCode(String wholesaleOrdCode) {
        this.wholesaleOrdCode = wholesaleOrdCode == null ? null : wholesaleOrdCode.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}