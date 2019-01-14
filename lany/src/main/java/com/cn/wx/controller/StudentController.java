package com.cn.wx.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cn.wx.pojo.Student;
import com.cn.wx.service.IStudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	static String news_imgurl=null;
     
	@Resource
	private IStudentService studentService;
	
	@RequestMapping(value={"/getStu"},method=RequestMethod.POST)
	public void getStu(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		JSONObject json1 = GetRequestJsonUtils.getRequestJsonObject(request);
		//String str = json1.toJSONString();
	     //System.out.println(str);
		String id = json1.getString("id");
		String password = json1.getString("password");
		//System.out.println(password);
		Student st = studentService.getStudentById(id);
		String st_password = st.getPassword();
		if(st_password.equals(password))
		{
			//System.out.println("ok");
			response.getWriter().print(true);
			response.getWriter().flush();
			response.getWriter().close();
		}
		else{
			response.getWriter().print(false);
			response.getWriter().flush();
			response.getWriter().close();

		}	
	}
	
	@RequestMapping(value={"/uploadIcon"})
	 @ResponseBody
	    public Object uploadIcon(HttpServletRequest request,HttpServletResponse response ) 
	    		throws ServletException, IOException{
		         request.setCharacterEncoding("UTF-8");
		         JSONObject json = GetRequestJsonUtils.getRequestJsonObject(request);
	             String id = json.getString("stu_id");
	             //System.out.println(id);
	             String icon_url = json.getString("icon_url");
	             //System.out.println(icon_url);
	             Student stu = studentService.getStudentById(id);
	             stu.setIconUrl(icon_url);
	             studentService.putIconUrl(stu);
	             return true;
	        }
	
	@RequestMapping(value={"/showStu"})
    @ResponseBody
    public Object showStu(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
		JSONObject json = GetRequestJsonUtils.getRequestJsonObject(request);
		String stuid = json.getString("stu_id");
		Student st = studentService.getStudentById(stuid);
		return st;
	}
	
}


	           
