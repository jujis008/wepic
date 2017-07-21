package com.wetuo.wepic.deal.actions ;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.sql.Timestamp;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.tools.Cleandar;
import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.beans.BidCat;
import com.wetuo.wepic.deal.beans.BidMarkCount;
import com.wetuo.wepic.deal.beans.BidResponseInvited;
import com.wetuo.wepic.deal.beans.BidStatus;
import com.wetuo.wepic.deal.beans.Industry;
import com.wetuo.wepic.deal.service.BidCatServiceImp;
import com.wetuo.wepic.deal.service.BidCatservice;
import com.wetuo.wepic.deal.service.BidForOpusService;
import com.wetuo.wepic.deal.service.BidMarkCountService;
import com.wetuo.wepic.deal.service.BidResponseInvitedService;
import com.wetuo.wepic.deal.service.BidService;
import com.wetuo.wepic.deal.service.BidStatusService;
import com.wetuo.wepic.deal.service.BidtransactionService;
import com.wetuo.wepic.deal.service.IndusterService;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserCreditService;
import com.wetuo.wepic.core.service.UserService;
 
import com.wetuo.wepic.common.hibernate.PageSize;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.common.struts.Constants;
import com.wetuo.wepic.common.struts.RegExpression;
import com.wetuo.wepic.common.util.FileUploadStatus;
import com.wetuo.wepic.common.util.MyProgressListener;
import com.wetuo.wepic.common.util.PictureUtil;
import com.wetuo.wepic.common.util.UploadUtils;
 
@SuppressWarnings("serial")  
public class BidAction extends PageAction {
	private static final long serialVersionUID = 1L;
	public BidAction(String className) {
		try{
		model=Class.forName(className).newInstance();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
    //新增约拍
    public String addBid() throws Exception{
    	int id=super.getLonginUserId();
	   if(id==0){   
        return "login";		   
	   }
	   User user=new User();
	   user.setId(id);
	   Bid bid=(Bid)model;
	   bid.setUser(user);
	   bid.setStartTime(new Timestamp(new Date().getTime()));
	   bid.setStatus(8);
	   bid.setSaveFrarite(0);
	   bid.setBidGood(0);
	   bid.setBidView(0);
	   //通过件数算总价
	   if(bid.getUnitpriceType()==1){
		   bid.setTotalMoney(bid.getUnitpriceProduct()*bid.getSumProdct());
	   }
	   else if(bid.getUnitpriceType()==4){
		   bid.setTotalMoney(bid.getUnitpriceProduct()*bid.getSumProdct());
	   }
	   else if(bid.getUnitpriceType()==6){
		   bid.setTotalMoney(bid.getUnitpriceProduct()*bid.getSumProdct());
	   }
	   else if(bid.getUnitpriceType()==2){
		   if(bid.getSumProductPhoto()!=5){
		   bid.setTotalMoney(bid.getUnitpriceProduct()*bid.getRecruitNum());
		   }else{
			   
			   bid.setTotalMoney(bid.getUnitpriceProduct()*bid.getRecruitNum()*bid.getSumProdct()); 
			   
		   }
	   }
	   else if(bid.getUnitpriceType()==3){
		   if(bid.getSumProductPhoto()!=5){
		   double totalMoney=bid.getUnitpriceProduct()*bid.getRecruitNum();
		   bid.setTotalMoney(totalMoney);
		   }else{
		   
		   bid.setTotalMoney(bid.getUnitpriceProduct()*bid.getRecruitNum()*bid.getSumProdct()); 
		   
	   }
		   //bid.setTotalMoney(bid.getUnitpriceProduct()*bid.getRecruitNum());   
	   }
	   else if(bid.getUnitpriceType()==3){
		   double totalMoney=bid.getUnitpriceProduct()*bid.getRecruitNum();
		   bid.setTotalMoney(totalMoney);
		   //bid.setTotalMoney(bid.getUnitpriceProduct()*bid.getRecruitNum());   
	   }

	   
	   
	   BidStatus bidStatus=new BidStatus();
	   bidStatus.setBid(bid);
	   bidStatus.setPublishBid("1");
	   bidStatus.setAdminChecked("0");
	   bidStatus.setAdminCheckNotPass("0");
	   bidStatus.setCancelBid("0");
	   bidStatus.setWorking("0");
	   bidStatus.setEndBid("0");
	   
	   bidStatusService.saveStatus(bidStatus);
	   bid.setBidStatus(bidStatus);
	  
	   bidService.insert(bid);
	   if(userIds!=null&&userIds.trim().contains(",")){
		   String[] uids=userIds.split(",");
		   for(int i=0;i<uids.length;i++){
		
			 String chaat=uids[i];
			 if(chaat.trim()!=""){
		     User user2=new User();
				user2.setId(Integer.parseInt(chaat));
				 BidResponseInvited bidResponseInvited=new BidResponseInvited();
				  bidResponseInvited.setBid(bid);
				  bidResponseInvited.setUser(user);
				  bidResponseInvited.setIsInvited(0);
				  bidResponseInvited.setReponseTime(new Timestamp(new Date().getTime()));
				  bidResponseInvited.setTaskFinished(0);
				  bidResponseInvited.setIsCheck(0);
				  bidResponseInvited.setWaitingPeople("0");
				  bidResponseInvited.setIsResponse(0);
				  bidResponseInvited.setIsConfirmed(0);
				  responseInvitedService.insert(bidResponseInvited);
			   }
			   
		   }
		   
		   
	   }
	   
	   
	   
	   
	   
//	   if(bid.getType()==2){
//	    if(bid.getUnitpriceType()==1){
//		  double totalMoeny=bid.getUnitpriceProduct()*bid.getSumProdct();  
//		   }
//	      else if(bid.getUnitpriceType()==2){
//			  if(bid.getTag().contains("产品拍摄")){
//		      double totalMoney=bid.getUnitpriceProduct()*bid.getSumProdct()*bid.getSumProductPhoto();  
//		      bid.setTotalMoney(totalMoney);
//		        }else{
//		      double totalMoney=bid.getUnitpriceProduct()*bid.getSumProductPhoto();  
//		      bid.setTotalMoney(totalMoney);
//		        }
//	    
//	  
//	   }
//	    else if(bid.getUnitpriceType()==3){
//			  if(bid.getTag().contains("产品拍摄")){
//		      double unicMoney=bid.getTotalMoney()/bid.getSumProdct()/bid.getSumProductPhoto(); 
//		      bid.setUnitpriceProduct(unicMoney);
//		        }else{
//		      double unicMoney=bid.getUnitpriceProduct()/bid.getSumProductPhoto(); 
//		      bid.setUnitpriceProduct(unicMoney);
//		        }
//	    
//	  
//	   }
//	   
//	   }
//	   
//	   else if(bid.getType()==1){
//		   if(bid.getUnitpriceType()==2){
//			
//		       }
//		   
//		   
//		   
//	   }
//	   
	  return "successBid"; 
	   
   }
    
    
    
    //新增约拍创意设计独用
    public String addBidforCySj() throws Exception{
    	int id=super.getLonginUserId();
	   if(id==0){   
        return "login";		   
	   }
	   User user=new User();
	   user.setId(id);
	   Bid bid=(Bid)model;
	   bid.setUser(user);
	   bid.setStartTime(new Timestamp(new Date().getTime()));
	   bid.setStatus(8);
	   bid.setSaveFrarite(0);
	   bid.setBidGood(0);
	   bid.setBidView(0);
	   
	   if(bid.getSumProdct()!=null&&bid.getSumProdct()!=0){
		   bid.setTotalMoney(bid.getUnitpriceProduct()*bid.getSumProdct()); 
	   }
	   BidStatus bidStatus=new BidStatus();
	   bidStatus.setBid(bid);
	   bidStatus.setPublishBid("1");
	   bidStatus.setAdminChecked("0");
	   bidStatus.setAdminCheckNotPass("0");
	   bidStatus.setCancelBid("0");
	   bidStatus.setWorking("0");
	   bidStatus.setEndBid("0");
	   bidStatusService.saveStatus(bidStatus);
	   bid.setBidStatus(bidStatus);
	  
	   bidService.insert(bid);
	  return "successBid"; 
	   
   }
    
    
    
    public String showBidDetail() throws Exception{
    	bid=bidService.select(((Bid)model).getId());
    	BidStatus bidStatus=bidStatusService.findById(bid.getBidStatus().getStatuId());
        BidCat bidCat =bidCatservice.findById(bid.getType());
        bid.setBidCat(bidCat);
    	bid.setBidStatus(bidStatus);
    	String content=Cleandar.getTimer(bid.getStartTime());
        bid.setContent(content);
    	
    	
    	
    	return "showBidDetail";
    }
    
    
    
  
    
    public String showBidOpusDetail() throws Exception{
    	bid=bidService.select(((Bid)model).getId());
    	BidStatus bidStatus=bidStatusService.findById(bid.getBidStatus().getStatuId());
        BidCat bidCat =bidCatservice.findById(bid.getType());
        bid.setBidCat(bidCat);
    	bid.setBidStatus(bidStatus);
    	String content=Cleandar.getTimer(bid.getStartTime());
        bid.setContent(content);
       String hangye=bid.getAppendix();
       String lung="";
      if(hangye!=null&&hangye.trim().length()>1){
      
       String[] str=hangye.split(",");
     
       for (String string : str) {
      Industry industry=industerService.getById(Integer.parseInt(string));
      lung+="  "+industry.getName();	
	}
      }
       int viProjct=0;
       int viAppliaction=0;
       if(bid.getSjProjectVI()!=null&&bid.getSjProjectVI().trim().length()>0){
        viProjct=bid.getSjProjectVI().split(",").length;
       }
       if(bid.getViApplication()!=null&&bid.getViApplication().trim().length()>0){
        viAppliaction=bid.getViApplication().split(",").length;
          }
     //  if(bid.getNumFont()==null||bid.getNumFont().trim().length()==0){
    	   bid.setViCount(viAppliaction+viProjct);//(+"");
    //   }
     bid.setAppendix(lung);
       
       
       
       
    	
    	
    	return "showBidOpusDetail";
    	
    	
    	
    	
    	
    	
    }
    
  
    //附件上传
    public String uploadAccessories() {
    		
    	try {
			httpurl=bidService.uploadFile(accessories,accessoriesFileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
    	
	    return "uploadAccessories";
	 
 }
   //删除图片
    public String deleteFiled(){
    	mes="faile";
    	UploadUtils utils=new UploadUtils();
    	utils.deleteFile(fileName, "appendix");
    	mes="suce";
//    	String savePath=ServletActionContext.getServletContext().getRealPath("/back/personalCentr/bid/accessories");
//    	File file=new File(savePath+"/"+fileName); 
//    	
//    	if(file.exists()){
//    		if(file.delete()){
//    			
//    			
//    		}
//    		
//    	}
    	
    	return "deleteFiled";
    }
    
    
    
    public String findAllMyBid(){
    	User user=new User();
    	int id=super.getLonginUserId();
    	if(id==0){
    		
    		return "login";
    	}
    	user.setId(id);
    	DetachedCriteria criteria=DetachedCriteria.forClass(Bid.class);
    	criteria.createAlias("user", "user");
    	criteria.createAlias("bidStatus", "bidStatus");
    	criteria.add(Restrictions.eq("bidStatus.adminCheckNotPass", "0"));
    	criteria.add(Restrictions.eq("user", user));
    	super.pager=bidService.findbidList(criteria,nowPage, 8);//(criteria);
    	DetachedCriteria detachedCriteria=DetachedCriteria.forClass(BidResponseInvited.class);
    	detachedCriteria.createAlias("user", "user");
    	detachedCriteria.add(Restrictions.eq("user.id", user.getId()));
    	detachedCriteria.add(Restrictions.eq("isConfirmed", 1));
    
    	int size=responseInvitedService.findAll(detachedCriteria).size();
    	bidMarkCount=bidMarkCountService.getBidMarkCount(user);
    	if(size!=0){
    		bidMarkCount.setChapinl(bidMarkCount.getBadMark()/size*100);	
    		bidMarkCount.setHaopl(bidMarkCount.getGoodMark()/size*100);
    		bidMarkCount.setChenggonglv(size/bidMarkCount.getYingYueBidCount()*100);
    	}else{
    		
    		bidMarkCount.setChapinl(0);	
    		bidMarkCount.setHaopl(0);
    		bidMarkCount.setChenggonglv(0);
    	}
    	return "findAllMyBid";
    	
    }
    
    
    
    
    /*
    public String findAllMyBidForFrontend(){
    	// System.out.println(msg);
    	
    	 DetachedCriteria criteria=DetachedCriteria.forClass(Bid.class);
    	 criteria.createAlias("bidStatus", "bidStatus");
    	 criteria.add(Restrictions.eq("bidStatus.adminCheckNotPass", "0"));
    	 super.pager=bidService.findAllMyBidForFrontend(criteria,nowPage, 8);//(criteria);
   
    	return "findAllMyBidForFrontend";
    	
    }
    
    */
    /*数据初始化
     * *
     */
    public String findAllMyBid123(){
    	List<User> list=  userService.findAll();
    	for (User user : list) {
    		BidMarkCount bidMarkCount=new BidMarkCount();
    		bidMarkCount.setBadMark(0);
    		bidMarkCount.setBidCount(0);
    		bidMarkCount.setGoodMark(0);
    		bidMarkCount.setTotalBidMoenyForShouRu(0);
    		bidMarkCount.setTotalBidMoenyForZhichu(0);
    		bidMarkCount.setYingYueBidCount(0);
    		bidMarkCount.setFabuBidCount(0);
    		bidMarkCount.setUser(user);
    		bidMarkCountService.saveBidMarkCount(bidMarkCount);
			
		}
    	
    	return "findAllMyBid";
    	
    }
    
    
    
    /*
     * wepic2.0改进版约拍
     * 
     * */
    //发布约拍
    public String deleteBidNoPerson(){
    Bid bid=bidService.select(((Bid)model).getId());
  
    DetachedCriteria detachedCriteria=DetachedCriteria.forClass(BidResponseInvited.class);
    detachedCriteria.createAlias("bid", "bid");
    detachedCriteria.add(Restrictions.eq("bid.id", bid.getId()));
    List<BidResponseInvited> BidResponseInviteds=responseInvitedService.findAll(detachedCriteria);
    for (BidResponseInvited bidResponseInvited : BidResponseInviteds) {
		responseInvitedService.delete(bidResponseInvited);
	}
    String bidStuId=bid.getBidStatus().getStatuId();
    bidService.delete(bid);
    bidStatusService.deleteStatus(bidStuId);
  //  responseInvitedService.
    	return "deleteBidNoPerson";
    	
    }
   
   
    //查找可以邀请的人
    public String chooseFrider(){
    	DetachedCriteria detachedCriteria=DetachedCriteria.forClass(User.class);
    	detachedCriteria.createAlias("userCat", "userCat");
    	detachedCriteria.add(Restrictions.eq("userCat.type", "photography"));
    	super.pager=userService.listDetaChedCriteri(detachedCriteria,nowPage, 10);
    	return "chooseFrider";
    }
    
    
    
    
    
    
      //前台方法
     public String fpageList(){
    	DetachedCriteria criteria=DetachedCriteria.forClass(Bid.class);
    	criteria.createAlias("bidStatus", "bidStatus");
    	criteria.add(Restrictions.eq("bidStatus.adminCheckNotPass", "0"));
    	super.pager=bidService.findbidListf(criteria,nowPage, PageSize.frontbidSize);//(criteria);
    	return "fpageList";
    }
    //根据条件检索
    public String retrievalBid(){
    	DetachedCriteria detachedCriteria=DetachedCriteria.forClass(BidResponseInvited.class);
    	//detachedCriteria.setProjection(Projections.rowCount());
    	
       detachedCriteria.createAlias("bid", "bid");
       detachedCriteria.setProjection(
       Projections.count("bid.id").as("bid.id"))
       .setProjection(Projections.groupProperty("bid.id"));
     //  detachedCriteria.add(Restrictions.sq)
    	try{
    	super.pager=bidService.findbidListf(detachedCriteria,nowPage, PageSize.frontbidSize);//(criteria);
    	List<BidResponseInvited> list=(List<BidResponseInvited>)super.pager.getResultList();
    	for (BidResponseInvited bidResponseInvited : list) {
			System.out.println(bidResponseInvited.getId());
		}
    	}catch (Exception e) {
		e.printStackTrace();
		}
       
    	
    	
    	return "retrievalBid";
    }
    //推荐项目
    public String goodProject(){
    Bid bid=bidService.select(((Bid)model).getId());
    bid.setBidGood(bid.getBidGood()+1);
    return "goodProject";
    }
    
    public String showBidF(){
    	Bid bid=bidService.select(((Bid)model).getId());
        bid.setBidView(bid.getBidView()+1);
       BidCat bidCat= bidCatservice.findById(bid.getType());
    	bid.setBidCat(bidCat);
    	return "showBidF";
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    private  BidService  bidService;
	//附件
	private File accessories;
	private String accessoriesFileName;
	private  String accessoriesContentType;
	//上传文件网络路径
	private String httpurl;
	private UserService userService;
	private UserCreditService creditService;
	private BidForOpusService bidForOpusService;
	private BidResponseInvitedService responseInvitedService;
	private BidtransactionService bidtransaction;
	private String fileName;
	private String mes;
	private int nowPage=1;
    private BidMarkCountService bidMarkCountService; 
	private BidMarkCount bidMarkCount;   
	private Bid bid;
	private BidStatusService bidStatusService;
	private BidCatservice bidCatservice;
	private IndusterService industerService;
	private String msg;
	private String userIds;
	public BidService getBidService() {
		return bidService;
	}
	
	
	public void setBidService(BidService bidService) {
		this.bidService = bidService;
	}
	public File getAccessories() {
		return accessories;
	}
	public void setAccessories(File accessories) {
		this.accessories = accessories;
	}
	public String getHttpurl() {
		return httpurl;
	}
	public void setHttpurl(String httpurl) {
		this.httpurl = httpurl;
	}
	public UserService getUserService() {
		return userService;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public UserCreditService getCreditService() {
		return creditService;
	}
	public void setCreditService(UserCreditService creditService) {
		this.creditService = creditService;
	}
	public BidForOpusService getBidForOpusService() {
		return bidForOpusService;
	}
	public void setBidForOpusService(BidForOpusService bidForOpusService) {
		this.bidForOpusService = bidForOpusService;
	}
	
	public BidResponseInvitedService getResponseInvitedService() {
		return responseInvitedService;
	}
	
	public void setResponseInvitedService(
			BidResponseInvitedService responseInvitedService) {
		this.responseInvitedService = responseInvitedService;
	}
	
	public BidtransactionService getBidtransaction() {
		return bidtransaction;
	}
	public void setBidtransaction(BidtransactionService bidtransaction) {
		this.bidtransaction = bidtransaction;
	}
	
	public String getAccessoriesFileName() {
		return accessoriesFileName;
	}
	
	public void setAccessoriesFileName(String accessoriesFileName) {
		this.accessoriesFileName = accessoriesFileName;
	}
	
	public String getAccessoriesContentType() {
		return accessoriesContentType;
	}
	
	public void setAccessoriesContentType(String accessoriesContentType) {
		this.accessoriesContentType = accessoriesContentType;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public BidMarkCountService getBidMarkCountService() {
		return bidMarkCountService;
	}

	public void setBidMarkCountService(BidMarkCountService bidMarkCountService) {
		this.bidMarkCountService = bidMarkCountService;
	}

	public BidMarkCount getBidMarkCount() {
		return bidMarkCount;
	}

	public void setBidMarkCount(BidMarkCount bidMarkCount) {
		this.bidMarkCount = bidMarkCount;
	}

	public Bid getBid() {
		return bid;
	}

	public void setBid(Bid bid) {
		this.bid = bid;
	}

	public BidStatusService getBidStatusService() {
		return bidStatusService;
	}

	public void setBidStatusService(BidStatusService bidStatusService) {
		this.bidStatusService = bidStatusService;
	}

	public BidCatservice getBidCatservice() {
		return bidCatservice;
	}

	public void setBidCatservice(BidCatservice bidCatservice) {
		this.bidCatservice = bidCatservice;
	}

	public IndusterService getIndusterService() {
		return industerService;
	}

	public void setIndusterService(IndusterService industerService) {
		this.industerService = industerService;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getUserIds() {
		return userIds;
	}

	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}	
	
	
	
}
	
	
//end class
