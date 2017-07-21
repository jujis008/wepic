package com.wetuo.wepic.core.dao;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.core.beans.UserPower;

public class UserPowerDaoImp extends XgHibernateCommonDao implements UserPowerDao{

	public boolean addUserPower(UserPower userPower) {
		try{
		super.getHibernateTemplate().save(userPower);
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean deleteRecode(int id) {
		try{
			super.getHibernateTemplate().delete(super.getHibernateTemplate().get(UserPower.class, id));
		}catch (Exception e) {
			return false;
		}
		return true;
	}

	public List<UserPower> findUserPowers(DetachedCriteria detachedCriteria) {
		
		return super.getHibernateTemplate().findByCriteria(detachedCriteria);
	}

	public boolean editeRecode(UserPower userPower) {
		try{
			super.getHibernateTemplate().update(userPower);
		}catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public UserPower findPowersById(int id){
		
		
		return super.getHibernateTemplate().get(UserPower.class, id);
	}

}
