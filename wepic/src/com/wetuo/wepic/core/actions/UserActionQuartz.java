package com.wetuo.wepic.core.actions;

import java.io.Serializable;

import org.springframework.scheduling.quartz.CronTriggerBean;

import com.wetuo.wepic.core.service.UserService;

public class UserActionQuartz extends CronTriggerBean implements Serializable {
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public void delNoActiveUser() {
		System.out.println("你好，贺海霞");
	}
}
