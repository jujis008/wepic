package com.wetuo.wepic.core.beans;

import java.sql.Timestamp;

public class MoneyRecharge {
	private String id;
	private String flag;//1为卖图收入2/为应约收入
	private Timestamp dateTime;
	private String  selerId;//交易编号
	private String money;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	public String getSelerId() {
		return selerId;
	}
	public void setSelerId(String selerId) {
		this.selerId = selerId;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	
	
	

}
