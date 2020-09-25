package com.ncu.clothwholesale.pojo;

import java.util.Date;

public class WholesaleOrder {
    private String wholesaleOrdCode;

    private Long shippingAddrNum;

    private String username;

    private String orderState;

    private String shippingCode;

    private Double sumPrice;

    private Date time;

    private String remark;

    private String orderRate;

    private String orderComment;

    public String getWholesaleOrdCode() {
        return wholesaleOrdCode;
    }

    public void setWholesaleOrdCode(String wholesaleOrdCode) {
        this.wholesaleOrdCode = wholesaleOrdCode == null ? null : wholesaleOrdCode.trim();
    }

    public Long getShippingAddrNum() {
        return shippingAddrNum;
    }

    public void setShippingAddrNum(Long shippingAddrNum) {
        this.shippingAddrNum = shippingAddrNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState == null ? null : orderState.trim();
    }

    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode == null ? null : shippingCode.trim();
    }

    public Double getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(Double sumPrice) {
        this.sumPrice = sumPrice;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getOrderRate() {
        return orderRate;
    }

    public void setOrderRate(String orderRate) {
        this.orderRate = orderRate == null ? null : orderRate.trim();
    }

    public String getOrderComment() {
        return orderComment;
    }

    public void setOrderComment(String orderComment) {
        this.orderComment = orderComment == null ? null : orderComment.trim();
    }
}