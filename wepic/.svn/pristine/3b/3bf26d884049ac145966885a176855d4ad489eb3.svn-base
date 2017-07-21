package com.wetuo.wepic.core.service;
import java.util.List;
import java.util.Map;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.AccountBankWithdraw;
import com.wetuo.wepic.core.dao.AccountBankWithdrawDao;

public class AccountBankWithdrawServiceImpl implements AccountBankWithdrawService {
	AccountBankWithdrawDao domainDao;
	
	
	public AccountBankWithdrawDao getDomainDao() {
		return domainDao;
	}

	public void setDomainDao(AccountBankWithdrawDao domainDao) {
		this.domainDao = domainDao;
	}

	//////////////common crud////////////////
	public List<AccountBankWithdraw> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<AccountBankWithdraw> findPart(String strFields, String[] arrStrValues){ 
		return domainDao.findPart(strFields,arrStrValues);
	}
	
	public Pager list(int pageSize, int pageNo)  {
		return domainDao.list(pageSize,pageNo);
	}//end list()
	
	public Pager list(Map<String,Object> mapSqlParam, int pageSize, int pageNo)  {
		return domainDao.list(mapSqlParam,pageSize,pageNo);
	}//end list()
	
	/////insert///
	public Integer insert(AccountBankWithdraw record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(AccountBankWithdraw record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(AccountBankWithdraw record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public AccountBankWithdraw select(Integer id)  {
		return domainDao.select(id);
	}
	public List<AccountBankWithdraw> findByAccount(int id) {
		return domainDao.findByAccount(id);
	}
	public List<AccountBankWithdraw> findByAccount2(int id) {
		return domainDao.findByAccount2(id);
	}
	public void isdefaultstatu(int id) {
		List<AccountBankWithdraw> bankWithdraws=this.getDomainDao().findbyuserofisdefault(id);
		for (AccountBankWithdraw accountBankWithdraw:bankWithdraws) {
			accountBankWithdraw.setIsdefault(0);
			this.getDomainDao().update(accountBankWithdraw);
		}
	}
	public AccountBankWithdraw defaultAccountBankWithdraw(int id){
		return domainDao.defaultAccountBankWithdraw(id);
	}
}
