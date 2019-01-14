package com.cn.wx.service;

import java.sql.Timestamp;
import java.util.List;

import com.cn.wx.pojo.News;

public interface INewsService {
	
	public News getNewsById(int newsId);

	public int putNews(String stu_id,String keyword,String news_img,String news_img1,String news_img2,String news_cont,Timestamp datetime);
	
	public News getNewsDesc();
	
	public int addNewsCmNum(News news);
	
	public int addNewsPsNum(News news);
	
	public int addNewsBrNum(News news);
	
	public List<News> getNewsByPage(int start); 
	
	public List<News> getNewsByKeyword(String keyword,int start);
	
	
}
