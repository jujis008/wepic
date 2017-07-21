package com.wetuo.wepic.deal.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.wetuo.wepic.deal.beans.BidResponseInvited;
import com.wetuo.wepic.deal.beans.BidResponseInvited;
import com.wetuo.wepic.core.beans.SiteConfig;
 
public class BidReceiverConfirmChange  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private String id;
	protected BidResponseInvited bidResponseInvitedFrom;
	protected BidResponseInvited bidResponseInvitedTo;
	protected SiteConfig siteConfig;
	private java.sql.Timestamp changeTime;
	private String changeReason;
	private String changeeOpnion;
 
	////start OneToMany
	private Bid bid;//
	public Bid getBid() {
		return bid;
	}//end get()
	public void setBid(Bid bid) {
		this.bid = bid;
	}//end set()
	/////////constructor//////////////////
	
	public BidReceiverConfirmChange(String id,BidResponseInvited bidResponseInvitedFrom,BidResponseInvited bidResponseInvitedTo,SiteConfig siteConfig,java.sql.Timestamp changeTime,String changeReason,String changeeOpnion) {
		this.id = id;
		this.bidResponseInvitedFrom = bidResponseInvitedFrom;
		this.bidResponseInvitedTo = bidResponseInvitedTo;
		this.siteConfig = siteConfig;
		this.changeTime = changeTime;
		this.changeReason = changeReason;
		this.changeeOpnion = changeeOpnion;
	}//
	
	public BidReceiverConfirmChange(){
		super();
	}
 
	/////getter////setter//////
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public SiteConfig  getSiteConfig(){
		return this.siteConfig;
	}
	public void  setSiteConfig(SiteConfig siteConfig){
		this.siteConfig = siteConfig ;
	}
	public java.sql.Timestamp  getChangeTime(){
		return this.changeTime;
	}
	public void  setChangeTime(java.sql.Timestamp changeTime){
		this.changeTime = changeTime ;
	}
	public String  getChangeReason(){
		return this.changeReason;
	}
	public void  setChangeReason(String changeReason){
		this.changeReason = changeReason ;
	}
	public String  getChangeeOpnion(){
		return this.changeeOpnion;
	}
	public void  setChangeeOpnion(String changeeOpnion){
		this.changeeOpnion = changeeOpnion ;
	}
	public BidResponseInvited getBidResponseInvitedFrom() {
		return bidResponseInvitedFrom;
	}
	public void setBidResponseInvitedFrom(BidResponseInvited bidResponseInvitedFrom) {
		this.bidResponseInvitedFrom = bidResponseInvitedFrom;
	}
	public BidResponseInvited getBidResponseInvitedTo() {
		return bidResponseInvitedTo;
	}
	public void setBidResponseInvitedTo(BidResponseInvited bidResponseInvitedTo) {
		this.bidResponseInvitedTo = bidResponseInvitedTo;
	}
	
	
 
}//end class
