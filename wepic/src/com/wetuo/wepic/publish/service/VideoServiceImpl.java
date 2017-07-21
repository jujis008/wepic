package com.wetuo.wepic.publish.service;

import java.util.List;

import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.publish.beans.Video;
import com.wetuo.wepic.publish.beans.VideoSpecialCat;
import com.wetuo.wepic.publish.dao.VideoDao;

public class VideoServiceImpl implements VideoService {
	private VideoDao videoDao;

	public VideoDao getVideoDao() {
		return videoDao;
	}

	public void setVideoDao(VideoDao videoDao) {
		this.videoDao = videoDao;
	}
	
	/**
	 * 根据用户的视频专辑查找视频列表
	 * @param videoSpecialCat
	 * @return
	 */
	public List<Video> findVideoListByVideoSpecialCat(VideoSpecialCat videoSpecialCat,User user){
		List<Video> videoList=null;
		videoList=videoDao.findVideoListByVideoSpecialCat(videoSpecialCat, user);
		return videoList;
	}
}
