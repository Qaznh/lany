package com.cn.wx.pojo;

public class Kebiao extends KebiaoKey {
    private String kebiaoUrl;

    public String getKebiaoUrl() {
        return kebiaoUrl;
    }

    public void setKebiaoUrl(String kebiaoUrl) {
        this.kebiaoUrl = kebiaoUrl == null ? null : kebiaoUrl.trim();
    }
}