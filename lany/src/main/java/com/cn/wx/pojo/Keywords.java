package com.cn.wx.pojo;

public class Keywords {
    private Integer kwId;

    private String keyword;

    private Integer enable;

    public Integer getKwId() {
        return kwId;
    }

    public void setKwId(Integer kwId) {
        this.kwId = kwId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}