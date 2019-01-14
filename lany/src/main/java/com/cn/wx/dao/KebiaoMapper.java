package com.cn.wx.dao;

import com.cn.wx.pojo.Kebiao;
import com.cn.wx.pojo.KebiaoKey;

public interface KebiaoMapper {
    int deleteByPrimaryKey(KebiaoKey key);

    int insert(Kebiao record);

    int insertSelective(Kebiao record);

    Kebiao selectByPrimaryKey(KebiaoKey key);

    int updateByPrimaryKeySelective(Kebiao record);

    int updateByPrimaryKey(Kebiao record);
}