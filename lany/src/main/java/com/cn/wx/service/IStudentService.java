package com.cn.wx.service;

import com.cn.wx.pojo.Student;


public interface IStudentService {

	public Student getStudentById(String studentId);
	
	public int putIconUrl(Student stu);
}
