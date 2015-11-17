package com.storehouse.business.services;

import com.storehouse.common.entity.Role;
import com.storehouse.common.enums.UserType;

public interface RoleService {
	public Role getRoleByUserType(UserType userType);
}
