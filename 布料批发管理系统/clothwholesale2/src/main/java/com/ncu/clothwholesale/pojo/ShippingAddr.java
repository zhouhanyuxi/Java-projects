package com.ncu.clothwholesale.pojo;

public class ShippingAddr {
    private Long shippingAddrNum;

    private String username;

    private String shippingAddr;

    private String postcode;

    private String contactName;

    private String mobile;

    private String email;

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

    public String getShippingAddr() {
        return shippingAddr;
    }

    public void setShippingAddr(String shippingAddr) {
        this.shippingAddr = shippingAddr == null ? null : shippingAddr.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
}