package com.wetuo.wepic.core.service ;
 
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.opensymphony.xwork2.ActionContext;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.AccountBankWithdraw;
import com.wetuo.wepic.core.beans.AccountWithdraw;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.dao.AccountBankWithdrawDao;
import com.wetuo.wepic.core.dao.AccountDao;
import com.wetuo.wepic.core.dao.AccountWithdrawDao;
import com.wetuo.wepic.core.dao.UserDao;
import common.quickvalid.validators.int_range;
 
public class AccountWithdrawServiceImpl implements AccountWithdrawService {
	AccountWithdrawDao domainDao;
	AccountBankWithdrawDao bankWithdrawDao;
	AccountDao accountDao;
	UserDao userDao;
	public AccountWithdrawDao getAccountWithdrawDao() {
		return domainDao;
	}//
	public void setAccountWithdrawDao(AccountWithdrawDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	public AccountBankWithdrawDao getBankWithdrawDao() {
		return bankWithdrawDao;
	}
	public void setBankWithdrawDao(AccountBankWithdrawDao bankWithdrawDao) {
		this.bankWithdrawDao = bankWithdrawDao;
	}
	//////////////common crud////////////////
	public List<AccountWithdraw> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<AccountWithdraw> findPart(String strFields, String[] arrStrValues){ 
		return domainDao.findPart(strFields,arrStrValues);
	}
	
	public Pager list(int pageSize, int pageNo)  {
		return domainDao.list(pageSize,pageNo);
	}//end list()
	
	public Pager list(String username, int pageSize, int pageNo)  {
		return domainDao.list(username,pageSize,pageNo);
	}//end list()
	
	public Pager list(Map<String,Object> mapSqlParam, int pageSize, int pageNo)  {
		return domainDao.list(mapSqlParam,pageSize,pageNo);
	}//end list()
	
	/////insert///
	public Integer insert(AccountWithdraw record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(AccountWithdraw record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(Integer id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(AccountWithdraw record)  {
		return domainDao.update(record);
	}//end update()
	
	
	/***提现申请***/
	public boolean accountWithdrawApplay(AccountWithdraw accountWithdraw,
			Account account) {
		Integer nit = domainDao.insert(accountWithdraw);
		boolean b = accountDao.update(account);
		if(nit>0 && b){
			return true;
		}
		return false;
	}
	/***获取申请提现列表***/
	public Pager list(Integer userId, int pageSize, int pageNo) {
		Pager pager =  domainDao.List(userId, pageSize, pageNo);
		return pager;
	}
	
	public Pager applayList(int pageSize, int pageNo) {
		return domainDao.applayList(pageSize, pageNo,0);
	}
	
	/***生产提现订单****/
	public boolean productApplyForm(int accountWithdrawId, int userId) {
		User user = userDao.selectById(userId);
		AccountWithdraw accountWithdraw = domainDao.select(accountWithdrawId);
		accountWithdraw.setAdmin(user);
		accountWithdraw.setIfDemandWithdraw(1);
		return domainDao.update(accountWithdraw);
	}
	
	
	/****查询体现单列表****/
	public Pager ifEnsureApplyList(int pageSize, int pageNo) {
		return domainDao.applayList(pageSize, pageNo,1);
	}
	
	/***确认提现订单****/
//	public boolean confirmApply(int id,int accountId,int flag) {
//		AccountWithdraw accountWithdraw = domainDao.select(id);
//		User user = accountWithdraw.getAdmin();
//		if(user == null){
//			int userId=(Integer)ActionContext.getContext().getSession().get("id");
//			user = userDao.select(userId);
//			accountWithdraw.setAdmin(user);
//		}
//		Account account = accountDao.select(accountId);
//		if(flag==2)
//			account.setTotalMoney(account.getTotalMoney().subtract(new BigDecimal(accountWithdraw.getWithdrawMoney())));
//		else if(flag==3)
//			account.setRemainingMoney(account.getRemainingMoney().add(new BigDecimal(accountWithdraw.getWithdrawMoney())));
//		else 
//			return false;
//		
//		accountWithdraw.setIfDemandWithdraw(flag);
//		accountWithdraw.setWithdrawTime(new Timestamp(new Date().getTime()));
//		return (accountDao.update(account) && domainDao.update(accountWithdraw));
//	}
	
			
	/////select///
	public AccountWithdraw select(Integer id)  {
		return domainDao.select(id);
	}//end select()
	public AccountDao getAccountDao() {
		return accountDao;
	}
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public boolean confirmApply(int id, int accountId, int flag) {
		// TODO Auto-generated method stub
		return false;
	}
	public List<AccountWithdraw> findByAccount(int id) {
		// TODO Auto-generated method stub
		return domainDao.findByAccount(id);
	}
	/////////////////////////////////////////wepic2.0////////////////////////////////////////////
	public Pager findbyDetachedCriteria(DetachedCriteria detachedCriteria,int pageNo,int pageSize){		 
		 return domainDao.findbyDetachedCriteria(detachedCriteria,pageNo,pageSize);
	 }
	public List find(DetachedCriteria detachedCriteria){
		return domainDao.find(detachedCriteria);
	}
	public DetachedCriteria detachedCriteria(int accountId){
		DetachedCriteria criteria1=DetachedCriteria.forClass(AccountWithdraw.class,"accountWithdraw");
		criteria1.createAlias("accountWithdraw.account", "account");
		criteria1.add(Restrictions.eq("account.id",accountId));
		criteria1.add(Restrictions.eq("status",1));
		return criteria1;
	}
	
	public List findresofuser(int accountId){
		List<AccountWithdraw> list=domainDao.findByAccount(accountId);;
		int totalnum=0;
		BigDecimal totalmoney=new BigDecimal(0);   
		for (AccountWithdraw accountWithdraw:list) {
			totalmoney=totalmoney.add(accountWithdraw.getWithdrawMoney());
		}
		totalnum=list.size();
		List resList=new LinkedList();
		resList.add(0,totalnum);
		resList.add(1,totalmoney);
		return resList;
	}
	
	public List findres(){
		List<AccountWithdraw> list=domainDao.findAll();
		int totalnum=0;
		BigDecimal totalmoney=new BigDecimal(0);   
		for (AccountWithdraw accountWithdraw:list) {
			totalmoney=totalmoney.add(accountWithdraw.getWithdrawMoney());
		}
		totalnum=list.size();
		List resList=new LinkedList();
		resList.add(0,totalnum);
		resList.add(1,totalmoney);
		return resList;
	}
	@SuppressWarnings("static-access")
	public Timestamp getcurrent() {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String a=df.format(new Date());
		Timestamp ts = new Timestamp(System.currentTimeMillis());  
		ts.valueOf(a);
		return ts;
	}
	public String getcurrent2() {
		SimpleDateFormat df=new SimpleDateFormat("yyyyMMddHHmmsssss");
		String a=df.format(new Date());
		return a;
	}
	public Map applywithdraw(Integer accountId,String userwithdrawMoney,String hiddenbank){
		Map resMap=new HashMap();
		List templList=new LinkedList();
		int tradeFlag=0;
		BigDecimal frozenBigDecimal=new BigDecimal(0);
		Account account = this.accountDao.select(accountId);  
		User user=userDao.selectById(account.getUserId());
 		List<AccountWithdraw> accountWithdraws=findByAccount(accountId);
 		BigDecimal accountwithdrawtotal=new BigDecimal(0);
 		for (AccountWithdraw accountWithdraw2: accountWithdraws) {
 			accountwithdrawtotal=accountwithdrawtotal.add(accountWithdraw2.getWithdrawMoney());
		}
		if(userwithdrawMoney!=null){
			BigDecimal bd=new BigDecimal(userwithdrawMoney);
			//判断余额是否大于用户所要提现的金额
			//tradeFlag=1(余额充足)tradeFlag=2(余额不足)tradeFlag=3(网络连接失败)tradeFlag=4(用户开户行账户为空,系统不允许提现)
			//res=-1(tradeFlag=2时自定义的一个值)
			int res=0;
			int a=bd.compareTo(account.getRemainingMoney());
			System.out.println(a+"****");
			if(account!=null&&account.getRemainingMoney().compareTo(bd)!=-1&&account.getBankAccount()!=null){
				tradeFlag=1;//余额充足
				account.setRemainingMoney(account.getRemainingMoney().subtract(bd));
				accountDao.update(account);
				frozenBigDecimal=account.getTotalMoney().subtract(account.getRemainingMoney());
				AccountWithdraw accountWithdraw=new AccountWithdraw();
				accountWithdraw.setAccount(account);
				accountWithdraw.setAdmin(null);
				accountWithdraw.setWithdrawMoney(bd);
				accountWithdraw.setStatus(1);
				accountWithdraw.setWithdrawTime(getcurrent());
				accountWithdraw.setSerialnumber(getcurrent2());
				accountWithdraw.setTotalwithdrawMoney(accountwithdrawtotal);
				if (hiddenbank.equals("") || hiddenbank == null) {
					AccountBankWithdraw accountBankWithdraw=bankWithdrawDao.defaultAccountBankWithdraw(accountId);
					accountBankWithdraw.setWithdrawnumber(accountBankWithdraw.getWithdrawnumber()+1);
					accountBankWithdraw.setAccount(account);
					bankWithdrawDao.update(accountBankWithdraw);
					accountWithdraw.setAccountBankWithdraw(accountBankWithdraw);
				}else {
					AccountBankWithdraw accountBankWithdraw=bankWithdrawDao.defaultAccountBankWithdraw(accountId);
					accountBankWithdraw.setWithdrawnumber(accountBankWithdraw.getWithdrawnumber()+1);
					bankWithdrawDao.update(accountBankWithdraw);
					accountWithdraw.setAccountBankWithdraw(accountBankWithdraw);	
				}
				res=domainDao.insert(accountWithdraw);
				if (res==0) { 
					tradeFlag=3;
				}
				AccountWithdraw accountWithdraw2=domainDao.select(res);
				if (domainDao.update(accountWithdraw2)) {
				}else {
					tradeFlag=3;
				}
				templList.add(tradeFlag);
				templList.add(account.getRemainingMoney());
				templList.add(frozenBigDecimal);
				resMap.put(res,templList);
			}else {
				System.out.println(account.getBankAccount());
				frozenBigDecimal=new BigDecimal(0.0);
				if (account.getBankAccount()==null) {
					tradeFlag=4;//银行账户为空,不允许提现
				}else{
				tradeFlag=2;//余额不足
				}
				res=-1;
				templList.add(tradeFlag);
				templList.add(account.getRemainingMoney());
				templList.add(frozenBigDecimal);
				resMap.put(res,templList);
			}
			
		}
		return resMap;
	}
}//end class
