package com.wetuo.wepic.core.dao;

import java.util.List;

import com.wetuo.wepic.common.hibernate.XgHibernateCommonDao;
import com.wetuo.wepic.core.beans.LoginInfo;

public class StoreAccessInfoDaoImpl extends XgHibernateCommonDao implements StoreAccessInfoDao {

	public void saveInfo(LoginInfo info) {
	    this.getHibernateTemplate().save(info);
	}

	public List<LoginInfo> showCount() {
		String hql = "from LoginInfo";
		List<LoginInfo> list = this.getHibernateTemplate().find(hql);
		return list;
	}

}
