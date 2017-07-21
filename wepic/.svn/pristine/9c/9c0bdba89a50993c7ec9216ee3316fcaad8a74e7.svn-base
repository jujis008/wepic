package com.wetuo.wepic.core.service;

import java.util.List;

import com.wetuo.wepic.core.beans.RoleTags;
import com.wetuo.wepic.core.dao.RoleTagDao;

public class RoleTagServiceImp implements RoleTagService {
	private RoleTagDao roleTagDao;
public boolean insert(RoleTags roleTag){
	
	
	return roleTagDao.insert(roleTag);
	
	
}
public List<RoleTags> findByRole(String role){
	
	return roleTagDao.findByRole(role);
	
}

public  RoleTags  findByRoleId(int id){
	
	return roleTagDao.findByRoleId(id);
	
}


public RoleTagDao getRoleTagDao() {
	return roleTagDao;
}
public void setRoleTagDao(RoleTagDao roleTagDao) {
	this.roleTagDao = roleTagDao;
}




}
