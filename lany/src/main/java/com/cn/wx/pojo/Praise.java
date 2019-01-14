package com.cn.wx.pojo;

import java.util.Date;

public class Praise {
    private Integer id;

    private String stuId;

    private Integer newsId;

    private Date crawlTime;

    private Boolean flaggood;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Date getCrawlTime() {
        return crawlTime;
    }

    public void setCrawlTime(Date crawlTime) {
        this.crawlTime = crawlTime;
    }

    public Boolean getFlaggood() {
        return flaggood;
    }

    public void setFlaggood(Boolean flaggood) {
        this.flaggood = flaggood;
    }
}