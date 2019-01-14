package com.cn.wx.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.wx.dao.NewsMapper;
import com.cn.wx.pojo.News;
import com.cn.wx.service.INewsService;

@Service("newsService")
public class NewsServiceImpl implements INewsService{
	@Resource
	private NewsMapper newsDao;
	public News getNewsById(int newsId){
		return this.newsDao.selectByPrimaryKey(newsId);
	}
	
	public int putNews(String stu_id,String keyword,String news_img,String news_img1,String news_img2,String news_cont,Timestamp datetime){
		News news = new News();
		news.setStuId(stu_id);
		news.setKeyword(keyword);
		news.setNewsCont(news_cont);
		news.setNewsImg(news_img);
		news.setNewsImg1(news_img1);
		news.setNewsImg2(news_img2);
		news.setCreateTime(datetime);
	    int a = this.newsDao.insertSelective(news);
	    return a;
	}
	
	public News getNewsDesc(){
		return this.newsDao.selectDesc();
	}
	
	public int addNewsCmNum(News news){
		return this.newsDao.updateByPrimaryKeySelective(news);
	}
	
	public int addNewsPsNum(News news){
		return this.newsDao.updateByPrimaryKeySelective(news);
	}
	
	public int addNewsBrNum(News news){
		return this.newsDao.updateByPrimaryKeySelective(news);
	}
	
	public List<News> getNewsByPage(int start){
		return this.newsDao.selectByPageno(start);
	}
	
	public List<News> getNewsByKeyword(String keyword,int start){
		return this.newsDao.selectByKeyword(keyword,start);
	}
}
