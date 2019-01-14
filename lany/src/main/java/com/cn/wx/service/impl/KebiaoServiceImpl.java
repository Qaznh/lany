package com.cn.wx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.wx.dao.KebiaoMapper;
import com.cn.wx.pojo.Kebiao;
import com.cn.wx.pojo.KebiaoKey;
import com.cn.wx.service.IKebiaoService;

@Service("kebiaoService")
public class KebiaoServiceImpl implements IKebiaoService{
	@Resource
	private KebiaoMapper kebiaoDao;
	public Kebiao getKebiaoById(KebiaoKey key){
		return this.kebiaoDao.selectByPrimaryKey(key);
	}

}
