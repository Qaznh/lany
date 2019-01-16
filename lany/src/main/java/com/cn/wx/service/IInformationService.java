package com.cn.wx.service;

import java.sql.Timestamp;
import java.util.List;

import com.cn.wx.pojo.Information;

public interface IInformationService {

	public int putInformation(String targetStu,String fromStu,int newsId,boolean praise,int commentId,int replyId,Timestamp datetime);
	
	public Information getInformation(int id);
	
	public List<Information> getInformation(int start,String target_stu);
}
