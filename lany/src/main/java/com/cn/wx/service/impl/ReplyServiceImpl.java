package com.cn.wx.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.wx.dao.ReplyMapper;
import com.cn.wx.pojo.Reply;
import com.cn.wx.service.IReplyService;

@Service("replyService")
public class ReplyServiceImpl implements IReplyService{
	
	@Resource
	private ReplyMapper replyDao;
	
	public Reply getReplyById(int replyId){
		return this.replyDao.selectByPrimaryKey(replyId);
	}
	
	public int putReply(int commentId, String fromStuId,String toStuId,String replyCont,Timestamp datetime){
		Reply repl = new Reply();
		repl.setCommentId(commentId);
		repl.setFromStuid(fromStuId);
		repl.setToStuid(toStuId);
		repl.setReplyCont(replyCont);
		repl.setCreateTime(datetime);
		int a = this.replyDao.insertSelective(repl);
		return a;
	}
	
	public List<Reply> getReplyByComtId(int commentId){
		return this.replyDao.selectByComtId(commentId);
	}

}
