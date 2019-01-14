package com.cn.wx.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.alibaba.fastjson.JSONObject;
import com.cn.wx.pojo.Xiaolis;
import com.cn.wx.service.IXiaoliService;

@Controller
@RequestMapping("/xiaoli")
public class XiaolisController {

	@Resource
	private IXiaoliService xiaoliService;
	
	@RequestMapping(value={"/showXiaoli"},method=RequestMethod.POST)
	public void showXiaoli(HttpServletRequest request,HttpServletResponse response)
			throws ServletException, IOException{
		int count = xiaoliService.getXiaoliCount();
		JSONObject json = new JSONObject();
		for(int id=1;id<=count;id++){
		String xid=String.valueOf(id);
    	 Xiaolis xl = xiaoliService.getXiaoliById(id);
    	 String url=xl.getXiaoliUrl();
    	 json.put(xid, url);
    	 }
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(json);
		response.getWriter().flush();
		response.getWriter().close();
	}
}
