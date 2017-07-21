package com.wetuo.wepic.deal.service ;
 
import java.util.List;
import java.util.Map;
 
import com.wetuo.wepic.deal.beans.BuyCartDeal;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.util.BuyCart;
import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.User;
 
public interface BuyCartDealService {
 
 	List<BuyCartDeal> findAll();
 	List<BuyCartDeal> findPart(String strFields,String[] strArrValues);
 	
	public Pager list(int pageSize, int pageNo)  ;
	public Pager list(String username, int pageSize, int pageNo) ;
	public Pager list(Map<String,Object>  mapSqlParam, int pageSize, int pageNo) ;
   	public BuyCartDeal select(String id);
	public String insert(BuyCartDeal record);
	public boolean update(BuyCartDeal record);
   	public boolean delete(BuyCartDeal record);
	public boolean delete(String id) ;
	public boolean dealCart(List<Account> list);
	public String dealBusiness(BuyCart buyCart,User user,BuyCartDeal buyCartDeal);
	public BuyCartDeal currentDeal(User user);
 
}//end class
