package com.cn.wx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.wx.pojo.News;

public interface NewsMapper {
	
    int deleteByPrimaryKey(Integer newsId);
    
    int deleteByNewId(@Param("news_id")int news_id);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer newsId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);
    News selectDesc();
    
    List<News> selectByPageno(@Param("start")int start);
    
    List<News> selectByKeyword(@Param("keyword")String keyword,@Param("start")int start);
    
    List<News> selectByStuid(@Param("stuId")String stuId,@Param("start")int start);
}