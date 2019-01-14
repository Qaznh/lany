package com.cn.wx.service.impl;

import javax.annotation.Resource;  

import org.springframework.stereotype.Service;  
 
import com.cn.wx.dao.StudentMapper;  
import com.cn.wx.pojo.Student;  
import com.cn.wx.service.IStudentService;  

@Service("studentService")
public class StudentServiceImpl implements IStudentService {
	@Resource
	private StudentMapper studentDao;
	public Student getStudentById(String studentId){
		// TODO Auto-generated method stub  
	       return this.studentDao.selectByPrimaryKey(studentId);
	}
	
	public int putIconUrl(Student stu){
		return this.studentDao.updateByPrimaryKeySelective(stu);
	}

}
