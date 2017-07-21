package com.wetuo.wepic.publish.beans ;
 
import java.io.Serializable;

import com.wetuo.wepic.core.beans.RoleTags;
import com.wetuo.wepic.core.beans.User;
 
import java.sql.Blob;
import java.sql.Timestamp;
import java.util.*;
	
import java.util.*;
	
public class Publish  implements Serializable {
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

	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String picNumber;//作品编号
	protected User user;
	protected User admin;
	private String name;
	private String content;
	private String logo;//1特殊图片未处理.0是正常图片2特殊图片样图已上传3特殊图片已处理
	private Timestamp publishTime;
	private Integer period;
	private String position;
	private Integer sequence;
	private Integer sequenceShould;
	private Integer moneyExpect;
	private Integer hit;
	private Integer status;	
	private Set<PublishCat_Publish> setpublishCat_Publish;
	List<String> resons=new ArrayList<String>();
	/**
	 *  0 未发布
        1 已发布
        2 审核通过
        3 审核不通过
        4 用做摄影作品
        5 用作摄影故事封面
        6 用作摄影故事详情
        7 删除

	 * 
	 * 
	 * 
	 * 
	 */
	
	//图片状态分为：0审核中，1审核未通过-不可以发布，2审核通过-可以发布，3可以发布-不可购买(，4销售中，5版权已被购买
	
	//1作品带有黄色因素；	2作品质量未达到上传要求；	3作品像素尺寸太小，未达到上传要求；4作品带有侵权风险行为因素；
	private String notPassedCause; //status==1,不通过：（原因）	
	
	private Blob picture;
	private Integer periodShould;
	private String positionShould;
	private String moneyUnit;
	private Double moneyAmount;
	private Timestamp moneyTime;
	private String picUrl;//原图
	
	private String thumbnailUrl;//缩略图
	private String watermarkUrl;//水印图
	private String smalldrawUrl;//小样图
	private String fixwidthUrl;//宽度固定的图
	private String indexImgUrl;//推荐到首页的大图
	private String smallthumbnailUrl;
	private String typeName;
	private String venderUrl;
	private String voiceUrl;
	private String backImageUrl;
	private String backColor;
	private Integer type;
	private String originalPic;
	private String samplePic;
	private String biggerPic;
	private String smallPic;//小样图 tom
	private String smallDraw2;
	private String smallDrawCut;
	private Integer copyright;//1使用权2版权3使用权,版权
	private String copyrightArea;
	private Integer copyrightPrice;
	private Integer authorization;
	private float size;
	private Integer usageBuyNum;	
	private Integer usagePrice;
	private Double usagePeriod;
	private String tags;
	private String QRCode;
	private String chinesusagePeriod;//使用期限,中文
	private Integer qualityLevel;
	private Integer ifContentHealthy;
	private Integer ifTort;
	private String violationReason;
	private Integer violationPunish;	
	private Timestamp violationPunishTime;
	private Integer ifPermitPublish;
	private Integer width;
	private Integer height;
	private String picMode;
	private int publishwish;//1是可出售2是仅展示 
	private Integer commend;//1推荐
	private String licenseAgreement;
	//1肖像权许可协议书；2物产授权许可协议；0不涉及相关版权；copyrightproperty 3既有物权也有肖像权
	private String portraitprotocol;//肖像协议
	private String productsprotocol;//物产协议
	private String workdescribe;//作品或摄影故事描述
	private Integer purpose;//图片用途0 全用途 1:仅用于传媒与媒体，不可用于其他商业用途；
	private String writenopassreason;//管理员填写的未通过原因
	private String upTime;//上传时间
	private String thumbnail125;
	private PublishStatus publishStatus;
	private List<RoleTags>  roleTags;//用于显示作品的标签tags
	private List<PublishCat> publishCats;
	private PublishCat publishCat;//
	private Set<PublishDetail> publishDetailSet  = new HashSet<PublishDetail>();//
	private Set<AssessComplaint> assessComplaintSet  = new HashSet<AssessComplaint>();//
	private String psdPrecision;//图片精度
	private Timestamp deleteTime;
	public String getThumbnail125() {
		return thumbnail125;
	}
	public void setThumbnail125(String thumbnail125) {
		this.thumbnail125 = thumbnail125;
	}
	public String getWorkdescribe() {
		return workdescribe;
	}
	public void setWorkdescribe(String workdescribe) {
		this.workdescribe = workdescribe;
	}
	public String getPortraitprotocol() {
		return portraitprotocol;
	}
	public void setPortraitprotocol(String portraitprotocol) {
		this.portraitprotocol = portraitprotocol;
	}
	public String getProductsprotocol() {
		return productsprotocol;
	}
	public void setProductsprotocol(String productsprotocol) {
		this.productsprotocol = productsprotocol;
	}
	
	private Integer copyrightproperty;
	
	public Integer getCopyrightproperty() {
		return copyrightproperty;
	}
	public void setCopyrightproperty(Integer copyrightproperty) {
		this.copyrightproperty = copyrightproperty;
	}
	public int getPublishwish() {
		return publishwish;
	}
	public void setPublishwish(int publishwish) {
		this.publishwish = publishwish;
	}
	////start OneToMany
	
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getOriginalPic() {
		return originalPic;
	}
	public void setOriginalPic(String originalPic) {
		this.originalPic = originalPic;
	}
	public String getSamplePic() {
		return samplePic;
	}
	public void setSamplePic(String samplePic) {
		this.samplePic = samplePic;
	}
	public String getBiggerPic() {
		return biggerPic;
	}
	public void setBiggerPic(String biggerPic) {
		this.biggerPic = biggerPic;
	}
	public String getSmallPic() {
		return smallPic;
	}
	public void setSmallPic(String smallPic) {
		this.smallPic = smallPic;
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
	
	
	
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
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
	public Integer getIfContentHealthy() {
		return ifContentHealthy;
	}
	public void setIfContentHealthy(Integer ifContentHealthy) {
		this.ifContentHealthy = ifContentHealthy;
	}
	public Integer getIfTort() {
		return ifTort;
	}
	public void setIfTort(Integer ifTort) {
		this.ifTort = ifTort;
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
	public PublishCat getPublishCat() {
		return publishCat;
	}//end get()
	public void setPublishCat(PublishCat publishCat) {
		this.publishCat = publishCat;
	}//end set()
	////start OneToMany
	
	public Set<PublishDetail> getPublishDetailSet() {
		return this.publishDetailSet;
	}//end get
	public void setPublishDetailSet(Set<PublishDetail> publishDetailSet) {
		this.publishDetailSet = publishDetailSet ;
	}//end set
	////start OneToMany

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
	
	public Publish(Integer id,User user,String name,String content,String logo,Timestamp publishTime,Integer period,String position,Integer sequence,Integer sequenceShould,Integer moneyExpect,Integer hit,String moneyUnit,Double moneyAmount,Timestamp moneyTime) {
		this.id = id;
		this.user = user;
		this.name = name;
		this.content = content;
		this.logo = logo;
		this.publishTime = publishTime;
		this.period = period;
		this.position = position;
		this.sequence = sequence;
		this.sequenceShould=sequenceShould;
		this.moneyExpect = moneyExpect;
		this.hit = hit;
		this.moneyUnit=moneyUnit;
		this.moneyAmount=moneyAmount;
		this.moneyTime=moneyTime;
	}//
	public Publish(Integer id,String name,Integer sequence) {
		//new Publish(p.id,p.biggerPic,p.name)
		
	}//
	
	
	public Publish(){
		super();
	}
	public Publish(Integer id,String name,String indexImgUrl){
		this.id=id;
		this.name=name;
		this.indexImgUrl=indexImgUrl;
		
	}
	public Publish(Integer id,User user,String thumbnailUrl){
		this.id=id;
		this.user=user;
		this.thumbnailUrl=thumbnailUrl;
		
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
	public Integer  getPeriod(){
		return this.period;
	}
	public void  setPeriod(Integer period){
		this.period = period ;
	}
	public String  getPosition(){
		return this.position;
	}
	public void  setPosition(String position){
		this.position = position ;
	}
	
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public Integer getSequenceShould() {
		return sequenceShould;
	}
	public void setSequenceShould(Integer sequenceShould) {
		this.sequenceShould = sequenceShould;
	}
	public Integer  getMoneyExpect(){
		return this.moneyExpect;
	}
	public void  setMoneyExpect(Integer moneyExpect){
		this.moneyExpect = moneyExpect ;
	}
	public Integer  getHit(){
		return this.hit;
	}
	public void  setHit(Integer hit){
		this.hit = hit ;
	}
	public Blob getPicture() {
		return picture;
	}
	public void setPicture(Blob picture) {
		this.picture = picture;
	}
	public Integer getPeriodShould() {
		return periodShould;
	}
	public void setPeriodShould(Integer periodShould) {
		this.periodShould = periodShould;
	}
	public String getPositionShould() {
		return positionShould;
	}
	public void setPositionShould(String positionShould) {
		this.positionShould = positionShould;
	}
	public String getMoneyUnit() {
		return moneyUnit;
	}
	public void setMoneyUnit(String moneyUnit) {
		this.moneyUnit = moneyUnit;
	}
	public Double getMoneyAmount() {
		return moneyAmount;
	}
	public void setMoneyAmount(Double moneyAmount) {
		this.moneyAmount = moneyAmount;
	}
	public Timestamp getMoneyTime() {
		return moneyTime;
	}
	public void setMoneyTime(Timestamp moneyTime) {
		this.moneyTime = moneyTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getThumbnailUrl() {
		return thumbnailUrl;
	}
	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}
	public String getWatermarkUrl() {
		return watermarkUrl;
	}
	public void setWatermarkUrl(String watermarkUrl) {
		this.watermarkUrl = watermarkUrl;
	}
	public String getSmalldrawUrl() {
		return smalldrawUrl;
	}
	public void setSmalldrawUrl(String smalldrawUrl) {
		this.smalldrawUrl = smalldrawUrl;
	}
	public String getSmallDraw2() {
		return smallDraw2;
	}
	public void setSmallDraw2(String smallDraw2) {
		this.smallDraw2 = smallDraw2;
	}
	public String getFixwidthUrl() {
		return fixwidthUrl;
	}
	public void setFixwidthUrl(String fixwidthUrl) {
		this.fixwidthUrl = fixwidthUrl;
	}
	public String getIndexImgUrl() {
		return indexImgUrl;
	}
	public void setIndexImgUrl(String indexImgUrl) {
		this.indexImgUrl = indexImgUrl;
	}
	public String getSmallthumbnailUrl() {
		return smallthumbnailUrl;
	}
	public void setSmallthumbnailUrl(String smallthumbnailUrl) {
		this.smallthumbnailUrl = smallthumbnailUrl;
	}
	public String getVenderUrl() {
		return venderUrl;
	}
	public void setVenderUrl(String venderUrl) {
		this.venderUrl = venderUrl;
	}
	public String getVoiceUrl() {
		return voiceUrl;
	}
	public void setVoiceUrl(String voiceUrl) {
		this.voiceUrl = voiceUrl;
	}
	public String getBackImageUrl() {
		return backImageUrl;
	}
	public void setBackImageUrl(String backImageUrl) {
		this.backImageUrl = backImageUrl;
	}
	public String getBackColor() {
		return backColor;
	}
	public void setBackColor(String backColor) {
		this.backColor = backColor;
	}
	public User getAdmin() {
		return admin;
	}
	public void setAdmin(User admin) {
		this.admin = admin;
	}
	public Integer getWidth() {
		return width;
	}
	public void setWidth(Integer width) {
		this.width = width;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public String getPicMode() {
		return picMode;
	}
	public void setPicMode(String picMode) {
		this.picMode = picMode;
	}
	public String getNotPassedCause() {
		return notPassedCause;
	}
	public void setNotPassedCause(String notPassedCause) {
		this.notPassedCause = notPassedCause;
	}
	public Integer getCommend() {
		return commend;
	}
	public void setCommend(Integer commend) {
		this.commend = commend;
	}
	public String getLicenseAgreement() {
		return licenseAgreement;
	}
	public void setLicenseAgreement(String licenseAgreement) {
		this.licenseAgreement = licenseAgreement;
	}
	public String getPicNumber() {
		return picNumber;
	}
	public void setPicNumber(String picNumber) {
		this.picNumber = picNumber;
	}
	public Integer getPurpose() {
		return purpose;
	}
	public void setPurpose(Integer purpose) {
		this.purpose = purpose;
	}
	public String getWritenopassreason() {
		return writenopassreason;
	}
	public void setWritenopassreason(String writenopassreason) {
		this.writenopassreason = writenopassreason;
	}
	public String getChinesusagePeriod() {
		return chinesusagePeriod;
	}
	public void setChinesusagePeriod(String chinesusagePeriod) {
		this.chinesusagePeriod = chinesusagePeriod;
	}
	public String getSmallDrawCut() {
		return smallDrawCut;
	}
	public void setSmallDrawCut(String smallDrawCut) {
		this.smallDrawCut = smallDrawCut;
	}
	public String getUpTime() {
		return upTime;
	}
	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}
	public PublishStatus getPublishStatus() {
		return publishStatus;
	}
	public void setPublishStatus(PublishStatus publishStatus) {
		this.publishStatus = publishStatus;
	}
	
	public void setRoleTags(List<RoleTags> roleTags) {
		this.roleTags = roleTags;
	}
	public List<RoleTags> getRoleTags() {
		return roleTags;
	}
	public List<PublishCat> getPublishCats() {
		return publishCats;
	}
	public void setPublishCats(List<PublishCat> publishCats) {
		this.publishCats = publishCats;
	}
	public Set<PublishCat_Publish> getSetpublishCat_Publish() {
		return setpublishCat_Publish;
	}
	public void setSetpublishCat_Publish(
			Set<PublishCat_Publish> setpublishCatPublish) {
		setpublishCat_Publish = setpublishCatPublish;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public String getPsdPrecision() {
		return psdPrecision;
	}
	public void setPsdPrecision(String psdPrecision) {
		this.psdPrecision = psdPrecision;
	}
	public List<String> getResons() {
		return resons;
	}
	public void setResons(List<String> resons) {
		this.resons = resons;
	}
	public Timestamp getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(Timestamp deleteTime) {
		this.deleteTime = deleteTime;
	}
	@Override
	public String toString() {
		return "Publish [QRCode=" + QRCode + ", admin=" + admin
				+ ", assessComplaintSet=" + assessComplaintSet
				+ ", authorization=" + authorization + ", backColor="
				+ backColor + ", backImageUrl=" + backImageUrl + ", biggerPic="
				+ biggerPic + ", chinesusagePeriod=" + chinesusagePeriod
				+ ", commend=" + commend + ", content=" + content
				+ ", copyright=" + copyright + ", copyrightArea="
				+ copyrightArea + ", copyrightPrice=" + copyrightPrice
				+ ", copyrightproperty=" + copyrightproperty + ", deleteTime="
				+ deleteTime + ", fixwidthUrl=" + fixwidthUrl + ", height="
				+ height + ", hit=" + hit + ", id=" + id
				+ ", ifContentHealthy=" + ifContentHealthy
				+ ", ifPermitPublish=" + ifPermitPublish + ", ifTort=" + ifTort
				+ ", indexImgUrl=" + indexImgUrl + ", licenseAgreement="
				+ licenseAgreement + ", logo=" + logo + ", moneyAmount="
				+ moneyAmount + ", moneyExpect=" + moneyExpect + ", moneyTime="
				+ moneyTime + ", moneyUnit=" + moneyUnit + ", name=" + name
				+ ", notPassedCause=" + notPassedCause + ", originalPic="
				+ originalPic + ", period=" + period + ", periodShould="
				+ periodShould + ", picMode=" + picMode + ", picNumber="
				+ picNumber + ", picUrl=" + picUrl + ", picture=" + picture
				+ ", portraitprotocol=" + portraitprotocol + ", position="
				+ position + ", positionShould=" + positionShould
				+ ", productsprotocol=" + productsprotocol + ", psdPrecision="
				+ psdPrecision + ", publishCat=" + publishCat
				+ ", publishCats=" + publishCats + ", publishDetailSet="
				+ publishDetailSet + ", publishSpecialCat=" + publishSpecialCat
				+ ", publishStatus=" + publishStatus + ", publishTime="
				+ publishTime + ", publishwish=" + publishwish + ", purpose="
				+ purpose + ", qualityLevel=" + qualityLevel + ", resons="
				+ resons + ", roleTags=" + roleTags + ", samplePic="
				+ samplePic + ", sequence=" + sequence + ", sequenceShould="
				+ sequenceShould + ", setpublishCat_Publish="
				+ setpublishCat_Publish + ", size=" + size + ", smallDraw2="
				+ smallDraw2 + ", smallDrawCut=" + smallDrawCut + ", smallPic="
				+ smallPic + ", smalldrawUrl=" + smalldrawUrl
				+ ", smallthumbnailUrl=" + smallthumbnailUrl + ", status="
				+ status + ", tags=" + tags + ", thumbnail125=" + thumbnail125
				+ ", thumbnailUrl=" + thumbnailUrl + ", type=" + type
				+ ", typeName=" + typeName + ", upTime=" + upTime
				+ ", usageBuyNum=" + usageBuyNum + ", usagePeriod="
				+ usagePeriod + ", usagePrice=" + usagePrice + ", user=" + user
				+ ", venderUrl=" + venderUrl + ", violationPunish="
				+ violationPunish + ", violationPunishTime="
				+ violationPunishTime + ", violationReason=" + violationReason
				+ ", voiceUrl=" + voiceUrl + ", watermarkUrl=" + watermarkUrl
				+ ", width=" + width + ", workdescribe=" + workdescribe
				+ ", writenopassreason=" + writenopassreason + "]";
	}
	
	
	
	
	
 
}//end class
