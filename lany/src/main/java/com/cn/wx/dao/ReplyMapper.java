package com.cn.wx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cn.wx.pojo.Reply;

public interface ReplyMapper {
    int deleteByPrimaryKey(Integer replyId);

    int insert(Reply record);

    int insertSelective(Reply record);

    Reply selectByPrimaryKey(Integer replyId);
    
    Reply selectId(@Param("from_stuid")String from_stuid,@Param("comment_id")int comment_id,@Param("create_time")String datetime);

    int updateByPrimaryKeySelective(Reply record);

    int updateByPrimaryKeyWithBLOBs(Reply record);

    int updateByPrimaryKey(Reply record);
    
    List<Reply> selectByComtId(Integer replyId);
}