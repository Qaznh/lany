package com.cn.wx.controller;

import java.io.IOException;
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
import com.cn.wx.pojo.Information;
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
@RequestMapping("/infm")
public class InformationController {

	@Resource
	private IInformationService informationService;
	
	@Resource
	private INewsService newsService;
	
	@Resource
	private IReplyService replyService;
	
	@Resource  
    private IStudentService studentService;
	
	@Resource  
    private ICommentService commentService;
	
	@RequestMapping(value={"/showinfm"},method=RequestMethod.POST)
	@ResponseBody
	public Object showInfm(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
		JSONObject json = GetRequestJsonUtils.getRequestJsonObject(request);
		int start = (json.getIntValue("page")*10);
		String stuid = json.getString("stu_id");
		List<Information> infm = informationService.getInformation(start, stuid);
		List<JSONObject> inform= new ArrayList<JSONObject>();
		for(int i=0;i<infm.size();i++){
			Information informa = infm.get(i);
			JSONObject json1 = new JSONObject();
			Student stu = studentService.getStudentById(informa.getFromStu());
			json1.put("from_stu", stu.getStuName());
    		json1.put("icon_url", stu.getIconUrl());
    		json1.put("id", informa.getId());
    		
    		if(informa.getPraise()==true){
    		json1.put("praise", informa.getPraise());
    		JSONObject jsnews = new JSONObject();
    		if(informa.getNewsId()!=0){
    			News ns = newsService.getNewsById(informa.getNewsId());
    			if(ns!=null){
    			jsnews.put("news_id", ns.getNewsId());
    			jsnews.put("info_cont", ns.getNewsCont());
    			jsnews.put("img", ns.getNewsImg());
    			}
    		   }
    		 json1.put("cont", jsnews);
    		}
    		
    		else{
    			json1.put("praise",informa.getPraise());
        		if(informa.getNewsId()!=0){
        			JSONObject jsnews1 = new JSONObject();
        			News ns = newsService.getNewsById(informa.getNewsId());
        			if(ns!=null){
        			jsnews1.put("news_id", ns.getNewsId());
        			jsnews1.put("info_cont", ns.getNewsCont());
        			jsnews1.put("img", ns.getNewsImg());
        			}
        		  json1.put("cont", jsnews1);
        		  
         			Comment com = commentService.getCommentById(informa.getCommentId());
         			if(com!=null){
         			json1.put("detail_cont", com.getCommentCont());
         			}
        		 
    		}
        		else{ 
            			JSONObject jscom = new JSONObject();
            			Comment com = commentService.getCommentById(informa.getCommentId());
            			if(com!=null){
            			jscom.put("news_id", com.getNewsId());
            			jscom.put("info_cont",com.getCommentCont());
            			jscom.put("img", null);
            			}
            		json1.put("cont", jscom);
            	
            		    Reply rep = replyService.getReplyById(informa.getReplyId());
            			if(rep!=null){
            			json1.put("detail_cont", rep.getReplyCont());
            			}
            		}
        		}
	
        	Date d = informa.getCreateTime();
        	String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
        	json1.put("create_time", sdf);
    		inform.add(json1);
		}
		return inform;
		
	}
	
    @RequestMapping(value={"/delinfor"})
    @ResponseBody
    public Object delInfomaByid(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
    	JSONObject json = GetRequestJsonUtils.getRequestJsonObject(request);
    	int id = json.getIntValue("id");
    	int tag = informationService.delInformation(id);
    	if(tag==1){
    	    return true;
    	}else
    		return false;
    }
    
    @RequestMapping(value={"/delinfall"})
    @ResponseBody
    public Object delInfomaByStu(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
    	JSONObject json = GetRequestJsonUtils.getRequestJsonObject(request);
    	String stuId = json.getString("stu_id");
    	int tag = informationService.delInformaBySi(stuId);
    	if(tag==1){
    	    return true;
    	}else
    		return false;
    }
}
