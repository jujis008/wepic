package com.wetuo.wepic.core.service ;
 
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
 
import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.MoneyInfo;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface AccountService {
 
 	List<Account> findAll();
 	List<Account> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public Account select(Integer id);
   	public Account select(Integer userId,String s);
	public Integer insert(Account record);
	public boolean update(Account record);
   	public boolean delete(Account record);
	public boolean delete(Integer id) ;
	public void transferMoneyDetail(int fromUserId,int toUserId,int num) throws Exception ;
	public MoneyInfo countselect(Integer accoundId);
	public MoneyInfo admincountselect();
	public Pager list(final int pageSize,final int pageNo,DetachedCriteria detachedCriteria);	
 
}//end class
