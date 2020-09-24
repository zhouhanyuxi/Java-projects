package com.ncu.clothwholesale.pojo;

public class SellPrice {
    private String sellPriceCode;

    private String productCode;

    private Integer lowerLimit;

    private Float price;

    public String getSellPriceCode() {
        return sellPriceCode;
    }

    public void setSellPriceCode(String sellPriceCode) {
        this.sellPriceCode = sellPriceCode == null ? null : sellPriceCode.trim();
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public Integer getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(Integer lowerLimit) {
        this.lowerLimit = lowerLimit;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}