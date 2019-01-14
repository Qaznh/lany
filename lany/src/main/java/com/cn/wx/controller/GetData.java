package com.cn.wx.controller;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONObject;
import com.cn.wx.pojo.Student;
import com.cn.wx.service.IStudentService;

public class GetData {

	@Resource  
    private static IStudentService studentService;
	
	public static char[] a = new char[13];
	public  static int getYear(String id){
		for(int i=0;i<id.length();i++) 
		   {a[i] = id.charAt(i);}
		String year = String.valueOf(a[0])+String.valueOf(a[1]);
			int i = Integer.parseInt(year);
			//System.out.println(i);
		return i;
	}
	
	public static JSONObject retuGradeJson(int year,String url,int term){
		JSONObject json = new JSONObject();
		switch(term){
		case 1:{
			int a = year + 1;
			String str1 = "20"+year+"-"+"20"+a+"学年第一学期";
			json.put("label", str1);
			json.put("value", url);
			break;
			
		}
		case 2:{
			int a = year + 1;
			String str2 = "20"+year+"-"+"20"+a+"学年第二学期";
			json.put("label", str2);
			json.put("value", url);
			break;
		}
		case 3:{
			int a = year + 1;
			int b = year + 2;
			String str3 = "20"+a+"-"+"20"+b+"学年第一学期";
			json.put("label", str3);
			json.put("value", url);
			break;
		}
		case 4:{
			int a = year + 1;
			int b = year + 2;
			String str4 = "20"+a+"-"+"20"+b+"学年第二学期";
			json.put("label", str4);
			json.put("value", url);
			break;
		}
		case 5:{
			int a = year + 2;
			int b = year + 3;
		    String str5 = "20"+a+"-"+"20"+b+"学年第一学期";
			json.put("label", str5);
			json.put("value", url);
			break;
		}
		case 6:{
			int a = year + 2;
			int b = year + 3;
			String str6 = "20"+a+"-"+"20"+b+"学年第二学期";
			json.put("label", str6);
			json.put("value", url);
			break;
		}
		case 7:{
			int a = year + 3;
			int b = year + 4;
			String str7 = "20"+a+"-"+"20"+b+"学年第一学期";
			json.put("label", str7);
			json.put("value", url);
			break;
		}
		case 8:{
			int a = year + 3;
			int b = year + 4;
			String str8 = "20"+a+"-"+"20"+b+"学年第二学期";
			json.put("label", str8);
			json.put("value", url);
			break;
		}
	   }
		return json;
	}
	
	public static JSONObject retuKebiaoJson(int year,String url,int term){
		JSONObject json = new JSONObject();
		switch(term){
		case 1:{
			int a = year + 1;
			String str1 = "20"+year+"-"+"20"+a+"学年第一学期";
			json.put("label", str1);
			json.put("value", url);
			break;
			
		}
		case 2:{
			int a = year + 1;
			String str2 = "20"+year+"-"+"20"+a+"学年第二学期";
			json.put("label", str2);
			json.put("value", url);
			break;
		}
		case 3:{
			int a = year + 1;
			int b = year + 2;
			String str3 = "20"+a+"-"+"20"+b+"学年第一学期";
			json.put("label", str3);
			json.put("value", url);
			break;
		}
		case 4:{
			int a = year + 1;
			int b = year + 2;
			String str4 = "20"+a+"-"+"20"+b+"学年第二学期";
			json.put("label", str4);
			json.put("value", url);
			break;
		}
		case 5:{
			int a = year + 2;
			int b = year + 3;
		    String str5 = "20"+a+"-"+"20"+b+"学年第一学期";
			json.put("label", str5);
			json.put("value", url);
			break;
		}
		case 6:{
			int a = year + 2;
			int b = year + 3;
			String str6 = "20"+a+"-"+"20"+b+"学年第二学期";
			json.put("label", str6);
			json.put("value", url);
			break;
		}
		case 7:{
			int a = year + 3;
			int b = year + 4;
			String str7 = "20"+a+"-"+"20"+b+"学年第一学期";
			json.put("label", str7);
			json.put("value", url);
			break;
		}
		case 8:{
			int a = year + 3;
			int b = year + 4;
			String str8 = "20"+a+"-"+"20"+b+"学年第二学期";
			json.put("label", str8);
			json.put("value", url);
			break;
		}
	   }
		return json;
	}
	
	public static JSONObject retuKeywordJson(int count,String kws){
		JSONObject json = new JSONObject();
		json.put("name", kws);
		return json;
	}
	
	public static String getStunameByid(String id){
		Student stu = studentService.getStudentById(id);
		String stu_name = stu.getStuName();
		return stu_name;
	}
}
