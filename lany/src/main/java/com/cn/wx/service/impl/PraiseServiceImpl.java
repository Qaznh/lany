package com.cn.wx.service.impl;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.wx.dao.PraiseMapper;
import com.cn.wx.pojo.Praise;
import com.cn.wx.service.IPraiseService;

@Service("praiseService")
public class PraiseServiceImpl implements IPraiseService{

	@Resource
	private PraiseMapper praiseDao;
	
	public Praise getpraiseById(int Id){
		return this.praiseDao.selectByPrimaryKey(Id);
	}
	
	public int putPraise(int newsId,String stuId,Timestamp datetime,boolean flaggood){
		Praise pra = new Praise();
		pra.setNewsId(newsId);
		pra.setStuId(stuId);
		pra.setCrawlTime(datetime);
		pra.setFlaggood(flaggood);
		int a = this.praiseDao.insert(pra);
		return a;
	}
	
	public int outPraise(String stuId,int newsId){
		return this.praiseDao.deleteBySiNi(stuId, newsId);
	}
	
	public Praise getprasieBySiNi(String stuId,int newsId){
		return this.praiseDao.selectBySiNi(stuId, newsId);
	}
}
