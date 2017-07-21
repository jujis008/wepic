package com.wetuo.wepic.core.dao;

import java.util.List;
import java.util.Map;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.AccountBankWithdraw;

public interface AccountBankWithdrawDao {
	List<AccountBankWithdraw> findAll();
 	List<AccountBankWithdraw> findPart(String strFields,String[] strArrValues);
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public AccountBankWithdraw select(Integer id);
	public Integer insert(AccountBankWithdraw record);
	public boolean update(AccountBankWithdraw record);
   	public boolean delete(AccountBankWithdraw record);
	public boolean delete(Integer id) ;
	public AccountBankWithdraw selectEntity(String id);
	public List findByAccount(int id);
	public List findByAccount2(int id);
	public List<AccountBankWithdraw> findbyuserofisdefault(int id);
	public AccountBankWithdraw defaultAccountBankWithdraw(int id);
}
