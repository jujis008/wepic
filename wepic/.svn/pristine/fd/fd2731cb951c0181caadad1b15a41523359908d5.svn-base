package com.wetuo.wepic.core.actions;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.components.If;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.util.MD5Code;
import com.wetuo.wepic.core.beans.LoginHistory;
import com.wetuo.wepic.core.beans.RoleTags;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.beans.UserCat;
import com.wetuo.wepic.core.beans.UserInfoBeans;
import com.wetuo.wepic.core.service.UserCatService;
import com.wetuo.wepic.core.service.UserService;
import com.wetuo.wepic.publish.beans.Story;
@SuppressWarnings("unchecked")
public class ConfigurationAction extends PageAction{
	private Integer userId;
	private String inputmail;
	private String inputcode;
	private String mobilecode;
	private String newmobile;
	private String oldpwd;
	private String newpwd;
	private Integer msgFlag;
	private String emailcode;
	private Integer uploadres;
	private String param;
	private String picurl;
	
	private File goverregister;
	private String goverregisterFileName;
	private String goverregisterContentType;
	
	private File mdeiaregister;//媒体信息登记表
	private String mdeiaregisterFileName;
	private String mdeiaregisterContentType;
	
	private File myupfile;//上传证件照
	private String myupfileFileName;
	private String myupfileContentType;
	
	private File license; //上传执照
	private String licenseFileName;
	private String licenseContentType;
	
	private File letters;//申请公函
	private String lettersFileName;
	private String lettersContentType;
	public String modifypassword() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "modifypassword";
	}
	@JSON(serialize=false)
	public String validatepwd() throws Exception {
		int id=super.getLonginUserId();
		state=this.getUserService().validatepwd(id, oldpwd);
		return "validatepwd";
	}
	public String modifypwdsuc() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "modifypwdsuc";
	}
	public String modifysucpwd() throws Exception {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		MD5Code des = new MD5Code("leemenz");
		String newjiami=des.encrypt(newpwd);
		user.setPassword(newjiami);
		this.getUserService().update(user);
		state="1";
		return "modifysucpwd";
	}
	public String modifymobile() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "modifymobile";
	}
	public String configuration() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "configuration";
	}
	public String changephonebycurrentemail() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
	    return "changephonebycurrentemail";	
	}
	public String changephonebycurrentmobile() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "changephonebycurrentmobile";
	}
	public String validateloginpwd() throws Exception {
		String writepwd=ServletActionContext.getRequest().getParameter("inputpwd");
		user=this.getUserService().selectById(userId);
		MD5Code des = new MD5Code("leemenz");
		String despwd=des.decrypt(user.getPassword());//解密
		if (writepwd.equalsIgnoreCase(despwd)) {
			state="1";
		}else {
			state="0";
		}
		return "validateloginpwd";
	}
	
	public String changesteptwo() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "changesteptwo";
	}
	
	public String changephonesteptwo() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "changephonesteptwo";
	}
	public String validatemail() throws Exception {
		int id=super.getLonginUserId();
		state=this.getUserService().validatemail(id, inputmail);
		return "validatemail";
	}
	
	
	@JSON(serialize=false)
	public String sendemail() {
		int id=super.getLonginUserId();
		state=this.getUserService().sendemail(id);
		return "sendemail";
	}
	
	public String changephonebyemailvalidate() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		String sessioncode=getSession("loginValidateCode").toString();
		if (emailcode.equalsIgnoreCase(sessioncode)) {
			state="1";
		}else {
			state ="0";
		}
		return "changephonebyemailvalidate";
	}
	public String sendregemail() {
		return "sendregemail";
	}
	public String sendsuc() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "sendsuc";
	}
	public String validatecode() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		String sessioncode=getSession("loginValidateCode").toString();
		if (inputcode.equalsIgnoreCase(sessioncode)) {
			state="1";
		}else {
			state ="0";
		}
//		setSession("loginValidateCode", rs);
		return "validatecode";
	}
	public String checkmailfail() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "checkmailfail";
	}
	public String changephonefail() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "changephonefail";
	}
	public String modifysuc() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "modifysuc";
	}
	public String changephonesuc() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "changephonesuc";
	}
	public String securityIndex() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "securityIndex";
	}
	public String mobilevalidate() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "mobilevalidate";
	}
	public String validatemobilecode2() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		String sessioncode=getSession("msgcode").toString();
		if (mobilecode.equalsIgnoreCase(sessioncode)) {
			state="1";
		}else {
			state ="0";
		}
		return "validatemobilecode2";
	}
	public String validatemobilecode() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		user.setMobile(newmobile);
		this.getUserService().update(user);
		String sessioncode=getSession("msgcode").toString();
		if (mobilecode.equalsIgnoreCase(sessioncode)) {
			state="1";
		}else {
			state ="0";
		}
		return "validatemobilecode";
	}
	public String sendEmil(){
		int id=super.getLonginUserId();
		msgFlag=this.getUserService().sendEmil(id);
		return "sendEmil";
		}
	public String sendmobilecodeofmodifyemail() {
		int id=super.getLonginUserId();
		state=this.getUserService().sendmobilecodeofmodifyemail(id);
		return "sendmobilecodeofmodifyemail";
	}
	public String sendmobilecode() {
		state=this.getUserService().sendmobilecode(userId, newmobile);
		return "sendmobilecode";
	}
	 
	
	
	////////////////////////////实名认证////////////////////////////////////////
	public String personvalidate() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "personvalidate";
	}
	public String personvalidateing() throws Exception {
		int id=super.getLonginUserId();
		String areaCode=ServletActionContext.getRequest().getParameter("areaCode");
		String number=ServletActionContext.getRequest().getParameter("number");
		int res=this.getUserService().validateuser(user, id, areaCode, number,myidcardpic);
		return "personvalidateing";
	}
	public String personvalidateprocess() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "personvalidateprocess";
	}
	public String enterpricevalidateprocess() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "enterpricevalidateprocess";
	}
	public String enterpricevalidatesuc() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "enterpricevalidatesuc";
	}
	public String personvalidatesuc() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "personvalidatesuc";
	}
	public String personvalidatefail() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "personvalidatefail";
	}
	
	@JSON(serialize=false)
	public String uploadimg() {
		List myresult=new LinkedList();
		myresult=this.getUserService().uploadimg(myupfile,myupfileFileName);
		uploadres=Integer.valueOf(myresult.get(0).toString());
		param=myresult.get(1).toString();
		return "uploadimg";	
	}
	//上传执照
	@JSON(serialize=false)
	public String uploadlicense() {
		List myresult=new LinkedList();
		myresult=this.getUserService().uploadimg(license,licenseFileName);
		uploadres=Integer.valueOf(myresult.get(0).toString());
		param=myresult.get(1).toString();
		return "uploadlicense";	
	}
	//上传申请公函
	@JSON(serialize=false)
	public String uploadletters() {
		List myresult=new LinkedList();
		myresult=this.getUserService().uploadimg(letters,lettersFileName);
		uploadres=Integer.valueOf(myresult.get(0).toString());
		param=myresult.get(1).toString();
		return "uploadletters";	
	}
	//上传政府登记表
	@JSON(serialize=false)
	public String uploadgoverregister() {
		List myresult=new LinkedList();
		myresult=this.getUserService().uploadimg(goverregister,goverregisterFileName);
		uploadres=Integer.valueOf(myresult.get(0).toString());
		param=myresult.get(1).toString();
		return "uploadgoverregister";
	}
	//上传媒体登记表
	@JSON(serialize=false)
	public String uploadmediaregister() {
		List myresult=new LinkedList();
		myresult=this.getUserService().uploadimg(mdeiaregister,mdeiaregisterFileName);
		uploadres=Integer.valueOf(myresult.get(0).toString());
		param=myresult.get(1).toString();
		return "uploadmediaregister";
	}
	@JSON(serialize=false)
	public String modifyphonevalidatesuc() {
		int id=super.getLonginUserId();
		state=this.getUserService().sendmobilecode(id, newmobile);
		return "modifyphonevalidatesuc";
	}
	@JSON(serialize=false)
	public String updatephonesuc() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		user.setMobile(newmobile);
		this.getUserService().update(user);
		state="1";
		return "updatephonesuc";
	}
	
	@JSON(serialize=false)
	public String modifyaddr() throws Exception {
		int id=super.getLonginUserId();
		User user2=this.getUserService().selectById(id);
		user2.setResidence(user.getResidence());
		this.getUserService().update(user2);
		state="1";
		return "modifyaddr";
	}
	@JSON(serialize=false)
	public String modifycompanyaddr() throws Exception {
		int id=super.getLonginUserId();
		User user2=this.getUserService().selectById(id);
		user2.setCompanyAddr(user.getCompanyAddr());
		this.getUserService().update(user2);
		state="1";
		return "modifycompanyaddr";
	}
	@JSON(serialize=false)
	public String modifytel() throws Exception {
		int id=super.getLonginUserId();
		User user2=this.getUserService().selectById(id);
		user2.setWorktel(user.getWorktel());
		this.getUserService().update(user2);
		state="1";
		return "modifytel";
	}
	@JSON(serialize=false)
	public String modifyqq() throws Exception {
		int id=super.getLonginUserId();
		User user2=this.getUserService().selectById(id);
		user2.setQq(user.getQq());
		this.getUserService().update(user2);
		state="1";
		return "modifyqq";
	}
	@JSON(serialize=false)
	public String modifybusinessScope() {
		int id=super.getLonginUserId();
		User user2=this.getUserService().selectById(id);
		user2.setBusinessScope(user.getBusinessScope());
		this.getUserService().update(user2);
		state="1";
		return "modifybusinessScope";
	}
	@JSON(serialize=false)
	public String modifycompanyAddr() throws Exception {
		int id=super.getLonginUserId();
		User user2=this.getUserService().selectById(id);
		user2.setCompanyAddr(user.getCompanyAddr());
		this.getUserService().update(user2);
		state="1";
		return "modifycompanyAddr";
	}
	public String modifyduty() {
		int id=super.getLonginUserId();
		User user2=this.getUserService().selectById(id);
		user2.setMarkerduty(user.getMarkerduty());
		this.getUserService().update(user2);
		state="1";
		return "modifyduty";
	}
	
	public String enterpricevalidate() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "enterpricevalidate";
	}
	public String enterpricevalidateing() throws Exception {
		int id=super.getLonginUserId();
		String Area_province=ServletActionContext.getRequest().getParameter("Area_province");
		String Area_city=ServletActionContext.getRequest().getParameter("Area_city");
		String Area_District=ServletActionContext.getRequest().getParameter("Area_District");
		String phoneNumber=ServletActionContext.getRequest().getParameter("phoneNumber");
		String areaCode2=ServletActionContext.getRequest().getParameter("areaCode");
		String areaCode=Area_province+"-"+Area_city+"-"+Area_District;
		String gudingtel=areaCode2+"-"+phoneNumber;
		int res=this.getUserService().enterpricevalidate(user, id,areaCode,gudingtel);
		return "enterpricevalidateing";
	}
	public String govermentvalidate() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "govermentvalidate";
	}
	public String govermentvalidateing() throws Exception {
		int id=super.getLonginUserId();
		String areaCode=ServletActionContext.getRequest().getParameter("areaCode");
		String phoneNumber=ServletActionContext.getRequest().getParameter("phoneNumber");
		String gudingtel=areaCode+"-"+phoneNumber;
		int res=this.getUserService().enterpricevalidate(user, id,"",gudingtel);
		return "govermentvalidateing";
	}
	public String govermentvalidateingprocess() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "govermentvalidateingprocess";
	}
	public String govermentvalidatesuc() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "govermentvalidatesuc";
	}
	public String organzitionvalidatefail() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		if (user.getEnterpriceType() == 1) {
			return "govermentvalidatefail";
		}
		if (user.getEnterpriceType() == 2) {
			return "mediavalidatefail";
		}
		if (user.getEnterpriceType() == 3) {
			return "enterprisevalidatefail";
		}
		if (user.getEnterpriceType() == 4) {
			return "othervalidatefail";
		}
		loginHistory=this.getUserService().recentHistory();
		return null;
	}
	public String mediavalidate() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "mediavalidate";
	}
	public String mediavalidateing() throws Exception {
		int id=super.getLonginUserId();
		String areaCode2=ServletActionContext.getRequest().getParameter("areaCode");
		String phoneNumber=ServletActionContext.getRequest().getParameter("phoneNumber");
		String gudingtel=areaCode2+"-"+phoneNumber;
		int res=this.getUserService().enterpricevalidate(user, id,"",gudingtel);
		return "mediavalidateing";
	}
	public String mediavalidateingprocess() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "mediavalidateingprocess";
	}
	public String mediavalidatesuc() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "mediavalidatesuc";
	}
	public String othervalidate() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "othervalidate";
	}
	public String othervalidateing() throws Exception {
		int id=super.getLonginUserId();
		String Area_province=ServletActionContext.getRequest().getParameter("Area_province");
		String Area_city=ServletActionContext.getRequest().getParameter("Area_city");
		String Area_District=ServletActionContext.getRequest().getParameter("Area_District");
		String phoneNumber=ServletActionContext.getRequest().getParameter("phoneNumber");
		String areaCode2=ServletActionContext.getRequest().getParameter("areaCode");
		String areaCode=Area_province+"-"+Area_city+"-"+Area_District;
		String gudingtel=areaCode2+"-"+phoneNumber;
		int res=this.getUserService().enterpricevalidate(user, id,areaCode,gudingtel);
		return "othervalidateing";
	}
	public String othervalidateingprocess() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "othervalidateingprocess";
	}
	public String othervalidatesuc() {
		int id=super.getLonginUserId();
		user=this.getUserService().selectById(id);
		loginHistory=this.getUserService().recentHistory();
		return "othervalidatesuc";
	}
	
	
	
	/////////////////////管理员审核实名认证//////////////////////
	public String adminpersoncheck() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(User.class);
		criteria1.add(Restrictions.eq("personOrCompany", 1));
		criteria1.add(Restrictions.eq("ifIdentityTrue", 1));
		super.pager=this.getUserService().findbyDetachedCriteria(criteria1, pageNo,24);
		userCats=this.getUserCatService().getuserCatListJustUnderCat(2);
		return "adminpersoncheck";
	}
	public String adminpersoncheckbytype() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(User.class);
		criteria1.createAlias("userCat","cats");
		criteria1.add(Restrictions.eq("personOrCompany", 1));
		criteria1.add(Restrictions.eq("ifIdentityTrue", 1));
		criteria1.add(Restrictions.eq("cats.id", usercatId));
		super.pager=this.getUserService().findbyDetachedCriteria(criteria1, pageNo,24);
		userCats=this.getUserCatService().getuserCatListJustUnderCat(2);
		return "adminpersoncheckbytype";
	}
	public String checkpersondetail() {
		user=this.getUserService().selectById(userId);
		userCats=this.getUserCatService().getuserCatListJustUnderCat(2);
		return "checkpersondetail";
	}
	public String checkpersonnopassdetail() {
		user=this.getUserService().selectById(userId);
		userCats=this.getUserCatService().getuserCatListJustUnderCat(2);
		return "checkpersonnopassdetail";
	}
	/**
	 * 管理员个人实名认证审核通过
	 * @return
	 */
	public String checkpersonpass() {
		user=this.getUserService().selectById(userId);
		user.setIfIdentityTrue(2);
		user.setValidatetime(getcurrent2());
		this.getUserService().update(user);
		return "checkpersonpass";
	}
	public String adminorganizationlist() {
		flag=0;
		DetachedCriteria criteria1=DetachedCriteria.forClass(User.class);
		criteria1.add(Restrictions.eq("personOrCompany", 2));
		criteria1.add(Restrictions.or(Restrictions.eq("ifIdentityTrue",0),Restrictions.eq("ifIdentityTrue",2)));
		super.pager=this.getUserService().findbyDetachedCriteria(criteria1, pageNo,10);
		return "adminorganizationlist";
	}
	public String adminusernochooselist() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(User.class);
		
		criteria1.add(Restrictions.eq("personOrCompany", 0));
//		criteria1.add(Restrictions.eq("personOrCompany", null));
		if (usercatId ==0) {
		}else {
			criteria1.createAlias("userCat","cats");	
			criteria1.add(Restrictions.eq("cats.id", usercatId));	
		}
		super.pager=this.getUserService().findbyDetachedCriteria(criteria1, pageNo,10);
		userCats=this.getUserCatService().getuserCatListJustUnderCat(2);
		return "adminusernochooselist";
	}
	public String adminorganizationlistoftype() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(User.class);
		criteria1.add(Restrictions.eq("personOrCompany", 2));
		if (flag ==0) {
		}else {
			criteria1.add(Restrictions.eq("enterpriceType", flag));	
		}
		criteria1.add(Restrictions.or(Restrictions.eq("ifIdentityTrue",0),Restrictions.eq("ifIdentityTrue",2)));
		super.pager=this.getUserService().findbyDetachedCriteria(criteria1, pageNo,10);
		return "adminorganizationlistoftype";
	}
	public String adminpersonlist() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(User.class);
		criteria1.createAlias("userCat","cats");
		criteria1.add(Restrictions.eq("personOrCompany", 1));
		criteria1.add(Restrictions.or(Restrictions.eq("ifIdentityTrue",0),Restrictions.eq("ifIdentityTrue",2)));
		if (usercatId ==0) {
		}else {
			criteria1.add(Restrictions.eq("cats.id", usercatId));	
		}
		super.pager=this.getUserService().findbyDetachedCriteria(criteria1, pageNo,10);
		userCats=this.getUserCatService().getuserCatListJustUnderCat(2);
		return "adminpersonlist";
	}
	public String adminpersontype() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(User.class);
		criteria1.createAlias("userCat","cats");
		criteria1.add(Restrictions.eq("personOrCompany", 1));
		criteria1.add(Restrictions.or(Restrictions.eq("ifIdentityTrue",0),Restrictions.eq("ifIdentityTrue",2)));
		if (usercatId ==0) {
		}else {
			criteria1.add(Restrictions.eq("cats.id", usercatId));	
		}
		super.pager=this.getUserService().findbyDetachedCriteria(criteria1, pageNo,10);
		userCats=this.getUserCatService().getuserCatListJustUnderCat(2);
		return "adminpersontype";
	}
	public String getcurrent2() {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
		String a=df.format(new Date());
		return a;
	}
	public String adminpersoncheckpass() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(User.class);
		criteria1.add(Restrictions.eq("personOrCompany", 1));
		criteria1.add(Restrictions.eq("ifIdentityTrue", 2));
		super.pager=this.getUserService().findbyDetachedCriteria(criteria1, pageNo,24);
		return "adminpersoncheckpass";
	}
	/**
	 * 管理个人实名认证审核不通过列表
	 * @return
	 */
	public String adminpersonchecknopasslist() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(User.class);
		criteria1.add(Restrictions.eq("personOrCompany", 1));
		criteria1.add(Restrictions.eq("ifIdentityTrue", 3));
		super.pager=this.getUserService().findbyDetachedCriteria(criteria1, pageNo,24);
		userCats=this.getUserCatService().getuserCatListJustUnderCat(2);
		return "adminpersonchecknopasslist";
	}
	public String adminpersonchecknopasslistbytype() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(User.class);
		criteria1.createAlias("userCat","cats");
		criteria1.add(Restrictions.eq("personOrCompany", 1));
		criteria1.add(Restrictions.eq("ifIdentityTrue", 3));
		criteria1.add(Restrictions.eq("cats.id", usercatId));
		super.pager=this.getUserService().findbyDetachedCriteria(criteria1, pageNo,24);
		userCats=this.getUserCatService().getuserCatListJustUnderCat(2);
		return "adminpersonchecknopasslistbytype";
	}
	/**
	 * 管理个人实名认证审核不通过
	 * @return
	 */
	public String checkpersonnopass() {
		User tempuser=this.getUserService().selectById(userId);
		tempuser.setNopasscause(user.getNopasscause());
		String nopass="";
		if (user.getNopasscause().contains("0")) {
			tempuser.setOtherreason(user.getOtherreason());
		}
		if (user.getNopasscause().contains("1")) {
			nopass+="您上传的证件不清晰.";
		}
		if (user.getNopasscause().contains("2")) {
			nopass+="证件照片有改动.";
		}
		if (user.getNopasscause().contains("3")) {
			nopass+="您提交的身份信息不正确.";
		}
		tempuser.setNopassreason(nopass);
		tempuser.setIfIdentityTrue(3);
		user.setValidatetime(getcurrent2());
		this.getUserService().update(tempuser);
		return "checkpersonnopass";
	}
	
	
	
	
	
	
	
	
	/////管理员实名认证企业审核/////////////
	public String adminorganizationcheck() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(User.class);
		criteria1.add(Restrictions.eq("personOrCompany", 2));
		criteria1.add(Restrictions.eq("ifIdentityTrue", 1));
		super.pager=this.getUserService().findbyDetachedCriteria(criteria1, pageNo,24);
		return "adminorganizationcheck";
	}
	public String adminorganizationcheckbygoverment() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(User.class);
		criteria1.add(Restrictions.eq("personOrCompany", 2));
		criteria1.add(Restrictions.eq("ifIdentityTrue", 1));
		criteria1.add(Restrictions.eq("enterpriceType", 1));
		super.pager=this.getUserService().findbyDetachedCriteria(criteria1, pageNo,24);
		return "adminorganizationcheckbygoverment";
	}
	public String adminorganizationcheckbyenterprise() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(User.class);
		criteria1.add(Restrictions.eq("personOrCompany", 2));
		criteria1.add(Restrictions.eq("ifIdentityTrue", 1));
		criteria1.add(Restrictions.eq("enterpriceType", 3));
		super.pager=this.getUserService().findbyDetachedCriteria(criteria1, pageNo,24);
		return "adminorganizationcheckbyenterprise";
	}
	public String adminorganizationcheckbymedia() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(User.class);
		criteria1.add(Restrictions.eq("personOrCompany", 2));
		criteria1.add(Restrictions.eq("ifIdentityTrue", 1));
		criteria1.add(Restrictions.eq("enterpriceType", 2));
		super.pager=this.getUserService().findbyDetachedCriteria(criteria1, pageNo,24);
		return "adminorganizationcheckbymedia";
	}
	public String adminorganizationcheckbyother() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(User.class);
		criteria1.add(Restrictions.eq("personOrCompany", 2));
		criteria1.add(Restrictions.eq("ifIdentityTrue", 1));
		criteria1.add(Restrictions.eq("enterpriceType", 4));
		super.pager=this.getUserService().findbyDetachedCriteria(criteria1, pageNo,24);
		return "adminorganizationcheckbyother";
	}
	public String admindetailcheck() {
		//(1.政府 2.媒体 3.企业 4.其他组织)
		user=this.getUserService().selectById(userId);
		if (user.getEnterpriceType()==1) {
			return "admindetailcheckofgovernment";
		}
		if (user.getEnterpriceType()==2) {
			return "admindetailcheckofmedia";
		}
		if (user.getEnterpriceType()==3) {
			return "admindetailcheckofenterprise";
		}
		if (user.getEnterpriceType()==4) {
			return "admindetailcheckofother";
		}
		return null;
	}
	public String checkorganizationnopass() {
		User tempuser=this.getUserService().selectById(userId);
		tempuser.setNopasscause(user.getNopasscause());
		String nopass="";
		if (user.getNopasscause().contains("0")) {
			tempuser.setOtherreason(user.getOtherreason());
		}
		if (user.getNopasscause().contains("1")) {
			nopass+="您上传的证件不清晰.";
		}
		if (user.getNopasscause().contains("2")) {
			nopass+="证件照片有改动.";
		}
		if (user.getNopasscause().contains("3")) {
			nopass+="您提交的身份信息不正确.";
		}
		tempuser.setNopassreason(nopass);
		tempuser.setIfIdentityTrue(3);
		user.setValidatetime(getcurrent2());
		this.getUserService().update(tempuser);
		if (flag ==1) {
			return "checkgovernmentnopass";
		}
		if (flag ==2) {
			return "checkgmedianopass";		
		}
		if (flag ==3) {
			return "checkenterprisenopass";
		}
		if (flag ==4) {
			return "checkothernopass";
		}
		if (flag ==0) {
			return "checkallnopass";
		}
		return null;
	}
	public String adminorganizationnopasslist() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(User.class);
		criteria1.add(Restrictions.eq("personOrCompany", 2));
		criteria1.add(Restrictions.eq("ifIdentityTrue", 3));
		super.pager=this.getUserService().findbyDetachedCriteria(criteria1, pageNo,24);
		return "adminorganizationnopasslist";
	}
	public String admingovernmentnopasslist() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(User.class);
		criteria1.add(Restrictions.eq("personOrCompany", 2));
		criteria1.add(Restrictions.eq("ifIdentityTrue", 3));
		criteria1.add(Restrictions.eq("enterpriceType", 1));
		super.pager=this.getUserService().findbyDetachedCriteria(criteria1, pageNo,24);
		return "admingovernmentnopasslist";
	}
	public String adminmedianopasslist() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(User.class);
		criteria1.add(Restrictions.eq("personOrCompany", 2));
		criteria1.add(Restrictions.eq("ifIdentityTrue", 3));
		criteria1.add(Restrictions.eq("enterpriceType", 2));
		super.pager=this.getUserService().findbyDetachedCriteria(criteria1, pageNo,24);
		return "adminmedianopasslist";
	}
	public String adminenterprisenopasslist() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(User.class);
		criteria1.add(Restrictions.eq("personOrCompany", 2));
		criteria1.add(Restrictions.eq("ifIdentityTrue", 3));
		criteria1.add(Restrictions.eq("enterpriceType", 3));
		super.pager=this.getUserService().findbyDetachedCriteria(criteria1, pageNo,24);
		return "adminenterprisenopasslist";
	}
	public String adminothernopasslist() {
		DetachedCriteria criteria1=DetachedCriteria.forClass(User.class);
		criteria1.add(Restrictions.eq("personOrCompany", 2));
		criteria1.add(Restrictions.eq("ifIdentityTrue", 3));
		criteria1.add(Restrictions.eq("enterpriceType", 4));
		super.pager=this.getUserService().findbyDetachedCriteria(criteria1, pageNo,24);
		return "adminothernopasslist";
	}
	public String checkorganizationdetailnopass() {
		user=this.getUserService().selectById(userId);
		if (user.getEnterpriceType() == 1) {
			return "admindetailcheckofgovernmentnopass";
		}
		if (user.getEnterpriceType() == 2) {
			return "admindetailcheckofmedianopass";
		}
		if (user.getEnterpriceType() == 3) {
			return "admindetailcheckofenterprisenopass";
		}
		if (user.getEnterpriceType() == 4) {
			return "admindetailcheckofothernopass";
		}
		return null;
	}
	@JSON(serialize=false)
	public String userprenext() {
		if (usercatId ==0) {
			users=this.getUserService().userbyusercat(usercatId, userpersonOrCompany, userifIdentityTrue);	
		}else {
			users=this.getUserService().userbyusercat(usercatId, userpersonOrCompany, userifIdentityTrue);	
		}
		return "userprenext";
	}
	@JSON(serialize=false)
	public String govermentprenext() {
		if ( userenterprisetype==0) {
			users=this.getUserService().govermentbyusercat(userenterprisetype, userpersonOrCompany, userifIdentityTrue);	
		}else {
			users=this.getUserService().govermentbyusercat(userenterprisetype, userpersonOrCompany, userifIdentityTrue);	
		}
		return "govermentprenext";
	}
	private UserService userService;
	private String message;
	private User user;
	private int id;
	private String rePassword;
	private String registerId;
	private String imgcode;
	private String code;
	private String state;
	private UserCatService userCatService;
	private LoginHistory loginHistory;
	private String myidcardpic;
	private Integer flag;
	private List<UserCat> userCats;
	private List<User> users;
	private int usercatId;
	private int userpersonOrCompany;
	private int userifIdentityTrue;
	private int userenterprisetype;
	public Object getModel() {
		if (user == null) {
			user = new User();
		}
		return user;
	}
	public UserCatService getUserCatService() {
		return userCatService;
	}


	public void setUserCatService(UserCatService userCatService) {
		this.userCatService = userCatService;
	}
	//private
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRePassword() {
		return rePassword;
	}
	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getRegisterId() {
		return registerId;
	}
	public void setRegisterId(String registerId) {
		this.registerId = registerId;
	}


	public String getImgcode() {
		return imgcode;
	}


	public void setImgcode(String imgcode) {
		this.imgcode = imgcode;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}
	public LoginHistory getLoginHistory() {
		return loginHistory;
	}

	public void setLoginHistory(LoginHistory loginHistory) {
		this.loginHistory = loginHistory;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getInputmail() {
		return inputmail;
	}

	public void setInputmail(String inputmail) {
		this.inputmail = inputmail;
	}

	public String getInputcode() {
		return inputcode;
	}

	public void setInputcode(String inputcode) {
		this.inputcode = inputcode;
	}

	public String getMobilecode() {
		return mobilecode;
	}

	public void setMobilecode(String mobilecode) {
		this.mobilecode = mobilecode;
	}
	public String getNewmobile() {
		return newmobile;
	}
	public void setNewmobile(String newmobile) {
		this.newmobile = newmobile;
	}
	public String getOldpwd() {
		return oldpwd;
	}
	public void setOldpwd(String oldpwd) {
		this.oldpwd = oldpwd;
	}
	public String getNewpwd() {
		return newpwd;
	}
	public void setNewpwd(String newpwd) {
		this.newpwd = newpwd;
	}
	public Integer getMsgFlag() {
		return msgFlag;
	}
	public void setMsgFlag(Integer msgFlag) {
		this.msgFlag = msgFlag;
	}
	public String getEmailcode() {
		return emailcode;
	}
	public void setEmailcode(String emailcode) {
		this.emailcode = emailcode;
	}
	public File getMyupfile() {
		return myupfile;
	}
	public void setMyupfile(File myupfile) {
		this.myupfile = myupfile;
	}
	public String getMyupfileFileName() {
		return myupfileFileName;
	}
	public void setMyupfileFileName(String myupfileFileName) {
		this.myupfileFileName = myupfileFileName;
	}
	public String getMyupfileContentType() {
		return myupfileContentType;
	}
	public void setMyupfileContentType(String myupfileContentType) {
		this.myupfileContentType = myupfileContentType;
	}
	public Integer getUploadres() {
		return uploadres;
	}
	public void setUploadres(Integer uploadres) {
		this.uploadres = uploadres;
	}
	public String getParam() {
		return param;
	}
	public void setParam(String param) {
		this.param = param;
	}
	public String getPicurl() {
		return picurl;
	}
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	public String getMyidcardpic() {
		return myidcardpic;
	}
	public void setMyidcardpic(String myidcardpic) {
		this.myidcardpic = myidcardpic;
	}
	public File getLicense() {
		return license;
	}
	public void setLicense(File license) {
		this.license = license;
	}
	public String getLicenseFileName() {
		return licenseFileName;
	}
	public void setLicenseFileName(String licenseFileName) {
		this.licenseFileName = licenseFileName;
	}
	public String getLicenseContentType() {
		return licenseContentType;
	}
	public void setLicenseContentType(String licenseContentType) {
		this.licenseContentType = licenseContentType;
	}
	public File getLetters() {
		return letters;
	}
	public void setLetters(File letters) {
		this.letters = letters;
	}
	public String getLettersFileName() {
		return lettersFileName;
	}
	public void setLettersFileName(String lettersFileName) {
		this.lettersFileName = lettersFileName;
	}
	public String getLettersContentType() {
		return lettersContentType;
	}
	public void setLettersContentType(String lettersContentType) {
		this.lettersContentType = lettersContentType;
	}
	public File getGoverregister() {
		return goverregister;
	}
	public int getUsercatId() {
		return usercatId;
	}
	public void setUsercatId(int usercatId) {
		this.usercatId = usercatId;
	}
	public void setGoverregister(File goverregister) {
		this.goverregister = goverregister;
	}
	public String getGoverregisterFileName() {
		return goverregisterFileName;
	}
	public void setGoverregisterFileName(String goverregisterFileName) {
		this.goverregisterFileName = goverregisterFileName;
	}
	public String getGoverregisterContentType() {
		return goverregisterContentType;
	}
	public void setGoverregisterContentType(String goverregisterContentType) {
		this.goverregisterContentType = goverregisterContentType;
	}
	public File getMdeiaregister() {
		return mdeiaregister;
	}
	public void setMdeiaregister(File mdeiaregister) {
		this.mdeiaregister = mdeiaregister;
	}
	public String getMdeiaregisterFileName() {
		return mdeiaregisterFileName;
	}
	public void setMdeiaregisterFileName(String mdeiaregisterFileName) {
		this.mdeiaregisterFileName = mdeiaregisterFileName;
	}
	public String getMdeiaregisterContentType() {
		return mdeiaregisterContentType;
	}
	public void setMdeiaregisterContentType(String mdeiaregisterContentType) {
		this.mdeiaregisterContentType = mdeiaregisterContentType;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public List<UserCat> getUserCats() {
		return userCats;
	}
	public void setUserCats(List<UserCat> userCats) {
		this.userCats = userCats;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public int getUserpersonOrCompany() {
		return userpersonOrCompany;
	}
	public void setUserpersonOrCompany(int userpersonOrCompany) {
		this.userpersonOrCompany = userpersonOrCompany;
	}
	public int getUserifIdentityTrue() {
		return userifIdentityTrue;
	}
	public void setUserifIdentityTrue(int userifIdentityTrue) {
		this.userifIdentityTrue = userifIdentityTrue;
	}
	public int getUserenterprisetype() {
		return userenterprisetype;
	}
	public void setUserenterprisetype(int userenterprisetype) {
		this.userenterprisetype = userenterprisetype;
	}
}
