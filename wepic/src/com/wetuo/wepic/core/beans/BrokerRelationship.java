package com.wetuo.wepic.core.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.beans.User;
 
public class BrokerRelationship  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	protected User broker;//经纪人
	protected User author;//模特或摄影师
	protected User whoIsActive;//谁主动
	private java.sql.Timestamp creationTime;
	private java.sql.Timestamp applyTime;//申请时间
	private Integer isValid;//是否有效 0:不知道默认 2:无效 1:有效
	private Integer ifAccept;//是否接受  0不知道默认  1不接受  2接受
	private String invalidReason;//取消原因
 
	/////////constructor//////////////////
	
	public BrokerRelationship(Integer id,User broker,User author,java.sql.Timestamp creationTime,Integer isValid) {
		this.id = id;
		this.broker = broker;
		this.author = author;
		this.creationTime = creationTime;
		this.isValid = isValid;
	}//
	
	public BrokerRelationship(){
		super();
	}
 
	/////getter////setter//////
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
		public java.sql.Timestamp  getCreationTime(){
		return this.creationTime;
	}
	public void  setCreationTime(java.sql.Timestamp creationTime){
		this.creationTime = creationTime ;
	}
	public Integer  getIsValid(){
		return this.isValid;
	}
	public void  setIsValid(Integer isValid){
		this.isValid = isValid ;
	}

	public User getBroker() {
		return broker;
	}

	public void setBroker(User broker) {
		this.broker = broker;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public User getWhoIsActive() {
		return whoIsActive;
	}

	public void setWhoIsActive(User whoIsActive) {
		this.whoIsActive = whoIsActive;
	}

	public Integer getIfAccept() {
		return ifAccept;
	}

	public void setIfAccept(Integer ifAccept) {
		this.ifAccept = ifAccept;
	}

	public String getInvalidReason() {
		return invalidReason;
	}

	public void setInvalidReason(String invalidReason) {
		this.invalidReason = invalidReason;
	}

	public java.sql.Timestamp getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(java.sql.Timestamp applyTime) {
		this.applyTime = applyTime;
	}
	
	
	
	
 
}//end class
