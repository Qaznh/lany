package com.cn.wx.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.wx.pojo.Kebiao;
import com.cn.wx.pojo.KebiaoKey;
import com.cn.wx.service.IKebiaoService;

@Controller
@RequestMapping("/kebiao")
public class KebiaoController {

	@Resource
	private IKebiaoService kebiaoService;
	
	@RequestMapping(value={"/showKebiao"},method=RequestMethod.POST)
	@ResponseBody
	public Object showKebiao(HttpServletRequest request,HttpServletResponse response) 
	         throws ServletException, IOException {
		     JSONObject json1 = GetRequestJsonUtils.getRequestJsonObject(request);
		     //String str = json1.toJSONString();
		     //System.out.println(str);
		     String id = json1.getString("id");
		     //System.out.println(id);
		     //String kb_id = GetKbid.getKbid(id);
		     int year = GetData.getYear(id);
		     JSONArray arry = new JSONArray();
			 for(int term=1;term<=8;term++){
		     KebiaoKey key = new KebiaoKey();
		     key.setId(id);
		     key.setTerm(term);
		     Kebiao kb = kebiaoService.getKebiaoById(key);
		     if(kb!=null){
		    	 String kebiao_url = kb.getKebiaoUrl();
		    	 JSONObject json2 = GetData.retuKebiaoJson(year, kebiao_url, term);
		    	 arry.add(json2);
		     }else
			    	continue;
			 }
		    
			 //System.out.println(arry);
			 response.setCharacterEncoding("UTF-8");
			 return arry;
			}
}
	
	//@RequestMapping(value={"/addKebiao"},method=RequestMethod.POST)
	  
