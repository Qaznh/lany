package com.cn.wx.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cn.wx.pojo.Comment;
import com.cn.wx.pojo.News;
import com.cn.wx.pojo.Reply;
import com.cn.wx.pojo.Student;
import com.cn.wx.service.ICommentService;
import com.cn.wx.service.INewsService;
import com.cn.wx.service.IReplyService;
import com.cn.wx.service.IStudentService;

@Controller
@RequestMapping("/comt")
public class CommentController {

	@Resource
	private ICommentService commentService;
	
	@Resource
	private INewsService newsService;
	
	@Resource
	private IReplyService replyService;
	@Resource  
    private IStudentService studentService;
	
	@RequestMapping(value={"/showComt"},method=RequestMethod.POST)
	@ResponseBody
	public Object showComt(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
		JSONObject json = GetRequestJsonUtils.getRequestJsonObject(request);
		int start = (json.getIntValue("page")*5);
		int newsid = json.getIntValue("news_id");
		List<Comment> comt = commentService.getCommentByPage(start, newsid);
    	List<JSONObject> ns= new ArrayList<JSONObject>();
    	for(int i=0;i<comt.size();i++){
    		Comment ct = comt.get(i);
    		JSONObject json1 = new JSONObject();
    		Student stu = studentService.getStudentById(ct.getStuId());
    		json1.put("stu_name", stu.getStuName());
    		json1.put("icon_url", stu.getIconUrl());
    		json1.put("id", ct.getCommentId());
        	json1.put("stu_id",ct.getStuId());
        	json1.put("detail_comment",ct.getCommentCont());
        	json1.put("news_id", ct.getNewsId());
        	json1.put("flag", false);
        	Date d = ct.getCreateTime();
        	String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
        	json1.put("create_time", sdf);
        	
        	List<Reply> repl = replyService.getReplyByComtId(ct.getCommentId());
        	List<JSONObject> repy= new ArrayList<JSONObject>();
        	for(int j=0;j<repl.size();j++){
        		Reply re = repl.get(j);
        		JSONObject json2 = new JSONObject();
        		Student stu1 = studentService.getStudentById(re.getFromStuid());
        		Student stu2 = studentService.getStudentById(re.getToStuid());
        		json2.put("fromstu_name", stu1.getStuName());
        		json2.put("tostu_name", stu2.getStuName());
        		json2.put("detail_commentdetail_id", re.getReplyId());
        		json2.put("comment_id", re.getCommentId());
        		json2.put("fromstu_id",re.getFromStuid());
        		json2.put("tostu_id", re.getToStuid());
        		json2.put("detail_commentdetail_comment", re.getReplyCont());
        		Date d2 = re.getCreateTime();
        		String sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d2);
            	json2.put("create_time", sdf2);
            	repy.add(json2);
        	   }

        	json1.put("detail_commentdetail", repy);
        	//json1.put("")
        	
        	ns.add(json1);
    	   }
		return ns;
	}
	
	
	
	@RequestMapping(value={"/addComt"})
    @ResponseBody
	public boolean addComt(HttpServletRequest request)
			 throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		JSONObject json1 = GetRequestJsonUtils.getRequestJsonObject(request);
		String stuId = json1.getString("stuId");
		int newsId = json1.getIntValue("newsId");
		//System.out.println(newsId);
		String comcont = json1.getString("comcont");
		Timestamp datetime = new Timestamp(System.currentTimeMillis());
		int tag = commentService.putComment(newsId, stuId, comcont, datetime);
		//System.out.println(tag);
		if(tag==1)
		{
			News news=newsService.getNewsById(newsId);
	    	int comment_num = news.getCommentNum();
	    	comment_num++;
	    	news.setCommentNum(comment_num);
	    	newsService.addNewsCmNum(news);
			//System.out.println(tag2);
			return true;
			}
		else
			return false;
	}
}
