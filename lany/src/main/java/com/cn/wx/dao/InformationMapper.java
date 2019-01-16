package com.cn.wx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.wx.pojo.Information;

public interface InformationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Information record);

    int insertSelective(Information record);

    Information selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Information record);

    int updateByPrimaryKey(Information record);
    
    List<Information> selectByStuid(@Param("start")int start,@Param("target_stu")String target_stu);
}