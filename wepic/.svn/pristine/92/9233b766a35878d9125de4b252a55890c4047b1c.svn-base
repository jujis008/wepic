package com.wetuo.wepic.publish.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.ObjectUtils.Null;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.junit.runner.Request;

import sun.print.resources.serviceui;

import com.opensymphony.xwork2.ActionContext;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.beans.PublishCat;
import com.wetuo.wepic.publish.beans.PublishSpecialCat;
import com.wetuo.wepic.publish.service.PublishCatService;
import com.wetuo.wepic.publish.service.PublishService;
import com.wetuo.wepic.publish.service.PublishSpecialCatService;
import com.wetuo.wepic.publish.service.StoryService;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.beans.UserCredit;
import com.wetuo.wepic.core.service.ContactService;
import com.wetuo.wepic.core.service.UserCreditService;
import com.wetuo.wepic.core.service.UserService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
 
 
public class PublishSpecialCatAction extends PageAction {
	private static final long serialVersionUID = 1L;
 	private PublishSpecialCatService publishSpecialCatService;
	private UserService userService;
	private ContactService contactService;
	private UserCreditService userCreditService;
	private List<PublishSpecialCat> myUnderCatList;
	private List<PublishSpecialCat> specialCatList;
	private PublishSpecialCat publishSpecialCat;
	private List<List<Object>> publishSpecialCatImglist = new ArrayList<List<Object>>();
	private PublishService publishService;
	private String mgsBack;
	private PublishSpecialCat specialCat;
	public PublishSpecialCatAction(String className) {
		try{
		model=Class.forName(className).newInstance();
		}catch (Exception e) {
			e.printStackTrace();
		}
	     
	}
	public String findSpecialByUser(){
		User user=new User();
		int id=super.getLonginUserId();
		if(id==0){
			return "login";
		}
		user.setId(id);
		myUnderCatList=publishSpecialCatService.AllSpecialByUser(user);
		
		
		return "findSpecialByUser";
	}                  
	
	public String findSpecialOfStoryByUser(){
		User user=new User();
		int id=super.getLonginUserId();
		if(id==0){
			return "login";
		}
		user.setId(id);
		myUnderCatList=publishSpecialCatService.AllSpecialByUser(user);
		
		
		return "findSpecialOfStoryByUser";
	}
	
//    public String getpublishSpecialCats(){
//		
//		int id=super.getLonginUserId();
//		if(id==0){ 
//			return "getpublishSpecialCats";
//			
//		}
//		User user=new User();
//		user.setId(id);
//		publishSpecialCats=publishSpecialCatService.AllSpecialIdByUserName(user);
//		
//		return "getpublishSpecialCats";
//	}
	public Timestamp getcurrent() {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String a=df.format(new Date());
		Timestamp ts = new Timestamp(System.currentTimeMillis());  
		ts.valueOf(a);
		return ts;
	}
	public String savestoryspecial() {
		specialCat=(PublishSpecialCat)model;
		int userId=super.getLonginUserId();
		if(userId==0){
			 specialCat.setTitle("login");
			return "savestoryspecial";
		}
		try{	
			specialCat.setType("commen");
			specialCat.setCheckboxId("0");
			specialCat.setPid(3);
			specialCat.setUploadTime(getcurrent());
			User user=new User();
			user.setId(userId);
			specialCat.setUser(user);
			mgsBack="suc";
		publishSpecialCatService.insert(specialCat);
		specialCat.setTitle(mgsBack);
		
		}catch (Exception e) {
			 mgsBack="error";
			 specialCat.setTitle(mgsBack);
			e.printStackTrace();
			
		}
		
		
		
		
		return "savestoryspecial";
	}
	
	public String saveSpecial(){
		specialCat=(PublishSpecialCat)model;
		int userId=super.getLonginUserId();
		if(userId==0){
			 specialCat.setTitle("login");
			return "saveSpecial";
		}
		try{	
			specialCat.setType("commen");
			specialCat.setCheckboxId("0");
			specialCat.setPid(3);
			specialCat.setUploadTime(getcurrent());
			User user=new User();
			user.setId(userId);
			specialCat.setUser(user);
			mgsBack="suc";
		publishSpecialCatService.insert(specialCat);
		specialCat.setTitle(mgsBack);
		
		}catch (Exception e) {
			 mgsBack="error";
			 specialCat.setTitle(mgsBack);
			e.printStackTrace();
			
		}
		
		
		
		
		return "saveSpecial";
		
		
		
	}
	
	
	
	
	
	
	
	
	public String findSpecialById(){
		 specialCat=publishSpecialCatService.select(((PublishSpecialCat)model).getId());
		 return "saveSpecial";
	}
	
	public String findSpecialByIdOfStory(){
		 specialCat=publishSpecialCatService.select(((PublishSpecialCat)model).getId());
		 return "findSpecialByIdOfStory";
	}
	
	public String editeSpecial(){
		specialCat=(PublishSpecialCat)model;
		int userId=super.getLonginUserId();
		if(userId==0){
			 specialCat.setTitle("login");
			return "saveSpecial";
		}
		try{	
			specialCat.setType("commen");
			specialCat.setPid(3);
			specialCat.setCheckboxId("0");
			User user=new User();
			user.setId(userId);
			specialCat.setUser(user);
			mgsBack="suc";
		publishSpecialCatService.update(specialCat);
		specialCat.setTitle(mgsBack);
		
		}catch (Exception e) {
			 mgsBack="error";
			 specialCat.setTitle(mgsBack);
			e.printStackTrace();
			
		}
		
		 return "saveSpecial";	
		
	}
	
	public String deleteSpPic(){
		int userId=super.getLonginUserId();
		specialCat=new PublishSpecialCat();
		if(userId==0){
			 specialCat.setTitle("login");
			return "saveSpecial";
		}
		
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Publish.class);
		detachedCriteria.add(Restrictions.eq("publishSpecialCat.id", ((PublishSpecialCat)model).getId()));
	   String publishs= publishService.findbyCountBySpecialCat(detachedCriteria);
		if(publishs!=null&&!publishs.equals("")){
			int total=Integer.parseInt(publishs);
			if(total>1){
				specialCat.setTitle("hasPic");
				return "saveSpecial";
			}else{
				//PublishSpecialCat publishSpecialCat= publishSpecialCatService.select(((PublishSpecialCat)model).getId());
				publishSpecialCatService.delete(((PublishSpecialCat)model).getId());
//				publishSpecialCat.setCheckboxId("1");
//				specialCat=new PublishSpecialCat();
//				publishSpecialCatService.update(publishSpecialCat);
				specialCat.setTitle("suc");
				return "saveSpecial";
				
				
			}
		}
		return "saveSpecial";
	}
	public PublishSpecialCatService getPublishSpecialCatService() {
		return publishSpecialCatService;
	}
	public void setPublishSpecialCatService(
			PublishSpecialCatService publishSpecialCatService) {
		this.publishSpecialCatService = publishSpecialCatService;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public ContactService getContactService() {
		return contactService;
	}
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
	public UserCreditService getUserCreditService() {
		return userCreditService;
	}
	public void setUserCreditService(UserCreditService userCreditService) {
		this.userCreditService = userCreditService;
	}
	public List<PublishSpecialCat> getMyUnderCatList() {
		return myUnderCatList;
	}
	public void setMyUnderCatList(List<PublishSpecialCat> myUnderCatList) {
		this.myUnderCatList = myUnderCatList;
	}
	public List<PublishSpecialCat> getSpecialCatList() {
		return specialCatList;
	}
	public void setSpecialCatList(List<PublishSpecialCat> specialCatList) {
		this.specialCatList = specialCatList;
	}
	public PublishSpecialCat getPublishSpecialCat() {
		return publishSpecialCat;
	}
	public void setPublishSpecialCat(PublishSpecialCat publishSpecialCat) {
		this.publishSpecialCat = publishSpecialCat;
	}
	public List<List<Object>> getPublishSpecialCatImglist() {
		return publishSpecialCatImglist;
	}
	public void setPublishSpecialCatImglist(
			List<List<Object>> publishSpecialCatImglist) {
		this.publishSpecialCatImglist = publishSpecialCatImglist;
	}
	public PublishService getPublishService() {
		return publishService;
	}
	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}
	public String getMgsBack() {
		return mgsBack;
	}
	public void setMgsBack(String mgsBack) {
		this.mgsBack = mgsBack;
	}
	public PublishSpecialCat getSpecialCat() {
		return specialCat;
	}
	public void setSpecialCat(PublishSpecialCat specialCat) {
		this.specialCat = specialCat;
	}
	
	////////////////////////////////////////////////////////////////////////2.0版本///////////////////////////////////////////////////////////
	private List<PublishSpecialCat> publishSpecialCats=null;
	private StoryService storyService;
	public String getpublishSpecialCats(){
		
		int id=super.getLonginUserId();
		if(id==0){
			return "getpublishSpecialCats";
			
		}
		User user=new User();
		user.setId(id);
		publishSpecialCats=publishSpecialCatService.AllSpecialIdByUserName(user);
		
		return "getpublishSpecialCats";
	}
	
	@JSON(serialize=false)
 public String getpublishSpecialCats2(){
		
		int id=super.getLonginUserId();
		if(id==0){
			return "getpublishSpecialCats";
			
		}
		User user=new User();
		user.setId(id);
		publishSpecialCats=this.getStoryService().specialCats(id);
		
		return "getpublishSpecialCats2";
	}
	public List<PublishSpecialCat> getPublishSpecialCats() {
		return publishSpecialCats;
	}
	public void setPublishSpecialCats(List<PublishSpecialCat> publishSpecialCats) {
		this.publishSpecialCats = publishSpecialCats;
	}
	public StoryService getStoryService() {
		return storyService;
	}
	public void setStoryService(StoryService storyService) {
		this.storyService = storyService;
	}
	
}