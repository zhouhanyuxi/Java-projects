package com.ncu.clothwholesale.pojo;

public class Picture {
    private String filename;

    private Short pictureIndex;

    private String modelCode;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public Short getPictureIndex() {
        return pictureIndex;
    }

    public void setPictureIndex(Short pictureIndex) {
        this.pictureIndex = pictureIndex;
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode == null ? null : modelCode.trim();
    }
}