package com.wetuo.wepic.common.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.publish.beans.Publish;
import com.wetuo.wepic.publish.service.PublishService;
@SuppressWarnings("unchecked")
public class ShopCart extends PageAction {
	private Integer totalNums=0;
	private Integer totalPrice=0;
	private Integer copyRightPrice=0;
	private Integer usagePrice=0;
	private Map<String,Goods> shopCart;
	private PublishService publishService;
	private Integer id;
	private Goods goods;
	private String notice;
	private String validateMsg;
	 public String add() {
	        Publish publish=publishService.select(getId());
	        shopCart=(Map)ActionContext.getContext().getSession().get("shopCart");
	        if (shopCart==null) {
	            shopCart=new HashMap();
	            goods=new Goods();
	            goods.setNum(1);
	            goods.setPublish(publish);
	            goods.setPublishId(getId());
	            shopCart.put(getId().toString(),goods);
	        }else {
	                Set<String> set=shopCart.keySet();
	                if (set.contains(getId().toString())) {
	                    Goods g=(Goods)shopCart.get(getId().toString());
	                    g.setNum(g.getNum()+1);
	                    shopCart.put(getId().toString(),g);
	                }else {
	                    Goods goods1=new Goods();
	                    goods1.setNum(1);
	                    goods1.setPublish(publish);
	                    Map<String,Goods> shopCart=(Map<String, Goods>) ActionContext.getContext().getSession().get("shopCart");
	                    shopCart.put(getId().toString(),goods1);
	                }
	              }
	       
	        ActionContext.getContext().getSession().put("shopCart",shopCart);
	        totalNums=getTotal();
	        totalPrice=totalPrice();
	        return "cart";
	    }
	public int getTotal() {
		Map<String,Goods> map=(Map<String, Goods>)ActionContext.getContext().getSession().get("shopCart");
		Collection<Goods> collection= map.values();
		for (Goods goods:collection) {
			totalNums+=goods.getNum();
		}
		return totalNums;
	}
	public int totalPrice() {
		Map<String,Goods> map=(Map<String, Goods>)ActionContext.getContext().getSession().get("shopCart");
		Collection<Goods> collection= map.values();
		for (Goods goods:collection) {
			if (goods.getPublish().getCopyright()==0) {
				if (goods.getPublish().getCopyrightPrice()==null) {
					totalPrice=0;
				}else {
					copyRightPrice+=goods.getPublish().getCopyrightPrice()*goods.getNum();
					totalPrice=totalPrice+copyRightPrice;	
				}
				
			}if (goods.getPublish().getCopyright()==1) {
				if (goods.getPublish().getUsagePrice()==null) {
					totalPrice=0;
				}else {
					usagePrice+=goods.getPublish().getUsagePrice()*goods.getNum();
					totalPrice=totalPrice+usagePrice;	
				}
				
			}if (goods.getPublish().getCopyright()==2) {
			}
		}
		return totalPrice;
	}
	
//	@JSON(serialize=false)
//	public String del() {
//		shopCart=(Map<String, Goods>) ActionContext.getContext().getSession().get("shopCart");
//		Goods goods=(Goods)shopCart.get(id.toString());
//		shopCart.remove(shopCart.get(id.toString()));
//		shopCart.remove(goods);
//		ActionContext.getContext().getSession().put("shopCart",shopCart);
//		return "del";
//	}
	public String del() {
		shopCart=(Map<String, Goods>) ActionContext.getContext().getSession().get("shopCart");
		shopCart.remove(id.toString());
		ActionContext.getContext().getSession().put("shopCart",shopCart);
		totalNums=getTotal();
        totalPrice=totalPrice();
		return "del";
	}
	
	public String cancel() {
		shopCart=(Map<String, Goods>) ActionContext.getContext().getSession().get("shopCart");
		shopCart.remove(id.toString());
		ActionContext.getContext().getSession().put("shopCart",shopCart);
		totalNums=getTotal();
        totalPrice=totalPrice();
		return "cancel";
	}
	public String edit() {
		return "";
	}
	public Integer getTotalNums() {
		return totalNums;
	}
	public void setTotalNums(Integer totalNums) {
		this.totalNums = totalNums;
	}
	public Integer getCopyRightPrice() {
		return copyRightPrice;
	}
	public void setCopyRightPrice(Integer copyRightPrice) {
		this.copyRightPrice = copyRightPrice;
	}
	public Integer getUsagePrice() {
		return usagePrice;
	}
	public void setUsagePrice(Integer usagePrice) {
		this.usagePrice = usagePrice;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public PublishService getPublishService() {
		return publishService;
	}
	public void setPublishService(PublishService publishService) {
		this.publishService = publishService;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Map<String, Goods> getShopCart() {
		return shopCart;
	}
	public void setShopCart(Map<String, Goods> shopCart) {
		this.shopCart = shopCart;
	}
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}
	public String getValidateMsg() {
		return validateMsg;
	}
	public void setValidateMsg(String validateMsg) {
		this.validateMsg = validateMsg;
	}
}
