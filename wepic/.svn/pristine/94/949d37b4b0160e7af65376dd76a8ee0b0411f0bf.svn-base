package com.wetuo.wepic.core.service ;
 
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.core.beans.AccountRecharge;
import com.wetuo.wepic.common.hibernate.Pager;
 
public interface AccountRechargeService {
 
 	List<AccountRecharge> findAll();
 	List<AccountRecharge> findPart(String strFields,String[] strArrValues);
 	List<AccountRecharge> findByAccount(int id);
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public AccountRecharge select(Integer id);
	public Integer insert(AccountRecharge record);
	public boolean update(AccountRecharge record);
   	public boolean delete(AccountRecharge record);
	public boolean delete(Integer id) ;
	public boolean addMoney(int accountuserId,BigDecimal money, AccountService accountService,UserService userService ,String orderId) ;
}//end class
