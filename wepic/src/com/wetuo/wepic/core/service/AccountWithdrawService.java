package com.wetuo.wepic.core.service ;
 
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.AccountWithdraw;
import common.quickvalid.validators.int_range;
 
public interface AccountWithdrawService {
 
 	List<AccountWithdraw> findAll();
 	List<AccountWithdraw> findPart(String strFields,String[] strArrValues);
 	List<AccountWithdraw> findByAccount(int id);
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public AccountWithdraw select(Integer id);
	public Integer insert(AccountWithdraw record);
	public boolean update(AccountWithdraw record);
   	public boolean delete(AccountWithdraw record);
	public boolean delete(Integer id) ;
	
	public boolean accountWithdrawApplay(AccountWithdraw accountWithdraw,Account account);
	public Pager list(Integer userId,int pageSize, int pageNo);
	public Pager applayList(int pageSize, int pageNo);
	public boolean productApplyForm(int accountWithdrawId, int userId);
	public Pager ifEnsureApplyList(int pageSize, int pageNo);
	public boolean confirmApply(int id,int accountId,int flag);
    ///////////////////////////////wepic2.0//////////////////////////////
	public Pager findbyDetachedCriteria(DetachedCriteria detachedCriteria,int pageNo,int pageSize);
	public List findres();
	public List findresofuser(int accountId);
	public List find(DetachedCriteria detachedCriteria);
	public DetachedCriteria detachedCriteria(int accountId); 
	public Timestamp getcurrent();
	public String getcurrent2();
	public Map applywithdraw(Integer accountId,String userwithdrawMoney,String hiddenbank);
}//end class
