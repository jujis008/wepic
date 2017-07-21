package com.wetuo.wepic.core.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.AccountBankWithdraw;
import com.wetuo.wepic.core.beans.AccountRecharge;
import com.wetuo.wepic.core.beans.AccountSearchByDate;
import com.wetuo.wepic.core.beans.AccountWithdraw;
@SuppressWarnings("unchecked")
public class AccountSearchByDateServiceImpl implements AccountSearchByDateService {
	private AccountWithdrawService accountWithdrawService;
	private AccountBankWithdrawService accountBankWithdrawService;
	private AccountRechargeService accountRechargeService;
	private AccountService accountService;
	
	public List findresofuser(int accountId){
		return accountWithdrawService.findresofuser(accountId);
	}
	public List findresofuseraccorddate(int accountId,String start,String end){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DetachedCriteria criteria1=DetachedCriteria.forClass(AccountWithdraw.class,"accountWithdraw");
		Account account=accountService.select(accountId);
		criteria1.createAlias("accountWithdraw.account", "account");
		criteria1.add(Restrictions.eq("account.id",account.getId()));
		try {
			criteria1.add(Restrictions.between("accountWithdraw.withdrawTime",format.parse(start),format.parse(end)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<AccountWithdraw> list=this.getAccountWithdrawService().find(criteria1);
		List resList=new LinkedList();
		int totalnum=0;
		BigDecimal totalmoney=new BigDecimal(0);   
		for (AccountWithdraw accountWithdraw:list) {
			totalmoney=totalmoney.add(accountWithdraw.getWithdrawMoney());
		}
		totalnum=list.size();
		resList.add(0,totalnum);
		resList.add(1,totalmoney);
		return resList;
	}
	public Pager searchAccountBankwithdrawByDate(
			AccountSearchByDate searchByDate, int pageNo, int pageSize) {
			DetachedCriteria detachedCriteria=DetachedCriteria.forClass(AccountBankWithdraw.class);
			detachedCriteria.createAlias( "publishSpecialCat" ,  "publishSpecialCat" );
			Pager pager=accountWithdrawService.findbyDetachedCriteria(detachedCriteria, pageNo, pageSize);
			List<AccountBankWithdraw> stories=(List<AccountBankWithdraw>)pager.getResultList();
			pager.setResultList(stories);
		return pager;
	}

	
	
	public Pager searchAccountRechargeByDate(AccountSearchByDate searchByDate,
			int pageNo, int pageSize) {
//			DetachedCriteria detachedCriteria=DetachedCriteria.forClass(AccountRecharge.class);
//			detachedCriteria.createAlias( "publishSpecialCat" ,  "publishSpecialCat" );
//			Pager pager=accountRechargeService.findbyDetachedCriteria(detachedCriteria, pageNo, pageSize);
//			List<AccountRecharge> stories=(List<AccountRecharge>)pager.getResultList();
//			pager.setResultList(stories);
//		    return pager;
			return null;
	}
	public Pager adminsearchcheckfailByDate(AccountSearchByDate searchByDate,int pageNo, int pageSize){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DetachedCriteria criteria1=DetachedCriteria.forClass(AccountWithdraw.class,"accountWithdraw");
		criteria1.add(Restrictions.eq("status",3));
		try {
			criteria1.add(Restrictions.between("accountWithdraw.withdrawTime",format.parse(searchByDate.getStartdate()),format.parse(searchByDate.getEnddate())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pager pager=accountWithdrawService.findbyDetachedCriteria(criteria1, pageNo, pageSize);
		List<AccountWithdraw> accountWithdraws=(List<AccountWithdraw>) pager.getResultList();
		pager.setResultList(accountWithdraws);
		return pager;
	}
	public Pager adminsearchchecksucByDate(AccountSearchByDate searchByDate,int pageNo, int pageSize){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DetachedCriteria criteria1=DetachedCriteria.forClass(AccountWithdraw.class,"accountWithdraw");
		criteria1.add(Restrictions.eq("status",2));
		try {
			criteria1.add(Restrictions.between("accountWithdraw.withdrawTime",format.parse(searchByDate.getStartdate()),format.parse(searchByDate.getEnddate())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pager pager=accountWithdrawService.findbyDetachedCriteria(criteria1, pageNo, pageSize);
		List<AccountWithdraw> accountWithdraws=(List<AccountWithdraw>) pager.getResultList();
		pager.setResultList(accountWithdraws);
		return pager;
	}
	public Pager adminsearchwaitByDate(AccountSearchByDate searchByDate,int pageNo, int pageSize){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DetachedCriteria criteria1=DetachedCriteria.forClass(AccountWithdraw.class,"accountWithdraw");
		criteria1.add(Restrictions.eq("status",1));
		try {
			criteria1.add(Restrictions.between("accountWithdraw.withdrawTime",format.parse(searchByDate.getStartdate()),format.parse(searchByDate.getEnddate())));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pager pager=accountWithdrawService.findbyDetachedCriteria(criteria1, pageNo, pageSize);
		List<AccountWithdraw> accountWithdraws=(List<AccountWithdraw>) pager.getResultList();
		pager.setResultList(accountWithdraws);
		return pager;
	}
	public Pager searchAccountWithdrawByDate(AccountSearchByDate searchByDate,
			int pageNo, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		DetachedCriteria criteria1=DetachedCriteria.forClass(AccountWithdraw.class,"accountWithdraw");
		Account account=accountService.select(Integer.valueOf(searchByDate.getAccountId()));
		criteria1.createAlias("accountWithdraw.account", "account");
		criteria1.add(Restrictions.eq("account.id",account.getId()));
		criteria1.add(Restrictions.between("accountWithdraw.withdrawTime",format.parse(searchByDate.getStartdate()),format.parse(searchByDate.getEnddate())));
		Pager pager=accountWithdrawService.findbyDetachedCriteria(criteria1, pageNo, pageSize);
		List<AccountWithdraw> accountWithdraws=(List<AccountWithdraw>) pager.getResultList();
		pager.setResultList(accountWithdraws);
		return pager;
	}

	/////////////////////////getter setter///////////////////////////////////
	public AccountWithdrawService getAccountWithdrawService() {
		return accountWithdrawService;
	}

	public void setAccountWithdrawService(
			AccountWithdrawService accountWithdrawService) {
		this.accountWithdrawService = accountWithdrawService;
	}

	public AccountBankWithdrawService getAccountBankWithdrawService() {
		return accountBankWithdrawService;
	}

	public void setAccountBankWithdrawService(
			AccountBankWithdrawService accountBankWithdrawService) {
		this.accountBankWithdrawService = accountBankWithdrawService;
	}

	public AccountRechargeService getAccountRechargeService() {
		return accountRechargeService;
	}

	public void setAccountRechargeService(
			AccountRechargeService accountRechargeService) {
		this.accountRechargeService = accountRechargeService;
	}

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

}
