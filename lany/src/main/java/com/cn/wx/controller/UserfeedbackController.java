package com.cn.wx.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cn.wx.pojo.Student;
import com.cn.wx.service.IStudentService;
import com.cn.wx.service.IUserfeedbackService;

@CrossOrigin
@Controller
@RequestMapping("ufb")
public class UserfeedbackController {

	@Resource  
    private IUserfeedbackService userfeedbackService;
	
	@Resource  
    private IStudentService studentService;
	
	@RequestMapping(value={"/addUfb"})
    @ResponseBody
    public Object addReply(HttpServletRequest request)
			throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		JSONObject json1 = GetRequestJsonUtils.getRequestJsonObject(request);
		//System.out.println(json1);
		String stuId = json1.getString("stu_id");
		String keyword = json1.getString("keyword");
		String comment = json1.getString("cont");
		String token = json1.getString("token");
		Student st = studentService.getStudentById(stuId);
		if(!token.equals(st.getToken())){
			JSONObject js = new JSONObject();
			js.put("token_state", false);
			return js;
		} 
		else{
		Timestamp datetime = new Timestamp(System.currentTimeMillis());
		int tag = userfeedbackService.putUserfeedback(stuId, keyword, comment, datetime);
		if(tag==1)
		{
			return true;
		}
		else
		    return false;
	}
		}
}
