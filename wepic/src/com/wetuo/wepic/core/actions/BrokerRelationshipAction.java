package com.wetuo.wepic.core.actions ;
 
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.core.beans.BrokerRelationship;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.beans.UserCredit;
import com.wetuo.wepic.core.service.BrokerRelationshipService;
import com.wetuo.wepic.core.service.ContactService;
import com.wetuo.wepic.core.service.UserCreditService;
import com.wetuo.wepic.core.service.UserService;
import com.wetuo.wepic.deal.beans.UserMess;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.tools.Cleandar;
 
public class BrokerRelationshipAction extends PageAction {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private BrokerRelationshipService brokerRelationshipService;
	protected String brokerId = null ;
	protected String authorId = null ;
	protected String brokerUserName = null ;
	protected String authorUserName = null ;
	private Integer flag;
	private UserService userService;
	//private List<E>
	private User  brokeuser;
	private UserCreditService userCreditService;
	private ContactService contactService;
	private String userName;
	private String realName;
	BrokerRelationship brokerRelationship;
	private int nowpage=1;
	private int endpage2;
	
	private int endPage;
	private UserCredit userCredit;
	
	
	
	
	
	public UserCredit getUserCredit() {
		return userCredit;
	}
	public void setUserCredit(UserCredit userCredit) {
		this.userCredit = userCredit;
	}
	public int getEndpage2() {
		return endpage2;
	}
	public void setEndpage2(int endpage2) {
		this.endpage2 = endpage2;
	}
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public BrokerRelationship getBrokerRelationship() {
		return brokerRelationship;
	}
	public void setBrokerRelationship(BrokerRelationship brokerRelationship) {
		this.brokerRelationship = brokerRelationship;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public ContactService getContactService() {
		return contactService;
	}
	public void setContactService(ContactService contactService) {
		this.contactService = contactService;
	}
	public UserCreditService getUserCreditService() {
		return userCreditService;
	}
	public void setUserCreditService(UserCreditService userCreditService) {
		this.userCreditService = userCreditService;
	}
	public User getBrokeuser() {
		return brokeuser;
	}
	public void setBrokeuser(User brokeuser) {
		this.brokeuser = brokeuser;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	protected String creationTime = null ; 
	protected String isValid = null ; 
	protected String username = null; 
	private String userId;
	private List<User> brokerList = new ArrayList<User>();
	private List<User> notBrokerList = new ArrayList<User>();
	private List<User> theBrokerOrnotList = new ArrayList<User>();
	private String photomoteId;
	private Integer currentUserid;
	public Integer getCurrentUserid() {
		return currentUserid;
	}
	public void setCurrentUserid(Integer currentUserid) {
		this.currentUserid = currentUserid;
	}

	private Integer fg = 0;//标记是否做过修改
	
	public Integer getFg() {
		return fg;
	}
	public void setFg(Integer fg) {
		this.fg = fg;
	}
	public String getPhotomoteId() {
		return photomoteId;
	}
	public void setPhotomoteId(String photomoteId) {
		this.photomoteId = photomoteId;
	}
	//???????????��????
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("brokerRelationshipadd!insert") != -1 || queryString.indexOf("brokerRelationshipedit!update") != -1) {
		
//			if (userId == null || userId.equals("")) {
//				addFieldError("userId", "userId must be inputed");
//			}//end if null
//			if (userId == null || userId.equals("")) {
//				addFieldError("userId", "userId must be inputed");
//			}//end if null
			if (creationTime == null || creationTime.equals("")) {
				addFieldError("creationTime", "creationTime must be inputed");
			}//end if null
			if (isValid == null || isValid.equals("")) {
				addFieldError("isValid", "isValid must be inputed");
			}//end if null
				// ??????? 
				// ??????? 
				// ??????? 
				// ??????? 
		}//end if
	}//end validate()
	
	public String init() throws Exception {
		clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		super.pager = this.getBrokerRelationshipService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		setSession(Constants.PAGER_BROKERRELATIONSHIP, super.pager);
		return Constants.LIST_KEY;
	}//end init()
	
	public String initAdmin() throws Exception {
		clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		super.pager = this.getBrokerRelationshipService().list( super.pageSize, super.pageNo);
		//setSession(Constants.PAGER_BROKERRELATIONSHIP, super.pager);
		return "initAdmin" ;
	}//end init()
	
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getBrokerRelationshipService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_BROKERRELATIONSHIP, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
	
	public String moteorPhotolookBroker() throws Exception{
		clearErrorsAndMessages();
		super.pager = this.getUserService().addBrokerShip(super.pageSize,super.pageNo);
		return Constants.ADD_KEY;
	}
	
	public String brokerlookPhotoormote() throws Exception{
		clearErrorsAndMessages();
		super.pager = this.getUserService().addbrokerscustomer(super.pageSize,super.pageNo);
		User user = this.getUserService().select(super.getLoginUsername());
		this.setCurrentUserid(user.getId());
		return "brokerAddPage";
	}
	
	
	
	
	
	
	
	
	/**
	 * 经纪人申请做某人的经纪人
	 * @return
	 * @throws Exception
	 */
	public String applyBeSomesBroker() throws Exception{
		clearErrorsAndMessages();
		String authorId = super.getRequest().getParameter("authorId");
		BrokerRelationship ship = new BrokerRelationship();
		User author = null;
		User broker = null;
		String brokerName = super.getLoginUsername();
		if(brokerName != null && brokerName.length() > 0){
			broker = this.getUserService().select(brokerName);
			if(broker != null){
				ship.setBroker(broker);
				ship.setWhoIsActive(broker);
			}
		}
		if(authorId != null && authorId.length()>0){
			author = this.getUserService().selectById(Integer.parseInt(authorId));
			if(author != null){
				ship.setAuthor(author);
			}
		}
		//申请时间
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		String strDate = format.format(date);
		ship.setApplyTime(java.sql.Timestamp.valueOf(strDate));
		ship.setIsValid(0);//不知道
		ship.setIfAccept(0);//不知道
		int nid = this.getBrokerRelationshipService().insert(ship);
		if(nid > 0){
//			StringBuffer sb = new StringBuffer();
//			String fg = author.getBrokerFlag();
//			String addStr = broker.getId().toString();
//			String brokerflg = sb.append(fg).append(",").append(addStr).toString();
			author.setBrokerFlag("yes");
			this.getUserService().update(author);
			return brokerlookPhotoormote();
		}
		return Constants.ERROR_KEY;
	}
	/**
	 * 同意某人做自己的经纪人
	 * @return
	 * @throws Exception
	 */
	public String agreenBroker()throws Exception{
		String shipId = super.getRequest().getParameter("shipid");
		BrokerRelationship ship = null;
		boolean updateResult = false;
		if(shipId != null && shipId.length() > 0){
			ship = this.getBrokerRelationshipService().select(Integer.parseInt(shipId));
			if(ship != null){
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				java.util.Date date = new java.util.Date();
				String strTime = format.format(date);
				ship.setCreationTime(java.sql.Timestamp.valueOf(strTime));
				ship.setIsValid(1);
				ship.setIfAccept(2);
				updateResult = this.getBrokerRelationshipService().update(ship);
			}
		}
		if(updateResult == true){
			fg = 1;
			return init();
		}
		return Constants.ERROR_KEY;
	}
	
	/**
	 * 不同意某经纪人的请求
	 * @return
	 * @throws Exception
	 */
	public String disAgreeBroker() throws Exception{
		String shipId = super.getRequest().getParameter("shipid");
		boolean result = false;
		if(shipId != null && shipId.length() > 0){
			BrokerRelationship ship = this.getBrokerRelationshipService().select(Integer.parseInt(shipId));
			if(ship != null){
				java.util.Date date = new java.util.Date();
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateStr = format.format(date);
				ship.setCreationTime(java.sql.Timestamp.valueOf(dateStr));
				ship.setIsValid(2);
				ship.setIfAccept(1);
				result = this.getBrokerRelationshipService().update(ship);
			}
		}
		if(result == true){
			fg = 1;
			String userid = super.getRequest().getParameter("userid");
			if(userid != null && userid.length() > 0){
				User user = this.getUserService().selectById(Integer.parseInt(userid));
				if(user != null){
					user.setBrokerFlag(null);
					this.getUserService().update(user);
				}
			}
			return init();
		}
		return Constants.ERROR_KEY;
	}
		
	public String add() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		
		// ?????????
		reset();
		//取出所有的经纪人
		List<User> userList = this.getUserService().findAll();
		List<User> borkerOfUserList = new ArrayList<User>(); //所有的经纪人
		List<User> notBorkerOfUserList = new ArrayList<User>();//所有的非经纪人
		//该循环用于将所有的经纪人放在一起，所有的模特和摄影师放在一起
		for(int i=0;i<userList.size();i++){
			User u = userList.get(i);
			String role = u.getRole();
			String[] roles = role.split("_");
			boolean isbroker = false;
			for(int j=0;j<roles.length;j++){
				if("broker".equals(roles[j])){
					//this.getBrokerList().add(u);
					borkerOfUserList.add(u);
					isbroker = true;
					break;
				}
			}
			if(isbroker == true){
				isbroker = false;
				continue;
			}
			notBorkerOfUserList.add(u);
		}
//		this.setBrokerList(borkerOfUserList);
//		this.setNotBrokerList(notBorkerOfUserList);
//		for(int i=0;i<userList.size();i++){
//			User ouser = userList.get(i);
//			for(int j=0;j<this.brokerList.size();j++){
//				User iuser = brokerList.get(j);
//				if(ouser.getId() == iuser.getId()){
//					break;
//				}else{
//					this.getNotBrokerList().add(ouser);
//					break;
//				}
//			}
//		}
		User user = this.getUserService().select(super.getLoginUsername());
		if(user != null){
			String role = user.getRole();
			if(role.length() > 0){
				String[] roles = role.split("_");
				for(int i=0;i<roles.length;i++){
					if("broker".equals(roles[i])){
						this.setTheBrokerOrnotList(notBorkerOfUserList);
						return "brokerAddPage";
					}
				}
			}
		}
		this.setTheBrokerOrnotList(borkerOfUserList);
		return Constants.ADD_KEY;
	}//end add()
	private void reset() {
		setId(null);
		setBrokerId(null);
		setAuthorId(null);
		setCreationTime(null);
		setIsValid(null);
	}//end reset()
		// ?????��??
	private void bean2Form(BrokerRelationship brokerRelationship) {
		setId(brokerRelationship.getId().toString());
		setBrokerId(brokerRelationship.getBroker().getId().toString());
		setAuthorId(brokerRelationship.getAuthor().getId().toString());
		setCreationTime(brokerRelationship.getCreationTime().toString()      );
		setIsValid(brokerRelationship.getIsValid().toString()      );
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("brokerRelationship.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			BrokerRelationship brokerRelationship = this.getBrokerRelationshipService().select(Integer.valueOf(id));
			
			// ??????????????
			if (brokerRelationship == null) {
				saveActionError("brokerRelationship.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(brokerRelationship);
				return Constants.EDIT_KEY;
			}
		}//end if
		
	}//end edit()
		
	public String insert() throws Exception {
		// 
		clearErrorsAndMessages();
		Integer nid = null ;
		List<BrokerRelationship> bsList = new ArrayList<BrokerRelationship>();
		BrokerRelationship broker = new BrokerRelationship();
		
		try{
		    BrokerRelationship brokerRelationship = new BrokerRelationship();
			if(this.getAuthorId() != null && this.getAuthorId().length() > 0){
				brokerRelationship.setBroker(this.getUserService().select(super.getLoginUsername()));
				brokerRelationship.setAuthor(this.getUserService().selectById(Integer.parseInt(this.getAuthorId())));
			}else{
				   User author = this.getUserService().select(super.getLoginUsername());
				   brokerRelationship.setAuthor(author); 
				   if(this.getUserId().length() > 0){
					   brokerRelationship.setBroker(this.getUserService().selectById(Integer.parseInt(this.getUserId())));    
				   }
			 }
			if(this.getCreationTime().length() >= 0){
				SimpleDateFormat  format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateStr = format.format(Date.valueOf(this.getCreationTime()));
				brokerRelationship.setCreationTime(java.sql.Timestamp.valueOf(dateStr));
			}
			if(this.getIsValid().length() > 0){
				brokerRelationship.setIsValid(Integer.valueOf(this.getIsValid() ));
			}
	    User au = this.getUserService().select(super.getLoginUsername());
	    bsList = getRelationShips(au);
		nid = this.getBrokerRelationshipService().insert(brokerRelationship);
		broker = brokerRelationship;
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BROKERRELATIONSHIP);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getBrokerRelationshipService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			modifyValid(bsList);
			modifyBrokerStatus(broker);
			saveActionMessage("brokerRelationship.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("brokerRelationship.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	public void modifyBrokerStatus(BrokerRelationship broker){
		this.getBrokerRelationshipService().modifyBrokerStatus(broker);
	}
	//查询当前用户的经纪人关系
	private List<BrokerRelationship> getRelationShips(User user){
		return this.getBrokerRelationshipService().getRelationShips(user);
	}
	
	//模特摄影师的经纪人
	@SuppressWarnings("unchecked")
	public String photoOrmodeljingjiren(){
		int newpageSize=2;
          User user=userService.select(super.getLoginUsername());
          if(user==null){
        	  
        	  return "login";
          }
          String role=user.getRole();
             //我的经纪人
        	if(role.contains("model")||role.contains("photographer")){
        		brokeuser =photoOrModel(user);
        		
        	}
        	
        	if(role.contains("broker")){
        		//申请的让我当经纪人
        		DetachedCriteria criteria=DetachedCriteria.forClass(BrokerRelationship.class);
        	    criteria.add(Restrictions.eq("broker",user));
        		criteria.add(Restrictions.or(Restrictions.eq("ifAccept", 0),Restrictions.eq("ifAccept", 1)));
        		criteria.addOrder(Order.asc("ifAccept"));
        		criteria.addOrder(Order.desc("applyTime"));
        		
        		Pager pager1=brokerRelationshipService.list(criteria,newpageSize, nowpage);
        		endPage=pager1.getLastPageNo();
        		nowpage=1;
        		List<User> arrayList=new ArrayList<User>();
        		Map map=ActionContext.getContext().getContextMap();
        		List<BrokerRelationship> list=(List<BrokerRelationship>) pager1.getResultList();
        			for (BrokerRelationship brokerRelationship : list) {
        				//brokerRelationship = list.get(0);
        				User newbrokeuser = userService.selectById(brokerRelationship.getAuthor()
        						.getId());
        				UserCredit userCredit = userCreditService.selectByUser(newbrokeuser);
        				UserMess userMess = new UserMess();
        				int attentionNumber = this.getContactService().findAttentionNumber(
        						user);
        				int fansNumber = this.getContactService().findFansNumber(user);
        				userMess.setBadRemark(userCredit.getBidBadRemarkNum());
        				userMess.setFansNumber(fansNumber);
        				userMess.setAttentionNumber(attentionNumber);
        				userMess.setGoodRemark(userCredit.getBidGoodRemarkNum());
        				userMess.setIdString(brokerRelationship.getId()+"");
        				userMess.setFlage(brokerRelationship.getIfAccept()+"");
        				 //  userCredit=userCreditService.selectByUser(newbrokeuser);
        				   UserCredit credit=new UserCredit();
        				   int total=(int) userCredit.getTotalMark();
        				   int star=total/200;
        				   credit.setStar(star-1);
        				   userMess.setCredit(credit);
        				   
        				   
        				newbrokeuser.setUserMess(userMess);
        				arrayList.add(newbrokeuser);
        	        	
        	          }
        			pager1.setResultList(arrayList);
        		    map.put("pager1",pager1);
        		
        		//被我经济的人
        		DetachedCriteria criteria2=DetachedCriteria.forClass(BrokerRelationship.class);
        	    criteria2.add(Restrictions.eq("broker",user));
        		criteria2.add(Restrictions.eq("ifAccept", 2));
        		criteria2.add(Restrictions.eq("isValid", 1));
        		Pager pager2=brokerRelationshipService.list(criteria2,newpageSize, nowpage);
        		List<User> newbymeBrokerRelationships=new ArrayList<User>();
        		List<BrokerRelationship> bymeBrokerRelationships=(List<BrokerRelationship>) pager2.getResultList();
        		endpage2=pager2.getLastPageNo();
       			for (BrokerRelationship brokerRelationship : bymeBrokerRelationships) {
       				//brokerRelationship = list.get(0);
       				User newbrokeuser = userService.selectById(brokerRelationship.getAuthor()
       						.getId());
       				UserCredit userCredit = userCreditService.selectByUser(newbrokeuser);
       				UserMess userMess = new UserMess();
       				int attentionNumber = this.getContactService().findAttentionNumber(
       						newbrokeuser);
       				int fansNumber = this.getContactService().findFansNumber(newbrokeuser);
       				userMess.setBadRemark(userCredit.getBidBadRemarkNum());
       				userMess.setFansNumber(fansNumber);
       				userMess.setAttentionNumber(attentionNumber);
       				userMess.setGoodRemark(userCredit.getBidGoodRemarkNum());
       			 //  userCredit=userCreditService.selectByUser(newbrokeuser);
    			   UserCredit credit=new UserCredit();
    			   int total=(int) userCredit.getTotalMark();
    			   int star=total/200;
    			   credit.setStar(star-1);
    			   userMess.setCredit(credit);
    			   
    			   
       				newbrokeuser.setUserMess(userMess);
       				userMess.setIdString(brokerRelationship.getId()+"");
       				newbymeBrokerRelationships.add(newbrokeuser);
       	        	
       	          }
       			pager2.setResultList(newbymeBrokerRelationships);
        		map.put("pager2",pager2);
        	}
          
        
		return "photoOrmodeljingjiren";
	}
	   
	//申请
	public String applyBymeBroke(){
		int newpageSize=2;
		  User user=userService.select(super.getLoginUsername());
          if(user==null){
        	  
        	  return "login";
          }
		
		//申请的让我当经纪人
		DetachedCriteria criteria=DetachedCriteria.forClass(BrokerRelationship.class);
	    criteria.add(Restrictions.eq("broker",user));
		//criteria.add();
		criteria.add(Restrictions.or(Restrictions.eq("ifAccept", 0),Restrictions.eq("ifAccept", 1)));
		criteria.addOrder(Order.asc("ifAccept"));
		criteria.addOrder(Order.desc("applyTime"));
		
		Pager pager1=brokerRelationshipService.list(criteria,newpageSize, nowpage);
		List<User> arrayList=new ArrayList<User>();
		Map map=ActionContext.getContext().getContextMap();
		List<BrokerRelationship> list=(List<BrokerRelationship>) pager1.getResultList();
			for (BrokerRelationship brokerRelationship : list) {
				//brokerRelationship = list.get(0);
				User newbrokeuser = userService.selectById(brokerRelationship.getAuthor()
						.getId());
				UserCredit userCredit = userCreditService.selectByUser(newbrokeuser);
				UserMess userMess = new UserMess();
				int attentionNumber = this.getContactService().findAttentionNumber(
						newbrokeuser);
				int fansNumber = this.getContactService().findFansNumber(newbrokeuser);
				userMess.setBadRemark(userCredit.getBidBadRemarkNum());
				userMess.setFansNumber(fansNumber);
				userMess.setAttentionNumber(attentionNumber);
				userMess.setGoodRemark(userCredit.getBidGoodRemarkNum());
				userMess.setIdString(brokerRelationship.getId()+"");
				userMess.setFlage(brokerRelationship.getIfAccept()+"");
				  // userCredit=userCreditService.selectByUser(newbrokeuser);
				   UserCredit credit=new UserCredit();
				   int total=(int) userCredit.getTotalMark();
				   int star=total/200;
				   credit.setStar(star-1);
				   userMess.setCredit(credit);
				   
				newbrokeuser.setUserMess(userMess);
				arrayList.add(newbrokeuser);
	        	
	          }
			pager1.setResultList(arrayList);
		    super.pager=pager1;
		return "applyBymeBroke";
		
		
		
	}
	@SuppressWarnings({ "unused", "static-access" })
	public String cancelBroke() throws Exception{
	
		int newpageSize=2;
	    BrokerRelationship brokerRelationship=brokerRelationshipService.select(Integer.parseInt(id));
	    Map<String, Object> map=new HashMap<String, Object>();
	    Calendar cal = Calendar.getInstance();
		cal.setTime(new java.util.Date());
		cal.add(cal.YEAR, 1);
		java.util.Date date=cal.getTime();
		 SimpleDateFormat  dsf1 = new SimpleDateFormat("yyyy/MM/dd");
		 //SimpleDateFormat  dsf2 = new SimpleDateFormat("yyyy/MM/dd");
		 String startTimr=dsf1.format(brokerRelationship.getCreationTime());
		 System.out.println(startTimr);
		map.put("END_DATE", dsf1.format(date));
		map.put("START_DATE",startTimr);
	    int days=Cleandar.TimeDay(map);
	    flag=0;
	    if(days<365){
	    	//this.addActionError("您的经纪人经济的时间还没到,您暂时不能更换经纪人");
			 flag=2;
			 return "cancelBroke";
	    }
		brokerRelationship.setIsValid(2);
		if(brokerRelationshipService.update(brokerRelationship)) flag=1;
		
		return "cancelBroke";
	}
	  public String pagerBoke(){
		  int newpageSize=2;
		  User user=userService.select(super.getLoginUsername());
          if(user==null){
        	  
        	  return "login";
          }
		
		  DetachedCriteria criteria2=DetachedCriteria.forClass(BrokerRelationship.class);
  	    criteria2.add(Restrictions.eq("broker",user));
  		criteria2.add(Restrictions.eq("ifAccept", 2));
  		criteria2.add(Restrictions.eq("isValid", 1));
  		Pager pager2=brokerRelationshipService.list(criteria2,newpageSize, nowpage);
  		List<User> newbymeBrokerRelationships=new ArrayList<User>();
  		List<BrokerRelationship> bymeBrokerRelationships=(List<BrokerRelationship>) pager2.getResultList();
  		endpage2=pager2.getLastPageNo();
 			for (BrokerRelationship brokerRelationship : bymeBrokerRelationships) {
 				//brokerRelationship = list.get(0);
 				User newbrokeuser = userService.selectById(brokerRelationship.getAuthor()
 						.getId());
 				UserCredit userCredit = userCreditService.selectByUser(newbrokeuser);
 				UserMess userMess = new UserMess();
 				int attentionNumber = this.getContactService().findAttentionNumber(newbrokeuser);
 				int fansNumber = this.getContactService().findFansNumber(newbrokeuser);
 				userMess.setBadRemark(userCredit.getBidBadRemarkNum());
 				userMess.setFansNumber(fansNumber);
 				userMess.setAttentionNumber(attentionNumber);
 				userMess.setGoodRemark(userCredit.getBidGoodRemarkNum());
 				userMess.setIdString(brokerRelationship.getId()+"");
 				userMess.setFlage(brokerRelationship.getIfAccept()+"");
 			//   userCredit=userCreditService.selectByUser(newbrokeuser);
			   UserCredit credit=new UserCredit();
			   int total=(int) userCredit.getTotalMark();
			   int star=total/200;
			   credit.setStar(star-1);
			   userMess.setCredit(credit);
			   
 				newbrokeuser.setUserMess(userMess);
 				
			   
 				newbymeBrokerRelationships.add(newbrokeuser);
 	        	
 	          }
 			pager2.setResultList(newbymeBrokerRelationships);
		    super.pager=pager2;
 			
 			
		  
	    //被我经济的人
//  		DetachedCriteria criteria2=DetachedCriteria.forClass(BrokerRelationship.class);
//  	    criteria2.add(Restrictions.eq("broker",userService.select(userName) ));
//  		criteria2.add(Restrictions.eq("ifAccept", 2));
//  		criteria2.add(Restrictions.eq("isValid", 1));
//  		Pager pager2=brokerRelationshipService.list(criteria2,1, pageNo);
  		return "pagerBoke";
		  
		  
		  
	  }
	  
	  /**
		 * 模特或摄影师申请某人做自己的经纪人
		 * @return
		 * @throws Exception
		 */
		public String applySomeoneBecomeMyBroker() throws Exception{
			String mpName = super.getLoginUsername();
			User author = this.getUserService().select(mpName);//当前模特或摄影师
			User whoIsActive = author;
			
			String brokerId = super.getRequest().getParameter(userName); //被申请的经纪人id
			User broker = null;
			
				broker = this.getUserService().select(userName);
				
				if(broker==null){
					this.addActionError("查无此人,请检查经纪人的用户名是否正确");
					return "input";
					
					
				}	else if(!broker.getRole().contains("broker")){
					this.addActionError("此人没有经纪人的身份,没有权限成为您的经纪人");
					return "input";
					
				}
				else if(broker.getUsername().equals(super.getLoginUsername())){
					this.addActionError("您自己不能经纪您自己");
					return "input";
				}
				else if(broker.getIfIdentityTrue()!=2){
					this.addActionError("此人没有经过实名认证,没有权限成为您的经纪人");
					return "input";
					
				}else if(!broker.getRealName().equals(realName)){
					this.addActionError("请您仔细检查经纪人的真实姓名,有无错别字,或者符号");
					return "input";
				}
				
				List<BrokerRelationship> list= brokerRelationshipService.getRelationShips(author);
				if(list!=null&&list.size()>0){
				BrokerRelationship brokerRelationship=list.get(0);
				Calendar cal = Calendar.getInstance();
				cal.setTime(brokerRelationship.getCreationTime());
				cal.add(cal.YEAR, 1);
				java.util.Date date=cal.getTime();
				Map<String, Object> map=new HashMap<String, Object>();
				map.put("END_DATE", date);
				map.put("START_DATE", brokerRelationship.getCreationTime());
			    int days=Cleandar.TimeDay(map);
			    if(days<365){
			    	this.addActionError("您的经纪人经济的时间还没到,您暂时不能更换经纪人");
					return "input";
			    }
					
					
					
				}
				
				
				
				
			
			BrokerRelationship ship = new BrokerRelationship();
			ship.setBroker(broker);
			ship.setAuthor(author);
			ship.setWhoIsActive(whoIsActive);
			java.util.Date date = new java.util.Date();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String strDate = format.format(date);
			ship.setApplyTime(java.sql.Timestamp.valueOf(strDate));
			ship.setIsValid(0);
			ship.setIfAccept(0);
		    int result = this.getBrokerRelationshipService().insert(ship);
		    if(result > 0){
		    	return photoOrmodeljingjiren();
		    }
		    return Constants.ERROR_KEY;
		}
		
		
	//模特或摄影师的经纪人
	public User  photoOrModel(User user){
		
		
		    Map<String, Object> map=new HashMap<String, Object>();
		   // map.put(key, value);
		   List<BrokerRelationship> list=this.getBrokerRelationshipService().getRelationShips(user);
			if(list.size() > 0) {
				brokerRelationship = list.get(0);
				brokeuser = userService.selectById(brokerRelationship.getBroker().getId());
				UserCredit userCredit = userCreditService.selectByUser(brokeuser);
				UserMess userMess = new UserMess();
				int attentionNumber = this.getContactService().findAttentionNumber(brokeuser);
				int fansNumber = this.getContactService().findFansNumber(brokeuser);
				userMess.setBadRemark(userCredit.getBidBadRemarkNum());
				userMess.setFansNumber(fansNumber);
				userMess.setAttentionNumber(attentionNumber);
				userMess.setGoodRemark(userCredit.getBidGoodRemarkNum());
				userMess.setIdString(brokerRelationship.getId()+"");
			   //userCredit=userCreditService.selectByUser(brokeuser);
			   UserCredit credit=new UserCredit();
			   int total=(int) userCredit.getTotalMark();
			   int star=total/200;
			   credit.setStar(star);
			   userMess.setCredit(credit);
			   
				brokeuser.setUserMess(userMess);
	        	
	          }
		
		return brokeuser;
		
	}
	
	public String listAllapply(){
		
		
		
		String userNameString=null;
		userName=super.getLoginUsername();
		if(userName==null){
			return "login";
			
		}
		DetachedCriteria criteria=DetachedCriteria.forClass(BrokerRelationship.class);
	    criteria.add(Restrictions.eq("broker",userService.select(userName) ));
		criteria.add(Restrictions.eq("ifAccept", 0));
		Pager pager=brokerRelationshipService.list(criteria,pageSize, pageNo);
		
		return "listAllapply";
	}
	
	
	
	//当增加经纪人关系成功以后，将当前摄影师或模特之前对应的经纪人关系设置为无效
	public void modifyValid(List<BrokerRelationship> strList){
		this.getBrokerRelationshipService().modifyValid(strList);
	}
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			BrokerRelationship brokerRelationship = this.getBrokerRelationshipService().select(new Integer(id));
			brokerRelationship.setBroker(this.getUserService().selectById(Integer.parseInt(this.getBrokerId())));    
			brokerRelationship.setAuthor(this.getUserService().selectById(Integer.parseInt(this.getAuthorId())));    
			brokerRelationship.setCreationTime(java.sql.Timestamp.valueOf(this.getCreationTime() ));
			brokerRelationship.setIsValid(Integer.valueOf(this.getIsValid() ));
		this.getBrokerRelationshipService().update(brokerRelationship);
		
		bean2Form(brokerRelationship);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_BROKERRELATIONSHIP);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getBrokerRelationshipService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("brokerRelationship.message.edit.success");
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
				saveActionError("brokerRelationship.message.edit.notexist");
			} else {
				// ??????
				this.getBrokerRelationshipService().delete(Integer.valueOf(id));
				saveActionMessage("brokerRelationship.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getBrokerRelationshipService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		return Constants.LIST_KEY;
		
	}//end delete()
		
	
	
	/***查询所有选了我做经济人且有效的列表***/
	public String brokerRelationshipList() throws Exception{
		
		try {
			String loginName = super.getLoginUsername();
			if(loginName == null || loginName.length()==0)
			{
				return "login";
			}
			clearErrorsAndMessages();
			int userId=(Integer)ActionContext.getContext().getSession().get("id");
			Pager pagerSession = (Pager) getSession(Constants.PAGER_BROKERRELATIONSHIP);
			if(pagerSession == null){
				//??????????
				super.pageSize = Constants.pageSize;
				super.pageNo = Constants.pageNo;
			}else{
				super.pageSize = pagerSession.getPageSize();
				super.pageNo = pagerSession.getPageNo();
				
			}
			super.pager = this.getBrokerRelationshipService().list(userId,0, super.pageSize, super.pageNo);
		} catch (Exception e) {
			e.printStackTrace();
			saveActionMessage2("brokerRelationshipList error");
			return Constants.ERROR_KEY;
		}
		this.setCurrentUserid(this.getUserService().select(super.getLoginUsername()).getId());
		return "brokerRelationshipList";
	}
	
	/*****建立经济关系******/
	public String relationshipChoose() throws Exception{
		try{
			String loginName = super.getLoginUsername();
			if(loginName == null || loginName.length()==0)
			{
				return "login";
			}
			clearErrorsAndMessages();
			int userId=(Integer)ActionContext.getContext().getSession().get("id");
			if(!this.getBrokerRelationshipService().chooseRelationship(Integer.valueOf(id), userId, flag))
				saveActionMessage("brokerRelationship.message.relationshipChoose.false");
		}catch (Exception e) {
			e.printStackTrace();
			return Constants.ERROR_KEY;
		}
		return photoOrmodeljingjiren();
	}
	
	/*******查看其他模特或摄影师或经纪人信息********/
	public String viewOthers() throws Exception{
		
		return "viewOthers";
	}
 
	/////getter////setter//////
	public String getId(){
		return  id;
	}
	public void  setId(String id){
		this.id = id ;
	}
	 
	public BrokerRelationshipService getBrokerRelationshipService() {
		return brokerRelationshipService;
	}
	public void setBrokerRelationshipService(BrokerRelationshipService brokerRelationshipService) {
		this.brokerRelationshipService = brokerRelationshipService;
	}
	
	 
	public String getCreationTime(){
		return  creationTime;
	}
	public void  setCreationTime(String creationTime){
		this.creationTime = creationTime ;
	}
	 
	public String getIsValid(){
		return  isValid;
	}
	public void  setIsValid(String isValid){
		this.isValid = isValid ;
	}
	 
	public String getUsername() {
	 	return username;
	}
	
	public void setUsername(String username) {
	 	this.username = username;
	}
	public String getBrokerId() {
		return brokerId;
	}
	public void setBrokerId(String brokerId) {
		this.brokerId = brokerId;
	}
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	
	public String getBrokerUserName() {
		if(brokerUserName == null){
			brokerUserName = this.getUserService().selectById(Integer.parseInt(this.getBrokerId())).getUsername();
		}
		return brokerUserName;
	}
	public void setBrokerUserName(String brokerUserName) {
		this.brokerUserName = brokerUserName;
	}
	public String getAuthorUserName() {
		if(authorUserName == null){
			authorUserName = this.getUserService().selectById(Integer.parseInt(this.getAuthorId())).getUsername();
		}		
		return authorUserName;
	}
	public void setAuthorUserName(String authorUserName) {
		this.authorUserName = authorUserName;
	}
	public Integer getFlag() {
		return flag;
	}
	public void setFlag(Integer flag) {
		this.flag = flag;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<User> getBrokerList() {
		return brokerList;
	}
	public void setBrokerList(List<User> brokerList) {
		this.brokerList = brokerList;
	}
	 
	public List<User> getNotBrokerList() {
		return notBrokerList;
	}
	public void setNotBrokerList(List<User> notBrokerList) {
		this.notBrokerList = notBrokerList;
	}
	public List<User> getTheBrokerOrnotList() {
		return theBrokerOrnotList;
	}
	public void setTheBrokerOrnotList(List<User> theBrokerOrnotList) {
		this.theBrokerOrnotList = theBrokerOrnotList;
	}
	
	 
}//end class
