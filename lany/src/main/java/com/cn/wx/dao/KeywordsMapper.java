package com.cn.wx.dao;

import com.cn.wx.pojo.Keywords;

public interface KeywordsMapper {
    int deleteByPrimaryKey(Integer kwId);
    
    int deleteByKeyword(String keyword);

    int insert(Keywords record);

    int insertSelective(Keywords record);

    Keywords selectByPrimaryKey(Integer kwId);
    
    Keywords selectByKeyword(String keyword);

    int updateByPrimaryKeySelective(Keywords record);

    int updateByPrimaryKey(Keywords record);
    
    int selectCount();

}