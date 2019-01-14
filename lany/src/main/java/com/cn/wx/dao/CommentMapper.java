package com.cn.wx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.wx.pojo.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentId);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
    
    List<Comment> selectByPage(@Param("start")int start,@Param("news_id")Integer news_id);
}