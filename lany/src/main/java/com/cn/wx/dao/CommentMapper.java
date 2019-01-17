package com.cn.wx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.wx.pojo.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer commentId);
    
    int deleteByCommentId(@Param("comment_id")int comment_id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer commentId);
    
    Comment selectId(@Param("stuId")String stu_id,@Param("news_id")int news_id,@Param("create_time")String create_time);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);
    
    List<Comment> selectByPage(@Param("start")int start,@Param("news_id")Integer news_id);
    
    List<Comment> selectByStuid(@Param("start")int start,@Param("stu_id")String news_id);
}