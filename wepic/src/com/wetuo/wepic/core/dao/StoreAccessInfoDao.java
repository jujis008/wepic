package com.wetuo.wepic.core.dao;

import java.util.List;

import com.wetuo.wepic.core.beans.LoginInfo;

public interface StoreAccessInfoDao {

	public void saveInfo(LoginInfo info);

	public List<LoginInfo> showCount();

}
