package com.cn.wx.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cn.wx.pojo.Student;
import com.cn.wx.service.IReplyService;
import com.cn.wx.service.IStudentService;

@CrossOrigin
@Controller
@RequestMapping("/repl")
public class ReplyController {

	@Resource
	private IReplyService replyService;
	
	@Resource  
    private IStudentService studentService;
	
	@RequestMapping(value={"/addReply"})
    @ResponseBody
	public Object addReply(HttpServletRequest request)
			throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		JSONObject json1 = GetRequestJsonUtils.getRequestJsonObject(request);
		int commentId = json1.getIntValue("comment_id");
		String fromStuId = json1.getString("fromstu_id");
		String token = json1.getString("token");
		Student st = studentService.getStudentById(fromStuId);
		if(!token.equals(st.getToken())){
			JSONObject js = new JSONObject();
			js.put("token_state", false);
			return js;
		} 
		else{
		String toStuId = json1.getString("tostu_id");
		String replyCont = json1.getString("reply_cont");
		Timestamp datetime = new Timestamp(System.currentTimeMillis());
		int tag = replyService.putReply(commentId, fromStuId, toStuId, replyCont, datetime);
		if(tag==1)
		{
			return true;
			}
		else
			return false;
	}
		}
	
}
