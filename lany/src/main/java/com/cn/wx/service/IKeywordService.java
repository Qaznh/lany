package com.cn.wx.service;

import com.cn.wx.pojo.Keywords;

public interface IKeywordService {

	public Keywords getKeywordById(int keywordid);
	
	public void putKeyword(String keyword);
	
	public void delKeyword(String keyword);
	
	public int getKeywordCount();
	
	public Keywords getKeywordByKeyword(String keyword);
}
