package com.wetuo.wepic.publish.actions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.opensymphony.xwork2.ActionSupport;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
import com.wetuo.wepic.publish.beans.Video;
import com.wetuo.wepic.publish.beans.VideoSpecialCat;
import com.wetuo.wepic.publish.service.VideoService;
import com.wetuo.wepic.publish.service.VideoSpecialCatService;

public class VideoSpecialCatAction extends PageAction {
	private VideoSpecialCatService videoSpecialCatService;
	private UserService userService;
	private VideoService videoService;
	private String name;	//专辑名称
	private int isExist;	//专辑名称是否存在 1（存在） 0（不存在）
	
	Map<Integer,String> videoSpeciaCatlMap=null;		//用户的视频专辑类表及同列表下的第一个视频的预览图
	
	
	public Map<Integer, String> getVideoSpeciaCatlMap() {
		return videoSpeciaCatlMap;
	}

	public void setVideoSpeciaCatlMap(Map<Integer, String> videoSpeciaCatlMap) {
		this.videoSpeciaCatlMap = videoSpeciaCatlMap;
	}
	private List<VideoSpecialCat> videoSpecialCats;
	
	
	public VideoService getVideoService() {
		return videoService;
	}

	public void setVideoService(VideoService videoService) {
		this.videoService = videoService;
	}

	public List<VideoSpecialCat> getVideoSpecialCats() {
		return videoSpecialCats;
	}

	public void setVideoSpecialCats(List<VideoSpecialCat> videoSpecialCats) {
		this.videoSpecialCats = videoSpecialCats;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public int getIsExist() {
		return isExist;
	}

	public void setIsExist(int isExist) {
		this.isExist = isExist;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public VideoSpecialCatService getVideoSpecialCatService() {
		return videoSpecialCatService;
	}

	public void setVideoSpecialCatService(
			VideoSpecialCatService videoSpecialCatService) {
		this.videoSpecialCatService = videoSpecialCatService;
	}
	
	/**
	 * 查看所有添加的专辑名称是否存在
	 * @return 
	 */
	public String nameIsExist(){
		
		VideoSpecialCat videoSpecialCat=videoSpecialCatService.findVideoSpecialCatByName(name);
		if(videoSpecialCat!=null){
			isExist=1;
		}else{
			isExist=0;
		}
		return "nameIsExist";
	}
	/**
	 * 查找用户的专辑列表
	 * @return
	 */
	public String videoSpecialCatAlbum1(){
		
		String loginName=super.getLoginUsername();
		if(loginName==null||loginName.length()==0){
			return "login";
		}else{
			User user=userService.select(loginName);
			videoSpecialCats=videoSpecialCatService.findAllVideoSpecialCatByUser(user);
			if(videoSpecialCats.size()==0){
			return "videoSpecialCatAlbum1";
			}else{
				videoSpeciaCatlMap=new HashMap<Integer, String>();
				for(int i=0;i<videoSpecialCats.size();i++){
					//根据专辑名去查找视频该专辑下的视频列表 
					Video video=videoService.findVideoListByVideoSpecialCat(videoSpecialCats.get(i), user).get(0);
					//如果视频列表不为空 则显示给专辑列表为空
					//如果视频类表不为空 则将Map中放入改视频列表下的第一张图片
					//如果视频类表不为空 则将Map中放入改视频列表下的第一张图片
					if(video==null){
						videoSpeciaCatlMap.put(videoSpecialCats.get(i).getId(),null);
					}else{
						videoSpeciaCatlMap.put(videoSpecialCats.get(i).getId(), video.getPicUrl());
					}

					//如果视频正在转换状态 则放入一个默认的图片的地址
				}
			}
		}
		return "videoSpecialCatAlbum1";
	}
}
