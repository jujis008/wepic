package com.wetuo.wepic.publish.service;

import java.util.List;

import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.publish.beans.Video;
import com.wetuo.wepic.publish.beans.VideoSpecialCat;

public interface VideoService {
	/**
	 * 根据用户视频专辑查找视频列表
	 * @param videoSpecialCat
	 * @return
	 */
	public List<Video> findVideoListByVideoSpecialCat(VideoSpecialCat videoSpecialCat,User user);
}
