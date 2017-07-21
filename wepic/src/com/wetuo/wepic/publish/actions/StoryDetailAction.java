package com.wetuo.wepic.publish.actions;

import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.publish.service.PublishCatService;
import com.wetuo.wepic.publish.service.PublishService;
import com.wetuo.wepic.publish.service.StoryDetailService;
import com.wetuo.wepic.publish.service.StoryService;

public class StoryDetailAction extends PageAction{
	private StoryService storyService;
	private StoryDetailService storyDetailService;
	private PublishCatService publishCatService;
	private PublishService publishService;
	
	
	public StoryService getStoryService() {
		return storyService;
	}
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}
	public StoryDetailService getStoryDetailService() {
		return storyDetailService;
	}
	public void setStoryDetailService(StoryDetailService storyDetailService) {
		this.storyDetailService = storyDetailService;
	}
	public PublishCatService getPublishCatService() {
		return publishCatService;
	}
	public void setPublishCatService(PublishCatService publishCatService) {
		this.publishCatService = publishCatService;
	}
	public PublishService getPublishService() {
		return publishService;
	}
	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}

}
