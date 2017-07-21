package com.wetuo.wepic.core.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.wetuo.wepic.core.beans.UserDetail;
import com.wetuo.wepic.core.beans.UserPower;
import com.wetuo.wepic.core.dao.UserDetailDao;
import com.wetuo.wepic.core.dao.UserPowerDao;

public class UserPowerServiceImp implements UserPowerService  {

	private UserPowerDao powerDao;
	private UserDetailDao detailDao;
	public boolean addUserPower(UserPower userPower) {
		// TODO Auto-generated method stub
		return powerDao.addUserPower(userPower);
	}

	public boolean deleteRecode(int id) {
		// TODO Auto-generated method stub
		return powerDao.deleteRecode(id);
	}

	public boolean editeRecode(UserPower userPower) {
		// TODO Auto-generated method stub
		return powerDao.editeRecode(userPower);
	}

	public List<UserPower> findUserPowers(DetachedCriteria detachedCriteria) {
		List<UserPower> userPowers=powerDao.findUserPowers(detachedCriteria);
		for (UserPower userPower : userPowers) {
			DetachedCriteria criteria=DetachedCriteria.forClass(UserDetail.class);
			criteria.createAlias("userPower", "userPower");
			criteria.add(Restrictions.eq("userPower", userPower));
			List<UserDetail> userDetails=detailDao.findAllUserPower(criteria);
			userPower.setUserDetails(userDetails);
		}
		
		
		return userPowers;
	}
	public UserPower findPowersById(int id) {
		// TODO Auto-generated method stub
		return powerDao.findPowersById(id);
	}

	public UserPowerDao getPowerDao() {
		return powerDao;
	}

	public void setPowerDao(UserPowerDao powerDao) {
		this.powerDao = powerDao;
	}

	public UserDetailDao getDetailDao() {
		return detailDao;
	}

	public void setDetailDao(UserDetailDao detailDao) {
		this.detailDao = detailDao;
	}
	
	
	

}
