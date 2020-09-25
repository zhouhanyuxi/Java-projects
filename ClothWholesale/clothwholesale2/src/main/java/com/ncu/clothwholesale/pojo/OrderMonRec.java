package com.ncu.clothwholesale.pojo;

public class OrderMonRec {
    private String ordMonRecCode;

    private String year;

    private String month;

    private Integer orderNum;

    private Double moneyNum;

    public String getOrdMonRecCode() {
        return ordMonRecCode;
    }

    public void setOrdMonRecCode(String ordMonRecCode) {
        this.ordMonRecCode = ordMonRecCode == null ? null : ordMonRecCode.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month == null ? null : month.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Double getMoneyNum() {
        return moneyNum;
    }

    public void setMoneyNum(Double moneyNum) {
        this.moneyNum = moneyNum;
    }
}