package com.wetuo.wepic.core.actions ;
 
import java.util.regex.Matcher;

import java.util.Date;

import java.sql.Timestamp;



import com.wetuo.wepic.core.beans.SiteConfig;
import com.wetuo.wepic.core.service.SiteConfigService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;

 
 
public class SiteConfigAction extends PageAction {
 
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private SiteConfigService siteConfigService;
	protected String tax = null ; 
	protected String thirdPayRate = null ; 
	protected String proportionBroker = null ; 
	protected String proportionSite = null ; 
	protected String limitChangeWorker = null ; 
	protected String configTime = null ; 
	protected String username = null; 
	//???????????��????
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("siteConfigadd!insert") != -1 || queryString.indexOf("siteConfigedit!update") != -1) {
		
			if (tax == null || tax.equals("")) {
				addFieldError("tax", "tax must be inputed");
			}//end if null
			if (thirdPayRate == null || thirdPayRate.equals("")) {
				addFieldError("thirdPayRate", "thirdPayRate must be inputed");
			}//end if null
			if (proportionBroker == null || proportionBroker.equals("")) {
				addFieldError("proportionBroker", "proportionBroker must be inputed");
			}//end if null
			if (proportionSite == null || proportionSite.equals("")) {
				addFieldError("proportionSite", "proportionSite must be inputed");
			}//end if null
		
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
		super.pager = this.getSiteConfigService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_SITECONFIG, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getSiteConfigService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_SITECONFIG, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
		
	public String add() throws Exception {
	
		clearErrorsAndMessages();

//		reset();
		return Constants.ADD_KEY;
	}//end add()
	private void reset() {
		setId(null);
		setTax(null);
		setThirdPayRate(null);
		setProportionBroker(null);
		setProportionSite(null);
		setLimitChangeWorker(null);
		setConfigTime(null);
	}//end reset()
		// ?????��??
	private void bean2Form(SiteConfig siteConfig) {
		setId(siteConfig.getId().toString());
		setTax(new Double(siteConfig.getTax()).toString());
		setThirdPayRate(new Double(siteConfig.getThirdPayRate()).toString());
		setProportionBroker(String.valueOf(siteConfig.getProportionBroker())  );
		setProportionSite(String.valueOf(siteConfig.getProportionSite()));
		setLimitChangeWorker(siteConfig.getLimitChangeWorker().toString()      );
		setConfigTime(siteConfig.getConfigTime().toString()      );
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("siteConfig.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			SiteConfig siteConfig = this.getSiteConfigService().select(id); 
			
			setId(siteConfig.getId().toString());
			setTax(String.valueOf((siteConfig.getTax())));
			setThirdPayRate(String.valueOf(siteConfig.getThirdPayRate()));
			setProportionBroker(String.valueOf(siteConfig.getProportionBroker())  );
			setProportionSite(String.valueOf(siteConfig.getProportionSite()));
			setLimitChangeWorker(siteConfig.getLimitChangeWorker().toString());
			//setConfigTime(siteConfig.getConfigTime().toString()      );
			if (siteConfig == null) {
				saveActionError("siteConfig.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(siteConfig);
				return Constants.EDIT_KEY;
			}
		}//end if
		
	}//end edit()
		
	public String insert() throws Exception {
		// 
		clearErrorsAndMessages();
		String nid = null ;
		
		try{
			
		//
			SiteConfig config=new SiteConfig();
			config.setConfigTime(new Timestamp(new Date().getTime()));
			config.setLimitChangeWorker((Integer)super.getSession("id"));
			 double bro =Double.parseDouble(proportionBroker);
			config.setProportionBroker(bro);
			 double broSite =Double.parseDouble(proportionSite);
			config.setProportionSite(broSite);
			config.setTax(new Double(tax));
			config.setThirdPayRate(new Double(thirdPayRate));
			nid=siteConfigService.insert(config);
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_SITECONFIG);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getSiteConfigService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("siteConfig.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("siteConfig.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			SiteConfig config = this.getSiteConfigService().select(new String(id));
			config.setConfigTime(new Timestamp(new Date().getTime()));
			config.setLimitChangeWorker((Integer)super.getSession("id"));
			 double bro =Double.parseDouble(proportionBroker);
			config.setProportionBroker(bro);
			 double broSite =Double.parseDouble(proportionSite);
			config.setProportionSite(broSite);
			config.setTax(new Double(tax));
			config.setThirdPayRate(new Double(thirdPayRate));

		this.getSiteConfigService().update(config);
		
		bean2Form(config);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_SITECONFIG);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getSiteConfigService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("siteConfig.message.edit.success");
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
				saveActionError("siteConfig.message.edit.notexist");
			} else {
				// ??????
				this.getSiteConfigService().delete(id);
				saveActionMessage("siteConfig.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getSiteConfigService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
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
	 
	public SiteConfigService getSiteConfigService() {
		return siteConfigService;
	}
	public void setSiteConfigService(SiteConfigService siteConfigService) {
		this.siteConfigService = siteConfigService;
	}
	
	public String getTax(){
		return  tax;
	}
	public void  setTax(String tax){
		this.tax = tax ;
	}
	 
	public String getThirdPayRate(){
		return  thirdPayRate;
	}
	public void  setThirdPayRate(String thirdPayRate){
		this.thirdPayRate = thirdPayRate ;
	}
	 
	public String getProportionBroker(){
		return  proportionBroker;
	}
	public void  setProportionBroker(String proportionBroker){
		this.proportionBroker = proportionBroker ;
	}
	 
	public String getProportionSite(){
		return  proportionSite;
	}
	public void  setProportionSite(String proportionSite){
		this.proportionSite = proportionSite ;
	}
	 
	public String getLimitChangeWorker(){
		return  limitChangeWorker;
	}
	public void  setLimitChangeWorker(String limitChangeWorker){
		this.limitChangeWorker = limitChangeWorker ;
	}
	 
	public String getConfigTime(){
		return  configTime;
	}
	public void  setConfigTime(String configTime){
		this.configTime = configTime ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	 
}//end class
