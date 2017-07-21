package com.wetuo.wepic.publish.actions;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.beans.PublishCat_Publish;
import com.wetuo.wepic.publish.beans.PublishPicSearchByTerm;
import com.wetuo.wepic.publish.beans.PublishSpecialCat;
import com.wetuo.wepic.publish.beans.PublishStatus;
import com.wetuo.wepic.publish.service.PublishCatService;
import com.wetuo.wepic.publish.service.PublishCat_PublishService;
import com.wetuo.wepic.publish.service.PublishPicSearchByTermService;
import com.wetuo.wepic.publish.service.PublishService;
import com.wetuo.wepic.publish.service.PublishSpecialCatService;
import com.wetuo.wepic.publish.service.PublishStatusService;

public class PublishPicSearchByTermAction extends PageAction {
	private PublishPicSearchByTerm picSearchByTerm;
	private PublishPicSearchByTermService picSearchByTermService;
	private PublishSpecialCatService publishSpecialCatService;
	
	public PublishPicSearchByTermAction(String className) {
		try {
			model=Class.forName(className).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	
	public String searchByTermfromMylib(){
		picSearchByTerm=(PublishPicSearchByTerm)model;
		if(picSearchByTerm.getSpecalCatId()==null||picSearchByTerm.getSpecalCatId().trim().equals("")){
			PublishSpecialCat specalCat= publishSpecialCatService.selectByName("isDefault");
			picSearchByTerm.setSpecalCatId(specalCat.getId()+"");
			picSearchByTerm.setSpecialName(specalCat.getName());
		}
		picSearchByTerm.setUserId(super.getLonginUserId());
		super.pager=picSearchByTermService.searchByTermfromMylib(picSearchByTerm,pageNo,16);
		return "searchByTermfromMylib";
	}
	
	public String searchstoryByfrom(){
		picSearchByTerm=(PublishPicSearchByTerm)model;
		picSearchByTerm.setUserId(super.getLonginUserId());
		super.pager=picSearchByTermService.searchByTermPicforStory(picSearchByTerm,pageNo,16);
		return "searchstoryByfrom";
	}
	
	public String searchunpublishstoryByfrom() {
		picSearchByTerm=(PublishPicSearchByTerm)model;
		picSearchByTerm.setUserId(super.getLonginUserId());
		super.pager=picSearchByTermService.searchByTermPicforUnpublishStory(picSearchByTerm,pageNo,16);
		return "searchunpublishstoryByfrom";
	}
	
	//查询可以发布的图片
	public String searchByTermfromMylibforPublish(){
		
		picSearchByTerm=(PublishPicSearchByTerm)model;
		if(picSearchByTerm.getSpecalCatId()==null||picSearchByTerm.getSpecalCatId().trim().equals("")){
			PublishSpecialCat specalCat= publishSpecialCatService.selectByName("isDefault");
			picSearchByTerm.setSpecalCatId(specalCat.getId()+"");
			picSearchByTerm.setSpecialName(specalCat.getName());
			
			
		}
		
		//picSearchByTerm=(PublishPicSearchByTerm)model;
		picSearchByTerm.setUserId(super.getLonginUserId());
		super.pager=picSearchByTermService.searchByTermPicforPublish(picSearchByTerm,pageNo,200);
		return "searchByTermfromMylibforPublish";
	}
	
	//查询用户可以图片
	public String searchByTermfromMylibforUser(){
		
		picSearchByTerm=(PublishPicSearchByTerm)model;
		if(picSearchByTerm.getSpecalCatId()==null||picSearchByTerm.getSpecalCatId().trim().equals("")){
			PublishSpecialCat specalCat= publishSpecialCatService.selectByName("isDefault");
			picSearchByTerm.setSpecalCatId(specalCat.getId()+"");
			picSearchByTerm.setSpecialName(specalCat.getName());
			
			
		}
		
		//picSearchByTerm=(PublishPicSearchByTerm)model;
		picSearchByTerm.setUserId(super.getLonginUserId());
		super.pager=picSearchByTermService.searchByTermPicforPublish(picSearchByTerm,pageNo,200);
		return "searchByTermfromMylibforUser";
	}
	
public String searchByTermfromMylibforHonor(){
		
		picSearchByTerm=(PublishPicSearchByTerm)model;
		if(picSearchByTerm.getSpecalCatId()==null||picSearchByTerm.getSpecalCatId().trim().equals("")){
			PublishSpecialCat specalCat= publishSpecialCatService.selectByName("isDefault");
			picSearchByTerm.setSpecalCatId(specalCat.getId()+"");
			picSearchByTerm.setSpecialName(specalCat.getName());
			
			
		}
		
		//picSearchByTerm=(PublishPicSearchByTerm)model;
		picSearchByTerm.setUserId(super.getLonginUserId());
		super.pager=picSearchByTermService.searchByTermPicforPublish(picSearchByTerm,pageNo,200);
		return "searchByTermfromMylibforHonor";
	}

	

public String searchByTermfromMylibforUserPic(){
	
	picSearchByTerm=(PublishPicSearchByTerm)model;
	if(picSearchByTerm.getSpecalCatId()==null||picSearchByTerm.getSpecalCatId().trim().equals("")){
		PublishSpecialCat specalCat= publishSpecialCatService.selectByName("isDefault");
		picSearchByTerm.setSpecalCatId(specalCat.getId()+"");
		picSearchByTerm.setSpecialName(specalCat.getName());
		
		
	}
	
	//picSearchByTerm=(PublishPicSearchByTerm)model;
	picSearchByTerm.setUserId(super.getLonginUserId());
	super.pager=picSearchByTermService.searchByTermPicforPublish(picSearchByTerm,pageNo,200);
	return "searchByTermfromMylibforUserPic";
}

	
	public PublishPicSearchByTerm getPicSearchByTerm() {
		return picSearchByTerm;
	}


	public void setPicSearchByTerm(PublishPicSearchByTerm picSearchByTerm) {
		this.picSearchByTerm = picSearchByTerm;
	}


	public PublishPicSearchByTermService getPicSearchByTermService() {
		return picSearchByTermService;
	}


	public void setPicSearchByTermService(
			PublishPicSearchByTermService picSearchByTermService) {
		this.picSearchByTermService = picSearchByTermService;
	}


	public PublishSpecialCatService getPublishSpecialCatService() {
		return publishSpecialCatService;
	}


	public void setPublishSpecialCatService(
			PublishSpecialCatService publishSpecialCatService) {
		this.publishSpecialCatService = publishSpecialCatService;
	}
    

	

}
