package com.wetuo.wepic.common.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.wetuo.wepic.core.beans.User;
import com.wetuo.wepic.deal.beans.BuyCartDeal;
import com.wetuo.wepic.deal.beans.BuyCommodities;
import com.sun.org.apache.bcel.internal.generic.NEW;
@SuppressWarnings({"unchecked","unused"})
public class BuyCart {
	
	private BuyCartDeal buyCartDeal = new BuyCartDeal();
	private Map<String,BuyCommodities> shopCartMap=null;
	private Integer totalNums=0;
	private Integer totalPrice=0;
	/**
	 * 添加到购物车
	 * @param buyCommodities
	 */
	public void add(BuyCommodities buyCommodities) {
		if (shopCartMap==null) {
			shopCartMap=new HashMap<String, BuyCommodities>();
		}else {
			if (shopCartMap.containsKey(buyCommodities.getPublish().getId().toString())) {
				buyCommodities.setAmount(buyCommodities.getAmount()+1);
			}else {
				buyCommodities.setAmount(1);
			}		
		}
		if (buyCommodities.getPublish().getCopyright()==0) {
			buyCommodities.setUsgeTotalPrice(buyCommodities.getPublish().getUsagePrice()*buyCommodities.getAmount());
		}if (buyCommodities.getPublish().getCopyright()==1) {
			buyCommodities.setCopyrighTotalPrice(buyCommodities.getPublish().getCopyrightPrice()*buyCommodities.getAmount());
		}if (buyCommodities.getPublish().getCopyright()==2) {
			if (buyCommodities.getCopyrightOrUsage()==0) {
				buyCommodities.setUsgeTotalPrice(buyCommodities.getPublish().getUsagePrice()*buyCommodities.getAmount());
			}if (buyCommodities.getCopyrightOrUsage()==1) {
				buyCommodities.setCopyrighTotalPrice(buyCommodities.getPublish().getCopyrightPrice()*buyCommodities.getAmount());
			}
		}	
		shopCartMap.put(buyCommodities.getPublish().getId().toString(),buyCommodities);
		totalPrice=totalPrice();
		totalNums=getTotal();
	}
	/**
	 * 获得购物车中所有的信息
	 * @return
	 */
	public Map<String,BuyCommodities> findAll() {
		return shopCartMap;
	}
	/**
	 * 删除购物车中的商品
	 * @param id
	 */
	public void del(String id) {
		shopCartMap.remove(id);
		totalPrice=totalPrice();
		totalNums=getTotal();
	}
	/**
	 * 得到购物车中所有商品的总数
	 * @return
	 */
	public int getTotal() {
		totalNums=0;
		Collection<BuyCommodities> collection= shopCartMap.values();
		for (BuyCommodities commodities:collection) {
			totalNums+=commodities.getAmount();
		}
		return totalNums;
	}
	/**
	 * 得到购物车中所有商品的总价格
	 * @return
	 */
	public int totalPrice(){
		totalPrice=0;
		Collection<BuyCommodities> collection= shopCartMap.values();
		for (BuyCommodities commodities:collection) {
			if (commodities.getCopyrightOrUsage()==0) {
				if (commodities.getPublish().getUsagePrice()==null) {
					totalPrice=0;
				}else {
					totalPrice=totalPrice+commodities.getPublish().getUsagePrice()*commodities.getAmount();
				}
			}if (commodities.getCopyrightOrUsage()==1) {
				if (commodities.getPublish().getCopyrightPrice()==null) {
					totalPrice=0;
				}else {
					totalPrice=totalPrice+commodities.getPublish().getCopyrightPrice()*commodities.getAmount();					
				}
			}
		}
		return totalPrice;
	}
	
	public BuyCartDeal getBuyCartDeal() {
		return buyCartDeal;
	}
	public void setBuyCartDeal(BuyCartDeal buyCartDeal) {
		this.buyCartDeal = buyCartDeal;
	}
	public Map<String, BuyCommodities> getShopCartMap() {
		return shopCartMap;
	}
	public void setShopCartMap(Map<String, BuyCommodities> shopCartMap) {
		this.shopCartMap = shopCartMap;
	}
	public Integer getTotalNums() {
		return totalNums;
	}
	public void setTotalNums(Integer totalNums) {
		this.totalNums = totalNums;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

}
