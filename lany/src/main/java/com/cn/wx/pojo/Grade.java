package com.cn.wx.pojo;

public class Grade extends GradeKey {
    private String gradeUrl;

    public String getGradeUrl() {
        return gradeUrl;
    }

    public void setGradeUrl(String gradeUrl) {
        this.gradeUrl = gradeUrl == null ? null : gradeUrl.trim();
    }
}