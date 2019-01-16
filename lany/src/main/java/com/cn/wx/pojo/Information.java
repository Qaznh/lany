package com.cn.wx.pojo;

import java.util.Date;

public class Information {
    private Integer id;

    private String targetStu;

    private String fromStu;

    private Integer newsId;

    private Boolean praise;

    private Integer commentId;

    private Integer replyId;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTargetStu() {
        return targetStu;
    }

    public void setTargetStu(String targetStu) {
        this.targetStu = targetStu == null ? null : targetStu.trim();
    }

    public String getFromStu() {
        return fromStu;
    }

    public void setFromStu(String fromStu) {
        this.fromStu = fromStu == null ? null : fromStu.trim();
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Boolean getPraise() {
        return praise;
    }

    public void setPraise(Boolean praise) {
        this.praise = praise;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}