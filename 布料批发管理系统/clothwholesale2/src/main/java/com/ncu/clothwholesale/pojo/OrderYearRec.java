package com.ncu.clothwholesale.pojo;

public class OrderYearRec {
    private String ordYearRecCode;

    private String year;

    private Integer orderNum;

    private Double moneyNum;

    public String getOrdYearRecCode() {
        return ordYearRecCode;
    }

    public void setOrdYearRecCode(String ordYearRecCode) {
        this.ordYearRecCode = ordYearRecCode == null ? null : ordYearRecCode.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
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