package com.wetuo.wepic.deal.service ;
 
import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.fop.layout.Page;
import org.hibernate.criterion.DetachedCriteria;
 
import com.wetuo.wepic.deal.beans.Bid;
import com.wetuo.wepic.deal.beans.BidResponseInvited;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface BidService {
	
	public String uploadFile(File myfile,String fileName)throws Exception;
   	public Bid select(String id);
	public String insert(Bid record);
	public Pager findbidList(DetachedCriteria  criteria,int nowPage,int pageSize);
	public Pager findAllMyBidForFrontend(DetachedCriteria  criteria,int nowPage,int pageSize);
	public Pager findbidListf(DetachedCriteria criteria, int nowPage,int pageSize);
	
	/*******************************************2.0的方法*****************************************/
 
 	List<Bid> findAll();
 	List<Bid> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager checkedBid(int pageSize, int pageNo,String param) ;
	
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;

	public boolean update(Bid record);
   	public boolean delete(Bid record);
	public boolean delete(String id) ;
	public Pager findPublicBidList(String username, int pageSize, int pageNo);
	 public List<?> findByendPriod(String endTime);
	 public Pager cancelbidList(String username, int pageSize, int pageNo) ;
	 public List<Bid> selectByFrontPage(String typeId,int pageNo, int pageSize);
	 public List<Bid> selectByFrontPage2(String typeId,int pageNo,int pageSize);
	 public Pager selectByteyuePage(final String typeId,final int pageNo,final int pageSize);
    public List<?> selectBidMsg(int id);
    public List<?> selectResonBid( int id);
    public  List<Bid> bidList(DetachedCriteria  criteria);
    public Pager selectFindSerarch(String position,String type,String dateTime,String price,String satues,int pageSize, int pageNo);
	 
}//end class
