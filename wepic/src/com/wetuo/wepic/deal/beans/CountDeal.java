package com.wetuo.wepic.deal.beans;


import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.publish.beans.Publish;

public class CountDeal {
	private String id;
	private String type;
	private User deliveUser;
	private User buyUser;
	private String dealTime;
	private double money;
	private String dealType;
	private int    buyCount;
	private String nmae;
	private Publish publics;
	private Bid bid;
	private String fapiao;
	public Publish getPublics() {
		return publics;
	}
	public void setPublics(Publish publics) {
		this.publics = publics;
	}
	public Bid getBid() {
		return bid;
	}
	public void setBid(Bid bid) {
		this.bid = bid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public User getDeliveUser() {
		return deliveUser;
	}
	public void setDeliveUser(User deliveUser) {
		this.deliveUser = deliveUser;
	}
	public User getBuyUser() {
		return buyUser;
	}
	public void setBuyUser(User buyUser) {
		this.buyUser = buyUser;
	}
	public String getDealTime() {
		return dealTime;
	}
	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getDealType() {
		return dealType;
	}
	public void setDealType(String dealType) {
		this.dealType = dealType;
	}
	public int getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
	}
	public String getNmae() {
		return nmae;
	}
	public void setNmae(String nmae) {
		this.nmae = nmae;
	}
	public String getFapiao() {
		return fapiao;
	}
	public void setFapiao(String fapiao) {
		this.fapiao = fapiao;
	}
	
	
	
	
	
	
	
	
	

}
