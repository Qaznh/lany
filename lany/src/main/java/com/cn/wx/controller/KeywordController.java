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
import com.cn.wx.pojo.Keywords;
import com.cn.wx.service.IKeywordService;

@Controller
@RequestMapping("/keyword")
public class KeywordController {
	
	@Resource
	private IKeywordService keywordService;

	@RequestMapping(value={"/showKeyword"},method=RequestMethod.POST)
	@ResponseBody
	public Object showKeyword(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
		JSONArray arry = new JSONArray();
		int count = keywordService.getKeywordCount();
		for(int i=1;i<=count;i++){
			Keywords kw = keywordService.getKeywordById(i);
			String kws = kw.getKeyword();
			//JSONObject json = GetData.retuKeywordJson(i, kws);
			arry.add(kws);
		}
		response.setCharacterEncoding("UTF-8");
		return arry;
	}

}
