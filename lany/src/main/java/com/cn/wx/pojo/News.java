package com.cn.wx.pojo;

import java.util.Date;

public class News {
    private Integer newsId;

    private String keyword;

    private String stuId;

    private String newsImg;

    private Integer commentNum;

    private Integer praiseNum;

    private Integer browseNum;

    private Date createTime;

    private String newsImg1;

    private String newsImg2;

    private String newsCont;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    public String getStuId() {
        return stuId;
    }

    public void setStuId(String stuId) {
        this.stuId = stuId == null ? null : stuId.trim();
    }

    public String getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(String newsImg) {
        this.newsImg = newsImg == null ? null : newsImg.trim();
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public Integer getBrowseNum() {
        return browseNum;
    }

    public void setBrowseNum(Integer browseNum) {
        this.browseNum = browseNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNewsImg1() {
        return newsImg1;
    }

    public void setNewsImg1(String newsImg1) {
        this.newsImg1 = newsImg1 == null ? null : newsImg1.trim();
    }

    public String getNewsImg2() {
        return newsImg2;
    }

    public void setNewsImg2(String newsImg2) {
        this.newsImg2 = newsImg2 == null ? null : newsImg2.trim();
    }

    public String getNewsCont() {
        return newsCont;
    }

    public void setNewsCont(String newsCont) {
        this.newsCont = newsCont == null ? null : newsCont.trim();
    }
}