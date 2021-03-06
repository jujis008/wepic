package com.wetuo.wepic.publish.actions ;
 
import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionContext;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.util.ConvertChinese;
import com.wetuo.wepic.core.service.UserService;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.beans.PublishCat;
import com.wetuo.wepic.publish.service.PublishCatService;
import com.wetuo.wepic.publish.service.PublishService;
import com.sun.org.apache.bcel.internal.generic.NEW;

@SuppressWarnings("serial") 
public class PublishCatAction extends PageAction {
 
	/////instantce variable//////
	private static final long serialVersionUID = 1L;
	protected String id = null ; 
	protected String publishCatId = null ; 
	@Resource
	//private int publishCatId
 	private PublishCatService publishCatService;
	protected String name = null ; 
	protected String enName=null;
	protected String discription = null ; 
	protected String type = null ; 
	protected String username = null; 
	protected String title = null; 
	protected String url = null; 
	protected String target = null; 
	protected String icon = null; 
	protected String iconOpen = null; 
	protected String checkboxId = null; 
	protected String pid = null; 
	protected String secondCatId=null;
	//publishCatImglist
	private UserService userService;
	private PublishCat publishCat;
	
	private List<PublishCat> publishCatlist;
	private List<PublishCat> justUnderTopProjectCatPublishCatlist;
	Map<PublishCat, List<PublishCat>> mapCatCats ;
	private List<List<PublishCat>> publishCatLevel2list;
	private List<PublishCat> myUnderCatList;
	private List<PublishCat> mySecCatList;
	private PublishService publishService;
	private Map pubMap = new HashMap();
	private List<Publish> mySecPubList;
	private PublishCat sonPublishCat;
	private PublishCat fatherPublishCat;
	private List<List<Object>> publishCatImglist = new ArrayList<List<Object>>();
	List<PublishCat> getPublisCatchildList;
	private String tags ;
	
	
	public List<PublishCat> getGetPublisCatchildList() {
		return getPublisCatchildList;
	}

	public void setGetPublisCatchildList(List<PublishCat> getPublisCatchildList) {
		this.getPublisCatchildList = getPublisCatchildList;
	}

	public List<List<Object>> getPublishCatImglist() {
		return publishCatImglist;
	}

	public void setPublishCatImglist(List<List<Object>> publishCatImglist) {
		this.publishCatImglist = publishCatImglist;
	}



	public String underCat() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		String catId = ServletActionContext.getRequest().getParameter("pid"); 
		return "underCat";
	}//end init()
	
	
	
	@JSON(serialize = false)
	public String getPublishCatLevel2listUnderCat(){
		try {
			publishCatLevel2list = this.getPublishCatService().getLevel2PublishCatMapUnderProjectCat(Integer.parseInt(getPid()));
			return "getPublishCatLevel2listUnderCat";
		} catch (Exception e) {
			e.printStackTrace();
		}
	 return null;
	}
	
	@JSON(serialize = false)
	public String getUnderCatList(){
		try {
//			String catId = ServletActionContext.getRequest().getParameter("pid");
			
			//myUnderCatList=this.getPublishCatService().getPublishCatListUnderProjectCat(Integer.parseInt(getSecondCatId()));
			myUnderCatList=this.getPublishCatService().getPublishCatList();
			
			return "getUnderCatList";
		} catch (Exception e) {
			e.printStackTrace();
		}
	 return null;
	}
	
	@JSON(serialize = false)
	public String getPublishCatListJustUnderProjectCat(){
		try {
			justUnderTopProjectCatPublishCatlist = this.getPublishCatService().getPublishCatListJustUnderProjectCat(Integer.parseInt(getPid()));
			for(PublishCat pubCat:  justUnderTopProjectCatPublishCatlist ){
				System.out.println("pubCat name :" + pubCat.getName());
				//System.out.println("pubCat parent name :" + pubCat.getPublishCat().getName());
				System.out.println("pubCat pid :" + pubCat.getPid());
			}
			return "getProjectCatsJustUnderTopProjectCat";
		} catch (Exception e) {
			e.printStackTrace();
		}
	 return null;
	}
	
	@JSON(serialize = false)
	public String getPublishCatMapUnderProjectCat(){
		try {
			this.mapCatCats = this.getPublishCatService().getPublishCatMapUnderProjectCat(Integer.parseInt(getPid()));
			return "getPublishCatMapUnderProjectCat";
		} catch (Exception e) {
			e.printStackTrace();
		}
	 return null;
	}
	
	
	@JSON(serialize = false)
	public String getPublisCatList(){
		try {
			publishCatlist = this.getPublishCatService().getPublishCatList();
//			for(PublishCat pubCat:publishCatlist ){
//				System.out.println("pubCat name :" + pubCat.getName());
//				//System.out.println("pubCat parent name :" + pubCat.getPublishCat().getName());
//				System.out.println("pubCat pid :" + pubCat.getPid());
//			}
			return "getPublisCatList";
		} catch (Exception e) {
			e.printStackTrace();
		}
	 return null;
	}
	
	
	@JSON(serialize = false)
	public String getPublisCatchildList(){
		try {
			getPublisCatchildList=publishCatService.getPublishCatListUnderPid(new Integer(id));			
			//publishCatlist = this.getPublishCatService().getPublishCatListchild(new Integer(id));
			return "publisCatchildList";
		} catch (Exception e) {
			e.printStackTrace();
		}
	 return null;
	}
	
	
	
	private String parId;
	public String getParId() {
		return parId;
	}
	public void setParId(String parId) {
		this.parId = parId;
	}

	
	public Pager ImgChangeByCat(Integer catId) {
		try {
			super.pageSize =5;
			super.pageNo = 1;
			super.pager=this.getPublishService().ImgChangeByCat(catId,pageSize, pageNo);
			return super.pager;
		} catch (Exception e) {
			e.printStackTrace();
		}
	 return null;
	}
	//publishCatImglist
	@SuppressWarnings("unchecked")
	@JSON(serialize=false)
	public String photoCatImgList() {
		try {
			publishCatlist = this.getPublishCatService().getPublishCatListUnderPid(Integer.valueOf(getParId()));
			for(PublishCat publishCat : publishCatlist ){
				List<Object> innerList = new ArrayList();
				Pager pager = ImgChangeByCat(publishCat.getId());
				innerList.add(publishCat);
				if(pager != null){
					for(Publish publish :  (List<Publish>)pager.getResultList() ){
						innerList.add(publish);
					}
				}
				
				publishCatImglist.add(innerList);
//				for (int i = 0; i < innerList.size(); i++) {
//					publishCatImglist.add((List<?>) innerList.get(i));
//				}
				
			}
			
			return "photoCatImgList";
		} catch (Exception e) {
			e.printStackTrace();
		}
	 return null;
	}
	
	
	@JSON(serialize=false)
	public String photoCatList() {
		try {
			publishCatlist = this.getPublishCatService().getPublishCatListUnderPid(Integer.valueOf(getParId()));
			return "photoCatList";
		} catch (Exception e) {
			e.printStackTrace();
		}
	 return null;
	}
	/////
	public void validate() {
		
		clearErrorsAndMessages();
		
		// ??????????
		String queryString = getRequestPath();
		if (queryString.indexOf("publishCatadd!insert") != -1 || queryString.indexOf("publishCatedit!update") != -1) {
		
			if (publishCatId == null || publishCatId.equals("")) {
				addFieldError("publishCatId", "publishCatId must be inputed");
			}//end if null
			if (name == null || name.equals("")) {
				addFieldError("name", "name must be inputed");
			}//end if null
			if (discription == null || discription.equals("")) {
				addFieldError("discription", "discription must be inputed");
			}//end if null
		
			if (name == null || name.equals("")) {
				addFieldError("name", getText("publishCat.error.name"));
			}
		}//end if
	}//end validate()
	public String init() throws Exception {
		clearErrorsAndMessages();
		super.pageSize = Constants.pageSize;
		super.pageNo = Constants.pageNo;
		super.pager = this.getPublishCatService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		//setSession(Constants.PAGER_PUBLISHCAT, super.pager);
		return Constants.LIST_KEY;
	}//end init()
		
	public String list() throws Exception {
		clearErrorsAndMessages();
		super.pager = this.getPublishCatService().list(super.getLoginUsername(), super.pageSize, super.pageNo);	
		//setSession(Constants.PAGER_PUBLISHCAT, super.pager);
		return Constants.LIST_KEY;
	}//end list()
		
	
	public String thisCat() throws Exception {
		clearErrorsAndMessages();
		String catId = ServletActionContext.getRequest().getParameter("catId");
		this.publishCat = this.getPublishCatService().select(Integer.parseInt(catId));	
		//setSession(Constants.PAGER_PUBLISHCAT, super.pager);
		return "thisCat" ;
	}//end list()
		
	
	public String add() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
//		if(ServletActionContext.getRequest().getParameter("from") != null && ServletActionContext.getRequest().getParameter("from") != ""){
//			if(ServletActionContext.getRequest().getParameter("from").indexOf("publishCat") > -1){
//				ServletActionContext.getResponse().sendRedirect("publishCat!init.do");
//			}
//		}
		String pid = ServletActionContext.getRequest().getParameter("pid");
		ServletActionContext.getRequest().setAttribute("pid", pid);
		System.out.println("pid of add : " + pid );
		reset();
		return Constants.ADD_KEY;
	}//end add()
	private void reset() {
		setId(null);
		setPublishCatId(null);
		setName(null);
		setDiscription(null);
		setType(null);
	}//end reset()
	private void bean2Form(PublishCat publishCat) {
		setId(publishCat.getId().toString());
		//setPublishCatId(publishCat.getPublishCat().getId().toString());
		setPublishCatId(publishCat.getPid().toString());
		
		setName(publishCat.getName());
		setDiscription(publishCat.getDiscription());
		setType(publishCat.getType());
	}//end bean2Form()
	public String edit() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		
		// id???????????
		if (this.getId() == null) {
			saveActionError("publishCat.message.edit.notexist");
			return Constants.LIST_KEY;
		} else {
			// ???????
			PublishCat publishCat = this.getPublishCatService().select(Integer.valueOf(id));
			
			// ??????????????
			if (publishCat == null) {
				saveActionError("publishCat.message.edit.notexist");
				return Constants.LIST_KEY;
			} else {
				// ?????��??
				bean2Form(publishCat);
				return Constants.EDIT_KEY;
			}
		}//end if
		
	}//end edit()
		
	public String insert() throws Exception {
		String loginName = super.getLoginUsername();
		
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		// 
		clearErrorsAndMessages();
		Integer nid = null ;
		
		try{
			//PublishCat	publishCatInstance= this.getPublishCatService().select(Integer.parseInt(publishCatId)) ;		
			PublishCat publishCat = new PublishCat();
			if(this.getTags() != null ){
				publishCat.setTags(tags);
			}
			//publishCat.setPublishCat(publishCatInstance);    
			publishCat.setPid(Integer.parseInt(publishCatId));    
			publishCat.setName(this.getName());
			publishCat.setEnName(this.getEnName());
			publishCat.setDiscription(this.getDiscription());
			publishCat.setType(this.getType());
			publishCat.setTitle(title);
			publishCat.setCheckboxId(checkboxId);
			publishCat.setIcon(icon);
			publishCat.setIconOpen(iconOpen);
			publishCat.setUrl(url);
			publishCat.setTarget(target);
			publishCat.setUserId(userService.select(super.getLoginUsername()).getId());
			nid = this.getPublishCatService().insert(publishCat);
			System.out.println(this.getPublishCatService().select(nid).getEnName());
			
		Pager pagerSession = (Pager) getSession(Constants.PAGER_PUBLISHCAT);
		if(pagerSession == null){
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
		super.pager = this.getPublishCatService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
		
		
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		if (nid != null) {
			saveActionMessage("publishCat.message.add.success");
			return Constants.LIST_KEY;
		} else {
			saveActionError("publishCat.message.add.failed");
			return Constants.ADD_KEY;
		}
	}//end insert()
	/**
	 * 创建文件夹
	 */
//	public void createDir(int tempId) {
//		String temppath=getPath();
//		String allID=this.getParId(tempId);
//		String []tempAll=allID.split(",");
//		List myAllID=new ArrayList();
//		for (int i = 0; i < tempAll.length; i++) {
//			myAllID.add(tempAll[i]);
//		}
//		int size=myAllID.size();
//		File file=null;
//		String enName="";
//		String catName="";
//		for (int i = size-1; i >=0; i--) {
//			String currentID=myAllID.get(i).toString();
//			enName=this.getPublishCatService().select(Integer.valueOf(currentID)).getEnName();
//			catName=this.getPublishCatService().select(Integer.valueOf(currentID)).getName();
//			if (enName==null || enName=="") {
//				file=new File(temppath+ConvertChinese.getEname(catName));
//				if (file.exists()) {
//					temppath=temppath+ConvertChinese.getEname(catName)+"\\";
//					continue;
//				}else {
//					file.mkdir();
//				}			
//				temppath=temppath+ConvertChinese.getEname(catName)+"\\";
//			}else {
//				file=new File(temppath+enName);
//				if (file.exists()) {
//					temppath=temppath+enName+"\\";
//					continue;
//				}else {
//					file.mkdir();
//				}
//				temppath=temppath+enName+"\\";
//			}
//		}
//	}
	
	
//	public String getDirPath(int tempId) {
//		String temppath=getPath();
//		String allID=this.getParId(tempId);
//		String []tempAll=allID.split(",");
//		List myAllID=new ArrayList();
//		for (int i = 0; i < tempAll.length; i++) {
//			myAllID.add(tempAll[i]);
//		}
//		int size=myAllID.size();
//		File file=null;
//		String enName="";
//		String catName="";
//		for (int i = size-1; i >=0; i--) {
//			String currentID=myAllID.get(i).toString();
//			enName=this.getPublishCatService().select(Integer.valueOf(currentID)).getEnName();
//			catName=this.getPublishCatService().select(Integer.valueOf(currentID)).getName();
//			if (enName==null || enName=="") {
//				file=new File(temppath+ConvertChinese.getEname(catName));
//				if (file.exists()) {
//					temppath=temppath+ConvertChinese.getEname(catName)+"\\";
//					continue;
//				}else {
//					temppath=temppath+ConvertChinese.getEname(catName)+"\\";
//				}			
//				
//			}else {
//				file=new File(temppath+enName);
//				if (file.exists()) {
//					temppath=temppath+enName+"\\";
//					continue;
//				}else {
//					temppath=temppath+enName+"\\";
//				}
//			}
//		}
//		return temppath;
//	}
	
	/**
	 * 得到新增分类时候的id和对应的所有父类对应的id
	 * @param parId
	 * @return
	 */
	public String getParId(int parId) {
		String str=parId+",";
		do {
			parId=this.getPublishCatService().select(parId).getPid();
			str+=parId+",";
		} while (this.getPublishCatService().select(parId).getPid()!=0);
		return str;
	}
	public String getPath() {
		String myp = this.getServletContext().getRealPath("/").toString();
		return myp;
	}
	public String update() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		// 
		clearErrorsAndMessages();
		
		try{
			PublishCat	publishCatInstance= this.getPublishCatService().select(Integer.parseInt(publishCatId)) ;		
			
			PublishCat publishCat = this.getPublishCatService().select(new Integer(id));
			//publishCat.setPublishCat(publishCatInstance);  
			publishCat.setPid(Integer.parseInt(publishCatId));    
			
			publishCat.setName(this.getName());
			publishCat.setDiscription(this.getDiscription());
			publishCat.setType(this.getType());
		this.getPublishCatService().update(publishCat);
		
		bean2Form(publishCat);	
		
		// ?????????????
		Pager pagerSession = (Pager) getSession(Constants.PAGER_PUBLISHCAT);
		if(pagerSession == null){
			//??????????
			super.pageSize = Constants.pageSize;
			super.pageNo = Constants.pageNo;
		}else{
			super.pageSize = pagerSession.getPageSize();
			super.pageNo = pagerSession.getPageNo();
			
		}
		
			// ????????????
			super.pager = this.getPublishCatService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			saveActionMessage("publishCat.message.edit.success");
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2(" Sorry ");
			return Constants.ERROR_KEY;
		}
		
		return Constants.LIST_KEY;
	}//end update() 
	public String delete() throws Exception {
		String loginName = super.getLoginUsername();
		if(loginName == null || loginName.length()==0)
		{
			return "login";
		}
		clearErrorsAndMessages();
		
		try{
			// id???????????
			if (this.getId() == null) {
				saveActionError("publishCat.message.edit.notexist");
			} else {
				// ??????
				this.getPublishCatService().delete(Integer.valueOf(id));
				saveActionMessage("publishCat.message.delete.success");
			}
			
			// ???????????
			super.pager = this.getPublishCatService().list(super.getLoginUsername(), super.pageSize, super.pageNo);
			
		}catch(Exception e){
			saveActionError2(e.toString());
			saveActionMessage2("Please delete child first");
			return Constants.ERROR_KEY;
		}
		return Constants.LIST_KEY;
		
	}//end delete()
	
	//获取所有的二级发布分类，用于二级页面的显示
	public String getAllChildPublishCatbyPid(){
		String perId = ServletActionContext.getRequest().getParameter("perid");
		List<PublishCat> list = new ArrayList<PublishCat>();
		Map<PublishCat,Publish> map = new HashMap<PublishCat,Publish>();
		if(perId != null && perId.length() > 0){
			list = this.getPublishCatService().getPublishCatListJustUnderProjectCat(Integer.parseInt(perId));
		}
		if(list != null && list.size() > 0){
			//this.setMySecCatList(list);
			for(int i=0;i<list.size();i++){
				PublishCat publishcat = list.get(i);
				List<Publish> publist = this.getPublishService().getPublishListBycatId(publishcat.getId().toString());
				Publish publish = null;
				if(publist != null && publist.size() > 0){
					publish = publist.get(0);
				}
				map.put(publishcat, publish);
			}
		} 
		this.setPubMap(map);
		return "toSecPage";
	}
	
	//获取热点发布信息
	public String getHotPublishsUnderpublishCat(){
		String perId = ServletActionContext.getRequest().getParameter("perid");
		List<PublishCat> list = new ArrayList<PublishCat>();
		List<Publish> pubList = new ArrayList<Publish>();
		if(perId != null && perId.length() > 0){
			list = this.getPublishCatService().getPublishCatListJustUnderProjectCat(Integer.parseInt(perId));
		}
		if(list != null && list.size() > 0){
			for(int i=0;i<list.size();i++){
				PublishCat publishcat = list.get(i);
				List<Publish> publist = this.getPublishService().getPublishListBycatId(publishcat.getId().toString());
				if(publist != null && publist.size() > 0){
					pubList.add(publist.get(0));
				}
			}
		}
		this.setMySecPubList(pubList);
		return "toSechotPage";
	}
	
	//最后一个publishcat
	public String gotOnePublishCatSth(){
		String sonPublishcatId = ServletActionContext.getRequest().getParameter("sonPublishcatId"); //发布分类id
		String fatherpublishCatId = ServletActionContext.getRequest().getParameter("fatherpublishCatId");//父分类的id
		if(sonPublishcatId != null && sonPublishcatId.length() > 0){
			PublishCat sonPublishCat = this.getPublishCatService().select(Integer.parseInt(sonPublishcatId));
			if(sonPublishCat != null){
				this.setSonPublishCat(sonPublishCat);
			}
		}
		if(fatherpublishCatId != null && fatherpublishCatId.length() > 0){
			PublishCat fatherPublishCat = this.getPublishCatService().select(Integer.parseInt(fatherpublishCatId));
			if(fatherPublishCat != null){
				this.setFatherPublishCat(fatherPublishCat);
			}
		}
		return "publishthird";
	}
	
	//定位
	public String getThePosionOfNow() throws Exception{
		String pcatId = ServletActionContext.getRequest().getParameter("pucatid");
		if(pcatId != null && pcatId.length() > 0){
			PublishCat cat = this.getPublishCatService().select(Integer.parseInt(pcatId));
			if(cat != null){
				this.setFatherPublishCat(cat);
			}
		}
		return "toFatherposion";
	}
	
	//获取子分类下的发布信息
	public String getAllPublishByCatId(){
		String puid = ServletActionContext.getRequest().getParameter("mypubIds");
		List<Publish> pubList = new ArrayList<Publish>();
		if(puid != null && puid.length() > 0){
			pubList = this.getPublishService().getPublishListBycatId(puid);
		}
		if(pubList != null && pubList.size() > 0){
			this.setMySecPubList(pubList);
		}
		return "pubUnderCat";
	}
		
	/////getter////setter//////
	public String getId(){
		return  id;
	}
	public void  setId(String id){
		this.id = id ;
	}
	 
	public PublishCatService getPublishCatService() {
		return publishCatService;
	}
	public void setPublishCatService(PublishCatService publishCatService) {
		this.publishCatService = publishCatService;
	}
	
	public String getPublishCatId(){
		return  publishCatId;
	}
	public void  setPublishCatId(String publishCatId){
		this.publishCatId = publishCatId ;
	}
	 
	public String getName(){
		return  name;
	}
	public void  setName(String name){
		this.name = name ;
	}
	 
	public String getEnName() {
		return enName;
	}


	public void setEnName(String enName) {
		this.enName = enName;
	}


	public String getDiscription(){
		return  discription;
	}
	public void  setDiscription(String discription){
		this.discription = discription ;
	}
	 
	public String getType(){
		return  type;
	}
	public void  setType(String type){
		this.type = type ;
	}
	 
	 public String getUsername() {
	 	return username;
	 }
	 public void setUsername(String username) {
	 	this.username = username;
	 }
	 
	 public String getTitle() {
			return title;
		}
	 public void setTitle(String title) {
			this.title = title;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public String getTarget() {
			return target;
		}
		public void setTarget(String target) {
			this.target = target;
		}
		public String getIcon() {
			return icon;
		}
		public void setIcon(String icon) {
			this.icon = icon;
		}
		public String getIconOpen() {
			return iconOpen;
		}
		public void setIconOpen(String iconOpen) {
			this.iconOpen = iconOpen;
		}
		public String getCheckboxId() {
			return checkboxId;
		}
		public void setCheckboxId(String checkboxId) {
			this.checkboxId = checkboxId;
		}
		public String getPid() {
			return pid;
		}
		public void setPid(String pid) {
			this.pid = pid;
		}
		
		public List<PublishCat> getJustUnderTopProjectCatPublishCatlist() {
			return justUnderTopProjectCatPublishCatlist;
		}
		public void setJustUnderTopProjectCatPublishCatlist(
				List<PublishCat> justUnderTopProjectCatPublishCatlist) {
			this.justUnderTopProjectCatPublishCatlist = justUnderTopProjectCatPublishCatlist;
		}

		public Map<PublishCat, List<PublishCat>> getMapCatCats() {
			return mapCatCats;
		}
		
		public List<List<PublishCat>> getPublishCatLevel2list() {
			return publishCatLevel2list;
		}
		public void setPublishCatLevel2list(List<List<PublishCat>> publishCatLevel2list) {
			this.publishCatLevel2list = publishCatLevel2list;
		}

		public List<PublishCat> getPublishCatlist() {
			return publishCatlist;
		}
		public void setPublishCatlist(List<PublishCat> publishCatlist) {
			this.publishCatlist = publishCatlist;
		}
		public void setMapCatCats(Map<PublishCat, List<PublishCat>> mapCatCats) {
			this.mapCatCats = mapCatCats;
		}


		public List<PublishCat> getMyUnderCatList() {
			return myUnderCatList;
		}


		public void setMyUnderCatList(List<PublishCat> myUnderCatList) {
			this.myUnderCatList = myUnderCatList;
		}


		public String getSecondCatId() {
			return secondCatId;
		}


		public void setSecondCatId(String secondCatId) {
			this.secondCatId = secondCatId;
		}


		public List<PublishCat> getMySecCatList() {
			return mySecCatList;
		}


		public void setMySecCatList(List<PublishCat> mySecCatList) {
			this.mySecCatList = mySecCatList;
		}


		public PublishService getPublishService() {
			return publishService;
		}


		public void setPublishService(PublishService publishService) {
			this.publishService = publishService;
		}


		public Map getPubMap() {
			return pubMap;
		}


		public void setPubMap(Map pubMap) {
			this.pubMap = pubMap;
		}


		public List<Publish> getMySecPubList() {
			return mySecPubList;
		}


		public void setMySecPubList(List<Publish> mySecPubList) {
			this.mySecPubList = mySecPubList;
		}


		public PublishCat getSonPublishCat() {
			return sonPublishCat;
		}


		public void setSonPublishCat(PublishCat sonPublishCat) {
			this.sonPublishCat = sonPublishCat;
		}


		public PublishCat getFatherPublishCat() {
			return fatherPublishCat;
		}


		public void setFatherPublishCat(PublishCat fatherPublishCat) {
			this.fatherPublishCat = fatherPublishCat;
		}

		public UserService getUserService() {
			return userService;
		}

		public void setUserService(UserService userService) {
			this.userService = userService;
		}

		public String getTags() {
			return tags;
		}

		public void setTags(String tags) {
			this.tags = tags;
		}

		public PublishCat getPublishCat() {
			return publishCat;
		}

		public void setPublishCat(PublishCat publishCat) {
			this.publishCat = publishCat;
		}
		
		public static void main(String[] args) {
			Map totalMap=new HashMap();
			Map tempMap=new HashMap();
			PublishCatAction publishCatAction=new PublishCatAction();
			String date=publishCatAction.getcurrent();
			for (int i = 0; i <3; i++) {
				tempMap.put(i,date);
				for (int j = 0; j < i; j++) {
					totalMap.put(j,tempMap);
				}
			}
			System.out.println(totalMap);
			
		}
		@SuppressWarnings("static-access")
		public String getcurrent() {
			SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String a=df.format(new Date());
			Timestamp ts = new Timestamp(System.currentTimeMillis());  
			ts.valueOf(a);
			return ts.toString();
		}
		/////////////////////////////////////////////////////////////////////////2.0方法///////////////////////
      private List<PublishCat> publishChiledCats;
		private String catTagsList;
		public String typecatOfStory() {
			publishChiledCats=publishCatService.allstorycats();
			return "typecatOfStory";
		}
		public String getTypeCat(){
			
			 List<PublishCat> publishCats=publishCatService.getPublishCatListUnderPid(0);
	    	 int catId = 0;
	    	 for (PublishCat publishCat : publishCats) {
				if(publishCat.getId()==Integer.parseInt(id)){
					catId=publishCat.getId();
					break;
				}
			}
	    	publishChiledCats=publishCatService.getPublishCatListUnderPid(catId); 
	    	
	    	//publish=publishService.select(((Publish)model).getId());
			
			
			
			
			
			
			return "getTypeCat";
		}
		
		
		
		
		public String getTypeCatTags(){
			//System.out.println(id.trim().equals(""));
			if(id.trim().equals("")){
				
				return "getTypeCatTags";
				
			}
			String[] ids=id.split(" ");
			String retu="";//cattags
			
			for (String string : ids) {
				PublishCat cat=publishCatService.select(Integer.parseInt(string));
				String[] catTags=cat.getTags().split(",");
				int num=30/ids.length;
				if(num>catTags.length){
					num=catTags.length;
					
				}
				int[] ret=getRamdom(catTags.length, num);
				for (int i : ret) {
					if(retu==""){
					retu=catTags[i];		
						
					}else{
						retu+=","+catTags[i];
						
						
					}
					
				}
			}
			catTagsList=retu;
			return "getTypeCatTags";
		}

		public List<PublishCat> getPublishChiledCats() {
			return publishChiledCats;
		}

		public void setPublishChiledCats(List<PublishCat> publishChiledCats) {
			this.publishChiledCats = publishChiledCats;
		}
		
		
		
		public String getCatTagsList() {
			return catTagsList;
		}

		public void setCatTagsList(String catTagsList) {
			this.catTagsList = catTagsList;
		}

		public int[] getRamdom(int length,int suiji){
			
			  int[] intRet = new int[suiji];
              int intRd = 0; //存放随机数
              int count = 0; //记录生成的随机数个数
              int flag = 0; //是否已经生成过标志
              while(count<suiji){
            	  Random random=new Random();
                   intRd = random.nextInt(length);
                   for(int i=0;i<count;i++){
                       if(intRet[i]==intRd){
                           flag = 1;
                           break;
                       }else{
                           flag = 0;
                       }
                   }
                   if(flag==0){
                       intRet[count] = intRd;
                       count++;
                   }
          }
			
			return intRet;
		}
		
		
		
}

