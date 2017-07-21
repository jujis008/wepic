package com.wetuo.wepic.publish.service;

import java.util.List;

import com.wetuo.wepic.publish.beans.StorySystemFilterWords;
import com.wetuo.wepic.publish.dao.StoryFilterWordsDao;

public class StoryFilterWordsServiceImpl implements StoryFilterWordsService {
	StoryFilterWordsDao storyFilterWordsDao;

	public StoryFilterWordsDao getStoryFilterWordsDao() {
		return storyFilterWordsDao;
	}

	public void setStoryFilterWordsDao(StoryFilterWordsDao storyFilterWordsDao) {
		this.storyFilterWordsDao = storyFilterWordsDao;
	}

	public List<StorySystemFilterWords> findAll() {
		// TODO Auto-generated method stub
		return storyFilterWordsDao.findAll();
	}
	
	public Integer insert(StorySystemFilterWords record){
		return storyFilterWordsDao.insert(record);
	}
}
