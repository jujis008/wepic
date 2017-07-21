package com.wetuo.wepic.core.dao;

import java.util.List;

import com.wetuo.wepic.core.beans.RoleTags;

public interface RoleTagDao {
public boolean insert(RoleTags roleTag);
public List<RoleTags> findByRole(String role);
public  RoleTags findByRoleId(int id);
}
