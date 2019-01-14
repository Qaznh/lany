package com.cn.wx.service;

import java.sql.Timestamp;
import java.util.List;

import com.cn.wx.pojo.Reply;

public interface IReplyService {

	public Reply getReplyById(int replyId);
	
	public int putReply(int commentId, String fromStuId,String toStuId,String replyCont,Timestamp datetime);
	
	public List<Reply> getReplyByComtId(int commentId);
}
