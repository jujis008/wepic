package com.wetuo.wepic.core.actions ;
 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.StringTokenizer;
import java.io.File;
import java.util.*;
import java.text.SimpleDateFormat;
import com.wetuo.wepic.core.beans.UserCredit;
import com.wetuo.wepic.core.service.UserCreditService;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
 
 
public class UserCreditAction extends PageAction {
 
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private UserCreditService userCreditService;
	protected String userId = null ;
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	protected String dealMoney = null ; 
	protected String productsNum = null ; 
	protected String bidNum = null ; 
	protected String bidConfirmedNum = null ; 
	protected String bidGoodRemarkNum = null ; 
	protected String bidBadRemarkNum = null ; 
	protected String totalMark = null ; 
	protected String diamond = null ; 
	protected String star = null ; 
	protected String ifCancelMemberQualification = null ; 
	protected String username = null; 
	//???????????��????
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("userCreditadd!insert") != -1 || queryString.indexOf("userCreditedit!update") != -1) {
		
			if (userId == null || userId.equals("")) {
				addFieldError("userId", "userId must be inputed");
			}//end if null
			if (dealMoney == null || dealMoney.equals("")) {
				addFieldError("dealMoney", "dealMoney must be inputed");
			}//end if null
			if (productsNum == null || productsNum.equals("")) {
				addFieldError("productsNum", "productsNum must be inputed");
			}//end if null
			if (bidNum == null || bidNum.equals("")) {
				addFieldError("bidNum", "bidNum must be inputed");
			}//end if null
			if (bidConfirmedNum == null || bidConfirmedNum.equals("")) {
				addFieldError("bidConfirmedNum", "bidConfirmedNum must be inputed");
			}//end if null
			if (bidGoodRemarkNum == null || bidGoodRemarkNum.equals("")) {
				addFieldError("bidGoodRemarkNum", "bidGoodRemarkNum must be inputed");
			}//end if null
			if (bidBadRemarkNum == null || bidBadRemarkNum.equals("")) {
				addFieldError("bidBadRemarkNum", "bidBadRemarkNum must be inputed");
			}//end if null
			if (totalMark == null || totalMark.equals("")) {
				addFieldError("totalMark", "totalMark must be inputed");
			}//end if null
			if (diamond == null || diamond.equals("")) {
				addFieldError("diamond", "diamond must be inputed");
			}//end if null
			if (star == null || star.equals("")) {
				addFieldError("star", "star must be inputed");
			}//end if null
			if (ifCancelMemberQualification == null || ifCancelMemberQualification.equals("")) {
				addFieldError("ifCancelMemberQualification", "ifCancelMemberQualification must be inputed");
			}//end if null
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
		}//end if
	}//end validate()
	public String init() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		
		// ???????????
		super.pager = this.getUserCreditService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_USERCREDIT, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getUserCreditService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_USERCREDIT, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
		
	public String add() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		
		// ?????????
		reset();
		return Constants.ADD_KEY;
	}//end add()
	private void reset() {
		setId(null);
		setUserId(null);
		setDealMoney(null);
		setProductsNum(null);
		setBidNum(null);
		setBidConfirmedNum(null);
		setBidGoodRemarkNum(null);
		setBidBadRemarkNum(null);
		setTotalMark(null);
		setDiamond(null);
		setStar(null);
		setIfCancelMemberQualification(null);
	}//end reset()
		// ?????��??
//	private void bean2Form(UserCredit userCredit) {
//		setId(userCredit.getId().toString());
//		setUserId(userCredit.getUser().getId().toString());
//		setDealMoney(userCredit.getDealMoney().toString()      );
//		setProductsNum(userCredit.getProductsNum().toString()      );
//		setBidNum(userCredit.getBidNum().toString()      );
//		setBidConfirmedNum(userCredit.getBidConfirmedNum().toString()      );
//		setBidGoodRemarkNum(userCredit.getBidGoodRemarkNum().toString()      );
//		setBidBadRemarkNum(userCredit.getBidBadRemarkNum().toString()      );
//		setTotalMark(userCredit.getTotalMark().toString()      );
//		setDiamond(userCredit.getDiamond().toString()      );
//		setStar(userCredit.getStar().toString()      );
//		setIfCancelMemberQualification(userCredit.getIfCancelMemberQualification().toString()      );
//	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("userCredit.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			UserCredit userCredit = this.getUserCreditService().select(Integer.valueOf(id));
			
			// ??????????????
			if (userCredit == null) {
				saveActionError("userCredit.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				//bean2Form(userCredit);
				return Constants.EDIT_KEY;
			}
		}//end if
		
	}//end edit()
		
	public String insert() throws Exception {
		// 
		clearErrorsAndMessages();
		Integer nid = null ;
		
		try{
			
		//
		UserCredit userCredit = new UserCredit();
		//userCredit.setUser(userInstance);    
		userCredit.setUser(this.getUserService().selectById(Integer.parseInt(this.getUserId())));     
			
		userCredit.setDealMoney(Integer.valueOf(this.getDealMoney() ));
		userCredit.setProductsNum(Integer.valueOf(this.getProductsNum() ));
		userCredit.setBidNum(Integer.valueOf(this.getBidNum() ));
		userCredit.setBidConfirmedNum(Integer.valueOf(this.getBidConfirmedNum() ));
		userCredit.setBidGoodRemarkNum(Integer.valueOf(this.getBidGoodRemarkNum() ));
		userCredit.setBidBadRemarkNum(Integer.valueOf(this.getBidBadRemarkNum() ));
		userCredit.setTotalMark(Integer.valueOf(this.getTotalMark() ));
		userCredit.setDiamond(Integer.valueOf(this.getDiamond() ));
		userCredit.setStar(Integer.valueOf(this.getStar() ));
		userCredit.setIfCancelMemberQualification(Integer.valueOf(this.getIfCancelMemberQualification() ));
		nid = this.getUserCreditService().insert(userCredit);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_USERCREDIT);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getUserCreditService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("userCredit.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("userCredit.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			UserCredit userCredit = this.getUserCreditService().select(new Integer(id));
			//userCredit.setUser(userInstance);  
			userCredit.setUser(this.getUserService().selectById(Integer.parseInt(this.getUserId())));     
			
			userCredit.setDealMoney(Integer.valueOf(this.getDealMoney() ));
			userCredit.setProductsNum(Integer.valueOf(this.getProductsNum() ));
			userCredit.setBidNum(Integer.valueOf(this.getBidNum() ));
			userCredit.setBidConfirmedNum(Integer.valueOf(this.getBidConfirmedNum() ));
			userCredit.setBidGoodRemarkNum(Integer.valueOf(this.getBidGoodRemarkNum() ));
			userCredit.setBidBadRemarkNum(Integer.valueOf(this.getBidBadRemarkNum() ));
			userCredit.setTotalMark(Integer.valueOf(this.getTotalMark() ));
			userCredit.setDiamond(Integer.valueOf(this.getDiamond() ));
			userCredit.setStar(Integer.valueOf(this.getStar() ));
			userCredit.setIfCancelMemberQualification(Integer.valueOf(this.getIfCancelMemberQualification() ));
		this.getUserCreditService().update(userCredit);
		
		//bean2Form(userCredit);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_USERCREDIT);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getUserCreditService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("userCredit.message.edit.success");
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		return Constants.LIST_KEY;
	}//end update() 
	public String delete() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		try{
			// id???????????
			if (this.getId() == null) {
				saveActionError("userCredit.message.edit.notexist");
			} else {
				// ??????
				this.getUserCreditService().delete(Integer.valueOf(id));
				saveActionMessage("userCredit.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getUserCreditService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		return Constants.LIST_KEY;
		
	}//end delete()
		
 
	/////getter////setter//////
	public String getId(){
		return  id;
	}
	public void  setId(String id){
		this.id = id ;
	}
	 
	public UserCreditService getUserCreditService() {
		return userCreditService;
	}
	public void setUserCreditService(UserCreditService userCreditService) {
		this.userCreditService = userCreditService;
	}
	
	public String getUserId(){
		return  userId;
	}
	public void  setUserId(String userId){
		this.userId = userId ;
	}
	 
	public String getDealMoney(){
		return  dealMoney;
	}
	public void  setDealMoney(String dealMoney){
		this.dealMoney = dealMoney ;
	}
	 
	public String getProductsNum(){
		return  productsNum;
	}
	public void  setProductsNum(String productsNum){
		this.productsNum = productsNum ;
	}
	 
	public String getBidNum(){
		return  bidNum;
	}
	public void  setBidNum(String bidNum){
		this.bidNum = bidNum ;
	}
	 
	public String getBidConfirmedNum(){
		return  bidConfirmedNum;
	}
	public void  setBidConfirmedNum(String bidConfirmedNum){
		this.bidConfirmedNum = bidConfirmedNum ;
	}
	 
	public String getBidGoodRemarkNum(){
		return  bidGoodRemarkNum;
	}
	public void  setBidGoodRemarkNum(String bidGoodRemarkNum){
		this.bidGoodRemarkNum = bidGoodRemarkNum ;
	}
	 
	public String getBidBadRemarkNum(){
		return  bidBadRemarkNum;
	}
	public void  setBidBadRemarkNum(String bidBadRemarkNum){
		this.bidBadRemarkNum = bidBadRemarkNum ;
	}
	 
	public String getTotalMark(){
		return  totalMark;
	}
	public void  setTotalMark(String totalMark){
		this.totalMark = totalMark ;
	}
	 
	public String getDiamond(){
		return  diamond;
	}
	public void  setDiamond(String diamond){
		this.diamond = diamond ;
	}
	 
	public String getStar(){
		return  star;
	}
	public void  setStar(String star){
		this.star = star ;
	}
	 
	public String getIfCancelMemberQualification(){
		return  ifCancelMemberQualification;
	}
	public void  setIfCancelMemberQualification(String ifCancelMemberQualification){
		this.ifCancelMemberQualification = ifCancelMemberQualification ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	 
}//end class
