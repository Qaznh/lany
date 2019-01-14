package com.cn.wx.pojo;

import java.util.Date;

public class Reply {
    private Integer replyId;

    private Integer commentId;

    private String fromStuid;

    private String toStuid;

    private Date createTime;

    private String replyCont;

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getFromStuid() {
        return fromStuid;
    }

    public void setFromStuid(String fromStuid) {
        this.fromStuid = fromStuid == null ? null : fromStuid.trim();
    }

    public String getToStuid() {
        return toStuid;
    }

    public void setToStuid(String toStuid) {
        this.toStuid = toStuid == null ? null : toStuid.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getReplyCont() {
        return replyCont;
    }

    public void setReplyCont(String replyCont) {
        this.replyCont = replyCont == null ? null : replyCont.trim();
    }
}