package com.cn.wx.dao;

import com.cn.wx.pojo.Grade;
import com.cn.wx.pojo.GradeKey;

public interface GradeMapper {
    int deleteByPrimaryKey(GradeKey key);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(GradeKey key);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
}