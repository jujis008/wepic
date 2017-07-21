package com.wetuo.wepic.deal.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import com.wetuo.wepic.deal.beans.Industry;
import com.wetuo.wepic.deal.dao.IndustryDao;

public class IndustryServiceImp implements IndusterService  {
	private IndustryDao dao;

	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}

	public List<Industry> findByDetachriteri(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
	 return dao.findByDetachriteri(detachedCriteria);
	}
	public Industry getById(int id){
		
		
		
		
		return dao.getById(id);
		
		
		
	}

	public boolean save(Industry industry) {
		// TODO Auto-generated method stub
		return dao.save(industry);
	}

	public boolean update(Industry industry) {
		// TODO Auto-generated method stub
		return dao.update(industry);
	}

	public IndustryDao getDao() {
		return dao;
	}

	public void setDao(IndustryDao dao) {
		this.dao = dao;
	}
	

}
