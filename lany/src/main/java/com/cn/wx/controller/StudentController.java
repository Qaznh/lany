package com.cn.wx.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cn.wx.pojo.Student;
import com.cn.wx.service.IStudentService;

@CrossOrigin
@Controller
@RequestMapping("/student")
public class StudentController {
	
	static String news_imgurl=null;
     
	@Resource
	private IStudentService studentService;
	
	@RequestMapping(value={"/getStu"},method=RequestMethod.POST)
	@ResponseBody
	public void getStu(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		JSONObject json1 = GetRequestJsonUtils.getRequestJsonObject(request);
		//String str = json1.toJSONString();
	     //System.out.println(str);
		String id = json1.getString("id");
		String token = json1.getString("token");
		//System.out.println(json1);
		Student st = studentService.getStudentById(id);
		if(st!=null){
			   st.setToken(token);
			   studentService.putStuToken(st);
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
		String token = json.getString("token");
		//System.out.println(token);
		Student st = studentService.getStudentById(stuid);
		if(!token.equals(st.getToken())){
			JSONObject js = new JSONObject();
			js.put("token_state", false);
			return js;
		} 
		else
			return st;
	}
	
	@RequestMapping(value={"/testStAct"})
    @ResponseBody
    public Object testStAct(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
		JSONObject json = GetRequestJsonUtils.getRequestJsonObject(request);
		String stuid = json.getString("id");
		String password = json.getString("password");
		String token = json.getString("token");
		Student st = studentService.getStudentById(stuid);
		//System.out.println(json);
		if(st==null){
			int error = 500;
			return error;
		}
		else{
			if(st.getPassword().equals(password))
			{
		      if(st.getActive())
		      {
		    	  return 1;
		      }
		      else{
		          {
		    	     st.setActive(true);
				     st.setToken(token);
				     studentService.putStuAcitve(st);
				     return 0;
		          }
		      }
	     }
			else{
	    	 return 2;
	     }
	   }
     }
	
	@RequestMapping(value={"/cgStAct"})
    @ResponseBody
    public boolean cgStAct(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
		JSONObject json = GetRequestJsonUtils.getRequestJsonObject(request);
		String stuid = json.getString("stu_id");
		Student st = studentService.getStudentById(stuid);
		st.setActive(false);
		int tag = studentService.putStuAcitve(st);
		if(tag==1)
		    return true;
		else
			return false;
	}
	
	@RequestMapping(value={"/getToken"})
    @ResponseBody
    public Object getToken(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
		JSONObject json = GetRequestJsonUtils.getRequestJsonObject(request);
		String stuid = json.getString("stu_id");
		Student st = studentService.getStudentById(stuid);
		String token = st.getToken();
		return token;
	}
	
}


	           
