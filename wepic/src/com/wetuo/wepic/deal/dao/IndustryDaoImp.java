package com.wetuo.wepic.deal.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.deal.beans.Industry;

public class IndustryDaoImp extends XgHibernateCommonDao implements IndustryDao  {

	public boolean delete(int id) {
		Industry entity=new Industry();
		entity.setId(id);
		
		super.getHibernateTemplate().delete(entity);
		return false;
	}

	public boolean save(Industry industry) {
		
		super.getHibernateTemplate().save(industry);
		
		
		return false;
	}

	public boolean update(Industry industry) {
		super.getHibernateTemplate().update(industry);
		return false;
	}

	public List<Industry> findByDetachriteri(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return super.getHibernateTemplate().findByCriteria(detachedCriteria);
	}

	public Industry getById(int id) {
		// TODO Auto-generated method stub
		return super.getHibernateTemplate().get(Industry.class, id);
	}

}
