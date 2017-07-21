package com.wetuo.wepic.deal.service ;
 
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import org.springframework.transaction.annotation.Transactional;

import com.wetuo.wepic.deal.beans.BuyAccountOperation;
import com.wetuo.wepic.deal.beans.BuyCartDeal;
import com.wetuo.wepic.deal.beans.BuyCommodities;
import com.wetuo.wepic.deal.dao.BuyCartDealDao;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.service.PublishService;
import com.wetuo.wepic.common.hibernate.Pager;
import com.wetuo.wepic.common.util.BuyCart;
import com.wetuo.wepic.common.util.GengerateExchangeCode;
import com.wetuo.wepic.core.beans.Account;
import com.wetuo.wepic.core.beans.BrokerRelationship;
import com.wetuo.wepic.core.beans.SiteConfig;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.core.service.AccountService;
import com.wetuo.wepic.core.service.BrokerRelationshipService;
import com.wetuo.wepic.core.service.SiteConfigService;
 
public class BuyCartDealServiceImpl implements BuyCartDealService {
	BuyCartDealDao domainDao;
	AccountService accountService;
	SiteConfigService siteConfigService;
	BuyAccountOperationService buyAccountOperationService;
	BuyCommoditiesService buyCommoditiesService;
	BrokerRelationshipService brokerRelationshipService;
	PublishService publishService;
	public PublishService getPublishService() {
		return publishService;
	}
	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}
	public BrokerRelationshipService getBrokerRelationshipService() {
		return brokerRelationshipService;
	}
	public void setBrokerRelationshipService(
			BrokerRelationshipService brokerRelationshipService) {
		this.brokerRelationshipService = brokerRelationshipService;
	}
	public BuyCommoditiesService getBuyCommoditiesService() {
		return buyCommoditiesService;
	}
	public void setBuyCommoditiesService(BuyCommoditiesService buyCommoditiesService) {
		this.buyCommoditiesService = buyCommoditiesService;
	}
	public BuyAccountOperationService getBuyAccountOperationService() {
		return buyAccountOperationService;
	}
	public void setBuyAccountOperationService(
			BuyAccountOperationService buyAccountOperationService) {
		this.buyAccountOperationService = buyAccountOperationService;
	}
	public SiteConfigService getSiteConfigService() {
		return siteConfigService;
	}
	public void setSiteConfigService(SiteConfigService siteConfigService) {
		this.siteConfigService = siteConfigService;
	}
	public AccountService getAccountService() {
		return accountService;
	}
	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	public BuyCartDealDao getBuyCartDealDao() {
		return domainDao;
	}//
	public void setBuyCartDealDao(BuyCartDealDao  domainDao) {
		this.domainDao = domainDao;
	}//
	
	//////////////common crud////////////////
	public List<BuyCartDeal> findAll(){ 
		return domainDao.findAll();
	}
	
	public List<BuyCartDeal> findPart(String strFields, String[] arrStrValues){ 
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
	public String insert(BuyCartDeal record) {
		return domainDao.insert(record) ;
	}//end insert()
			
	/////delete///
	public boolean delete(BuyCartDeal record)  {
		return domainDao.delete(record);
	}//end delete()
			
	public boolean delete(String id)  {
		return domainDao.delete(id);
	}//end delete()
	
	/////update///
	public boolean update(BuyCartDeal record)  {
		return domainDao.update(record);
	}//end update()
			
	/////select///
	public BuyCartDeal select(String id)  {
		return domainDao.select(id);
	}//end select()
	@Transactional
	public boolean dealCart(List<Account> list) {
		for (Account account:list) {
			this.getAccountService().update(account);
			return true;
		}
		return false;
	}
	/**
	 * 交易的处理，操作BuyCartDeal，BuyCommodities,BuyAccountOperation,Account
	 */
	@Transactional
	public String dealBusiness(BuyCart buyCart,User user,BuyCartDeal buyCartDeal2) {
		String res="fail";
		int compareResult=0;
		try {
			buyCartDeal2.setUser(user);
			buyCartDeal2.setTotalMoney(Double.valueOf(buyCart.getTotalPrice().toString()));
			Set<String> keySet = buyCart.getShopCartMap().keySet();
			for(String key : keySet){
				buyCartDeal2.getBuyCommoditiesSet().add(buyCart.getShopCartMap().get(key))	; 	
			}
			Account account=this.getAccountService().select(user.getId(),"");
			SiteConfig siteConfig=this.getSiteConfigService().getCurrentSiteConfig();
			
			BigDecimal taxDecimal=new BigDecimal(siteConfig.getTax()).setScale(4,BigDecimal.ROUND_HALF_EVEN);//税
			BigDecimal thirDecimal=new BigDecimal(siteConfig.getThirdPayRate()).setScale(4, BigDecimal.ROUND_HALF_EVEN);//第三方税
			BigDecimal platformtax=new BigDecimal(siteConfig.getProportionSite()).setScale(4,BigDecimal.ROUND_HALF_EVEN);//平台税
			BigDecimal brokertax=new BigDecimal(siteConfig.getProportionBroker()).setScale(4,BigDecimal.ROUND_HALF_EVEN);//经纪人分钱税率
			
			BigDecimal complete=new BigDecimal(1);
			BigDecimal authtax=complete.subtract(taxDecimal.add(thirDecimal).add(platformtax.add(brokertax)));//发布作品的用户分钱的税率
			BigDecimal authMoney=new BigDecimal(0);
			BigDecimal bigDecimal=new BigDecimal(buyCartDeal2.getTotalMoney());//购物车中所有商品的总价格
			compareResult=account.getRemainingMoney().compareTo(bigDecimal);//对比结果    a.compareTo(b) 返回值    -1 小于   0 等于    1 大于 
			if (compareResult>-1) {
				buyCartDeal2.setDeliveryTime(getcurrent());
				buyCartDeal2.setStatus(4);
				this.getBuyCartDealDao().update(buyCartDeal2);
				//从买家账户扣钱
				BuyAccountOperation buyAccountOpertation=new BuyAccountOperation();
				buyAccountOpertation.setBuyCartDeal(buyCartDeal2);
				buyAccountOpertation.setOperationType(4);
				buyAccountOpertation.setOperationTime(getcurrent());
				buyAccountOpertation.setMoneyUnit("元");
				buyAccountOpertation.setAccount(account);
				buyAccountOpertation.setMoney(bigDecimal);
				buyAccountOpertation.setSiteConfig(siteConfig);
				this.getBuyAccountOperationService().insert(buyAccountOpertation);
				//将买家的账户更新
				account.setRemainingMoney(account.getRemainingMoney().subtract(bigDecimal));
				account.setTotalMoney(account.getRemainingMoney());
				this.getAccountService().update(account);
				
				BigDecimal bigDecimal2=new BigDecimal(0);
				//开始分钱
				for (BuyCommodities buyCommodities:buyCartDeal2.getBuyCommoditiesSet()) {
					buyCommodities.setBuyCartDeal(buyCartDeal2);///-----出错
					Publish publish=buyCommodities.getPublish();
					this.getBuyCommoditiesService().insert(buyCommodities);
					//管理员账户
					Account adminAccount=this.getAccountService().select(24,"");
					
					//作品的作者
					User user2=buyCommodities.getPublish().getUser();
					
					//判断user2即发布的作者是否存在经纪人，并且经纪关系有效
					List<BrokerRelationship> brokerRelationships=this.getBrokerRelationshipService().getRelationShips(user2);
					Account brokerAccount=null;
					User user3=null;
					BigDecimal broker=new BigDecimal(0);
					BigDecimal manageTax=new BigDecimal(0);
					BigDecimal brokerMoney=new BigDecimal(0);
					if (brokerRelationships==null || brokerRelationships.size()<1) {
						user3=null;
						broker=new BigDecimal(0);
						manageTax=manageTax.add(taxDecimal.add(platformtax.add(brokertax).add(thirDecimal)));//如果经纪关系不生效，这是管理员所得的分钱的税率
					}else {
					for (int i = 0; i < brokerRelationships.size(); i++) {
						if (brokerRelationships.get(i).getBroker()!=null && brokerRelationships.get(i).getIsValid()==1) {
							user3=brokerRelationships.get(i).getBroker();
							brokerAccount=this.getAccountService().select(user3.getId(),"");
							broker=broker.add(brokertax);//如果经纪关系生效，经纪人分钱的税率
							manageTax=manageTax.add(taxDecimal.add(platformtax.add(thirDecimal)));//管理员所得的分钱的税率
						}
					}
					}
					
					//发布图片用户对应的账户
					Account account3=this.getAccountService().select(user2.getId(),"");
					BigDecimal tax=new BigDecimal(siteConfig.getTax()).setScale(4,BigDecimal.ROUND_HALF_EVEN);
					BigDecimal third=new BigDecimal(siteConfig.getThirdPayRate()).setScale(4,BigDecimal.ROUND_HALF_EVEN);
					
					BigDecimal adminTotal=new BigDecimal(0);
					if (user3!=null && brokerAccount!=null) {
						if (buyCommodities.getCopyrightOrUsage()==0) {
							bigDecimal2=new BigDecimal(buyCommodities.getPublish().getUsagePrice());
						}else if (buyCommodities.getCopyrightOrUsage()==1) {
							bigDecimal2=new BigDecimal(buyCommodities.getPublish().getCopyrightPrice());
						}else if (buyCommodities.getCopyrightOrUsage()==2) {
							BigDecimal bigDecimal3=new BigDecimal(buyCommodities.getPublish().getCopyrightPrice());
							BigDecimal bigDecimal4=new BigDecimal(buyCommodities.getPublish().getUsagePrice());
							bigDecimal2=bigDecimal3.add(bigDecimal4);
						}
						adminTotal=bigDecimal2.multiply(tax).add(bigDecimal2.multiply(third)).add(bigDecimal2.multiply(platformtax));
						adminAccount.setRemainingMoney(adminAccount.getRemainingMoney().add(adminTotal));
						//经纪人所得的分钱
						brokerMoney=bigDecimal2.multiply(broker);
						brokerAccount.setRemainingMoney(brokerAccount.getRemainingMoney().add(bigDecimal2.multiply(broker)));
						authMoney=bigDecimal2.multiply(authtax);
						
					}
					//经纪关系不存在或者不生效
					else {
						if (buyCommodities.getCopyrightOrUsage()==0) {
							bigDecimal2=new BigDecimal(buyCommodities.getPublish().getUsagePrice());
						}else if (buyCommodities.getCopyrightOrUsage()==1) {
							bigDecimal2=new BigDecimal(buyCommodities.getPublish().getCopyrightPrice());
						}else if (buyCommodities.getCopyrightOrUsage()==2) {
							BigDecimal bigDecimal3=new BigDecimal(buyCommodities.getPublish().getCopyrightPrice());
							BigDecimal bigDecimal4=new BigDecimal(buyCommodities.getPublish().getUsagePrice());
							bigDecimal2=bigDecimal3.add(bigDecimal4);
						}
						adminTotal=bigDecimal2.multiply(tax).add(bigDecimal2.multiply(third)).add(bigDecimal2.multiply(brokertax).add(bigDecimal2.multiply(platformtax)));
						System.out.println(adminAccount.getRemainingMoney());
						BigDecimal temp=adminAccount.getRemainingMoney().add(adminTotal);
						adminAccount.setRemainingMoney(adminAccount.getRemainingMoney().add(adminTotal));
						authMoney=bigDecimal2.multiply(authtax);
					}
					
					
					account3.setRemainingMoney(account3.getRemainingMoney().add(authMoney));
					this.getAccountService().update(account3);
					account3.setTotalMoney(account3.getTotalMoney().add(account3.getRemainingMoney()));
					this.getAccountService().update(account3);
					
					/**
					 * 管理员分得到的钱（入账）
					 */
					BuyAccountOperation buyAccountOperation=new BuyAccountOperation();
					buyAccountOperation.setBuyCartDeal(buyCartDeal2);
					buyAccountOperation.setOperationTime(getcurrent());
					buyAccountOperation.setOperationType(3);
					buyAccountOperation.setMoney(adminTotal);
					buyAccountOperation.setAccount(adminAccount);
					buyAccountOperation.setMoneyUnit("元");
					buyAccountOperation.setSiteConfig(siteConfig);
					this.getBuyAccountOperationService().insert(buyAccountOperation);
					
					
					
					this.getAccountService().update(adminAccount);
					adminAccount.setTotalMoney(adminAccount.getRemainingMoney());
					this.getAccountService().update(adminAccount);
					
					
					BuyAccountOperation buyAccountOperation2=new BuyAccountOperation();
					buyAccountOperation2.setBuyCartDeal(buyCartDeal2);
					buyAccountOperation2.setOperationTime(getcurrent());
					buyAccountOperation2.setOperationType(3);
					buyAccountOperation2.setMoney(authMoney);
					buyAccountOperation2.setAccount(account3);
					buyAccountOperation2.setMoneyUnit("元");
					buyAccountOperation2.setSiteConfig(siteConfig);
					this.getBuyAccountOperationService().insert(buyAccountOperation2);
					
					this.getAccountService().update(account3);
					account3.setTotalMoney(account3.getRemainingMoney());
					this.getAccountService().update(account3);
					
					
					if (user3!=null) {
						BuyAccountOperation buyAccountOperation3=new BuyAccountOperation();
						buyAccountOperation3.setBuyCartDeal(buyCartDeal2);
						buyAccountOperation3.setOperationTime(getcurrent());
						buyAccountOperation3.setOperationType(3);
						buyAccountOperation3.setMoney(brokerMoney);
						buyAccountOperation3.setAccount(brokerAccount);
						buyAccountOperation3.setMoneyUnit("元");
						buyAccountOperation3.setSiteConfig(siteConfig);
						this.getBuyAccountOperationService().insert(buyAccountOperation3);
						this.getAccountService().update(brokerAccount);
						brokerAccount.setTotalMoney(brokerAccount.getRemainingMoney());
						this.getAccountService().update(brokerAccount);
					}
					
					
				}
				
				
				buyCartDeal2.setStatus(5);
				buyCartDeal2.setDeliveryTime(getcurrent());
				this.getBuyCartDealDao().update(buyCartDeal2);
				for (BuyCommodities buyCommodities:buyCartDeal2.getBuyCommoditiesSet()) {
					Publish publish=buyCommodities.getPublish();
					publish.setUsageBuyNum(publish.getUsageBuyNum()+1);
					this.getPublishService().update(publish);
				}
				
				res="suc";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			res="fail";
			buyCart.getBuyCartDeal().setStatus(4);
	    	buyCart.getBuyCartDeal().setDeliveryTime(getcurrent());
	    	boolean b=this.getBuyCartDealDao().update(buyCart.getBuyCartDeal());
	    	if (b) {
				res="not";
			}else {
			b=false;	
			}
		}
		return res;
	}
	public Timestamp getcurrent() {
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String a=df.format(new Date());
		Timestamp ts = new Timestamp(System.currentTimeMillis());  
		ts.valueOf(a);
		return ts;
	}
	public BuyCartDeal currentDeal(User user) {
		// TODO Auto-generated method stub
		return domainDao.currentDeal(user);
	}
}//end class
