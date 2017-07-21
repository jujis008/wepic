package com.wetuo.wepic.core.service ;
 
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.AccountRecharge;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.dao.AccountRechargeDao;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.deal.beans.BuyAccountOperation;
 
public class AccountRechargeServiceImpl implements AccountRechargeService {
	AccountRechargeDao domainDao;
	public AccountRechargeDao getAccountRechargeDao() {
		return domainDao;
	}//
	public void setAccountRechargeDao(AccountRechargeDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<AccountRecharge> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<AccountRecharge> findPart(String strFields, String[] arrStrValues){ 
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
	public Integer insert(AccountRecharge record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(AccountRecharge record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(AccountRecharge record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public AccountRecharge select(Integer id)  {
		return domainDao.select(id);
	}
	@Transactional
	public boolean addMoney(int accountuserId,BigDecimal money, AccountService accountService,UserService userService,String orderId) {
		AccountRecharge recharge1 = null;
		try{
			recharge1=domainDao.selectEntity(orderId);
			if(recharge1==null){
				Account account=accountService.select(accountuserId, "");
				account.setTotalMoney(money.add(account.getTotalMoney()));
				account.setRemainingMoney(money.add(account.getRemainingMoney()));
				accountService.update(account);
				AccountRecharge recharge=new AccountRecharge();
				recharge.setAccount(account);
				recharge.setAccountID(account.getAccountID());
				recharge.setOrderId(orderId);
				//recharge.setConfirmTime(0);
				recharge.setRechargeMoney(money);
				recharge.setRechargeTime(new Timestamp(new Date().getTime()));	
				User user=userService.selectById(accountuserId);
				recharge.setUser(user);
			 	domainDao.insert(recharge);
			}else return false;
		return true;
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
	}
	public List<AccountRecharge> findByAccount(int id) {
		return domainDao.findByAccount(id);
	}
	
	
	
	
}//end class
