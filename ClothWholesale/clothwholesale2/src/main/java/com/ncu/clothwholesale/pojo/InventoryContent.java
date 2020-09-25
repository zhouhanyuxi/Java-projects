package com.ncu.clothwholesale.pojo;

public class InventoryContent {
    private Long inventoryContInd;

    private String warehouseCode;

    private String modelCode;

    private Integer contentSum;

    public Long getInventoryContInd() {
        return inventoryContInd;
    }

    public void setInventoryContInd(Long inventoryContInd) {
        this.inventoryContInd = inventoryContInd;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode == null ? null : warehouseCode.trim();
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode == null ? null : modelCode.trim();
    }

    public Integer getContentSum() {
        return contentSum;
    }

    public void setContentSum(Integer contentSum) {
        this.contentSum = contentSum;
    }
}