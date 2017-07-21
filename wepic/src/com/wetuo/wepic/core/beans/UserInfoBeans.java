package com.wetuo.wepic.core.beans;

import com.wetuo.wepic.deal.beans.UserMess;

public class UserInfoBeans {
	private String nickName ;//用户昵称
	private String portrait;//用户头像
	private String occupation;//用户职业
	private String workPlace;//用户工作地址
	private String remaingMoeny;
	private UserMess userMess;
	private int star;//星级
	private int jewel;//钻级
	private String moeny;//余额
	private String chinerole;
	private String sex;
	private Account account;
	private String context;
	private String shoyiThisMonth;
	private String personOrCompany;
	private Integer ifIdentityTrue ;//0刚注册（未认证）  1申请实名认证（显示为审核） 2 通过 3 不通过
	private int degee;//等级
	private int nextDegeeMark;
	private String baif;
	
	
	
	
	public String getBaif() {
		return baif;
	}
	public void setBaif(String baif) {
		this.baif = baif;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public int getJewel() {
		return jewel;
	}
	public void setJewel(int jewel) {
		this.jewel = jewel;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public String getRemaingMoeny() {
		return remaingMoeny;
	}
	public void setRemaingMoeny(String remaingMoeny) {
		this.remaingMoeny = remaingMoeny;
	}
	public UserMess getUserMess() {
		return userMess;
	}
	public void setUserMess(UserMess userMess) {
		this.userMess = userMess;
	}
	public String getMoeny() {
		return moeny;
	}
	public void setMoeny(String moeny) {
		this.moeny = moeny;
	}
	public String getChinerole() {
		return chinerole;
	}
	public void setChinerole(String chinerole) {
		this.chinerole = chinerole;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getShoyiThisMonth() {
		return shoyiThisMonth;
	}
	public void setShoyiThisMonth(String shoyiThisMonth) {
		this.shoyiThisMonth = shoyiThisMonth;
	}
	public String getPersonOrCompany() {
		return personOrCompany;
	}
	public void setPersonOrCompany(String personOrCompany) {
		this.personOrCompany = personOrCompany;
	}
	public Integer getIfIdentityTrue() {
		return ifIdentityTrue;
	}
	public void setIfIdentityTrue(Integer ifIdentityTrue) {
		this.ifIdentityTrue = ifIdentityTrue;
	}
	public int getDegee() {
		return degee;
	}
	public void setDegee(int degee) {
		this.degee = degee;
	}
	public int getNextDegeeMark() {
		return nextDegeeMark;
	}
	public void setNextDegeeMark(int nextDegeeMark) {
		this.nextDegeeMark = nextDegeeMark;
	}
	
	

	
	
	
}
