package com.wetuo.wepic.core.service;

import java.util.List;

import com.wetuo.wepic.core.beans.LoginInfo;
import com.wetuo.wepic.core.dao.StoreAccessInfoDao;

public class StoreAccessInfoServiceImpl implements StoreAccessInfoService {
	private StoreAccessInfoDao accessInfoDao;
	public void saveInfo(LoginInfo info) {
		accessInfoDao.saveInfo(info);
	}
	public StoreAccessInfoDao getAccessInfoDao() {
		return accessInfoDao;
	}
	public void setAccessInfoDao(StoreAccessInfoDao accessInfoDao) {
		this.accessInfoDao = accessInfoDao;
	}
	public List<LoginInfo> showCount() {
		// TODO Auto-generated method stub
		return accessInfoDao.showCount();
	}
	
}
