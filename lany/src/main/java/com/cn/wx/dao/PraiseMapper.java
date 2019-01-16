package com.cn.wx.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.cn.wx.pojo.Praise;

public interface PraiseMapper {
    int deleteByPrimaryKey(Integer id);
    
    int deleteBySiNi(@Param("stuid")String stuId,@Param("newsid")int newsId);

    int insert(Praise record);

    int insertSelective(Praise record);

    Praise selectByPrimaryKey(Integer id);
    
    Praise selectBySiNi(@Param("stuid")String stuId,@Param("newsid")int newsId);

    int updateByPrimaryKeySelective(Praise record);

    int updateByPrimaryKey(Praise record);
    
    Praise selectId(@Param("stu_id")String stu_id,@Param("news_id")int news_id,@Param("crawl_time")Date datetime);
}