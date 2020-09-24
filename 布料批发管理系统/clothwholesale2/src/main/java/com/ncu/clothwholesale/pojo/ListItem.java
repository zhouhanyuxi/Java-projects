package com.ncu.clothwholesale.pojo;

public class ListItem {
    private String listItemCode;

    private String modelCode;

    private String username;

    private Integer totalNum;

    public String getListItemCode() {
        return listItemCode;
    }

    public void setListItemCode(String listItemCode) {
        this.listItemCode = listItemCode == null ? null : listItemCode.trim();
    }

    public String getModelCode() {
        return modelCode;
    }

    public void setModelCode(String modelCode) {
        this.modelCode = modelCode == null ? null : modelCode.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }
}