package com.storehouse.persistance.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.storehouse.common.entity.Role;
import com.storehouse.common.enums.UserType;
import com.storehouse.persistance.dao.RoleDao;

@Repository
public class RoleDaoImpl extends GenericDaoImpl<Role> implements RoleDao {
	public Role getRoleByUserType(UserType userType) {
		Query query = entityManager.createQuery("Select r FROM Role r WHERE r.userType = :userType");
		query.setParameter("userType", userType);
		Role role = (Role) query.getSingleResult();
		return role;

	}
}
