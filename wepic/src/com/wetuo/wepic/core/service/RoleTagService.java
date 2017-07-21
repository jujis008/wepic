package com.wetuo.wepic.core.service;

import java.util.List;

import com.wetuo.wepic.core.beans.RoleTags;

public interface RoleTagService {
public boolean insert(RoleTags roleTag);
public List<RoleTags> findByRole(String role);
public  RoleTags  findByRoleId(int id);
}
