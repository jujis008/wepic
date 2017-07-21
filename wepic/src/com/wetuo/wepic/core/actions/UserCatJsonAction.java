package com.wetuo.wepic.core.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;

import javax.management.relation.Role;

import org.apache.struts2.json.annotations.JSON;

import com.wetuo.wepic.core.beans.UserCat;
import com.wetuo.wepic.core.service.UserCatService;
import com.wetuo.wepic.core.beans.UserCat;
import com.wetuo.wepic.core.service.UserCatService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
import com.wetuo.wepic.publish.beans.PublishCat;
 
@SuppressWarnings("unchecked")
public class UserCatJsonAction extends PageAction {
  
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
	protected String userCatId = null ; 
 	private UserCatService userCatService;
 	protected List<UserCat> verifyCat;
	
	private List<UserCat> userCatlist;
	
	@JSON(serialize = false)
	public String getUserCatJsonList(){
		try {
			userCatlist = this.getUserCatService().findAll();
//			for(PublishCat pubCat:publishCatlist ){
//				System.out.println("pubCat name :" + pubCat.getName());
//				//System.out.println("pubCat parent name :" + pubCat.getPublishCat().getName());
//				System.out.println("pubCat pid :" + pubCat.getPid());
//			}
			return "getUserCatJsonList";
		} catch (Exception e) {
			e.printStackTrace();
		}
	 return null;
	}
	

	
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserCatId() {
		return userCatId;
	}

	public void setUserCatId(String userCatId) {
		this.userCatId = userCatId;
	}

	public UserCatService getUserCatService() {
		return userCatService;
	}

	public void setUserCatService(UserCatService userCatService) {
		this.userCatService = userCatService;
	}

	public List<UserCat> getUserCatlist() {
		return userCatlist;
	}

	public void setUserCatlist(List<UserCat> userCatlist) {
		this.userCatlist = userCatlist;
	}
	
	
	public List<UserCat> getVerifyCat() {
		return verifyCat;
	}

	public void setVerifyCat(List<UserCat> verifyCat) {
		this.verifyCat = verifyCat;
	}
	

	////////////////////////////////////////////
	public static void main(String[] args) {
		List<String> a=new ArrayList<String>();
		a.add("xx");
		a.add("qq");
		a.add("ww");
		a.add("rr");
		a.add("tt");
		a.add("uu");
		System.out.println(a);
//		String t=a.toString().substring(1,a.toString().length()-1);
//		System.out.println(t);
//		String x[]=t.split(",");
//		for (int i = 0; i < x.length; i++) {
//			System.out.println(x[i]);
//		}
	}
	 
}//end class
