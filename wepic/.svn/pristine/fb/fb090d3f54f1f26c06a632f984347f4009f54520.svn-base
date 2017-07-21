package com.wetuo.wepic.publish.service;

import java.util.List;

import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.publish.beans.VideoSpecialCat;
import com.wetuo.wepic.publish.dao.VideoSpecialCatDao;

public class VideoSpecialCatServiceImpl implements VideoSpecialCatService {
	private VideoSpecialCatDao videoSpecialCatDao;
	
	public VideoSpecialCatDao getVideoSpecialCatDao() {
		return videoSpecialCatDao;
	}

	public void setVideoSpecialCatDao(VideoSpecialCatDao videoSpecialCatDao) {
		this.videoSpecialCatDao = videoSpecialCatDao;
	}

	/**
	 * 查找用户的所有视频专辑
	 */
	public List findAllVideoSpecialCatByUser(User user) {
		// TODO Auto-generated method stub
		List videoSpecialCats=null;
		videoSpecialCats=videoSpecialCatDao.findAllVideoSpecialCatByUser(user);
		return videoSpecialCats;
	}
	/**
	 * 根据专辑名字查找专辑
	 * @param name
	 * @return
	 */
	public VideoSpecialCat findVideoSpecialCatByName(String name){
		VideoSpecialCat videoSpecialCat=null;
		videoSpecialCat=videoSpecialCatDao.selectByName(name);
		return videoSpecialCat;
	}

}
