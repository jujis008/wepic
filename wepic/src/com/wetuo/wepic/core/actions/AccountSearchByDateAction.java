package com.wetuo.wepic.core.actions;
import java.math.BigDecimal;
import java.util.List;

import com.wetuo.wepic.common.hibernate.PageSize;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.core.beans.AccountSearchByDate;
import com.wetuo.wepic.core.service.AccountSearchByDateService;
import com.wetuo.wepic.core.service.AccountWithdrawService;

public class AccountSearchByDateAction extends PageAction{
	private AccountSearchByDate accountSearchByDate;
	private AccountSearchByDateService accountSearchByDateService;
	private Integer totalWithdrawNumber;
	private BigDecimal totalMoney;
	private Integer currenttotalWithdrawNumber;
	private BigDecimal currenttotalMoney;
	public Object getModel() {
		if (accountSearchByDate == null) {
			accountSearchByDate = new AccountSearchByDate();
		}
		return accountSearchByDate;
	}
	
	public String searchaccountwithdrawbydate() throws Exception {
		super.pager=accountSearchByDateService.searchAccountWithdrawByDate(accountSearchByDate, pageNo, 20);
		List tempList=this.getAccountSearchByDateService().findresofuser(Integer.valueOf(accountSearchByDate.getAccountId()));
		totalWithdrawNumber=(Integer) tempList.get(0);
		totalMoney=(BigDecimal) tempList.get(1);
		List list=this.getAccountSearchByDateService().findresofuseraccorddate(Integer.valueOf(accountSearchByDate.getAccountId()), accountSearchByDate.getStartdate(),accountSearchByDate.getEnddate());
		currenttotalMoney=(BigDecimal)list.get(1);
		currenttotalWithdrawNumber=(Integer)list.get(0);
		return "searchaccountwithdrawbydate";
	}
	
	public String adminsearchchecksucbydate() {
		return "adminsearchchecksucbydate";
	}
	public String adminsearchcheckfailbydate() {
		
		return "adminsearchcheckfailbydate";
	}
	public String adminsearchwaitbydate(){
		try {
			super.pager=accountSearchByDateService.adminsearchwaitByDate(accountSearchByDate, pageNo, PageSize.adminwithdrawSize);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List tempList=this.getAccountSearchByDateService().findresofuser(Integer.valueOf(accountSearchByDate.getAccountId()));
		totalWithdrawNumber=(Integer) tempList.get(0);
		totalMoney=(BigDecimal) tempList.get(1);
		List list=this.getAccountSearchByDateService().findresofuseraccorddate(Integer.valueOf(accountSearchByDate.getAccountId()), accountSearchByDate.getStartdate(),accountSearchByDate.getEnddate());
		currenttotalMoney=(BigDecimal)list.get(1);
		currenttotalWithdrawNumber=(Integer)list.get(0);
		return "adminsearchbydate";
	}
	///////////////////////getter setter///////////////////////
	public AccountSearchByDate getAccountSearchByDate() {
		return accountSearchByDate;
	}

	public void setAccountSearchByDate(AccountSearchByDate accountSearchByDate) {
		this.accountSearchByDate = accountSearchByDate;
	}

	public AccountSearchByDateService getAccountSearchByDateService() {
		return accountSearchByDateService;
	}

	public void setAccountSearchByDateService(
			AccountSearchByDateService accountSearchByDateService) {
		this.accountSearchByDateService = accountSearchByDateService;
	}

	public Integer getTotalWithdrawNumber() {
		return totalWithdrawNumber;
	}

	public void setTotalWithdrawNumber(Integer totalWithdrawNumber) {
		this.totalWithdrawNumber = totalWithdrawNumber;
	}

	public BigDecimal getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(BigDecimal totalMoney) {
		this.totalMoney = totalMoney;
	}

	public Integer getCurrenttotalWithdrawNumber() {
		return currenttotalWithdrawNumber;
	}

	public void setCurrenttotalWithdrawNumber(Integer currenttotalWithdrawNumber) {
		this.currenttotalWithdrawNumber = currenttotalWithdrawNumber;
	}

	public BigDecimal getCurrenttotalMoney() {
		return currenttotalMoney;
	}

	public void setCurrenttotalMoney(BigDecimal currenttotalMoney) {
		this.currenttotalMoney = currenttotalMoney;
	}
	
}

