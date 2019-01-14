package com.cn.wx.service;

import java.sql.Timestamp;

public interface IUserfeedbackService {

	public int putUserfeedback(String stuId,String keyword,String comment,Timestamp datetime);
}
