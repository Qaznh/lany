package com.cn.wx.service;

import com.cn.wx.pojo.Xiaolis;
public interface IXiaoliService {

	public Xiaolis getXiaoliById(int xiaoliid);
	
	public Xiaolis getXiaoli();
	
	public int getXiaoliCount();
}
