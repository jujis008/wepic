package com.wetuo.wepic.publish.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.util.StringTokenizer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import java.sql.Blob;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.service.PublishService;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
 
 
import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;

	import com.wetuo.wepic.publish.beans.PublishCat;
import com.wetuo.wepic.publish.service.PublishCatService;
public class BackendAction extends PageAction {
	
	public String adminCommonPublish() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonPublish";
	}//end init()
	
	//
	public String userCatTreeAdmin() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "userCatTreeAdmin";
	}//end init()
	
	
	//未验证的发布管理
	public String adminCommonPublish_notverify() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonPublish_notverify";
	}
	//验证的发布管理
	public String adminCommonPublish_verify() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonPublish_verify";
	}
	
	//验证各个角色空间
	public String roleSpaceVerified() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "roleSpaceVerified";
	}
	
	
	//经纪人的发布管理
	public String adminCommonPublish_broker() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonPublish_broker";
	}
	//超级管理员的发布管理
	public String adminCommonPublish_admin() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonPublish_admin";
	}
	//超级管理员的发布管理
	public String bid_photo() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "bid_photo";
	}
	
	public String adminCommonBuy() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonBuy";
	}//end init()
	
	
	public String adminCommonInvite() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonInvite";
	}//end init()
	
	
	public String adminCommonUserInfo() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonUserInfo";
	}//end init()
	//未验证用户的用户信息管理
	public String adminCommonUserInfo_notverify() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonUserInfo_notverify";
	}//end init()
	
	
	//验证用户的用户信息管理
	public String adminCommonUserInfo_verify() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonUserInfo_verify";
	}//end init()
	
	//经纪人的用户信息管理
	public String adminCommonUserInfo_broker() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonUserInfo_broker";
	}//end init()
	//超级管理员的用户信息管理
	public String adminCommonUserInfo_admin() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonUserInfo_admin";
	}//end init()
	public String adminCommonCommunication() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonCommunication";
	}//end init()
	//未验证用户的通讯管理
	public String adminCommonCommunication_notverify() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonCommunication_notverify";
	}//end init()
	
	//验证用户的通讯管理
	public String adminCommonCommunication_verify() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonCommunication_verify";
	}//end init()
	//经纪人的通讯管理
	public String adminCommonCommunication_broker() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonCommunication_broker";
	}//end init()
	//超级管理员的通讯管理
	public String adminCommonCommunication_admin() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonCommunication_admin";
	}//end init()
	//图片买卖管理
	public String buypoto_verify() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "buypoto_verify";
	}//end init()
	
	//经纪人图片买卖管理
	public String buypoto_broker() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "buypoto_broker";
	}//end init()
	
	public String adminCommonMySpace() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonMySpace";
	}//end init()
	//未验证用户的空间管理
	public String adminCommonMySpace_notverify() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonMySpace_notverify";
	}//end init()
	
	//验证用户的空间管理
	public String adminCommonMySpace_verify() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonMySpace_verify";
	}//end init()
	//经纪人的空间管理
	public String adminCommonMySpace_broker() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonMySpace_broker";
	}//end init()
	//超级管理员的个人空间管理
	public String adminCommonMySpace_admin() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonMySpace_admin";
	}//end init()
	//管理员空间管理
	public String adminCommonSpace_adminspace() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonSpace_adminspace";
	}//end init()
	public String adminCommonAccountInfo() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonAccountInfo";
	}//end init()
	//未验证用户的账户管理
	public String adminCommonAccountInfo_notverify() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonAccountInfo_notverify";
	}//end init()
	
	
	//验证用户的账户管理
	public String adminCommonAccountInfo_verify() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonAccountInfo_verify";
	}//end init()
	
	//经纪人的账户管理
	public String adminCommonAccountInfo_broker() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonAccountInfo_broker";
	}//end init()
	//管理员的账户管理
	public String adminCommonAccountInfo_admin() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonAccountInfo_admin";
	}//end init()
	
	public String adminPublishTree() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminPublishTree";
	}//end init()
	
	public String commonPublishTree() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "commonPublishTree";
	}//end init()
	
	//摄影师的用户信息管理
	public String adminCommonUserInfo_photo() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonUserInfo_photo";
	}//end init()
	
	
	//摄影师的发布管理
	public String adminCommonPublish_photo() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonPublish_photo";
	}
	
	//摄影师的账户管理
	public String adminCommonAccountInfo_photo() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonAccountInfo_photo";
	}//end init()

	//摄影师的空间管理
	public String adminCommonMySpace_photo() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonMySpace_photo";
	}//end init()
	
	//摄影师图片买卖管理
	public String buypoto_photo() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "buypoto_photo";
	}//end init()
	
	
	//摄影师的通讯管理
	public String adminCommonCommunication_photo() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonCommunication_photo";
	}//end init()
	
	
	
	
	
	
	
	
	
	
	
	
	//model的用户信息管理
	public String adminCommonUserInfo_model() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonUserInfo_model";
	}//end init()
	
	
	//model的发布管理
	public String adminCommonPublish_model() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonPublish_model";
	}
	
	//model的账户管理
	public String adminCommonAccountInfo_model() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonAccountInfo_model";
	}//end init()

	//model的空间管理
	public String adminCommonMySpace_model() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonMySpace_model";
	}//end init()
	
	//model图片买卖管理
	public String buypoto_model() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "buypoto_model";
	}//end init()
	
	
	//model的通讯管理
	public String adminCommonCommunication_model() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonCommunication_model";
	}//end init()
	
	//model受邀请和评价
	public String invite_model() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "invite_model";
	}//end init()
	
	//已验证提取现金模块管理
	public String accountWithdraw_verify() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "accountWithdraw_verify";
	}//end init()
	
	//管理员提取现金模块管理
	public String adminCommonAccountWithdraw_admin() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		return "adminCommonAccountWithdraw_admin";
	}//end init()
	
	
	
	public static void main(String[] args){
//		 SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");//������
//		 System.out.println(  df.format(new Date())  );
		 //new PublishAction().getPublishTime();
		 
	 }
	 
	 
}//end class
