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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.wx.pojo.Grade;
import com.cn.wx.pojo.GradeKey;
import com.cn.wx.service.IGradeService;

import com.cn.wx.controller.GetData;

@Controller
@RequestMapping("/grade")
public class GradeController {

	@Resource
	private IGradeService gradeService;
	
	@RequestMapping(value={"/showGrade"},method=RequestMethod.POST)
	@ResponseBody
	public Object showGrade(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		JSONObject json1 = GetRequestJsonUtils.getRequestJsonObject(request);
	    //String str = json1.toJSONString();
	    //System.out.println(str);
	    String id = json1.getString("id");
	    //System.out.println(id);
	    int year = GetData.getYear(id);
	    JSONArray arry = new JSONArray();
	    for(int term=1;term<=8;term++){
	    GradeKey key = new GradeKey();
	    key.setId(id);
	    key.setTerm(term);
	    Grade gr = gradeService.getGradeById(key);
	   // System.out.println(gr);
	    if(gr!=null){
	    	String grade_url = gr.getGradeUrl();
	    	JSONObject json2 = GetData.retuGradeJson(year, grade_url, term);
	    	arry.add(json2);
	    }else
	    	continue;
	    //ServletOutputStream out = response.getOutputStream();
	   // out.write(arry.toString().getBytes("UTF-8"));
	    }
	    //System.out.println(arry);
	    response.setCharacterEncoding("UTF-8");
		return arry;
	}
}
