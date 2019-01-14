package com.cn.wx.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cn.wx.pojo.News;
import com.cn.wx.service.INewsService;
import com.cn.wx.service.IPraiseService;

@Controller
@RequestMapping("/praise")
public class PraiseController {

	@Resource
	private INewsService newsService;
	
	@Resource
	private IPraiseService praiseService;
	
	@RequestMapping(value={"/addPraise"})
    @ResponseBody
	public void addPraise(HttpServletRequest request)
			 throws ServletException, IOException{
		JSONObject json1 = GetRequestJsonUtils.getRequestJsonObject(request);
		boolean flaggood = json1.getBooleanValue("flaggood");
		//System.out.println(json1);
		String stuId = json1.getString("stu_id");
		int newsId = json1.getIntValue("news_id");
		Timestamp datetime = new Timestamp(System.currentTimeMillis());
		if(flaggood==true){
		    int tag = praiseService.putPraise(newsId, stuId,datetime,flaggood);
		   // System.out.println("true");
    	    if(tag==1){
    		   News news = newsService.getNewsById(newsId);
    		   int praise_num = news.getPraiseNum();
    		   praise_num++;
    		   news.setPraiseNum(praise_num);
    		   newsService.addNewsPsNum(news);
    		//System.out.println(tag2);
    	    }
    	  }
    	    else
    	    {
    	    	int tag2 = praiseService.outPraise(stuId, newsId);
    	    	if(tag2==1){
    				News news2 = newsService.getNewsById(newsId);
    	    		int praise_num2 = news2.getPraiseNum();
    	    		praise_num2--;
    	    		news2.setPraiseNum(praise_num2);
    	    		newsService.addNewsPsNum(news2);
    			}
    	    }
}
	
	
	@RequestMapping(value={"/outPraise"})
    @ResponseBody
    public void outPraise(HttpServletRequest request)
			 throws ServletException, IOException{
		JSONObject json1 = GetRequestJsonUtils.getRequestJsonObject(request);
		boolean flaggood = json1.getBooleanValue("flaggood");
		if(flaggood==false){
			String stuId = json1.getString("stu_id");
			int newsId = json1.getIntValue("news_id");
			int tag = praiseService.outPraise(stuId, newsId);
			if(tag==1){
				News news = newsService.getNewsById(newsId);
	    		int praise_num = news.getPraiseNum();
	    		praise_num--;
	    		news.setPraiseNum(praise_num);
	    		newsService.addNewsPsNum(news);
			}
		}
	}
}
