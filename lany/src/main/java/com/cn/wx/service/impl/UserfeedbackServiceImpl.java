package com.cn.wx.service.impl;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.wx.dao.UserfeedbackMapper;
import com.cn.wx.pojo.Userfeedback;
import com.cn.wx.service.IUserfeedbackService;

@Service("userfeedbackService")
public class UserfeedbackServiceImpl implements IUserfeedbackService{

	@Resource
	private UserfeedbackMapper userfeedbackDao;
	
	public int putUserfeedback(String stuId,String keyword,String comment,Timestamp datetime){
		Userfeedback ufb = new Userfeedback();
		ufb.setStuId(stuId);
		ufb.setKeyword(keyword);
		ufb.setComment(comment);
		ufb.setCreateTime(datetime);
		return this.userfeedbackDao.insertSelective(ufb);
	}
}
