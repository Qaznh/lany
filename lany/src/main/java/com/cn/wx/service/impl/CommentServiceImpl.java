package com.cn.wx.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.wx.dao.CommentMapper;
import com.cn.wx.pojo.Comment;
import com.cn.wx.service.ICommentService;

@Service("commentService")
public class CommentServiceImpl implements ICommentService{
	@Resource
	private CommentMapper commentDao;
	
	public Comment getCommentById(int commentId){
		return this.commentDao.selectByPrimaryKey(commentId);
	}
	
	public int putComment(int newsId,String stuId,String commentCont,Timestamp datetime){
		Comment comt = new Comment();
		comt.setStuId(stuId);
		comt.setNewsId(newsId);
		comt.setCreateTime(datetime);
		comt.setCommentCont(commentCont);
		int a = this.commentDao.insertSelective(comt);
		return a;		
	}
	
	public List<Comment> getCommentByPage(int start,int news_id){
		return this.commentDao.selectByPage(start, news_id);
	}


	
}
