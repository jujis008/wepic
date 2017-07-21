package com.wetuo.wepic.deal.beans ;
 
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;
import com.wetuo.wepic.core.beans.User;
 
import java.util.*;
	
import java.util.*;
	
import java.util.*;
	
import java.util.*;
	
import java.util.*;
	
import java.util.*;
	
public class Bid  implements Serializable {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	private String id;
	protected User user;//发布用户
	private String name;//标题
	private double totalMoney;//总价
	private java.sql.Timestamp startTime;//发布时间
	private String period;//应约截至时间
	private Integer bidType;//约拍类型
	private Integer publicOrPrivate;//1公开 2是秘密
	private Integer refresh;//查看次数
	private Integer status;// 暂时无用  //0-发布中，2筛选中 ,3拍摄中,4已结束,5-任务成功结束,6-已取消 7--约拍出现争议  8--未审核9--审核不通过;// 1-时间到，流标,3
	private String bidderAssess;//
	private java.sql.Timestamp payTime;
	private Integer ifTaskFinished;//暂时无用
	private Integer autoFinishPeriod;//
	private Integer numChangeWorker;//换人次数
	private Integer type;// 项目类型
	private String tag;//// 产品类型/
	private String workStartTime;//工作开始时间
	private String workEndTime;//工作结束时间
	private String content;//拍摄内容以及要求
	private int user_;//// 暂时无用/
	private int imgSum;//图片数量
	private int ifAskPrice; //是否需要摄影师报价？0 不需要，1需要
	private String workPlace;//工作地点
	private String appendix;//行业,征集创意设计独有
	private String contextHtml;//应约条件
	private String shootingEnvironment;//拍摄环境/内景2外景
	private String photoType;//拍摄方式 0不限,1跟拍2寄拍
	private String isHaveModel;//0是不需要模特1我方提供模特2是摄影师提供
	private Integer sumProdct;//产品数量 
	private Integer sumProductPhoto;//产品格式 1片2件3秒4套5人6篇7,张
	private Integer recruitNum;//人数,或者数量
	private Integer productNum;//数量 模特独用
    private double unitpriceProduct;//单价
    private Integer unitpriceType;//计价格式 1件2天3时4秒5片6套7个8页,9平米10篇11,张
    private String attachmentUrl;//附件地址
    private String containsModelPrice;//是否包含模特的费用
    private BidDetailCount bidDetailCount;
    private int bidView;//查看
    private int bidGood;//赞
    private int saveFrarite;//收藏
    private String copyRighyt;//1版权2使用权
    private int   ifNeedbill;//6--发票已填写
    private String workHour;
    private String needModelOrPhoto;//1是摄影师2 model;
    private String modeType;//模特类型
    private String modelStyle;//模特风格
    private String isAgeRequest;//年龄要求
    private String isSexRequest;//性别要求
    private String photoTerm;//拍摄团队 1我方提供2模特提供
    private String worksspecifications;//作品精度
    private String workPrecision;//作品规格1px.2厘米3,m,
    private String workPrecisionWidth;//作品规格Width,
    private String workPrecisionHeight;//作品规格Width,
    private String  fileType; //1位图2矢量图3:3D格式/文件类型
    private String isCopyright;//1使用权2版权 征集专有
    private String numFont;
    private String sjProjectVI;//VI基础设计系统
    private String viApplication;//VI应用设计系统
    private BidStatus bidStatus;
    private BidCat bidCat;
    private int viCount;//记录总数
    private String ChagetotalMoney;
    private Integer openbill;//发票状态(0 没有 1有)
   public BidStatus getBidStatus() {
		return bidStatus;
	}
	public void setBidStatus(BidStatus bidStatus) {
		this.bidStatus = bidStatus;
	}
	// private String isCopyright;
    public BidDetailCount getBidDetailCount() {
		return bidDetailCount;
	}
	public void setBidDetailCount(BidDetailCount bidDetailCount) {
		this.bidDetailCount = bidDetailCount;
	}
	public String getAttachmentUrl() {
		return attachmentUrl;
	}
	public Integer getUnitpriceType() {
		return unitpriceType;
	}
	public void setUnitpriceType(Integer unitpriceType) {
		this.unitpriceType = unitpriceType;
	}
	public void setAttachmentUrl(String attachmentUrl) {
		this.attachmentUrl = attachmentUrl;
	}
	public double getUnitpriceProduct() {
		return unitpriceProduct;
	}
	public void setUnitpriceProduct(double unitpriceProduct) {
		this.unitpriceProduct = unitpriceProduct;
	}
	
	public String getAppendix() {
		return appendix;
	}
	public void setAppendix(String appendix) {
		this.appendix = appendix;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public int getImgSum() {
		return imgSum;
	}
	public void setImgSum(int imgSum) {
		this.imgSum = imgSum;
	}
	public String getWorkStartTime() {
		return workStartTime;
	}
	public void setWorkStartTime(String workStartTime) {
		this.workStartTime = workStartTime;
	}
	public String getWorkEndTime() {
		return workEndTime;
	}
	public int getUser_() {
		return user_;
	}
	public void setUser_(int user) {
		user_ = user;
	}
	public void setWorkEndTime(String workEndTime) {
		this.workEndTime = workEndTime;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	////start OneToMany
	private Set<BidDetail> bidDetailSet  = new HashSet<BidDetail>();// 
	public Set<BidDetail> getBidDetailSet() {
		return this.bidDetailSet;
	}//end get
	public void setBidDetailSet(Set<BidDetail> bidDetailSet) {
		this.bidDetailSet = bidDetailSet ;
	}//end set
	////start OneToMany
	BidAimPerson bidAimPerson  = new BidAimPerson();// 
	

	public BidAimPerson getBidAimPerson() {
		return bidAimPerson;
	}
	public void setBidAimPerson(BidAimPerson bidAimPerson) {
		this.bidAimPerson = bidAimPerson;
	}
	////start OneToMany
	private Set<BidResponseInvited> bidResponseInvitedSet  = new HashSet<BidResponseInvited>();// 
	public Set<BidResponseInvited> getBidResponseInvitedSet() {
		return this.bidResponseInvitedSet;
	}//end get
	public void setBidResponseInvitedSet(Set<BidResponseInvited> bidResponseInvitedSet) {
		this.bidResponseInvitedSet = bidResponseInvitedSet ;
	}//end set
	////start OneToMany
	private Set<BidAccountOperation> bidAccountOperationSet  = new HashSet<BidAccountOperation>();// 
	public Set<BidAccountOperation> getBidAccountOperationSet() {
		return this.bidAccountOperationSet;
	}//end get
	public void setBidAccountOperationSet(Set<BidAccountOperation> bidAccountOperationSet) {
		this.bidAccountOperationSet = bidAccountOperationSet ;
	}//end set
	////start OneToMany
	private Set<BidReceiverConfirmChange> bidReceiverConfirmChangeSet  = new HashSet<BidReceiverConfirmChange>();// 
	public Set<BidReceiverConfirmChange> getBidReceiverConfirmChangeSet() {
		return this.bidReceiverConfirmChangeSet;
	}//end get
	public void setBidReceiverConfirmChangeSet(Set<BidReceiverConfirmChange> bidReceiverConfirmChangeSet) {
		this.bidReceiverConfirmChangeSet = bidReceiverConfirmChangeSet ;
	}//end set
	////start OneToMany
	private Set<BidForOpus> bidForOpusSet  = new HashSet<BidForOpus>();// 
	public Set<BidForOpus> getBidForOpusSet() {
		return this.bidForOpusSet;
	}//end get
	public void setBidForOpusSet(Set<BidForOpus> bidForOpusSet) {
		this.bidForOpusSet = bidForOpusSet ;
	}//end set
	/////////constructor//////////////////
	
	public Bid(String id,User user,String name,double totalMoney,Integer recruitNum,java.sql.Timestamp startTime,String period,Integer bidType,Integer publicOrPrivate,Integer refresh,Integer status,String bidderAssess,java.sql.Timestamp payTime,Integer ifTaskFinished,Integer autoFinishPeriod,Integer numChangeWorker) {
		this.id = id;
		this.user = user;
		this.name = name;
		this.totalMoney = totalMoney;
		this.recruitNum = recruitNum;
		this.startTime = startTime;
		this.period = period;
		this.bidType = bidType;
		this.publicOrPrivate = publicOrPrivate;
		this.refresh = refresh;
		this.status = status;
		this.bidderAssess = bidderAssess;
		this.payTime = payTime;
		this.ifTaskFinished = ifTaskFinished;
		this.autoFinishPeriod = autoFinishPeriod;
		this.numChangeWorker = numChangeWorker;
	}//
	
	public Bid(){
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
	public String  getName(){
		return this.name;
	}
	public void  setName(String name){
		this.name = name ;
	}
	public double  getTotalMoney(){
		return this.totalMoney;
	}
	public void  setTotalMoney(double totalMoney){
		this.totalMoney = totalMoney ;
	}
	public Integer  getRecruitNum(){
		return this.recruitNum;
	}
	public void  setRecruitNum(Integer recruitNum){
		this.recruitNum = recruitNum ;
	}
	public java.sql.Timestamp  getStartTime(){
		return this.startTime;
	}
	public void  setStartTime(java.sql.Timestamp startTime){
		this.startTime = startTime ;
	}
	public String  getPeriod(){
		return this.period;
	}
	public void  setPeriod(String period){
		this.period = period ;
	}
	public Integer  getBidType(){
		return this.bidType;
	}
	public void  setBidType(Integer bidType){
		this.bidType = bidType ;
	}
	public Integer  getPublicOrPrivate(){
		return this.publicOrPrivate;
	}
	public void  setPublicOrPrivate(Integer publicOrPrivate){
		this.publicOrPrivate = publicOrPrivate ;
	}
	public Integer  getRefresh(){
		return this.refresh;
	}
	public void  setRefresh(Integer refresh){
		this.refresh = refresh ;
	}
	public Integer  getStatus(){
		return this.status;
	}
	public void  setStatus(Integer status){
		this.status = status ;
	}
	public String  getBidderAssess(){
		return this.bidderAssess;
	}
	public void  setBidderAssess(String bidderAssess){
		this.bidderAssess = bidderAssess ;
	}
	public java.sql.Timestamp  getPayTime(){
		return this.payTime;
	}
	public void  setPayTime(java.sql.Timestamp payTime){
		this.payTime = payTime ;
	}
	public Integer  getIfTaskFinished(){
		return this.ifTaskFinished;
	}
	public void  setIfTaskFinished(Integer ifTaskFinished){
		this.ifTaskFinished = ifTaskFinished ;
	}
	public Integer  getAutoFinishPeriod(){
		return this.autoFinishPeriod;
	}
	public void  setAutoFinishPeriod(Integer autoFinishPeriod){
		this.autoFinishPeriod = autoFinishPeriod ;
	}
	public Integer  getNumChangeWorker(){
		return this.numChangeWorker;
	}
	public void  setNumChangeWorker(Integer numChangeWorker){
		this.numChangeWorker = numChangeWorker ;
	}
	public int getIfAskPrice() {
		return ifAskPrice;
	}
	public void setIfAskPrice(int ifAskPrice) {
		this.ifAskPrice = ifAskPrice;
	}
	public String getContextHtml() {
		return contextHtml;
	}
	public void setContextHtml(String contextHtml) {
		this.contextHtml = contextHtml;
	}
	public String getShootingEnvironment() {
		return shootingEnvironment;
	}
	public void setShootingEnvironment(String shootingEnvironment) {
		this.shootingEnvironment = shootingEnvironment;
	}
	public String getIsHaveModel() {
		return isHaveModel;
	}
	public void setIsHaveModel(String isHaveModel) {
		this.isHaveModel = isHaveModel;
	}
	public Integer getSumProdct() {
		return sumProdct;
	}
	public void setSumProdct(Integer sumProdct) {
		this.sumProdct = sumProdct;
	}
	public Integer getSumProductPhoto() {
		return sumProductPhoto;
	}
	public void setSumProductPhoto(Integer sumProductPhoto) {
		this.sumProductPhoto = sumProductPhoto;
	}
	public int getBidView() {
		return bidView;
	}
	public void setBidView(int bidView) {
		this.bidView = bidView;
	}
	public int getBidGood() {
		return bidGood;
	}
	public void setBidGood(int bidGood) {
		this.bidGood = bidGood;
	}
	public int getSaveFrarite() {
		return saveFrarite;
	}
	public void setSaveFrarite(int saveFrarite) {
		this.saveFrarite = saveFrarite;
	}
	
	public int getIfNeedbill() {
		return ifNeedbill;
	}
	public void setIfNeedbill(int ifNeedbill) {
		this.ifNeedbill = ifNeedbill;
	}
	
	public String getNeedModelOrPhoto() {
		return needModelOrPhoto;
	}
	public void setNeedModelOrPhoto(String needModelOrPhoto) {
		this.needModelOrPhoto = needModelOrPhoto;
	}
	public String getCopyRighyt() {
		return copyRighyt;
	}
	public void setCopyRighyt(String copyRighyt) {
		this.copyRighyt = copyRighyt;
	}
	public String getWorkHour() {
		return workHour;
	}
	public void setWorkHour(String workHour) {
		this.workHour = workHour;
	}
	public String getPhotoType() {
		return photoType;
	}
	public void setPhotoType(String photoType) {
		this.photoType = photoType;
	}
	public String getContainsModelPrice() {
		return containsModelPrice;
	}
	public void setContainsModelPrice(String containsModelPrice) {
		this.containsModelPrice = containsModelPrice;
	}
	public String getModeType() {
		return modeType;
	}
	public void setModeType(String modeType) {
		this.modeType = modeType;
	}
	public String getModelStyle() {
		return modelStyle;
	}
	public void setModelStyle(String modelStyle) {
		this.modelStyle = modelStyle;
	}
	public String getIsAgeRequest() {
		return isAgeRequest;
	}
	public void setIsAgeRequest(String isAgeRequest) {
		this.isAgeRequest = isAgeRequest;
	}
	public String getIsSexRequest() {
		return isSexRequest;
	}
	public void setIsSexRequest(String isSexRequest) {
		this.isSexRequest = isSexRequest;
	}
	public String getPhotoTerm() {
		return photoTerm;
	}
	public void setPhotoTerm(String photoTerm) {
		this.photoTerm = photoTerm;
	}
	public Integer getProductNum() {
		return productNum;
	}
	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}
	public String getWorksspecifications() {
		return worksspecifications;
	}
	public void setWorksspecifications(String worksspecifications) {
		this.worksspecifications = worksspecifications;
	}
	public String getWorkPrecision() {
		return workPrecision;
	}
	public void setWorkPrecision(String workPrecision) {
		this.workPrecision = workPrecision;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getWorkPrecisionWidth() {
		return workPrecisionWidth;
	}
	public void setWorkPrecisionWidth(String workPrecisionWidth) {
		this.workPrecisionWidth = workPrecisionWidth;
	}
	public String getWorkPrecisionHeight() {
		return workPrecisionHeight;
	}
	public void setWorkPrecisionHeight(String workPrecisionHeight) {
		this.workPrecisionHeight = workPrecisionHeight;
	}
	public String getIsCopyright() {
		return isCopyright;
	}
	public void setIsCopyright(String isCopyright) {
		this.isCopyright = isCopyright;
	}
	public String getNumFont() {
		return numFont;
	}
	public void setNumFont(String numFont) {
		this.numFont = numFont;
	}
	public String getSjProjectVI() {
		return sjProjectVI;
	}
	public void setSjProjectVI(String sjProjectVI) {
		this.sjProjectVI = sjProjectVI;
	}
	public String getViApplication() {
		return viApplication;
	}
	public void setViApplication(String viApplication) {
		this.viApplication = viApplication;
	}
	public BidCat getBidCat() {
		return bidCat;
	}
	public void setBidCat(BidCat bidCat) {
		this.bidCat = bidCat;
	}
	public int getViCount() {
		return viCount;
	}
	public void setViCount(int viCount) {
		this.viCount = viCount;
	}
	public String getChagetotalMoney() {
		return ChagetotalMoney;
	}
	public void setChagetotalMoney(String chagetotalMoney) {
		ChagetotalMoney = chagetotalMoney;
	}
	public Integer getOpenbill() {
		return openbill;
	}
	public void setOpenbill(Integer openbill) {
		this.openbill = openbill;
	}

   
	
	
	
 
}//end classsssddd
