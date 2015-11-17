package com.storehouse.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storehouse.business.services.RoleService;
import com.storehouse.common.entity.Role;
import com.storehouse.common.enums.UserType;
import com.storehouse.persistance.dao.RoleDao;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;

	public Role getRoleByUserType(UserType userType) {

		return roleDao.getRoleByUserType(userType);
	}

}
