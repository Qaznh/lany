package com.cn.wx.dao;

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
}