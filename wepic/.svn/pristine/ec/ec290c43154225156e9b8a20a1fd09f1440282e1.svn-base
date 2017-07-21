package com.wetuo.wepic.deal.actions;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.wetuo.wepic.common.struts.PageAction;
import com.wetuo.wepic.deal.beans.Industry;
import com.wetuo.wepic.deal.service.IndusterService;

public class IndustryAction extends PageAction {
	private IndusterService industerService;
	private List<Industry> list;
	private ArrayList<Industry> onelist;
	private ArrayList<Industry> twolist;
	private ArrayList<Industry> threelist;
	
	public IndustryAction(String  className) {
	try{
		model=Class.forName(className).newInstance();
	}catch (Exception e) {
		e.printStackTrace();
	}	
	
	}
	public String saveIndustry(){
		
		
		String[] str=new String[]{"农/林/牧/渔","跨领域经营","环保","其它"};
		
		for (String string : str) {
			Industry industry=new Industry();
			industry.setName(string);
			industry.setpId(48);
			industry.setType("node");
			industerService.save(industry);
		}
		
		
		
		
		
		//industerService.save((Industry)model);
		return "saveIndustry";
	}
	 public String updateIndustry(){
		 industerService.update((Industry)model);
		 return "updateIndustry";
	 }
	 public String deleteIndustry(){
		 
		 industerService.delete(1);
		 // industerService.delete(((Industry)model).getId());
		 
		 return "deleteIndustry";
	 }

	 
	 public String findListIndutrys(){
		 onelist=new ArrayList<Industry>();
		 twolist=new ArrayList<Industry>();
		 threelist=new ArrayList<Industry>();
      DetachedCriteria detachedCriteria=DetachedCriteria.forClass(Industry.class);
      detachedCriteria.add(Restrictions.eq("type", "parent"));
      list=industerService.findByDetachriteri(detachedCriteria);
      for(Industry industry:list){
        DetachedCriteria detachedCriteriaChild=DetachedCriteria.forClass(Industry.class);
    	detachedCriteriaChild.add(Restrictions.eq("pId", industry.getId()));
    	List<Industry> industries=industerService.findByDetachriteri(detachedCriteriaChild);
    	industry.setChildList(industries);
    	if("IT/通信/电子/互联网".equals(industry.getName().trim())||"文教体育/工艺美术".equals(industry.getName().trim())||"加工制造/仪表设备".equals(industry.getName().trim())||"政府/非盈利机构".equals(industry.getName().trim())){
    		onelist.add(industry);
    	}else if("商业服务".equals(industry.getName().trim())||"贸易/批发/零售业".equals(industry.getName().trim())||"酒店/餐饮/旅游".equals(industry.getName().trim())||"文化/体育/娱乐业".equals(industry.getName().trim())||"农林牧渔/其他".equals(industry.getName().trim())){
    		threelist.add(industry);
    	}else{
    		twolist.add(industry);
    	}
    	
    	
    	
    	
    	
      }
      
      
      
      return "findListIndutrys";
	 }
	 
	 
	 
	 
	 
	public IndusterService getIndusterService() {
		return industerService;
	}
	public void setIndusterService(IndusterService industerService) {
		this.industerService = industerService;
	}
	public List<Industry> getList() {
		return list;
	}
	public void setList(List<Industry> list) {
		this.list = list;
	}
	public ArrayList<Industry> getOnelist() {
		return onelist;
	}
	public void setOnelist(ArrayList<Industry> onelist) {
		this.onelist = onelist;
	}
	public ArrayList<Industry> getTwolist() {
		return twolist;
	}
	public void setTwolist(ArrayList<Industry> twolist) {
		this.twolist = twolist;
	}
	public ArrayList<Industry> getThreelist() {
		return threelist;
	}
	public void setThreelist(ArrayList<Industry> threelist) {
		this.threelist = threelist;
	}
	 
	 
	 
	 
	 
	 
	 
}
