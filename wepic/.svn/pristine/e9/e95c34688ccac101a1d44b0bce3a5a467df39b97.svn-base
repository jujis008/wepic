package com.wetuo.wepic.core.service;

import java.util.List;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.AccountSearchByDate;
public interface AccountSearchByDateService {
	 public Pager searchAccountWithdrawByDate(AccountSearchByDate searchByDate,int pageNo,int pageSize)throws Exception;
	 public Pager searchAccountBankwithdrawByDate(AccountSearchByDate searchByDate,int pageNo,int pageSize);
	 public Pager searchAccountRechargeByDate(AccountSearchByDate searchByDate,int pageNo,int pageSize);
	 public List findresofuser(int accountId);
	 public List findresofuseraccorddate(int accountId,String start,String end);
	 public Pager adminsearchwaitByDate(AccountSearchByDate searchByDate,int pageNo, int pageSize);
	 public Pager adminsearchchecksucByDate(AccountSearchByDate searchByDate,int pageNo, int pageSize);
	 public Pager adminsearchcheckfailByDate(AccountSearchByDate searchByDate,int pageNo, int pageSize);
}
