package com.wetuo.wepic.core.beans ;
 
import java.io.Serializable;
import com.wetuo.wepic.core.beans.User;
 
import java.sql.Timestamp;
import java.util.*;
public class Message  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	protected User user;
	private int userId;
	private String msgTxt;
	private Timestamp date ;
	private int statu;//0为没有执行1为已经执行过
	private int msgtype;//消息类型 1新粉丝 2交易消息 3项目消息 4日程提醒 5推广消息 6互动消息 7系统消息
	private int checkstatu;//查看状态 0 未查看 1 已经查看
	private int delstatu;//有图片的被删除 1有 0没有
	private String thumbnail125pic;//被删除的图片
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/////////constructor//////////////////
	
	public Message(Integer id,User user,String msgTxt,Timestamp date,Integer statu) {
		this.id = id;
		this.user = user;
		this.msgTxt=msgTxt;
		this.date=date;
		this.statu=statu;
	}//
	
	public Message(){
		super();
	}
 
	/////getter////setter//////
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public User  getUser(){
		return this.user;
	}
	public void  setUser(User user){
		this.user = user ;
	}
	public String getMsgTxt() {
		return msgTxt;
	}
	public void setMsgTxt(String msgTxt) {
		this.msgTxt = msgTxt;
	}

	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public int getStatu() {
		return statu;
	}
	public void setStatu(int statu) {
		this.statu = statu;
	}
	public int getMsgtype() {
		return msgtype;
	}
	public void setMsgtype(int msgtype) {
		this.msgtype = msgtype;
	}
	public int getCheckstatu() {
		return checkstatu;
	}
	public void setCheckstatu(int checkstatu) {
		this.checkstatu = checkstatu;
	}
	public int getDelstatu() {
		return delstatu;
	}
	public void setDelstatu(int delstatu) {
		this.delstatu = delstatu;
	}
	public String getThumbnail125pic() {
		return thumbnail125pic;
	}
	public void setThumbnail125pic(String thumbnail125pic) {
		this.thumbnail125pic = thumbnail125pic;
	}
}//end class
