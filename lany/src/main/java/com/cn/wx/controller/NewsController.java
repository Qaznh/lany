package com.cn.wx.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


import com.alibaba.fastjson.JSONObject;
import com.cn.wx.pojo.News;
import com.cn.wx.pojo.Praise;
import com.cn.wx.pojo.Student;
import com.cn.wx.service.IKeywordService;
import com.cn.wx.service.INewsService;
import com.cn.wx.service.IPraiseService;
import com.cn.wx.service.IStudentService;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	static String news_imgurl=null;
	static String news_imgurl1=null;
	static String news_imgurl2=null;
	
	@Resource
	private INewsService newsService;
	@Resource
	private IKeywordService keywordService;
	@Resource
	private IPraiseService praiseService;
	@Resource  
    private IStudentService studentService;
	
	
	
	@RequestMapping(value={"/showNews"},method=RequestMethod.POST)
	@ResponseBody
	public Object showNews(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
		JSONObject json = GetRequestJsonUtils.getRequestJsonObject(request);
		int newsid = json.getIntValue("news_id");
		String stuId = json.getString("stu_id"); 
		boolean flaggood;
		//System.out.println(newsid);
		Praise ps = praiseService.getprasieBySiNi(stuId, newsid);
		if(ps==null){
			flaggood = false;
		}
		else
			{flaggood = true;}
		News nw = newsService.getNewsById(newsid);
		 int brnu =nw.getBrowseNum();
		 brnu++;
		 nw.setBrowseNum(brnu);
		newsService.addNewsBrNum(nw);
		JSONObject json1 = new JSONObject();
		Student stu = studentService.getStudentById(nw.getStuId());
		json1.put("stu_name", stu.getStuName());
		json1.put("icon_url",stu.getIconUrl());
		json1.put("news_id", nw.getNewsId());
    	json1.put("keyword",nw.getKeyword());
    	json1.put("stu_id",nw.getStuId());
    	json1.put("news_cont",nw.getNewsCont());
    	json1.put("flaggood", flaggood);
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
    	json1.put("news_image", a);
    	json1.put("comment_num", nw.getCommentNum());
    	json1.put("praise_num", nw.getPraiseNum());
    	json1.put("browse_num", nw.getBrowseNum());
    	Date d = nw.getCreateTime();
    	String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
    	json1.put("create_time", sdf);
		return json1;
	}
	

	@RequestMapping(value={"/showNewsDesc"},method=RequestMethod.POST)
	@ResponseBody
	public Object showNewsDesc(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
		JSONObject json = new JSONObject();
    	News nw = newsService.getNewsDesc();
    	json.put("news_id", nw.getNewsId());
    	json.put("keyword",nw.getKeyword());
    	json.put("stu_id",nw.getStuId());
    	json.put("news_cont",nw.getNewsCont());
    	json.put("news_image", nw.getNewsImg());
    	json.put("comment_num", nw.getCommentNum());
    	json.put("praise_num", nw.getPraiseNum());
    	json.put("browse_num", nw.getBrowseNum());
    	Date d = nw.getCreateTime();
    	String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
    	json.put("create_time", sdf);
		return json;
	}
	
	
	@RequestMapping(value={"/upload"})
    @ResponseBody
    public void upload(HttpServletRequest request, @RequestParam(value = "file", required = false) MultipartFile file) 
			 throws IOException {
	   
       //System.out.println("执行upload");
       request.setCharacterEncoding("UTF-8");
       String id = request.getParameter("id");
       int count = Integer.parseInt(request.getParameter("count")); 
       if(!file.isEmpty()) {
        
           String fileName = file.getOriginalFilename();
           //System.out.println(fileName); wx4e7f9e9721288267.o6zAJsxcKurhZtmz7TBYVXJCUG4I.BF1ydRZlvzQt2b04df3ecc1d94afddff082d139c6f15.jpg
           
           String path = null;
           String type = null;
           type = fileName.indexOf(".") != -1 ? fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()) : null;
        
           if (type != null) {
               if ("GIF".equals(type.toUpperCase())||"PNG".equals(type.toUpperCase())||"JPG".equals(type.toUpperCase())) {
                   // 项目在容器中实际发布运行的根路径
            	   String realPath = request.getSession().getServletContext().getRealPath("")+"Image\\news_image\\";
            	   //System.out.println(realPath);
                   //String realPath = "Q:\\Users\\Aqzh\\git\\lany\\src\\main\\webapp\\Image\\news_image\\";
                   // 自定义的文件名称
                   String trueFileName = id +"_"+ UUID.randomUUID().toString()+"."+type.toLowerCase();
                  // System.out.println(trueFileName);
                   //System.out.println(trueFileName);
                   // 设置存放图片文件的路径
                   path = realPath + trueFileName; 
                   file.transferTo(new File(path));
                   String serverPath1 = "http://10.101.112.105:8080/lany/Image/news_image/";
                   switch(count)
                   {
                   case 0:news_imgurl = serverPath1 + trueFileName; break;
                   case 1:news_imgurl1 = serverPath1 + trueFileName;break;
                   case 2:news_imgurl2 = serverPath1 + trueFileName;break;
                   }
               }
           }
         }
      }
	
	
    @RequestMapping(value={"/addNews"})
    @ResponseBody
    public boolean addNews(HttpServletRequest request)
			 throws ServletException, IOException{
    	
    	request.setCharacterEncoding("UTF-8");
    	JSONObject json1 = GetRequestJsonUtils.getRequestJsonObject(request);   	
    	String id = json1.getString("id");
    	//System.out.println(id);
    	String keyword = json1.getString("keyword");
    	//System.out.println(keyword);
        String news_cont = json1.getString("news_cont");
        //System.out.println(news_cont);
        Timestamp datetime = new Timestamp(System.currentTimeMillis());
        
        int tag = newsService.putNews(id, keyword, news_imgurl, news_imgurl1, news_imgurl2, news_cont, datetime);
        news_imgurl=null;
        news_imgurl1=null;
        news_imgurl2=null;
        if(tag==1)
    	  return true;
        else
          return false;
    
   }
    
    @RequestMapping(value={"/showNewsPage"})
    @ResponseBody
    public Object showNewsPage(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
    	JSONObject json1 = GetRequestJsonUtils.getRequestJsonObject(request);
    	//System.out.println(json1.getIntValue("page"));
    	int start = (json1.getIntValue("page")*10);
    	String stuId = json1.getString("stu_id"); 
    	//System.out.println(stuId);
    	List<News> nws= newsService.getNewsByPage(start);
    	List<JSONObject> ns= new ArrayList<JSONObject>();
    	for(int i=0;i<nws.size();i++){
    		News b = nws.get(i);
    		JSONObject json = new JSONObject();
    		Student stu = studentService.getStudentById(b.getStuId());
    		boolean flaggood;
    		Praise ps = praiseService.getprasieBySiNi(stuId, b.getNewsId());
    		if(ps==null){
    			flaggood = false;
    		}
    		else
    			{flaggood = true;}
    		json.put("stu_name", stu.getStuName());
    		json.put("icon_url",stu.getIconUrl());
    		json.put("news_id", b.getNewsId());
        	json.put("keyword",b.getKeyword());
        	json.put("stu_id",b.getStuId());
        	json.put("news_cont",b.getNewsCont());
        	json.put("flaggood",flaggood);
        	List<String> a= new ArrayList<String>();
        	String img = b.getNewsImg();
        	String img1 = b.getNewsImg1();
        	String img2 = b.getNewsImg2();
        	if(img!=null){
            a.add(img);
            }
        	if(img1!=null){
        	 a.add(img1);
        	}
        	if(img2!=null){
        	 a.add(img2);
        	}
        	json.put("news_image", a);
        	json.put("comment_num", b.getCommentNum());
        	json.put("praise_num", b.getPraiseNum());
        	json.put("browse_num", b.getBrowseNum());
        	Date d = b.getCreateTime();
        	String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
        	json.put("create_time", sdf);
        	ns.add(json);
    	}
    	
		return ns;
    }
    
    @RequestMapping(value={"/showNewsByKw"})
    @ResponseBody
    public Object showNewsByKw(HttpServletRequest request,HttpServletResponse response)
			 throws ServletException, IOException{
    	JSONObject json1 = GetRequestJsonUtils.getRequestJsonObject(request);
    	//System.out.println(json1.getIntValue("page"));
    	int start = (json1.getIntValue("page")*10);
    	String keyword =json1.getString("keyword");
    	String stuId = json1.getString("stu_id"); 
    	List<News> nws= newsService.getNewsByKeyword(keyword,start);
    	List<JSONObject> ns= new ArrayList<JSONObject>();
    	for(int i=0;i<nws.size();i++){
    		News b = nws.get(i);
    		JSONObject json = new JSONObject();
    		Student stu = studentService.getStudentById(b.getStuId());
    		boolean flaggood;
    		Praise ps = praiseService.getprasieBySiNi(stuId, b.getNewsId());
    		if(ps==null){
    			flaggood = false;
    		}
    		else
    			{flaggood = true;}
    		json.put("stu_name", stu.getStuName());
    		json.put("icon_url", stu.getIconUrl());
    		json.put("news_id", b.getNewsId());
        	json.put("keyword",b.getKeyword());
        	json.put("stu_id",b.getStuId());
        	json.put("news_cont",b.getNewsCont());
        	json.put("flaggood",flaggood);
        	List<String> a= new ArrayList<String>();
        	String img = b.getNewsImg();
        	String img1 = b.getNewsImg1();
        	String img2 = b.getNewsImg2();
        	if(img!=null){
            a.add(img);
            }
        	if(img1!=null){
        	 a.add(img1);
        	}
        	if(img2!=null){
        	 a.add(img2);
        	}
        	json.put("news_image", a);
        	json.put("comment_num", b.getCommentNum());
        	json.put("praise_num", b.getPraiseNum());
        	json.put("browse_num", b.getBrowseNum());
        	Date d = b.getCreateTime();
        	String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
        	json.put("create_time", sdf);
        	ns.add(json);
    	}
    	return ns;
    }
    
}
