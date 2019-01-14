package com.cn.wx.service;

import java.sql.Timestamp;
import java.util.List;

import com.cn.wx.pojo.Comment;

public interface ICommentService {

	public Comment getCommentById(int commentId);
	
	public int putComment(int newsId,String stuId,String commentCont,Timestamp datetime);
	
	public List<Comment> getCommentByPage(int start,int news_id);
}
