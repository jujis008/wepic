package com.wetuo.wepic.deal.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.wetuo.wepic.core.beans.User;
 
public class BidForOpus  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private String id;
	protected User user;
	private java.sql.Timestamp sendTime;
	private String thumbNail_Image;
	private String original_Drawing;
	private String conetxt;
	private java.sql.Timestamp confirmTime;
	private Integer status;//0未看过1是待定,2确定3是已看过
	private String  watermark;
	private int user_;
	private String imgCertiFicate;
	private String copyRightType;
	private String bidid;
	
	
	
	
	
	public String getBidid() {
		return bidid;
	}
	public void setBidid(String bidid) {
		this.bidid = bidid;
	}
	public String getCopyRightType() {
		return copyRightType;
	}
	public void setCopyRightType(String copyRightType) {
		this.copyRightType = copyRightType;
	}
	public String getImgCertiFicate() {
		return imgCertiFicate;
	}
	public void setImgCertiFicate(String imgCertiFicate) {
		this.imgCertiFicate = imgCertiFicate;
	}
	public int getUser_() {
		return user_;
	}
	public void setUser_(int user) {
		user_ = user;
	}
	private String title;
	
 
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWatermark() {
		return watermark;
	}
	public void setWatermark(String watermark) {
		this.watermark = watermark;
	}
	////start OneToMany
	private Bid bid;//
	public Bid getBid() {
		return bid;
	}//end get()
	public void setBid(Bid bid) {
		this.bid = bid;
	}//end set()
	/////////constructor//////////////////
	
	public BidForOpus(String id,User user,java.sql.Timestamp sendTime,String thumbNail_Image,String original_Drawing,String conetxt,java.sql.Timestamp confirmTime,Integer status) {
		this.id = id;
		this.user = user;
		this.sendTime = sendTime;
		this.thumbNail_Image = thumbNail_Image;
		this.original_Drawing = original_Drawing;
		this.conetxt = conetxt;
		this.confirmTime = confirmTime;
		this.status = status;
	}//
	
	public BidForOpus(){
		super();
	}
 
	/////getter////setter//////
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User  getUser(){
		return this.user;
	}
	public void  setUser(User user){
		this.user = user ;
	}
	public java.sql.Timestamp  getSendTime(){
		return this.sendTime;
	}
	public void  setSendTime(java.sql.Timestamp sendTime){
		this.sendTime = sendTime ;
	}
	public String  getThumbNail_Image(){
		return this.thumbNail_Image;
	}
	public void  setThumbNail_Image(String thumbNail_Image){
		this.thumbNail_Image = thumbNail_Image ;
	}
	public String  getOriginal_Drawing(){
		return this.original_Drawing;
	}
	public void  setOriginal_Drawing(String original_Drawing){
		this.original_Drawing = original_Drawing ;
	}
	public String  getConetxt(){
		return this.conetxt;
	}
	public void  setConetxt(String conetxt){
		this.conetxt = conetxt ;
	}
	public java.sql.Timestamp  getConfirmTime(){
		return this.confirmTime;
	}
	public void  setConfirmTime(java.sql.Timestamp confirmTime){
		this.confirmTime = confirmTime ;
	}
	public Integer  getStatus(){
		return this.status;
	}
	public void  setStatus(Integer status){
		this.status = status ;
	}
 
}//end class
