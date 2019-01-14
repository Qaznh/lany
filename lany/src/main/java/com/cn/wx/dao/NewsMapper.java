package com.cn.wx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.wx.pojo.News;

public interface NewsMapper {
	
    int deleteByPrimaryKey(Integer newsId);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Integer newsId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKeyWithBLOBs(News record);

    int updateByPrimaryKey(News record);
    News selectDesc();
    
    List<News> selectByPageno(@Param("start")int start);
    
    List<News> selectByKeyword(@Param("keyword")String keyword,@Param("start")int start);
}