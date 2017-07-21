package com.wetuo.wepic.core.beans ;

import com.wetuo.wepic.deal.beans.UserMess;
 
import java.util.*;
	
	
public class User  {
	public User(){
		super();
	}
	public User(String name){
		this.username=name;
		
	}
 
	//用户档案(个人空间)
	
	/////instantce variable//////

	private Integer id;
	private String userNo;//用户编号
	private String username;//用户名称
	private String password;//用户密码
	private String email;//用户邮箱
	private UserMess userMess; 
	private String pic;
	private UserDetalfor detalfor;
	//(前台显示及搜索显示)
	private String nickName ;//用户昵称
	private String portrait;//用户头像
	private String smallportrait;//用户头像
	private String occupation;//用户职业
	private String workPlace;//用户工作地址
	/* 弃用*/
	private Integer creditRatings;//
	private Integer totalCredits ;//
	
	private String worktel;//
	private String mobile;//用户手机号码
	private String age;
	
	//基础信息
	private String sex;	//用户性别
	private String birthday ;//用户生日
	private Date regTime;//用户注册时间
	public Date getRegTime() {
		return regTime;
	}
	public void setRegTime(Date regTime) {
		this.regTime = regTime;
	}

	private String height;//身高
	private String weight;//体重	
	private String bust;//胸围
	private String waist;	//腰围
	private String hip;	//点击
	private String newhip;	//臀围
	private String shoeSize;//鞋码	
	private String hairColor;//头发颜色
	
	//学历
	private String highestDegree ;//最高学历
	private String highestDegreeDate ;//毕业时间
	private String highestDegreeSchool ;//毕业学校
	//private String 
	/*备用*/
	private String bachelorDate ;//学位
	private String bachelorSchool ;//院系
	private String zodiac; //生肖
	private String Constellation ;//星座
	private String bloodtype;//血型
	
	private String major;//专业
	private String training ;//培训
	
	//个人自荐(空间主页左栏显示)
	private String selfIntroduction ;//能力描述
	private String projects ;//代表项目
	private String context;//个人简介
	
	//作品及获奖(空间主页左栏显示)
	private String works ;//代表作品
	private String prize ;//获奖记录
	
	private String favorate;
	
	//联系信息(约拍确定后可见)
	private Integer personOrCompany;//注册方式（1、个人注册 2、公司注册）
	private String govermentenrollment;//政府登记表
	private String mediaenrollment;//媒体登记表
	//企业注册所需信息
	private Integer enterpriceType; // 企业注册类型 (1.政府 2.媒体 3.企业 4.其他组织)
	private String companyName;//公司名称
	private String companyEmail;//企业邮箱
	private String companyAddr;//企业地址
	private String certificateNo;//营业执照注册号
	private String companyRegAddr;//企业注册所在地
	private String companyBuildDate;//公司成立时间
	private String busnissAllowedTime;//公司营业期限
	private String businessScope;//经营范围
	private String companyRegMoney;//注册资本
	private String companyorgcode;//组织结构代码
	private String markerName;//运营者姓名
	private String markerIDCard;//运营者身份证号码
	private String certificatePic;//营业执照（营业执照扫描件）
	private String licenseagreement;//授权运营书
	private String markerduty;//运营者职务
	private String realName;//真实姓名
	private String homeTown;//家乡
	private String address;//
	private String Industry;//所属行业
	
	private String idCardFrontPic;//身份证正面
	private String idCardBackPic;//身份证反面
	private String residence;//住宅
	private String idCardNo;//身份证号
	
	private String qq;//qq
	private String qqCode;
	private String phone;
	private Integer hasBadHistory;
	private Integer ifApplyContributingPhotographer;
	private Integer isContributingPhotographer;
	private Integer adminId ;
	private Integer ifIdentityTrue ;//0刚注册（未认证）  1申请实名认证（显示为审核） 2 通过 3 不通过
	private Integer punishToAllPublish ;//0使用中 1 冻结 2除名
	private String role;
	private String chineseRole;
	private Integer statu;//是否被激活0未激活，1激活
	private String authenticationCode;//短信验证码
	private String specificUrl;
	private String qqOpenId;
	private String weiboOpenId;
	private String detail1;//自定义标签1
	private String detail2;//自定标签2;
	private String isediteuserInfo;//自定标签2;
	private String userTag;//用户标签
	private String personTag;//个人标签
	private String validatetime;
	
	
	public String getUserTag() {
		return userTag;
	}
	public void setUserTag(String userTag) {
		this.userTag = userTag;
	}
	public String getQqOpenId() {
		return qqOpenId;
	}
	public void setQqOpenId(String qqOpenId) {
		this.qqOpenId = qqOpenId;
	}
	public String getSpecificUrl() {
		return specificUrl;
	}
	public void setSpecificUrl(String specificUrl) {
		this.specificUrl = specificUrl;
	}
	public Integer getStatu() {
		return statu;
	}
	public void setStatu(Integer statu) {
		this.statu = statu;
	}
	public String getChineseRole() {
		return chineseRole;
	}
	public void setChineseRole(String chineseRole) {
		this.chineseRole = chineseRole;
	}
	

	public UserMess getUserMess() {
		return userMess;
	}
	public void setUserMess(UserMess userMess) {
		this.userMess = userMess;
	}

	private String brokerFlag;//用来判断该用户是否被某个经纪人请求过

	private String beAgreed;
	private String bgPic;

	private String nopassreason;//不通过原因
	private String otherreason;//管理员写入不通过原因
	private String nopasscause;

	public String getNopassreason() {
		return nopassreason;
	}
	public void setNopassreason(String nopassreason) {
		this.nopassreason = nopassreason;
	}
	public String getBeAgreed() {
		return beAgreed;
	}
	public void setBeAgreed(String beAgreed) {
		this.beAgreed = beAgreed;
	}
	public String getBrokerFlag() {
		return brokerFlag;
	}
	public void setBrokerFlag(String brokerFlag) {
		this.brokerFlag = brokerFlag;
	}
	public Integer getPersonOrCompany() {
		return personOrCompany;
	}
	public void setPersonOrCompany(Integer personOrCompany) {
		this.personOrCompany = personOrCompany;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	
	public String getDetail1() {
		return detail1;
	}
	public void setDetail1(String detail1) {
		this.detail1 = detail1;
	}
	public String getDetail2() {
		return detail2;
	}
	public void setDetail2(String detail2) {
		this.detail2 = detail2;
	}
	public String getCompanyEmail() {
		return companyEmail;
	}
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}
	public String getCompanyAddr() {
		return companyAddr;
	}
	public void setCompanyAddr(String companyAddr) {
		this.companyAddr = companyAddr;
	}
	public String getCertificateNo() {
		return certificateNo;
	}
	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}
	public String getCompanyRegAddr() {
		return companyRegAddr;
	}
	public void setCompanyRegAddr(String companyRegAddr) {
		this.companyRegAddr = companyRegAddr;
	}
	
	public String getCompanyBuildDate() {
		return companyBuildDate;
	}
	public void setCompanyBuildDate(String companyBuildDate) {
		this.companyBuildDate = companyBuildDate;
	}
	public String getBusnissAllowedTime() {
		return busnissAllowedTime;
	}
	public void setBusnissAllowedTime(String busnissAllowedTime) {
		this.busnissAllowedTime = busnissAllowedTime;
	}
	public String getBusinessScope() {
		return businessScope;
	}
	public void setBusinessScope(String businessScope) {
		this.businessScope = businessScope;
	}
	public String getCompanyRegMoney() {
		return companyRegMoney;
	}
	public void setCompanyRegMoney(String companyRegMoney) {
		this.companyRegMoney = companyRegMoney;
	}
	public String getCompanyorgcode() {
		return companyorgcode;
	}
	public void setCompanyorgcode(String companyorgcode) {
		this.companyorgcode = companyorgcode;
	}
	public String getMarkerName() {
		return markerName;
	}
	public void setMarkerName(String markerName) {
		this.markerName = markerName;
	}
	public String getMarkerIDCard() {
		return markerIDCard;
	}
	
	public String getIsediteuserInfo() {
		return isediteuserInfo;
	}
	public void setIsediteuserInfo(String isediteuserInfo) {
		this.isediteuserInfo = isediteuserInfo;
	}
	public void setMarkerIDCard(String markerIDCard) {
		this.markerIDCard = markerIDCard;
	}
	public String getLicenseagreement() {
		return licenseagreement;
	}
	public void setLicenseagreement(String licenseagreement) {
		this.licenseagreement = licenseagreement;
	}
	public String getMarkerduty() {
		return markerduty;
	}
	public void setMarkerduty(String markerduty) {
		this.markerduty = markerduty;
	}
	public String getResidence() {
		return residence;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
	public String getIdCardNo() {
		return idCardNo;
	}
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getQqCode() {
		return qqCode;
	}
	public void setQqCode(String qqCode) {
		this.qqCode = qqCode;
	}
	public String getPhone() {
		return phone;
	}
	
	public String getSmallportrait() {
		return smallportrait;
	}
	public void setSmallportrait(String smallportrait) {
		this.smallportrait = smallportrait;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getHasBadHistory() {
		return hasBadHistory;
	}
	public void setHasBadHistory(Integer hasBadHistory) {
		this.hasBadHistory = hasBadHistory;
	}
	public Integer getIfApplyContributingPhotographer() {
		return ifApplyContributingPhotographer;
	}
	public void setIfApplyContributingPhotographer(
			Integer ifApplyContributingPhotographer) {
		this.ifApplyContributingPhotographer = ifApplyContributingPhotographer;
	}
	public Integer getIsContributingPhotographer() {
		return isContributingPhotographer;
	}
	public void setIsContributingPhotographer(Integer isContributingPhotographer) {
		this.isContributingPhotographer = isContributingPhotographer;
	}
	public Integer getAdminId() {
		return adminId;
	}
	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}
	public Integer getIfIdentityTrue() {
		return ifIdentityTrue;
	}
	public void setIfIdentityTrue(Integer ifIdentityTrue) {
		this.ifIdentityTrue = ifIdentityTrue;
	}
	public Integer getPunishToAllPublish() {
		return punishToAllPublish;
	}
	public void setPunishToAllPublish(Integer punishToAllPublish) {
		this.punishToAllPublish = punishToAllPublish;
	}

	////start OneToMany
	private UserCat userCat;//
	public UserCat getUserCat() {
		return userCat;
	}//end get()
	public void setUserCat(UserCat userCat) {
		this.userCat = userCat;
	}//end set()
	////start OneToMany
	private Set<UserDetail> userDetailSet  = new HashSet<UserDetail>();// 
	public Set<UserDetail> getUserDetailSet() {
		return this.userDetailSet;
	}//end get
	public void setUserDetailSet(Set<UserDetail> userDetailSet) {
		this.userDetailSet = userDetailSet ;
	}//end set
	////start OneToMany
	private Set<UserHistory> userHistorySet  = new HashSet<UserHistory>();// 
	public Set<UserHistory> getUserHistorySet() {
		return this.userHistorySet;
	}//end get
	public void setUserHistorySet(Set<UserHistory> userHistorySet) {
		this.userHistorySet = userHistorySet ;
	}//end set
	////start OneToMany
	private Set<LoginHistory> loginHistorySet  = new HashSet<LoginHistory>();// 
	public Set<LoginHistory> getLoginHistorySet() {
		return this.loginHistorySet;
	}//end get
	public void setLoginHistorySet(Set<LoginHistory> loginHistorySet) {
		this.loginHistorySet = loginHistorySet ;
	}//end set
//	////start OneToMany
//	private Set<UserCreditHistory> userCreditHistorySet  = new HashSet<UserCreditHistory>();// 
//	public Set<UserCreditHistory> getUserCreditHistorySet() {
//		return this.userCreditHistorySet;
//	}//end get
//	public void setUserCreditHistorySet(Set<UserCreditHistory> userCreditHistorySet) {
//		this.userCreditHistorySet = userCreditHistorySet ;
//	}//end set
	////start OneToMany
	private Set<PublishFavorite> publishFavoriteSet  = new HashSet<PublishFavorite>();// 
	public Set<PublishFavorite> getPublishFavoriteSet() {
		return this.publishFavoriteSet;
	}//end get
	public void setPublishFavoriteSet(Set<PublishFavorite> publishFavoriteSet) {
		this.publishFavoriteSet = publishFavoriteSet ;
	}//end set
	/////////constructor//////////////////
	
	public User(Integer id,String username,String password,String email,String realName,String homeTown,String address,String pic,String worktel,String mobile,String sex,String favorate) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.realName = realName;
		this.homeTown = homeTown;
		this.address = address;
		this.pic = pic;
		this.worktel = worktel;
		this.mobile = mobile;
		this.sex = sex;
		this.favorate = favorate;
	}//
	
	
 
	/////getter////setter//////
	public Integer getId() {
		return this.id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String  getUsername(){
		return this.username;
	}
	public void  setUsername(String username){
		this.username = username ;
	}
	public String  getPassword(){
		return this.password;
	}
	public void  setPassword(String password){
		this.password = password ;
	}
	public String  getEmail(){
		return this.email;
	}
	public void  setEmail(String email){
		this.email = email ;
	}
	public String  getRealName(){
		return this.realName;
	}
	public void  setRealName(String realName){
		this.realName = realName ;
	}
	public String  getHomeTown(){
		return this.homeTown;
	}
	public void  setHomeTown(String homeTown){
		this.homeTown = homeTown ;
	}
	public String  getAddress(){
		return this.address;
	}
	public void  setAddress(String address){
		this.address = address ;
	}
	
	public String  getWorktel(){
		return this.worktel;
	}
	public void  setWorktel(String worktel){
		this.worktel = worktel ;
	}
	public String  getMobile(){
		return this.mobile;
	}
	public void  setMobile(String mobile){
		this.mobile = mobile ;
	}
	public String  getSex(){
		return this.sex;
	}
	public void  setSex(String sex){
		this.sex = sex ;
	}
	public String  getFavorate(){
		return this.favorate;
	}
	public void  setFavorate(String favorate){
		this.favorate = favorate ;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getCertificatePic() {
		return certificatePic;
	}
	public void setCertificatePic(String certificatePic) {
		this.certificatePic = certificatePic;
	}
	public String getIdCardFrontPic() {
		return idCardFrontPic;
	}
	public void setIdCardFrontPic(String idCardFrontPic) {
		this.idCardFrontPic = idCardFrontPic;
	}
	public String getIdCardBackPic() {
		return idCardBackPic;
	}
	public void setIdCardBackPic(String idCardBackPic) {
		this.idCardBackPic = idCardBackPic;
	}
	public String getSelfIntroduction() {
		return selfIntroduction;
	}
	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPortrait() {
		return portrait;
	}
	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public String getHairColor() {
		return hairColor;
	}
	public void setHairColor(String hairColor) {
		this.hairColor = hairColor;
	}
	public String getHighestDegree() {
		return highestDegree;
	}
	public void setHighestDegree(String highestDegree) {
		this.highestDegree = highestDegree;
	}
	public String getHighestDegreeSchool() {
		return highestDegreeSchool;
	}
	public void setHighestDegreeSchool(String highestDegreeSchool) {
		this.highestDegreeSchool = highestDegreeSchool;
	}
	
	public String getBachelorDate() {
		return bachelorDate;
	}
	public void setBachelorDate(String bachelorDate) {
		this.bachelorDate = bachelorDate;
	}
	public String getBachelorSchool() {
		return bachelorSchool;
	}
	public void setBachelorSchool(String bachelorSchool) {
		this.bachelorSchool = bachelorSchool;
	}
	public String getTraining() {
		return training;
	}
	public void setTraining(String training) {
		this.training = training;
	}
	public String getProjects() {
		return projects;
	}
	public void setProjects(String projects) {
		this.projects = projects;
	}
	public String getWorks() {
		return works;
	}
	public void setWorks(String works) {
		this.works = works;
	}
	public String getPrize() {
		return prize;
	}
	public void setPrize(String prize) {
		this.prize = prize;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getBgPic() {
		return bgPic;
	}
	public void setBgPic(String bgPic) {
		this.bgPic = bgPic;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public Integer getCreditRatings() {
		return creditRatings;
	}
	public void setCreditRatings(Integer creditRatings) {
		this.creditRatings = creditRatings;
	}
	public Integer getTotalCredits() {
		return totalCredits;
	}
	public void setTotalCredits(Integer totalCredits) {
		this.totalCredits = totalCredits;
	}
	public String getAuthenticationCode() {
		return authenticationCode;
	}
	public void setAuthenticationCode(String authenticationCode) {
		this.authenticationCode = authenticationCode;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getBust() {
		return bust;
	}
	public void setBust(String bust) {
		this.bust = bust;
	}
	public String getWaist() {
		return waist;
	}
	public void setWaist(String waist) {
		this.waist = waist;
	}
	public String getHip() {
		return hip;
	}
	public void setHip(String hip) {
		this.hip = hip;
	}
	public String getShoeSize() {
		return shoeSize;
	}
	public void setShoeSize(String shoeSize) {
		this.shoeSize = shoeSize;
	}
	public String getHighestDegreeDate() {
		return highestDegreeDate;
	}
	public void setHighestDegreeDate(String highestDegreeDate) {
		this.highestDegreeDate = highestDegreeDate;
	}
	public String getNewhip() {
		return newhip;
	}
	public void setNewhip(String newhip) {
		this.newhip = newhip;
	}
	public String getWeiboOpenId() {
		return weiboOpenId;
	}
	public void setWeiboOpenId(String weiboOpenId) {
		this.weiboOpenId = weiboOpenId;
	}
	public String getZodiac() {
		return zodiac;
	}
	public void setZodiac(String zodiac) {
		this.zodiac = zodiac;
	}
	public String getConstellation() {
		return Constellation;
	}
	public void setConstellation(String constellation) {
		Constellation = constellation;
	}
	public String getBloodtype() {
		return bloodtype;
	}
	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getIndustry() {
		return Industry;
	}
	public void setIndustry(String industry) {
		Industry = industry;
	}
	public String getPersonTag() {
		return personTag;
	}
	public void setPersonTag(String personTag) {
		this.personTag = personTag;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Integer getEnterpriceType() {
		return enterpriceType;
	}
	public void setEnterpriceType(Integer enterpriceType) {
		this.enterpriceType = enterpriceType;
	}
	public String getGovermentenrollment() {
		return govermentenrollment;
	}
	public void setGovermentenrollment(String govermentenrollment) {
		this.govermentenrollment = govermentenrollment;
	}
	public String getMediaenrollment() {
		return mediaenrollment;
	}
	public void setMediaenrollment(String mediaenrollment) {
		this.mediaenrollment = mediaenrollment;
	}
	public String getValidatetime() {
		return validatetime;
	}
	public void setValidatetime(String validatetime) {
		this.validatetime = validatetime;
	}
	public String getOtherreason() {
		return otherreason;
	}
	public void setOtherreason(String otherreason) {
		this.otherreason = otherreason;
	}
	public String getNopasscause() {
		return nopasscause;
	}
	public void setNopasscause(String nopasscause) {
		this.nopasscause = nopasscause;
	}
 
	
	
	
}//end class
