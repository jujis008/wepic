package com.wetuo.wepic.core.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.wetuo.wepic.core.beans.User;
 
public class UserCreditHistory  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	protected User admin;
	private java.sql.Timestamp startTime;
	private java.sql.Timestamp endTime;
	private String punishReason;
	private Integer punishType;
	private Integer fineMoney;
	private Integer isFineMoneyExecuted;
	private String moneyUnit;
	private Integer deMark;
	private Integer deDiamond;
	private Integer deStar;
	private Integer mark;
	private String addmarkreson;
	private String addmarkType;
	
	/*
	 * 
	 * 
	 * 
1	上传头像	50		    18差评1次	200
2	实名认证	1000		19 被成功投诉1次	500
3	发布图片作品	1		20作品侵权1次	降1级
4	发布故事作品	5		21恶意投诉	500
5	发布视频作品	5			
6	发布音频作品	5			
7	应约	5			
8	应约成功	100			
9	好评1次	50			
10	发布产品	10			
11	被订购1次	100			
12	图片被购买1次	10			
13	故事被购买1次	50			
14	视频被购买1次	50			
15	音频被购买1次	50			
16	分享作品1次	5			
17	推广1次	10			

	 * 
	 * */
	
 
	////start OneToMany
	private User user;//
	public User getUser() {
		return user;
	}//end get()
	public void setUser(User user) {
		this.user = user;
	}//end set()
	////start OneToMany
	private UserCredit userCredit;//
	public UserCredit getUserCredit() {
		return userCredit;
	}//end get()
	public void setUserCredit(UserCredit userCredit) {
		this.userCredit = userCredit;
	}//end set()
	/////////constructor//////////////////
	
//	public UserCreditHistory(Integer id,User user,java.sql.Timestamp startTime,java.sql.Timestamp endTime,String punishReason,Integer punishType,Integer creditRatings,Integer totalCredits,Integer fineMoney,Integer isFineMoneyExecuted,String moneyUnit) {
//		this.id = id;
//		this.user = user;
//		this.startTime = startTime;
//		this.endTime = endTime;
//		this.punishReason = punishReason;
//		this.punishType = punishType;
//		this.creditRatings = creditRatings;
//		this.totalCredits = totalCredits;
//		this.fineMoney = fineMoney;
//		this.isFineMoneyExecuted = isFineMoneyExecuted;
//		this.moneyUnit = moneyUnit;
//	}//
	
	public UserCreditHistory(){
		super();
	}
 
	/////getter////setter//////
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public java.sql.Timestamp  getStartTime(){
		return this.startTime;
	}
	public void  setStartTime(java.sql.Timestamp startTime){
		this.startTime = startTime ;
	}
	public java.sql.Timestamp  getEndTime(){
		return this.endTime;
	}
	public void  setEndTime(java.sql.Timestamp endTime){
		this.endTime = endTime ;
	}
	public String  getPunishReason(){
		return this.punishReason;
	}
	public void  setPunishReason(String punishReason){
		this.punishReason = punishReason ;
	}
	public Integer  getPunishType(){
		return this.punishType;
	}
	public void  setPunishType(Integer punishType){
		this.punishType = punishType ;
	}
//	public Integer  getCreditRatings(){
//		return this.creditRatings;
//	}
//	public void  setCreditRatings(Integer creditRatings){
//		this.creditRatings = creditRatings ;
//	}
//	public Integer  getTotalCredits(){
//		return this.totalCredits;
//	}
//	public void  setTotalCredits(Integer totalCredits){
//		this.totalCredits = totalCredits ;
//	}
	public Integer  getFineMoney(){
		return this.fineMoney;
	}
	public void  setFineMoney(Integer fineMoney){
		this.fineMoney = fineMoney ;
	}
	public Integer  getIsFineMoneyExecuted(){
		return this.isFineMoneyExecuted;
	}
	public void  setIsFineMoneyExecuted(Integer isFineMoneyExecuted){
		this.isFineMoneyExecuted = isFineMoneyExecuted ;
	}
	public String  getMoneyUnit(){
		return this.moneyUnit;
	}
	public void  setMoneyUnit(String moneyUnit){
		this.moneyUnit = moneyUnit ;
	}
	public User getAdmin() {
		return admin;
	}
	public void setAdmin(User admin) {
		this.admin = admin;
	}
	public Integer getDeMark() {
		return deMark;
	}
	public void setDeMark(Integer deMark) {
		this.deMark = deMark;
	}
	public Integer getDeDiamond() {
		return deDiamond;
	}
	public void setDeDiamond(Integer deDiamond) {
		this.deDiamond = deDiamond;
	}
	public Integer getDeStar() {
		return deStar;
	}
	public void setDeStar(Integer deStar) {
		this.deStar = deStar;
	}
	public Integer getMark() {
		return mark;
	}
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	public String getAddmarkreson() {
		return addmarkreson;
	}
	public void setAddmarkreson(String addmarkreson) {
		this.addmarkreson = addmarkreson;
	}
	public String getAddmarkType() {
		return addmarkType;
	}
	public void setAddmarkType(String addmarkType) {
		this.addmarkType = addmarkType;
	}
	
	
	
 
}//end class
