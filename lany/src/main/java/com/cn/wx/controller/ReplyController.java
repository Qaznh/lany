package com.cn.wx.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cn.wx.pojo.Reply;
import com.cn.wx.pojo.Student;
import com.cn.wx.service.ICommentService;
import com.cn.wx.service.IInformationService;
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
	
	@Resource
    private IInformationService informationService;
	
	@Resource  
    private ICommentService commentService;
	
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
		String sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(datetime);
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		ts = Timestamp.valueOf(sdf1);
		int tag = replyService.putReply(commentId, fromStuId, toStuId, replyCont, ts);
		if(tag==1)
		{
			//ystem.out.println(datetime);
			//System.out.println(sdf1);
			Reply rpy = replyService.getReplyId(fromStuId, commentId, sdf1);
			int tm = rpy.getReplyId();
			informationService.putInformation(fromStuId, toStuId, 0, false, commentId, tm, datetime);
			return true;
			}
		else
			return false;
	}
		}
	
	@RequestMapping(value={"/delReply"})
    @ResponseBody
    public Object delReplyByid(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
    	JSONObject json = GetRequestJsonUtils.getRequestJsonObject(request);
    	int reply_id = json.getIntValue("reply_id");
    	int tag = replyService.delReplyById(reply_id);
    	if(tag==1){
    		return true;
    	}else
    	{
    		return false;
    	}
	}
	
}
