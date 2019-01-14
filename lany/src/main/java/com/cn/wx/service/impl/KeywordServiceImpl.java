package com.cn.wx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cn.wx.dao.KeywordsMapper;
import com.cn.wx.pojo.Keywords;
import com.cn.wx.service.IKeywordService;

@Service("keywordService")
public class KeywordServiceImpl implements IKeywordService{
	@Resource
	private KeywordsMapper keywordDao;
	public Keywords getKeywordById(int keywordid){
		return this.keywordDao.selectByPrimaryKey(keywordid);
	}

	public int getKeywordCount(){
		return this.keywordDao.selectCount();
	}
	
	public void putKeyword(String keyword){
		Keywords  kw = new Keywords();
		int count = this.keywordDao.selectCount() +1 ;
		kw.setKwId(count);
		kw.setKeyword(keyword);
		kw.setEnable(1);
		this.keywordDao.insert(kw);
	}
	
	public void delKeyword(String keyword){
		Keywords kw = new Keywords();
		kw.setKeyword(keyword);
		this.keywordDao.deleteByKeyword(keyword);
	}
	
	public Keywords getKeywordByKeyword(String keyword){
		return this.keywordDao.selectByKeyword(keyword);
	}
}
