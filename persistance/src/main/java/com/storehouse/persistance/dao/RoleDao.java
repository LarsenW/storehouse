package com.storehouse.persistance.dao;

import com.storehouse.common.entity.Role;
import com.storehouse.common.enums.UserType;

public interface RoleDao extends GenericDao<Role> {
	
	public Role getRoleByUserType(UserType userType);
}
