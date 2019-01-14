package com.cn.wx.service;

import java.sql.Timestamp;

import com.cn.wx.pojo.Praise;

public interface IPraiseService {
	
	public Praise getpraiseById(int Id);
	
	public int putPraise(int newsId,String stuId,Timestamp datetime,boolean flaggood);
	
	public int outPraise(String stuId,int newsId);
	
	public Praise getprasieBySiNi(String stuId,int newsId);

}
