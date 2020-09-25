package com.ncu.clothwholesale.pojo;

public class OrderDayRec {
    private String ordDayRecCode;

    private String year;

    private String month;

    private String day;

    private Integer orderNum;

    private Double moneyNum;

    public String getOrdDayRecCode() {
        return ordDayRecCode;
    }

    public void setOrdDayRecCode(String ordDayRecCode) {
        this.ordDayRecCode = ordDayRecCode == null ? null : ordDayRecCode.trim();
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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day == null ? null : day.trim();
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