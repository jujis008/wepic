package com.wetuo.wepic.deal.service ;
 
import java.util.*;

import org.springframework.transaction.annotation.Transactional;

import com.wetuo.wepic.deal.beans.BuyAccountOperation;
import com.wetuo.wepic.deal.beans.BuyAccountOperationHistory;
import com.wetuo.wepic.deal.beans.BuyCartDeal;
import com.wetuo.wepic.deal.beans.BuyCommodities;
import com.wetuo.wepic.deal.beans.BuyCommoditiesHistory;
import com.wetuo.wepic.deal.beans.BuyHistory;
import com.wetuo.wepic.deal.dao.BuyHistoryDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class BuyHistoryServiceImpl implements BuyHistoryService {
	BuyHistoryDao domainDao;
	BuyCartDealService buyCartDealService;
	BuyCommoditiesService buyCommoditiesService;
	BuyAccountOperationService buyAccountOperationService;
	BuyCommoditiesHistoryService buyCommoditiesHistoryService;
	BuyAccountOperationHistoryService buyAccountOperationHistoryService;
	public BuyHistoryDao getBuyHistoryDao() {
		return domainDao;
	}//
	public void setBuyHistoryDao(BuyHistoryDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<BuyHistory> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<BuyHistory> findPart(String strFields, String[] arrStrValues){ 
		return domainDao.findPart(strFields,arrStrValues);
	}
	
	public Pager list(int pageSize, int pageNo)  {
		return domainDao.list(pageSize,pageNo);
	}//end list()
	
	public Pager list(String username, int pageSize, int pageNo)  {
		return domainDao.list(username,pageSize,pageNo);
	}//end list()
	
	public Pager list(Map<String,Object> mapSqlParam, int pageSize, int pageNo)  {
		return domainDao.list(mapSqlParam,pageSize,pageNo);
	}//end list()
	
	/////insert///
	public String insert(BuyHistory record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(BuyHistory record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(String id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(BuyHistory record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public BuyHistory select(String id)  {
		return domainDao.select(id);
	}//end select()
	@Transactional
	public boolean tradeTransport() {
		boolean res=false;
		try {
			res=true;
			
			List<BuyCartDeal> buyCartDeals=this.getBuyCartDealService().findAll();
			List<BuyAccountOperation> buyAccountOperations=null;
			List<BuyCommodities> buyCommodities=null;
			List<BuyHistory> buyHistories=null;
			List<BuyCommoditiesHistory> buyCommoditiesHistories=null;
			List<BuyAccountOperationHistory> buyAccountOperationHistories=null;
			
			return res;
		} catch (Exception e) {
			// TODO: handle exception
			return res;
		}
		
	}
	public BuyCartDealService getBuyCartDealService() {
		return buyCartDealService;
	}
	public BuyCommoditiesService getBuyCommoditiesService() {
		return buyCommoditiesService;
	}
	public BuyAccountOperationService getBuyAccountOperationService() {
		return buyAccountOperationService;
	}
	public BuyCommoditiesHistoryService getBuyCommoditiesHistoryService() {
		return buyCommoditiesHistoryService;
	}
	public BuyAccountOperationHistoryService getBuyAccountOperationHistoryService() {
		return buyAccountOperationHistoryService;
	}
	public void setBuyCartDealService(BuyCartDealService buyCartDealService) {
		this.buyCartDealService = buyCartDealService;
	}
	public void setBuyCommoditiesService(BuyCommoditiesService buyCommoditiesService) {
		this.buyCommoditiesService = buyCommoditiesService;
	}
	public void setBuyAccountOperationService(
			BuyAccountOperationService buyAccountOperationService) {
		this.buyAccountOperationService = buyAccountOperationService;
	}
	public void setBuyCommoditiesHistoryService(
			BuyCommoditiesHistoryService buyCommoditiesHistoryService) {
		this.buyCommoditiesHistoryService = buyCommoditiesHistoryService;
	}
	public void setBuyAccountOperationHistoryService(
			BuyAccountOperationHistoryService buyAccountOperationHistoryService) {
		this.buyAccountOperationHistoryService = buyAccountOperationHistoryService;
	}
}//end class
