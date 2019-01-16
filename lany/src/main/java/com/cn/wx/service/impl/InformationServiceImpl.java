package com.cn.wx.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.wx.dao.InformationMapper;
import com.cn.wx.pojo.Information;
import com.cn.wx.service.IInformationService;

@Service("informationService")
public class InformationServiceImpl implements IInformationService{

	@Resource
	private InformationMapper informationDao;
	
	public Information getInformation(int id){
		return this.informationDao.selectByPrimaryKey(id);
	}
	
	public int putInformation(String targetStu,String fromStu,int newsId,boolean praise,int commentId,int replyId,Timestamp datetime){
		Information infm = new Information();
		infm.setTargetStu(targetStu);
		infm.setFromStu(fromStu);
		infm.setNewsId(newsId);
		infm.setCommentId(commentId);
		infm.setPraise(praise);
		infm.setReplyId(replyId);
		infm.setCreateTime(datetime);
		return this.informationDao.insertSelective(infm);
	}
	
	public List<Information> getInformation(int start,String target_stu){
		return this.informationDao.selectByStuid(start,target_stu);
	}
}
