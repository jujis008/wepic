package com.wetuo.wepic.core.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.core.beans.RoleTags;

public class RoleTagDaoImp extends XgHibernateCommonDao implements RoleTagDao  {
public boolean insert(RoleTags roleTag){
	super.getHibernateTemplate().save(roleTag);
	return false;
	
}
public List<RoleTags> findByRole(String role){
	DetachedCriteria criteria=DetachedCriteria.forClass(RoleTags.class);
	criteria.add(Restrictions.eq("role", role));
	
	
	return super.getHibernateTemplate().findByCriteria(criteria);
	
}


public  RoleTags findByRoleId(int id){
	
	return super.getHibernateTemplate().get(RoleTags.class, id);
	
}
}
