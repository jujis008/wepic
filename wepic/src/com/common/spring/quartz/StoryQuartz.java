package com.common.spring.quartz;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tools.Cleandar;
import com.wetuo.wepic.publish.service.StoryService;
import com.wetuo.wepic.publish.beans.Story;
public class StoryQuartz {
	private StoryService storyService;
	
	public void adminDel() throws Exception {
		Cleandar cleandar=new Cleandar();
		Date current=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		String currentTime=sf.format(current);
		Map<String,Object> m=new HashMap<String, Object>();
		List<Story> userdeleteList=this.getStoryService().admindel();
		for (Story story:userdeleteList) {
			String userdeldate=sf.format(story.getDeltime());
			m.put("START_DATE", userdeldate);
			m.put("END_DATE",currentTime);
			int differday=cleandar.TimeDay2(m);
			if (differday >=30) {
				this.getStoryService().delstorydetailofstory(story.getId());
				this.getStoryService().delcatstory(story.getId());
				this.getStoryService().delete(story);
			}
		}
	}
	public void userDel() throws Exception {
		Cleandar cleandar=new Cleandar();
		Date current=new Date();
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd");
		String currentTime=sf.format(current);
		Map<String,Object> m=new HashMap<String, Object>();
		List<Story> userdeleteList=this.getStoryService().userdel();
		for (Story story:userdeleteList) {
			String userdeldate=sf.format(story.getDeltime());
			m.put("START_DATE", userdeldate);
			m.put("END_DATE",currentTime);
			int differday=cleandar.TimeDay2(m);
			if (differday >=30) {
				this.getStoryService().delstorydetailofstory(story.getId());
				this.getStoryService().delcatstory(story.getId());
				this.getStoryService().delete(story);
			}
		}
	}
	
	
	
   //////////////getter setter////////////////////
	public StoryService getStoryService() {
		return storyService;
	}
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}
}
