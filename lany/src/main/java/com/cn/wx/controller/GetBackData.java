package com.cn.wx.controller;

import java.io.IOException;


import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;
import com.cn.wx.controller.GetRequestJsonUtils;
import com.cn.wx.service.IStudentService;



@Controller
@RequestMapping("/GetBackData")
public class GetBackData {

	@Resource
	private IStudentService studentService;
	
	@RequestMapping("/req")
    public void req(HttpServletRequest request,HttpServletResponse response) 
    		         throws ServletException, IOException {
	        
		JSONObject json1 = GetRequestJsonUtils.getRequestJsonObject(request);
		//String str = json1.toJSONString();
		//System.out.println(str);
		//DataExcgImpl de = new DataExcgImpl();
		//JSONObject json2 = de.RetuJson(json1);
		response.getWriter().print(json1);
		response.getWriter().flush();
		response.getWriter().close();
	}

}


