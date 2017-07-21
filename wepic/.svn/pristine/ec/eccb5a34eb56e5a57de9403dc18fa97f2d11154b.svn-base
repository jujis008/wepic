package com.wetuo.wepic.core.service;

import java.util.List;
import java.util.Map;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.AccountBankWithdraw;

public interface AccountBankWithdrawService {
	List<AccountBankWithdraw> findAll();
 	List<AccountBankWithdraw> findPart(String strFields,String[] strArrValues);
 	List<AccountBankWithdraw> findByAccount(int id);
 	List<AccountBankWithdraw> findByAccount2(int id);
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public AccountBankWithdraw select(Integer id);
	public Integer insert(AccountBankWithdraw record);
	public boolean update(AccountBankWithdraw record);
   	public boolean delete(AccountBankWithdraw record);
	public boolean delete(Integer id) ;
	public void isdefaultstatu(int id);
	public AccountBankWithdraw defaultAccountBankWithdraw(int id);
}
