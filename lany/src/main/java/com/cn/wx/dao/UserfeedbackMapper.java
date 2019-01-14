package com.cn.wx.dao;

import com.cn.wx.pojo.Userfeedback;

public interface UserfeedbackMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userfeedback record);

    int insertSelective(Userfeedback record);

    Userfeedback selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userfeedback record);

    int updateByPrimaryKeyWithBLOBs(Userfeedback record);

    int updateByPrimaryKey(Userfeedback record);
}