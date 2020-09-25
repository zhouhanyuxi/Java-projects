package com.ncu.clothwholesale.pojo;

import java.util.Date;

public class WarehouseIORecord {
    private String warehouseIORecCode;

    private String warehouseCode;

    private String modelCode;

    private String adminCode;

    private Integer numberChange;

    private String reason;

    private String IOMark;

    private Date time;

    private String ordCode;

    private String remark;

    public String getWarehouseIORecCode() {
        return warehouseIORecCode;
    }

    public void setWarehouseIORecCode(String warehouseIORecCode) {
        this.warehouseIORecCode = warehouseIORecCode == null ? null : warehouseIORecCode.trim();
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

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode == null ? null : adminCode.trim();
    }

    public Integer getNumberChange() {
        return numberChange;
    }

    public void setNumberChange(Integer numberChange) {
        this.numberChange = numberChange;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
    }

    public String getIOMark() {
        return IOMark;
    }

    public void setIOMark(String IOMark) {
        this.IOMark = IOMark == null ? null : IOMark.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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