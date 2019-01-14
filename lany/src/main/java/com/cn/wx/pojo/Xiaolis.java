package com.cn.wx.pojo;

public class Xiaolis {
    private Integer xiaoliId;

    private String year;

    private String xiaoliUrl;

    public Integer getXiaoliId() {
        return xiaoliId;
    }

    public void setXiaoliId(Integer xiaoliId) {
        this.xiaoliId = xiaoliId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getXiaoliUrl() {
        return xiaoliUrl;
    }

    public void setXiaoliUrl(String xiaoliUrl) {
        this.xiaoliUrl = xiaoliUrl == null ? null : xiaoliUrl.trim();
    }
}