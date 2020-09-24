package com.ncu.clothwholesale.pojo;

public class Product {
    private String productCode;

    private String productName;

    private String originalName;

    private Double originalPrice;

    private Short typeTotal;

    private Integer width;

    private Integer weight;

    private String thickness;

    private String composition;

    private String ingredient;

    private String density;

    private String textileProcess;

    private String dyeProcess;

    private String fiberOrganization;

    private String pattern;

    private String mainUse;

    private String season;

    private Float shippingFee;

    private String intro;

    private String state;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode == null ? null : productCode.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getOriginalName() {
        return originalName;
    }

    public void setOriginalName(String originalName) {
        this.originalName = originalName == null ? null : originalName.trim();
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Short getTypeTotal() {
        return typeTotal;
    }

    public void setTypeTotal(Short typeTotal) {
        this.typeTotal = typeTotal;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getThickness() {
        return thickness;
    }

    public void setThickness(String thickness) {
        this.thickness = thickness == null ? null : thickness.trim();
    }

    public String getComposition() {
        return composition;
    }

    public void setComposition(String composition) {
        this.composition = composition == null ? null : composition.trim();
    }

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient == null ? null : ingredient.trim();
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density == null ? null : density.trim();
    }

    public String getTextileProcess() {
        return textileProcess;
    }

    public void setTextileProcess(String textileProcess) {
        this.textileProcess = textileProcess == null ? null : textileProcess.trim();
    }

    public String getDyeProcess() {
        return dyeProcess;
    }

    public void setDyeProcess(String dyeProcess) {
        this.dyeProcess = dyeProcess == null ? null : dyeProcess.trim();
    }

    public String getFiberOrganization() {
        return fiberOrganization;
    }

    public void setFiberOrganization(String fiberOrganization) {
        this.fiberOrganization = fiberOrganization == null ? null : fiberOrganization.trim();
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern == null ? null : pattern.trim();
    }

    public String getMainUse() {
        return mainUse;
    }

    public void setMainUse(String mainUse) {
        this.mainUse = mainUse == null ? null : mainUse.trim();
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season == null ? null : season.trim();
    }

    public Float getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(Float shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}