package com.wetuo.wepic.publish.service;

import java.util.List;

import com.wetuo.wepic.publish.beans.StorySystemFilterWords;

public interface StoryFilterWordsService {
	List<StorySystemFilterWords> findAll();
	public Integer insert(StorySystemFilterWords record);
}
