package com.wetuo.wepic.core.beans;

public class UserDetalfor {
	private String yeas;
	private String month;
	private String day;
	private String sheng;
	private String city;
	private String xian;
	public String getYeas() {
		return yeas;
	}
	public void setYeas(String yeas) {
		this.yeas = yeas;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String getSheng() {
		return sheng;
	}
	public void setSheng(String sheng) {
		this.sheng = sheng;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getXian() {
		return xian;
	}
	public void setXian(String xian) {
		this.xian = xian;
	}
	public static  UserDetalfor chaifenr(String data,String address ,String type){
		UserDetalfor userDetalfor=new UserDetalfor();
		if(data!=null&&data!=""){
		String dat[]=data.split(type);
		if(dat.length>=3){
			userDetalfor.setYeas(dat[0]);
			userDetalfor.setMonth(dat[1]);
			userDetalfor.setDay(dat[2]);
		}
		else{
			userDetalfor.setYeas(dat[0]);
			userDetalfor.setMonth(dat[1]);	
		}
		}
		if(address!=null&&address!=""){
		String place[]=address.split(" ");
		userDetalfor.setSheng(place[0]);
		userDetalfor.setCity(place[1]);
		userDetalfor.setXian(place[2]);
		}
		
		
		return userDetalfor;
	}
	
	public static UserDetalfor chaifenAdress(String address ,String type){
		
		UserDetalfor userDetalfor=new UserDetalfor();
		String place[]=address.split(" ");
		userDetalfor.setSheng(place[0]);
		userDetalfor.setCity(place[1]);
		userDetalfor.setXian(place[2]);
		
		return userDetalfor;
	}

}
