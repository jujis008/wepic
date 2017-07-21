package com.wetuo.wepic.publish.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.wetuo.wepic.core.beans.User;
 
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.*;
	
import java.util.*;
	
public class Video  implements Serializable {
	/*
	 * 版权属性分为版权和使用权，使用权是分期限的。
	图片状态分为：0审核中，1审核未通过-不可以发布，2审核通过-可以发布，3可以发布-不可购买，4销售中，5版权已被购买,6下架
	
	图片质量分级
	种类:不可查看，可以查看，可以出售
	violationPunish : 0 1 2
	copyright:版权（0使用权1版权）
	copyrightArea:版权区域
	authorization:授权方式
	usageBuyNum:使用权购买次数
	copyrightPrice:版权价格
	usagePrice:使用权价格
	usagePeriod:使用期限
	tags:标签
	QRCode:二维码
	qualityLevel:质量等级0，1，2，3.2．	评级： （评级的作用有：1.优先显示；2.管理员进行逐级下架操作。）
		根据作品图片的精度\尺寸大小\艺术性\不可替代性综合考虑,进行级别的评定。
		（）1级；（最高级）
		（）2级；
		（）3级；
		（）4级；
		（）5级；
	ifContentHealthy:是否健康(0不健康，1健康)
	ifTort:是否侵权
	violationReason:违纪原因
	violationPunishTime:处罚时间
	ifPermitPublish:是否发布(备用)
	violationPunish:违纪处罚
	width:图片宽度
	height:图片高度
	picMode:图片格式
	
	commend推荐：（显示）推荐到
	（1）首页大图；
	（2）首页特约模特；
	（3）首页特约摄影师；
	（4）首页摄影图片；
	（5）首页创意图片；
	（6）摄影图片页面大图；
	（7）创意图片页面大图；
	（8）商业约拍页面大图；
	（9）摄影故事页面大图；
	（10）特约摄影页面师大图；
	（11）特约模特页面大图；
	
	<select name="notPassedCause" >
		<option value="1">作品带有黄色因素</option>
		<option value="2">作品质量未达到上传要求</option>
		<option value="3">作品像素尺寸太小，未达到上传要求</option>
		<option value="4">作品带有侵权风险行为因素</option>
	</select>
	<select name="qualityLevel" >
				   	  <option value="1">1级（最高级）</option>
				      <option value="2">2级</option>
				      <option value="3">3级</option>
				      <option value="4">4级</option>
				      <option value="5">5级</option>
	</select>
				 
	 * 
	 * */
	private Integer id; 		//视频ID
	private Integer type;		//
	private String name;		//视频名称
	private String oldVideoUrl;		//视频的源文件地址
	private String newVideoUrl;
	private String picUrl;
	private Integer size;		//视频的文件大小
	private String content;		//视频的内容
	private String logo;		//视频的logo
	
	private String resolutionRatio;		//分辨率
	private String usage;		//用途
	
	private String format;		//视频格式
	private String shootingTime;		//拍摄时间
	private Timestamp publishTime;		//发布时间
	
	private String tags;		//标签
	private String QRCode;		//二维码
	
	private Integer hit;		//点击次数
	private Integer collectNum;		//收藏次数
	
	
	private Integer copyright;		//版权（0使用权1版权）
	private String copyrightArea;		//版权区域
	private Integer copyrightPrice;		//版权价格
	private Integer authorization; 		//授权方式
	

	private Integer usageBuyNum;		//使用权购买次数
	private Integer usagePrice;		//使用权购买价格
	private Double usagePeriod;		//使用期限
	private String moneyUnit;		//货币单位

	private Integer qualityLevel;		//质量等级0，1，2，3
	private Integer status;			//视频状态（0审核中，1审核未通过-不可以发布，2审核通过-可以发布，3可以发布-不可购买，4销售中，5版权已被购买,6下架）
	private Integer ifPermitPublish;	//是否发布
	private String violationReason;		//违纪原因
	private Integer violationPunish;		//违纪处罚
	private Timestamp violationPunishTime;		//处罚时间
	private User user;		//发布人
	private User admin;		//审核人
	private VideoSpecialCat videoSpecialCat;
	
	private Integer videoStatus;
	
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	
	

		


	
	
	
	
	
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
	public String getNewVideoUrl() {
		return newVideoUrl;
	}
	public void setNewVideoUrl(String newVideoUrl) {
		this.newVideoUrl = newVideoUrl;
	}
	public VideoSpecialCat getVideoSpecialCat() {
		return videoSpecialCat;
	}
	public void setVideoSpecialCat(VideoSpecialCat videoSpecialCat) {
		this.videoSpecialCat = videoSpecialCat;
	}
	public Integer getVideoStatus() {
		return videoStatus;
	}
	public void setVideoStatus(Integer videoStatus) {
		this.videoStatus = videoStatus;
	}
	public String getOldVideoUrl() {
		return oldVideoUrl;
	}
	public void setOldVideoUrl(String oldVideoUrl) {
		this.oldVideoUrl = oldVideoUrl;
	}
	public String getResolutionRatio() {
		return resolutionRatio;
	}
	public void setResolutionRatio(String resolutionRatio) {
		this.resolutionRatio = resolutionRatio;
	}
	public String getUsage() {
		return usage;
	}
	public void setUsage(String usage) {
		this.usage = usage;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getShootingTime() {
		return shootingTime;
	}
	public void setShootingTime(String shootingTime) {
		this.shootingTime = shootingTime;
	}
	public Integer getCollectNum() {
		return collectNum;
	}
	public void setCollectNum(Integer collectNum) {
		this.collectNum = collectNum;
	}
	public User getAdmin() {
		return admin;
	}
	public void setAdmin(User admin) {
		this.admin = admin;
	}
	/**
	private Integer copyrightproperty;
	
	public Integer getCopyrightproperty() {
		return copyrightproperty;
	}
	public void setCopyrightproperty(Integer copyrightproperty) {
		this.copyrightproperty = copyrightproperty;
	}**/
	
	////start OneToMany
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	public Integer getCopyright() {
		return copyright;
	}
	public void setCopyright(Integer copyright) {
		this.copyright = copyright;
	}
	public String getCopyrightArea() {
		return copyrightArea;
	}
	public void setCopyrightArea(String copyrightArea) {
		this.copyrightArea = copyrightArea;
	}
	public Integer getCopyrightPrice() {
		return copyrightPrice;
	}
	public void setCopyrightPrice(Integer copyrightPrice) {
		this.copyrightPrice = copyrightPrice;
	}
	public Integer getAuthorization() {
		return authorization;
	}
	public void setAuthorization(Integer authorization) {
		this.authorization = authorization;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getUsageBuyNum() {
		return usageBuyNum;
	}
	public void setUsageBuyNum(Integer usageBuyNum) {
		this.usageBuyNum = usageBuyNum;
	}
	public Integer getUsagePrice() {
		return usagePrice;
	}
	public void setUsagePrice(Integer usagePrice) {
		this.usagePrice = usagePrice;
	}

	
	public Double getUsagePeriod() {
		return usagePeriod;
	}
	public void setUsagePeriod(Double usagePeriod) {
		this.usagePeriod = usagePeriod;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getQRCode() {
		return QRCode;
	}
	public void setQRCode(String qRCode) {
		QRCode = qRCode;
	}
	public Integer getQualityLevel() {
		return qualityLevel;
	}
	public void setQualityLevel(Integer qualityLevel) {
		this.qualityLevel = qualityLevel;
	}
	
	public String getViolationReason() {
		return violationReason;
	}
	public void setViolationReason(String violationReason) {
		this.violationReason = violationReason;
	}
	public Integer getViolationPunish() {
		return violationPunish;
	}
	public void setViolationPunish(Integer violationPunish) {
		this.violationPunish = violationPunish;
	}
	public Timestamp getViolationPunishTime() {
		return violationPunishTime;
	}
	public void setViolationPunishTime(Timestamp violationPunishTime) {
		this.violationPunishTime = violationPunishTime;
	}
	public Integer getIfPermitPublish() {
		return ifPermitPublish;
	}
	public void setIfPermitPublish(Integer ifPermitPublish) {
		this.ifPermitPublish = ifPermitPublish;
	}
	
	/**
	////start OneToMany
	private Set<PublishDetail> publishDetailSet  = new HashSet<PublishDetail>();// 
	public Set<PublishDetail> getPublishDetailSet() {
		return this.publishDetailSet;
	}//end get
	public void setPublishDetailSet(Set<PublishDetail> publishDetailSet) {
		this.publishDetailSet = publishDetailSet ;
	}//end set
	**/
	////start OneToMany
	/**
	private Set<AssessComplaint> assessComplaintSet  = new HashSet<AssessComplaint>();// 
	public Set<AssessComplaint> getAssessComplaintSet() {
		return this.assessComplaintSet;
	}//end get
	public void setAssessComplaintSet(Set<AssessComplaint> assessComplaintSet) {
		this.assessComplaintSet = assessComplaintSet ;
	}//end set
	////start OneToMany
	private PublishSpecialCat publishSpecialCat;//
	public PublishSpecialCat getPublishSpecialCat() {
		return publishSpecialCat;
	}//end get()
	public void setPublishSpecialCat(PublishSpecialCat publishSpecialCat) {
		this.publishSpecialCat = publishSpecialCat;
	}//end set()
	/////////constructor//////////////////
	**/
	
	public Video(Integer id,String name,Integer sequence) {
		//new Publish(p.id,p.biggerPic,p.name)
		
	}//
	
	
	public Video(){
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
	public String  getName(){
		return this.name;
	}
	public void  setName(String name){
		this.name = name ;
	}
	public String  getContent(){
		return this.content;
	}
	public void  setContent(String content){
		this.content = content ;
	}
	public String  getLogo(){
		return this.logo;
	}
	public void  setLogo(String logo){
		this.logo = logo ;
	}
	public Timestamp getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Timestamp publishTime) {
		this.publishTime = publishTime;
	}
	
	public Integer  getHit(){
		return this.hit;
	}
	public void  setHit(Integer hit){
		this.hit = hit ;
	}
	
	public String getMoneyUnit() {
		return moneyUnit;
	}
	public void setMoneyUnit(String moneyUnit) {
		this.moneyUnit = moneyUnit;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
	
	
	
 
}//end class
