package com.cn.wx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.wx.dao.GradeMapper;
import com.cn.wx.pojo.Grade;
import com.cn.wx.pojo.GradeKey;
import com.cn.wx.service.IGradeService;

@Service("gradeService")
public class GradeServiceImpl implements IGradeService{
	@Resource
	private GradeMapper gradeDao;
	public Grade getGradeById(GradeKey key){
		return this.gradeDao.selectByPrimaryKey(key);
	}
	
}
