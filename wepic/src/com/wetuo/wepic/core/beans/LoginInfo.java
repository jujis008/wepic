package com.wetuo.wepic.core.beans;

import java.util.Date;

public class LoginInfo {
	private Integer id;
	private String ipAddress;
	private Date accessTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Date getAccessTime() {
		return accessTime;
	}
	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}
	@Override
	public String toString() {
		return this.getIpAddress()+"//"+this.getAccessTime();
	}
	
}
