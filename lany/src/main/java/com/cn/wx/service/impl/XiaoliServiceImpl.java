package com.cn.wx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.wx.dao.XiaolisMapper;
import com.cn.wx.pojo.Xiaolis;
import com.cn.wx.service.IXiaoliService;

@Service("xiaoliService")
public class XiaoliServiceImpl implements IXiaoliService{

	@Resource
	private XiaolisMapper xiaoliDao;
	public Xiaolis getXiaoliById(int xiaoliid){
		return this.xiaoliDao.selectByPrimaryKey(xiaoliid);
	}
	

	public Xiaolis getXiaoli(){
		return this.xiaoliDao.selectAll();
	}
	
	public int getXiaoliCount(){
		return this.xiaoliDao.selectCount();
	}
}
