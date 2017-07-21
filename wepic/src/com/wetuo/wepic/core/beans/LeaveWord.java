package com.wetuo.wepic.core.beans ;
 
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;

import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.publish.beans.Publish;
 
public class LeaveWord  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private int id;
	protected User member;
	protected User admin;
	private String content;
	private int whoseContent;
	private java.sql.Timestamp time;
	private String title;
	private String messageReply;
	private String  adtype;//1为建议2为投诉作品
	private String proofurl;//证据地址
	private String tel;
	private String email;
	private String qq;
	private String reason;
    private String step;//1未处理2,延迟处理3,处理中4结束5投诉驳回
	private Publish publish;
	private List<UrlProperties> urlList;
	private String conplinedContent;
	private String resultStat;//1是驳回投诉,2是进入法律途径
	private String detailContent;
	
	
	
	public String getDetailContent() {
		return detailContent;
	}


	public void setDetailContent(String detailContent) {
		this.detailContent = detailContent;
	}


	public String getConplinedContent() {
		return conplinedContent;
	}


	public void setConplinedContent(String conplinedContent) {
		this.conplinedContent = conplinedContent;
	}


	public List<UrlProperties> getUrlList() {
		return urlList;
	}


	public void setUrlList(List<UrlProperties> urlList) {
		this.urlList = urlList;
	}


	

	public Publish getPublish() {
		return publish;
	}


	public void setPublish(Publish publish) {
		this.publish = publish;
	}


	public void setId(int id) {
		this.id = id;
	}


	public void setWhoseContent(int whoseContent) {
		this.whoseContent = whoseContent;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getTitle() {
		return title;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getQq() {
		return qq;
	}


	public void setQq(String qq) {
		this.qq = qq;
	}


	public String getAdtype() {
		return adtype;
	}


	public void setAdtype(String adtype) {
		this.adtype = adtype;
	}


	public String getProofurl() {
		return proofurl;
	}

	public void setProofurl(String proofurl) {
		this.proofurl = proofurl;
	}

	public String getMessageReply() {
		return messageReply;
	}

	public void setMessageReply(String messageReply) {
		this.messageReply = messageReply;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

public LeaveWord(int id, User member, User admin, String content,
			int whoseContent, Timestamp time, String title,
			String messageReply, String adtype, String proofurl, String tel,
			String email, String qq, String reason, String step,
			Publish publish, List<UrlProperties> urlList) {
		super();
		this.id = id;
		this.member = member;
		this.admin = admin;
		this.content = content;
		this.whoseContent = whoseContent;
		this.time = time;
		this.title = title;
		this.messageReply = messageReply;
		this.adtype = adtype;
		this.proofurl = proofurl;
		this.tel = tel;
		this.email = email;
		this.qq = qq;
		this.reason = reason;
		this.step = step;
		this.publish = publish;
		this.urlList = urlList;
	}


//	public LeaveWord(int id,User member,User admin,String content,int whoseContent,java.sql.Timestamp time) {
//		this.id = id;
//		this.member = member;
//		this.admin = admin;
//		this.content = content;
//		this.whoseContent = whoseContent;
//		this.time = time;
//	}//
	
	public LeaveWord(){
		super();
	}
 
	/////getter////setter//////
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String  getContent(){
		return this.content;
	}
	public void  setContent(String content){
		this.content = content ;
	}
	public Integer  getWhoseContent(){
		return this.whoseContent;
	}
	public void  setWhoseContent(Integer whoseContent){
		this.whoseContent = whoseContent ;
	}
	public java.sql.Timestamp  getTime(){
		return this.time;
	}
	public void  setTime(java.sql.Timestamp time){
		this.time = time ;
	}

	public User getMember() {
		return member;
	}

	public void setMember(User member) {
		this.member = member;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}


	public String getStep() {
		return step;
	}


	public void setStep(String step) {
		this.step = step;
	}


	public String getResultStat() {
		return resultStat;
	}


	public void setResultStat(String resultStat) {
		this.resultStat = resultStat;
	}
	
	
 
}//end class
