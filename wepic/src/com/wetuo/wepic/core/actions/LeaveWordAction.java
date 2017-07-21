package com.wetuo.wepic.core.actions ;

import java.util.ArrayList;
import java.util.HashMap;

import java.io.File;
import java.util.*;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import com.opensymphony.xwork2.ActionContext;

import com.wetuo.wepic.core.beans.LeaveWord;
import com.wetuo.wepic.core.beans.UrlProperties;
import com.wetuo.wepic.core.service.LeaveWordService;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
 
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.util.UploadUtils;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.service.PublishService;

 
 
public class LeaveWordAction extends PageAction{
 
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
 	private LeaveWordService leaveWordService;
	protected String memberId = null ;
	
	protected String adminId = null ;
	private UserService userService;
	protected String content = null ; 
	protected String whoseContent = null ; 
	protected String time = null ; 
	protected String username = null; 
	protected String title;
	private String messageReply;
	private Object model;
	private String proofurl;//证据地址
	private String tel;
	private String email;
	private String qq;
	private String reason;
	private File proof;
	private String proofContentType;
	private String proofFileName;
	private String msg;
    private String photoId;
	private int nowPage;
	private PublishService publishService;
	private String complainedContent;
	private String resultStat;
	private String detailContent;
	
	
	
	
	public String getDetailContent() {
		return detailContent;
	}
	public void setDetailContent(String detailContent) {
		this.detailContent = detailContent;
	}
	public String getResultStat() {
		return resultStat;
	}
	public void setResultStat(String resultStat) {
		this.resultStat = resultStat;
	}
	public PublishService getPublishService() {
		return publishService;
	}
	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public File getProof() {
		return proof;
	}
	public void setProof(File proof) {
		this.proof = proof;
	}
	public String getProofContentType() {
		return proofContentType;
	}
	public void setProofContentType(String proofContentType) {
		this.proofContentType = proofContentType;
	}
	public String getProofFileName() {
		return proofFileName;
	}
	public void setProofFileName(String proofFileName) {
		this.proofFileName = proofFileName;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public Object getModel() {
		return model;
	}
	public void setModel(Object model) {
		this.model = model;
	}
	public String getProofurl() {
		return proofurl;
	}
	public void setProofurl(String proofurl) {
		this.proofurl = proofurl;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public String getMessageReply() {
		return messageReply;
	}
	public void setMessageReply(String messageReply) {
		this.messageReply = messageReply;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	//???????????��????
	public void validate() {
		
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("leaveWordadd!insert") != -1 || queryString.indexOf("leaveWordedit!update") != -1) {
//		
//			if (userId == null || userId.equals("")) {
//				addFieldError("userId", "userId must be inputed");
//			}//end if null
//			if (userId == null || userId.equals("")) {
//				addFieldError("userId", "userId must be inputed");
//			}//end if null
			if (content == null || content.equals("")) {
				addFieldError("content", "content must be inputed");
			}//end if null
			if (title == null || title.equals("")) {
				addFieldError("content", "content must be inputed");
			}//end if null
////			if (whoseContent == null || whoseContent.equals("")) {
////				addFieldError("whoseContent", "whoseContent must be inputed");
////			}//end if null
//			if (time == null || time.equals("")) {
//				addFieldError("time", "time must be inputed");
//			}//end if null
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
		super.pager = this.getLeaveWordService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		// ?????????
		setSession(Constants.PAGER_LEAVEWORD, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end init()
	
	
	
	
	public String init_notverify() throws Exception {
		String loginName = super.getLoginUsername();
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		// ???????????
		super.pager = this.getLeaveWordService().list(loginName, super.pageSize, super.pageNo);
		// ?????????
		setSession(Constants.PAGER_LEAVEWORD, super.pager);
		
		return Constants.LIST_KEY_NOTVERIFY;
		
	}//end init()
	
	
	
	public String initAdmin() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ??????????
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		
		// ???????????
		super.pager = this.getLeaveWordService().list(super.pageSize, super.pageNo);
		int rowCount=this.getLeaveWordService().findAll().size();
		super.pager.setRowCount(rowCount);
		// ?????????
		setSession(Constants.PAGER_LEAVEWORD, super.pager);
		
		return Constants.ADMINLIST_KEY;
		
	}//end init()
		
	public String list() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getLeaveWordService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_LEAVEWORD, super.pager);
		
		return Constants.LIST_KEY;
		
	}//end list()
	public String list_notverify() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// ???????????
		super.pager = this.getLeaveWordService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		
		// ?????????
		setSession(Constants.PAGER_LEAVEWORD, super.pager);
		
		return Constants.LIST_KEY_NOTVERIFY;
		
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
		setMemberId(null);
		setAdminId(null);
		setContent(null);
		setWhoseContent(null);
		setTime(null);
	}//end reset()
		// ?????��??
	private void bean2Form(LeaveWord leaveWord) {
		setId(leaveWord.getId().toString());
		setMemberId(leaveWord.getMember().getId().toString());
		setAdminId(leaveWord.getAdmin().getId().toString());
		setContent(leaveWord.getContent());
		setWhoseContent(leaveWord.getWhoseContent().toString()      );
		setTime(leaveWord.getTime().toString()      );
	}//end bean2Form()
	public String edit() throws Exception {
		// ?????????
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("leaveWord.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			LeaveWord leaveWord = this.getLeaveWordService().select(Integer.valueOf(id));
			
			// ??????????????
			if (leaveWord == null) {
				saveActionError("leaveWord.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(leaveWord);
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
		LeaveWord leaveWord = new LeaveWord();
			leaveWord.setMember(this.getUserService().select(this.getMemberId()));    
			leaveWord.setAdmin(this.getUserService().select(this.getAdminId()));    
			
		leaveWord.setContent(this.getContent());
		leaveWord.setWhoseContent(Integer.valueOf(this.getWhoseContent() ));
		leaveWord.setTime(java.sql.Timestamp.valueOf(this.getTime() ));
		nid = this.getLeaveWordService().insert(leaveWord);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_LEAVEWORD);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getLeaveWordService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("leaveWord.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("leaveWord.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	
	
	
	//未验证留言
	
	public String insert_notverify() throws Exception {
		 
		clearErrorsAndMessages();
		Integer nid = null ;
		
		try{
			
		//
		LeaveWord leaveWord = new LeaveWord();
		leaveWord.setMember(this.getUserService().selectById((Integer)super.getSession("id")));    
		//leaveWord.setAdmin();    
		leaveWord.setTitle(this.getTitle());
		leaveWord.setContent(this.getContent());
		//leaveWord.setWhoseContent(Integer.valueOf(this.getWhoseContent() ));
		leaveWord.setTime(new Timestamp(( new Date().getTime())));
		nid = this.getLeaveWordService().insert(leaveWord);
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_LEAVEWORD);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		//????????????
		super.pager = this.getLeaveWordService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		// ?????????
		if (nid != null) {
			saveActionMessage("leaveWord.message.add.success");
			return "sucess";
		} else {
			saveActionError("leaveWord.message.add.failed");
			return Constants.ADD_KEY;
		}
		
		
		
		
		//System.out.println(title+"====================");
		//return "sss";
	}//end insert()
	
	
	
	public String update() throws Exception {
		// 
		clearErrorsAndMessages();
		
		try{
			// 
			LeaveWord leaveWord = this.getLeaveWordService().select(new Integer(id));
//			leaveWord.setUser(userInstance);    
//			leaveWord.setUser(userInstance);  
			leaveWord.setMember(this.getUserService().select(this.getMemberId()));    
			leaveWord.setAdmin(this.getUserService().select(this.getAdminId()));    
			
			leaveWord.setContent(this.getContent());
			leaveWord.setWhoseContent(Integer.valueOf(this.getWhoseContent() ));
			leaveWord.setTime(java.sql.Timestamp.valueOf(this.getTime() ));
		this.getLeaveWordService().update(leaveWord);
		
		bean2Form(leaveWord);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_LEAVEWORD);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getLeaveWordService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("leaveWord.message.edit.success");
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
				saveActionError("leaveWord.message.edit.notexist");
			} else {
				// ??????
				this.getLeaveWordService().delete(Integer.valueOf(id));
				saveActionMessage("leaveWord.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getLeaveWordService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		return Constants.LIST_KEY;
		
	}
	
	//留言回复
	
	public String messageReply(){
		int leaveId=0;
		if(id!=null&&id.length()>0){
			 leaveId=Integer.parseInt(id);
			
		}
		LeaveWord leaveWord= leaveWordService.select(leaveId);
		leaveWord.setMessageReply(messageReply);
		leaveWord.setMessageReply(messageReply);
		leaveWord.setWhoseContent((Integer)super.getSession("id"));
		leaveWordService.update(leaveWord);

		
		
		return Constants.LIST_REMMES;
	}
	
	public String  listParame(){
		
		String type=super.getRequest().getParameter("type");
		
		clearErrorsAndMessages();
		
		// ??????????
		
		if("Y".equals(type)){
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
			super.pager = this.getLeaveWordService().Ylist(super.getLoginUsername(), super.pageSize, super.pageNo);	
			
		//	System.out.println("Y+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}else{
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
			super.pager = this.getLeaveWordService().Nlist(super.getLoginUsername(), super.pageSize, super.pageNo);
			//System.out.println("N+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			
		}
		
		
		// ?????????
		setSession(Constants.PAGER_LEAVEWORD, super.pager);
		
	//	return Constants.LIST_KEY_NOTVERIFY;
		
		
		
		
		
		return "listparamter";
		
	}
	public String initleaveWord(){
		String username=super.getLoginUsername();
		if(username==null||username.trim().length()<=0){
			return "login";
		}
		User user=userService.select(username);
		ActionContext.getContext().put("user", user);
		
		return "initleaveWord";
	}
	
	public String initleavecomplain(){
		String username=super.getLoginUsername();
		if(username==null||username.trim().length()<=0){
			return "login";
		}
		User user=userService.select(username);
		ActionContext.getContext().put("user", user);
		
		return "initleavecomplain";
	}
	
	public String initleaveWordcomplain(){
		String username=super.getLoginUsername();
		if(username==null||username.trim().length()<=0){
			return "login";
		}
		User user=userService.select(username);
		ActionContext.getContext().put("user", user);
		
		return "initleaveWordcomplain";
	}
	
	@SuppressWarnings("unchecked")
	public String savecomplain(){
		Object id=super.getSession("id");
		
		if(id==null){
			
		return "login";	
		}
		
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("picNumber", photoId);
		Pager pager=publishService.list(map, 1, 1);
		List<Publish> list=(List<Publish>)pager.getResultList();
		int length=list.size();
		Publish publish=null;
		if(length<=0){
			User user=userService.selectById(Integer.parseInt(id.toString()));
			ActionContext.getContext().put("user", user);
			super.addActionError("作品不存在");
			
			
			return "inputPager";
		}
		
		publish=list.get(0);
		int userId=Integer.parseInt(id.toString());
		User user=new User();
		user.setId(userId);
		
		LeaveWord leaveWord=new LeaveWord();
		leaveWord.setDetailContent(detailContent);
		leaveWord.setAdtype("2");
		leaveWord.setEmail(email);
		leaveWord.setMember(user);
		leaveWord.setPublish(publish);
		leaveWord.setQq(qq);
		leaveWord.setTel(tel);
		leaveWord.setTitle(title);
		leaveWord.setTime(new Timestamp(new Date().getTime()));
		leaveWord.setReason(reason);
		leaveWord.setProofurl(proofurl);//(reason);
		leaveWord.setStep("1");
		leaveWordService.insert(leaveWord);
		
		return findByPage();
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	public String findByPage(){
		username=super.getLoginUsername();
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("adtype", 2);
		
		Pager pager1=leaveWordService.list(username,"2",4, nowPage);
	    List<LeaveWord> leaveWords=(List<LeaveWord>) pager1.getResultList();
	    List<LeaveWord> newList=new ArrayList<LeaveWord>();
	    for (LeaveWord leaveWord : leaveWords) {
	    	if(leaveWord.getProofurl()!=null&&leaveWord.getProofurl().contains(".")){
	    	String[] strings=leaveWord.getProofurl().split(",");
	    	List<UrlProperties> list=new ArrayList<UrlProperties>();
	    	for (String string : strings) {
	    		String fileName=string.substring(string.lastIndexOf("/")+1, string.length());
	    		UrlProperties properties=new UrlProperties();
	    		properties.setFileName(fileName);
	    		properties.setUrl(string);
	    		list.add(properties);
			}
	    	leaveWord.setUrlList(list);
	    	newList.add(leaveWord);
		}
	    }
		pager1.setResultList(newList);
		super.pager=pager1;
		
		int endPage=pager1.getLastPageNo();
		ActionContext.getContext().put("endPage", endPage);
		
		return "findByPage";
	}
	
	public String saveadvice(){
		Object id=super.getSession("id");
		
		if(id==null){
			
		return "login";	
		}
		
		int userId=Integer.parseInt(id.toString());
		User user=new User();
		user.setId(userId);
		LeaveWord leaveWord=new LeaveWord();
		leaveWord.setContent(content);
		leaveWord.setAdtype("1");
		leaveWord.setEmail(email);
		leaveWord.setMember(user);
		leaveWord.setQq(qq);
		leaveWord.setTel(tel);
		leaveWord.setTitle(title);
		leaveWord.setTime(new Timestamp(new Date().getTime()));
		leaveWordService.insert(leaveWord);
		
		return "saveadvice";
	}
	
	
	
	
	int i=0;
	
	@SuppressWarnings("null")
	public String profileUpload(){
		String username=super.getLoginUsername();
		if(username==null&&username.length()<=0){
			return "login";
			
		}
		
		try{
			
			if(i>=10){
				msg="2";
			return "profileUpload";	
			}
			
			String type=proofFileName.substring(proofFileName.lastIndexOf("."),proofFileName.length());
			String newname=proofFileName.substring(0,proofFileName.lastIndexOf("."));
			String alowtype=".jpg.jpeg.gif.png.pdf.doc.docx.xls.ppt.txt";
			if(!alowtype.contains(type)){
				msg="1";
			return "profileUpload";	
				
			}
			String targetDirectory = ServletActionContext.getServletContext().getRealPath("/view/leaveWord/proof");
			
			HttpServletRequest request=super.getRequest();
			String path = request.getContextPath();
			//String newname=
			 Random rand = new Random();
			 String fla=rand.nextInt(99)+"";
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/view/leaveWord/proof/";
			UploadUtils uploadUtils=new UploadUtils();
			uploadUtils.copyFile(proof, new File(targetDirectory+ "/"+newname+username+fla+type));
			msg=newname+username+fla+type;
			proofurl=basePath+"/"+newname+username+fla+type;
			i++;
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		
		
		return "profileUpload";
	}
	
	public String listcomplainPager(){
		Object object=super.getSession("id");
		if(object==null){	
			return "login";
		}
		User user=new User();
	    user.setId(Integer.parseInt(object.toString()));
		Map<String, Object> map=new HashMap<String,Object>(); 
		map.put("user", user);
		map.put("adtype", 1);
		super.pager=leaveWordService.list(map,pageSize, pageNo);
		
		return "listcomplainPager";
	}
	
	
@SuppressWarnings("unchecked")
public String admingetAllCOmplainforPhoto(){
	
	username=super.getLoginUsername();
	if(username==null||!username.equals("super1")){
		return "login";
	}
	DetachedCriteria detachedCriteria=DetachedCriteria.forClass(LeaveWord.class);
	detachedCriteria.add(Restrictions.eq("adtype", "2"))
	                .addOrder(Order.asc("step"));
	Pager pager1=leaveWordService.listbyDetachedCrities(detachedCriteria, nowPage, 8);
	  List<LeaveWord> leaveWords=(List<LeaveWord>) pager1.getResultList();
	    List<LeaveWord> newList=new ArrayList<LeaveWord>();
	    
	    for (LeaveWord leaveWord : leaveWords) {
	    	if(leaveWord.getContent()!=null&&leaveWord.getContent().trim().length()>0){
	    	String[] complins=leaveWord.getContent().split("__");
	    	if(complins.length>=2){
	    	leaveWord.setContent(complins[0]);
	    	leaveWord.setConplinedContent(complins[1]);
	    	}
	    	}
	    	if(leaveWord.getProofurl()!=null&&leaveWord.getProofurl().trim().length()>0){
	    	//if(leaveWord.getProofurl().contains(",")){
	    	String[] strings=leaveWord.getProofurl().split(",");
	    	List<UrlProperties> list=new ArrayList<UrlProperties>();
	    	for (String string : strings) {
	    		String fileName=string.substring(string.lastIndexOf("/")+1, string.length());
	    		UrlProperties properties=new UrlProperties();
	    		properties.setFileName(fileName);
	    		properties.setUrl(string);
	    		list.add(properties);
			}
	    	leaveWord.setUrlList(list);
	    	//}
	    	}
	       Publish publish=publishService.select(leaveWord.getPublish().getId());
	    	User user=userService.selectById(leaveWord.getMember().getId());
	    	leaveWord.setMember(user);
	       leaveWord.setPublish(publish);
	    	
	    	
	    	newList.add(leaveWord);
		}
		pager1.setResultList(newList);
	  super.pager=pager1;
	  int pageno=super.pager.getPageNo()+1;
	  ActionContext.getContext().put("pageno", pageno);
		return "getAllCOmplainforPhoto";
	}
	 


  public String dealComplainForPhoto(){
	  Object object=super.getSession("id");
	  if(object==null){	
			return "login";
		}
	  String msgReplay=content+"__"+complainedContent;
	  LeaveWord leaveWord=leaveWordService.select(Integer.parseInt(id));
	  leaveWord.setContent(msgReplay.trim());
	  leaveWord.setResultStat(resultStat);
	 if(resultStat==null){
		 leaveWord.setStep("2"); 
		 //1表示驳回投诉.程序做处理结束判断
	 }else 
		 if(resultStat.equals("1")){
		 leaveWord.setStep("5"); 
	 }
		 else if(resultStat.equals("2")){
		 leaveWord.setStep("3"); 
	 }
	 leaveWordService.update(leaveWord);
   return admingetAllCOmplainforPhoto();
	  
	  
	  
	  
	  
	 // return "dealComplainForPhoto";
  }

	
	public String getId(){
		return  id;
	}
	public void  setId(String id){
		this.id = id ;
	}
	 
	public LeaveWordService getLeaveWordService() {
		return leaveWordService;
	}
	public void setLeaveWordService(LeaveWordService leaveWordService) {
		this.leaveWordService = leaveWordService;
	}
	
	 
	public String getContent(){
		return  content;
	}
	public void  setContent(String content){
		this.content = content ;
	}
	 
	public String getWhoseContent(){
		return  whoseContent;
	}
	public void  setWhoseContent(String whoseContent){
		this.whoseContent = whoseContent ;
	}
	 
	public String getTime(){
		return  time;
	}
	public void  setTime(String time){
		this.time = time ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getPhotoId() {
		return photoId;
	}
	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public String getComplainedContent() {
		return complainedContent;
	}
	public void setComplainedContent(String complainedContent) {
		this.complainedContent = complainedContent;
	}
	
	 
	 
}//end class
