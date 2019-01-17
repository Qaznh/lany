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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cn.wx.pojo.Comment;
import com.cn.wx.pojo.News;
import com.cn.wx.pojo.Reply;
import com.cn.wx.pojo.Student;
import com.cn.wx.service.ICommentService;
import com.cn.wx.service.IInformationService;
import com.cn.wx.service.INewsService;
import com.cn.wx.service.IReplyService;
import com.cn.wx.service.IStudentService;

@CrossOrigin
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
	
	@Resource
	private IInformationService informationService;
	
	@RequestMapping(value={"/showComt"},method=RequestMethod.POST)
	@ResponseBody
	public Object showComt(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
		JSONObject json = GetRequestJsonUtils.getRequestJsonObject(request);
		int start = (json.getIntValue("page")*6);
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
        	json1.put("ComReplay", "");
        	
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
	
	@RequestMapping(value={"/showComtBySi"},method=RequestMethod.POST)
	@ResponseBody
	public Object showComtbyStuid(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
		JSONObject json = GetRequestJsonUtils.getRequestJsonObject(request);
		int start = (json.getIntValue("page")*10);
		String stuid = json.getString("stu_id") ;
		List<Comment> comt = commentService.getCommentByStuid(start, stuid);
		List<List> ctn= new ArrayList<List>();
    	for(int i=0;i<comt.size();i++){
    		Comment ct = comt.get(i);
    		JSONObject json1 = new JSONObject();
    		JSONObject json2 = new JSONObject();
    		List<JSONObject> count = new ArrayList<JSONObject>();
    		
    		Student stu = studentService.getStudentById(ct.getStuId());
    		json1.put("stu_name", stu.getStuName());
    		json1.put("icon_url", stu.getIconUrl());
    		json1.put("id", ct.getCommentId());
        	json1.put("stu_id",ct.getStuId());
        	json1.put("detail_comment",ct.getCommentCont());
        	json1.put("news_id", ct.getNewsId());
        	Date d = ct.getCreateTime();
        	String sdf = new SimpleDateFormat("yyyy-MM-dd").format(d);
        	json1.put("create_time", sdf);
        	
        	News nw = newsService.getNewsById(ct.getNewsId());
        	Student stu1 = studentService.getStudentById(nw.getStuId());
    		json2.put("stu_name", stu1.getStuName());
    		json2.put("icon_url",stu1.getIconUrl());
    		json2.put("news_id", nw.getNewsId());
        	json2.put("keyword",nw.getKeyword());
        	json2.put("stu_id",nw.getStuId());
        	json2.put("news_cont",nw.getNewsCont());
        	List<String> a= new ArrayList<String>();
        	String img = nw.getNewsImg();
        	String img1 = nw.getNewsImg1();
        	String img2 = nw.getNewsImg2();
        	if(img!=null){
            a.add(img);
            }
        	if(img1!=null){
        	 a.add(img1);
        	}
        	if(img2!=null){
        	 a.add(img2);
        	}
        	json2.put("news_image", a);
        	json2.put("comment_num", nw.getCommentNum());
        	json2.put("praise_num", nw.getPraiseNum());
        	json2.put("browse_num", nw.getBrowseNum());
        	Date d1 = nw.getCreateTime();
        	String sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d1);
        	json2.put("create_time", sdf1);
        	
        	count.add(json1);
        	count.add(json2);
        	
        	ctn.add(count);
        	}
    	return ctn;
		
	}
	
	@RequestMapping(value={"/addComt"})
    @ResponseBody
	public Object addComt(HttpServletRequest request)
			 throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		JSONObject json1 = GetRequestJsonUtils.getRequestJsonObject(request);
		String stuId = json1.getString("stuId");
		String token = json1.getString("token");
		Student st = studentService.getStudentById(stuId);
		//System.out.println(json1);
		if(!token.equals(st.getToken())){
			JSONObject js = new JSONObject();
			js.put("token_state", false);
			return js;
		} 
		else{
		int newsId = json1.getIntValue("newsId");
		//System.out.println(newsId);
		String comcont = json1.getString("comcont");
		Timestamp datetime = new Timestamp(System.currentTimeMillis());
		String sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(datetime);
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		ts = Timestamp.valueOf(sdf1);
		int tag = commentService.putComment(newsId, stuId, comcont, ts);
		//System.out.println(ts);
		//System.out.println(sdf1);

		//System.out.println(tag);
		if(tag==1)
		{
			News news=newsService.getNewsById(newsId);
	    	int comment_num = news.getCommentNum();
	    	comment_num++;
	    	news.setCommentNum(comment_num);
	    	newsService.addNewsCmNum(news);
			//System.out.println(tag2);
	    	Comment ctm = commentService.getCommentId(stuId, newsId, sdf1);
	    	int tm = ctm.getCommentId();
	    	informationService.putInformation(news.getStuId(), stuId, newsId, false, tm, 0, ts);
			return true;
			}
		else
			return false;
	  }
	}
	
	@RequestMapping(value={"/delComt"})
    @ResponseBody
    public Object delCommentByid(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
    	JSONObject json = GetRequestJsonUtils.getRequestJsonObject(request);
    	//System.out.println(json);
    	int comment_id = json.getIntValue("comment_id");
    	int news_id = json.getIntValue("news_id");
    	int tag = commentService.delCommentById(comment_id);
    	if(tag==1){
        	News ns = newsService.getNewsById(news_id);
        	int  comNu=ns.getCommentNum();
        	     comNu--;
        	     ns.setCommentNum(comNu);
        	newsService.addNewsCmNum(ns);
    		return true;
    	}else
    	{
    		return false;
    	}
	}
	
}
