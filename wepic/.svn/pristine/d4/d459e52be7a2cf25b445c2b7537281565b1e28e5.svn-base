package com.wetuo.wepic.core.service ;
 
import java.util.*;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.MoneyInfo;
import com.wetuo.wepic.core.dao.AccountDao;
import com.wetuo.wepic.common.hibernate.Pager;
 
public class AccountServiceImpl implements AccountService {
	AccountDao domainDao;
	public AccountDao getAccountDao() {
		return domainDao;
	}//
	public void setAccountDao(AccountDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<Account> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<Account> findPart(String strFields, String[] arrStrValues){ 
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
	public Integer insert(Account record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(Account record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(Account record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public Account select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	public Account select(Integer userId, String s) {		
		return domainDao.select(userId, s);
	}
	public void transferMoneyDetail(int fromUserId, int toUserId, int num) throws Exception {
		// TODO Auto-generated method stub
		 domainDao.transferMoneyDetail(fromUserId, toUserId, num) ;
		 //throw new Exception();
	}
	public MoneyInfo countselect(Integer accoundId) {
		// TODO Auto-generated method stub
		return domainDao.countselect(accoundId);
	}
	public MoneyInfo admincountselect(){
		
		
		return domainDao.admincountselect();
	}
	public Pager list(int pageSize, int pageNo,
			DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return domainDao.list(pageSize, pageNo, detachedCriteria);
	}
	
}//end class
