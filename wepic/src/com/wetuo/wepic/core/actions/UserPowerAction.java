package com.wetuo.wepic.core.actions;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.beans.UserDetail;
import com.wetuo.wepic.core.beans.UserPower;
import com.wetuo.wepic.core.service.UserDetailService;
import com.wetuo.wepic.core.service.UserPowerService;
import com.wetuo.wepic.core.tools.ModelDriverReflect;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.service.PublishService;

@SuppressWarnings("serial")
public class UserPowerAction extends PageAction{

	public UserPowerAction(String className) {
		try{
		model=Class.forName(className).newInstance();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public String getAllUserPowerInfo(){
		int userId=super.getLonginUserId();
		User user=new User();
		user.setId(userId);
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(UserPower.class);
		detachedCriteria.createAlias("user", "user");
		detachedCriteria.add(Restrictions.eq("user", user));
		detachedCriteria.add(Restrictions.eq("zhengMingType","1"));
		List<UserPower> list=null;
		try{
			
		userPowers=powerService.findUserPowers(detachedCriteria);
		DetachedCriteria detachedCriteria1=DetachedCriteria.forClass(UserPower.class);
		detachedCriteria1.createAlias("user", "user");
		detachedCriteria1.add(Restrictions.eq("user", user));
		detachedCriteria1.add(Restrictions.eq("zhengMingType","2"));
     	projectuserPowers=powerService.findUserPowers(detachedCriteria1);
     	
     	
     	
     	
     	DetachedCriteria detachedCriteria2=DetachedCriteria.forClass(UserPower.class);
		detachedCriteria2.createAlias("user", "user");
		detachedCriteria2.add(Restrictions.eq("user", user));
		detachedCriteria2.add(Restrictions.eq("zhengMingType","3"));
     	hornoList=powerService.findUserPowers(detachedCriteria2);
     	
     	
     	
     	
     	
     	
     	
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		return "getAllUserPowerInfo";
	}             
	public String addUserPower() {
		@SuppressWarnings("unused")
		UserPower power=(UserPower)model;
		int userId=super.getLonginUserId();
		User user=new User();
		user.setId(userId);
		power.setUser(user);
		powerService.addUserPower(power);
		if(picIds!=null&&picIds!=""){
			String[] id=picIds.split(" ");
			if(picIds.contains(" ")){
				for (String string : id) {
					Publish publish=publishService.select(Integer.parseInt(string));
					UserDetail detail=new UserDetail();
					detail.setPicUrl(publish.getThumbnail125());
					detail.setUserPower(power);
					detail.setUser(user);
					detail.setName(publish.getId()+"");
					detailService.insert(detail);
					}	
				
			}else{
				Publish publish=publishService.select(Integer.parseInt(picIds));
				UserDetail detail=new UserDetail();
				detail.setPicUrl(publish.getThumbnail125());
				detail.setUserPower(power);
				detail.setUser(user);
				detail.setName(publish.getId()+"");
				detailService.insert(detail);
			}
			
		}
		
		return "addUserPower";
	}
    public String getByUserPoweId(){
    	DetachedCriteria detachedCriteria=DetachedCriteria.forClass(UserPower.class);
    	detachedCriteria.add(Restrictions.eq("id", ((UserPower)model).getId()));
        List<UserPower> powers=	powerService.findUserPowers(detachedCriteria);
    	if(powers!=null&&powers.size()>0){
    		userPower=powers.get(0);
    	}
    	
    	
    	return "getByUserPoweId";
    }
    
    public String deleteUserPower(){
    	
    	    
			DetachedCriteria criteria=DetachedCriteria.forClass(UserDetail.class);
			criteria.createAlias("userPower", "userPower");
			criteria.add(Restrictions.eq("userPower",(UserPower)model));
			List<UserDetail> userDetails=detailService.findAllUserPower(criteria);
			for (UserDetail userDetail : userDetails) {
				detailService.delete(userDetail);
			}
			powerService.deleteRecode(((UserPower)model).getId());
    	
    	return "deleteUserPower";
    }
    
    
    
    public String getediteUserPoweId(){
    	int userId=super.getLonginUserId();
		User user=new User();
		user.setId(userId);
		DetachedCriteria detachedCriteria=DetachedCriteria.forClass(UserPower.class);
		detachedCriteria.createAlias("user", "user");
		detachedCriteria.add(Restrictions.eq("user", user));
		detachedCriteria.add(Restrictions.eq("id", ((UserPower)model).getId()));
		//detachedCriteria.add(Restrictions.eq("zhengMingType","1"));
		List<UserPower> list=null;
		try{
			list=powerService.findUserPowers(detachedCriteria);
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(list!=null&&list.size()>0){
			userPower=list.get(0);
			
		}else{
			
			return "getediteUserPoweId";
		}
		
    	DetachedCriteria criteria=DetachedCriteria.forClass(UserDetail.class);
		criteria.createAlias("userPower", "userPower");
		criteria.add(Restrictions.eq("userPower",userPower));
		List<UserDetail> userDetails=detailService.findAllUserPower(criteria);
		userPower.setUserDetails(userDetails);
    	
    	
    	return "getediteUserPoweId";
    }
    
    public String updateUserPower(){
    	int userId=super.getLonginUserId();
    	if(userId==0){
    	return "login";	
    	}
		User user=new User();
		user.setId(userId);
    	UserPower oldpower=powerService.findPowersById(((UserPower) model).getId());
    	DetachedCriteria criteria=DetachedCriteria.forClass(UserDetail.class);
		criteria.createAlias("userPower", "userPower");
		criteria.add(Restrictions.eq("userPower",(UserPower)model));
		List<UserDetail> userDetails=detailService.findAllUserPower(criteria);
		for (UserDetail userDetail : userDetails) {
			detailService.delete(userDetail);
		}
		
    	ModelDriverReflect driverReflect=new ModelDriverReflect();
    	UserPower out=(UserPower)driverReflect.Reflect("com.wetuo.wepic.core.beans.UserPower",oldpower ,(UserPower) model);
    	powerService.editeRecode(out);
    	if(picIds!=null&&picIds!=""){
			String[] id=picIds.split(" ");
			for (String string : id) {
			Publish publish=publishService.select(Integer.parseInt(string));
			UserDetail detail=new UserDetail();
			detail.setPicUrl(publish.getSmalldrawUrl());
			detail.setUserPower(out);
			detail.setUser(user);
			detailService.insert(detail);
			
			}
    	}
    	return "updateUserPower";
    	
    	
    }
	public String deleteRecode(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String editeRecode(UserPower userPower) {
		// TODO Auto-generated method stub
		return null;
	}

	public String findUserPowers(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return null;
	}

	
	private UserPowerService powerService;
	private String  picIds;
	private PublishService publishService;
	private UserDetailService detailService;
	private List<UserPower> userPowers;
	private UserPower userPower;
	private List<UserPower> projectuserPowers;
	private List<UserPower> hornoList;
	public UserPowerService getPowerService() {
		return powerService;
	}
	public void setPowerService(UserPowerService powerService) {
		this.powerService = powerService;
	}


	public List<UserPower> getHornoList() {
		return hornoList;
	}



	public void setHornoList(List<UserPower> hornoList) {
		this.hornoList = hornoList;
	}



	public List<UserPower> getProjectuserPowers() {
		return projectuserPowers;
	}



	public void setProjectuserPowers(List<UserPower> projectuserPowers) {
		this.projectuserPowers = projectuserPowers;
	}



	public UserPower getUserPower() {
		return userPower;
	}



	public void setUserPower(UserPower userPower) {
		this.userPower = userPower;
	}



	public List<UserPower> getUserPowers() {
		return userPowers;
	}



	public void setUserPowers(List<UserPower> userPowers) {
		this.userPowers = userPowers;
	}



	public String getPicIds() {
		return picIds;
	}



	public void setPicIds(String picIds) {
		this.picIds = picIds;
	}



	public PublishService getPublishService() {
		return publishService;
	}



	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}



	public UserDetailService getDetailService() {
		return detailService;
	}



	public void setDetailService(UserDetailService detailService) {
		this.detailService = detailService;
	}
	
	
	
	
	
	
	
	

}
