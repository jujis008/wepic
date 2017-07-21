package com.wetuo.wepic.core.actions;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.wetuo.wepic.core.beans.LoginInfo;
import com.wetuo.wepic.core.service.StoreAccessInfoService;

public class StoreAcessInfoAction extends ActionSupport {
	private StoreAccessInfoService accessService;
	private List<LoginInfo> loginList;
	private int userOnline;
	public String insert() throws Exception {
		try{
			HttpServletRequest request = ServletActionContext.getRequest();
			String ip = request.getRemoteAddr();
			LoginInfo info = new LoginInfo();
			info.setIpAddress(ip);
			Date date = new Date();
			info.setAccessTime(date);
			System.out.println(info.toString());
			accessService.saveInfo(info);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	//在线统计
	public String showCount() throws Exception{
		List<LoginInfo> list = accessService.showCount();
		if(list != null && list.size() > 0){
			this.setUserOnline(list.size());
			this.setLoginList(list);
		}else{
			this.setUserOnline(0);
		}
		return "countOnline";
	}
	public StoreAccessInfoService getAccessService() {
		return accessService;
	}
	public void setAccessService(StoreAccessInfoService accessService) {
		this.accessService = accessService;
	}

	public int getUserOnline() {
		return userOnline;
	}

	public void setUserOnline(int userOnline) {
		this.userOnline = userOnline;
	}

	public List<LoginInfo> getLoginList() {
		return loginList;
	}

	public void setLoginList(List<LoginInfo> loginList) {
		this.loginList = loginList;
	}
	
}
