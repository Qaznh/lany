package org.wx.testmybatis;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;  

import org.apache.log4j.Logger;  
import org.junit.Test;  
import org.junit.runner.RunWith;  
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.ClassUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cn.wx.pojo.Comment;
import com.cn.wx.pojo.Keywords;
import com.cn.wx.pojo.News;
import com.cn.wx.pojo.Praise;
import com.cn.wx.pojo.Reply;
import com.cn.wx.pojo.Student;
import com.cn.wx.pojo.Xiaolis;
import com.cn.wx.service.ICommentService;
import com.cn.wx.service.IKeywordService;
import com.cn.wx.service.INewsService;
import com.cn.wx.service.IPraiseService;
import com.cn.wx.service.IReplyService;
import com.cn.wx.service.IStudentService;
import com.cn.wx.service.IUserfeedbackService;
import com.cn.wx.service.IXiaoliService;


@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类  
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"}) 
public class TestMyBatis {

	private static Logger logger = Logger.getLogger(TestMyBatis.class);  
//  private ApplicationContext ac = null;  
    @Resource  
    private INewsService newsService = null;  
    
    @Resource  
    private ICommentService commentService = null;
    
    @Resource  
    private IReplyService replyService = null;
    
    @Resource
    private IPraiseService praiseService = null;
    
    @Resource  
    private IStudentService studentService = null;  
    
    @Resource  
    private IUserfeedbackService userfeedbackService = null; 
//  @Before  
//  public void before() {  
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");  
//      userService = (IUserService) ac.getBean("userService");  
//  }  
  
    @Test  
    public void test1() {  
        
    /*
        List<News> nws= newsService.getNewsByPage(0);
    	
    	List<JSONObject> ns= new ArrayList<JSONObject>();
    	for(int i=0;i<nws.size();i++){
    		News b = nws.get(i);
    		JSONObject json = new JSONObject();
    		json.put("news_id", b.getNewsId());
        	json.put("keyword",b.getKeyword());
        	json.put("stu_id",b.getStuId());
        	json.put("news_cont",b.getNewsCont());
        	List<String> a= new ArrayList<String>();
        	String img = b.getNewsImg();
        	System.out.println(b.getNewsImg());
        	if(img!=null){
                a.add(img);
            }
            System.out.println(a);
        	json.put("news_image", a);
        	json.put("comment_num", b.getCommentNum());
        	json.put("praise_num", b.getPraiseNum());
        	json.put("browse_num", b.getBrowseNum());
        	Date d = b.getCreateTime();
        	String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
        	json.put("create_time", sdf);
        	ns.add(json);
    	}
    	*/
    	
    /*	
    	List<Reply> repl = replyService.getReplyByComtId(1);
    	List<JSONObject> ns= new ArrayList<JSONObject>();
    	for(int i=0;i<repl.size();i++){
    		Reply re = repl.get(i);
    		JSONObject json1 = new JSONObject();
    		json1.put("reply_id", re.getReplyId());
    		json1.put("comment_id", re.getCommentId());
    		json1.put("fromstu_id",re.getFromStuid());
    		json1.put("tostu_id", re.getToStuid());
    		json1.put("reply_cont", re.getReplyCont());
    		Date d = re.getCreateTime();
    		String sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d);
        	json1.put("create_time", sdf);
        	ns.add(json1);
    	}
    	*/
    	
    	/*
    	int newsid = 35;
    	String stuid = "1614080903221";
    	boolean flaggood = true;
    	Timestamp datetime = new Timestamp(System.currentTimeMillis());
    	int tag = praiseService.putPraise(newsid, stuid, datetime,flaggood);
    	if(tag==1)
    	{
    		News news = newsService.getNewsById(newsid);
    		int praise_num = news.getPraiseNum();
    		praise_num++;
    		news.setPraiseNum(praise_num);
    		int tag2 = newsService.addNewsPsNum(news);
    		System.out.println(tag2);
    	}*/
    	
    	/*
    	int tag2 = praiseService.outPraise("123", 53);
    	if(tag2==1){
			News news2 = newsService.getNewsById(53);
    		int praise_num2 = news2.getPraiseNum();
    		praise_num2--;
    		news2.setPraiseNum(praise_num2);
    		newsService.addNewsPsNum(news2);
		}*/
    	
    	/*
    	String id="1614080903221";
    	Student stu = studentService.getStudentById(id);
    	String iconUrl = "http://10.101.112.105:8080/storm/Image/news_image/1614080903221_18f3b6fd-d6b6-43bc-98aa-62f773aca119.jpg";
    	stu.setIconUrl(iconUrl);
    	int tag = studentService.putIconUrl(stu);*/	
    /*	
    	String stuId = "1614080903222";
    	int newsId = 35;
    	Praise ps = praiseService.getprasieBySiNi(stuId, newsId);
    	if(ps==null)
    	{System.out.println(5);}
    	else
    		System.out.println(10);
    	*/
    	String stuid = "1614080903221";
    	String keyword = "显示问题";
    	String comment = "abc";
    	Timestamp datetime = new Timestamp(System.currentTimeMillis());
    	int tag = userfeedbackService.putUserfeedback(stuid, keyword, comment, datetime);
    	
    	//Date d = b.getCreateTime();
        logger.info(tag);
        // System.out.println(user.getUserName());  
        // logger.info("值："+user.getUserName());  
        logger.info(JSON.toJSONString(tag));
        
    } 
}
