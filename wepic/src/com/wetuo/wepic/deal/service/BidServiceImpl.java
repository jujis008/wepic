package com.wetuo.wepic.deal.service ;
 
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.fop.layout.Page;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DaoSupport;

import com.tools.Cleandar;
import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.beans.BidCat;
import com.wetuo.wepic.deal.beans.BidDetailCount;
import com.wetuo.wepic.deal.beans.BidResponseInvited;
import com.wetuo.wepic.deal.dao.BidDao;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.util.UploadUtils;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.UserService;
 
public class BidServiceImpl implements BidService {
	BidDao domainDao;
	private UserService userService;
	private BidResponseInvitedService bidResponseInvitedService;
	private BidCatservice bidCatservice;
	public BidDao getBidDao() {
		return domainDao;
	}//
	
	
	public UserService getUserService() {
		return userService;
	}


	public void setUserService(UserService userService) {
		this.userService = userService;
	}


	public void setBidDao(BidDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	public BidResponseInvitedService getBidResponseInvitedService() {
		return bidResponseInvitedService;
	}
	public void setBidResponseInvitedService(
			BidResponseInvitedService bidResponseInvitedService) {
		this.bidResponseInvitedService = bidResponseInvitedService;
	}
	//////////////common crud////////////////
	public List<Bid> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<Bid> findPart(String strFields, String[] arrStrValues){ 
		return domainDao.findPart(strFields,arrStrValues);
	}
	
	public Pager list(int pageSize, int pageNo)  {
		return domainDao.list(pageSize,pageNo);
	}//end list()
	
	public Pager list(String username, int pageSize, int pageNo)  {
		return domainDao.list(username,pageSize,pageNo);
	}//end list()
	
	
	public Pager cancelbidList(String username, int pageSize, int pageNo)  {
		return domainDao.cancelbidList(username,pageSize,pageNo);
	}//end list()
	
	
	public Pager list(Map<String,Object> mapSqlParam, int pageSize, int pageNo)  {
		return domainDao.list(mapSqlParam,pageSize,pageNo);
	}//end list()
	
	/////insert///
	public String insert(Bid record) {
		
		
		
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(Bid record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(String id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(Bid record)  {
		return domainDao.update(record);
	}//end update()
	
	
	/////select///
	public Bid select(String id)  {
//		Bid b=domainDao.select(id);
//		System.out.println("xxxxxxxxxxxxxxx");
		return domainDao.select(id);
		
	}//end select()
	
	public Pager findPublicBidList(String username, int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.findPublicBidList(username, pageSize, pageNo);
	}
	
	
	 public List<?> findByendPriod(String endTime){
		 return domainDao.findByendPriod(endTime);
	 }
	 
	 public List<Bid> selectByFrontPage(String typeId,int pageNo, int pageSize){
		 return (List<Bid>)domainDao.selectByFrontPage(typeId, pageNo,  pageSize);
		 
	 }
	public Pager selectByteyuePage(String typeId, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return   domainDao.selectByteyuePage(typeId, pageNo, pageSize);
	}
	public List<?> selectBidMsg(int id) {
		// TODO Auto-generated method stub
		return domainDao.selectBidMsg(id);
	}
	public List<?> selectResonBid(int id) {
		// TODO Auto-generated method stub
		return domainDao.selectResonBid(id);
	}
	public List<Bid> selectByFrontPage2(String typeId, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return domainDao.selectByFrontPage2(typeId, pageNo, pageSize);
	}
	public Pager selectFindSerarch(String position, String type,
			String dateTime, String price, String satues,int pageSize, int pageNo) {
		// TODO Auto-generated method stub
		return domainDao.selectFindSerarch(position, type, dateTime, price, satues,pageSize,pageNo);
	}
	public Pager checkedBid( int pageSize, int pageNo,String param) {
		// TODO Auto-generated method stub
		return domainDao.checkedBid( pageSize, pageNo,param);
	}
	public  List<Bid> bidList(DetachedCriteria  criteria){	
		
		return domainDao.bidList(criteria);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//文件上传 之附件上传
	public String uploadFile(File myfile,String fileName) throws Exception{
		UploadUtils uploadUtils=new UploadUtils();
		return uploadUtils.upAppendix(myfile,fileName);
		
	}
	public Pager findbidList(DetachedCriteria criteria, int nowPage,int pageSize) {
		Pager  pager=domainDao.findbidList(criteria, nowPage, pageSize);
		List<Bid> bids=(List<Bid>) pager.getResultList();
		List<Bid> newbids=new ArrayList<Bid>();
		for (Bid bid : bids) {
			DetachedCriteria detachedCriteria=DetachedCriteria.forClass(BidResponseInvited.class);
			detachedCriteria.createAlias("bid", "bid");
			detachedCriteria.add(Restrictions.eq("bid", bid));
			BidDetailCount bidDetailCount=new BidDetailCount();
			bidDetailCount.setRenshu(bidResponseInvitedService.findAll(detachedCriteria).size());
		    bid.setBidDetailCount(bidDetailCount);
		    newbids.add(bid); 
		}
		pager.setResultList(newbids);
		return pager;
	}
	public Pager findAllMyBidForFrontend(DetachedCriteria  criteria,int nowPage,int pageSize){
		
		Pager  pager=domainDao.findbidList(criteria, nowPage, pageSize);
		List<Bid> bids=(List<Bid>) pager.getResultList();
		for (Bid bid : bids) {
			int userId=bid.getUser().getId();
			User user=userService.selectById(userId);
			bid.setUser(user);
			bid.setContent(Cleandar.getTimer(bid.getStartTime()));
		}
		
		return pager;
	}
	
	public Pager findbidListf(DetachedCriteria criteria, int nowPage,int pageSize) {
		Pager  pager=domainDao.findbidList(criteria, nowPage, pageSize);
		List<Bid> bids=(List<Bid>) pager.getResultList();
		//List<Bid> newbids=new ArrayList<Bid>();
		for (Bid bid : bids) {
		String mon=bid.getTotalMoney()+"";//.split(".");
		String[] mons=mon.split("\\.");
		if(Integer.parseInt(mons[1])<1){
			
			bid.setTotalMoney(Double.parseDouble(mons[0]));
			
		}
		
		BidCat bidCat=bidCatservice.findById(bid.getType());
		bid.setBidCat(bidCat);
		String content=Cleandar.getTimer(bid.getStartTime());
        bid.setContent(content);
		}
		//pager.setResultList(newbids);
		return pager;
	}


	public BidCatservice getBidCatservice() {
		return bidCatservice;
	}


	public void setBidCatservice(BidCatservice bidCatservice) {
		this.bidCatservice = bidCatservice;
	}
	
	
	
	
	
	

}//end class
