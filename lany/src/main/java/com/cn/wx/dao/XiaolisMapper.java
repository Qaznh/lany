package com.cn.wx.dao;

import com.cn.wx.pojo.Xiaolis;

public interface XiaolisMapper {
    int deleteByPrimaryKey(Integer xiaoliId);

    int insert(Xiaolis record);

    int insertSelective(Xiaolis record);

    Xiaolis selectByPrimaryKey(Integer xiaoliId);

    int updateByPrimaryKeySelective(Xiaolis record);

    int updateByPrimaryKey(Xiaolis record);
    
    Xiaolis selectAll();
    
    int selectCount();
    
    public int getXiaoliCount();
}