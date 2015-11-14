package com.storehouse.persistance.dao;

import com.storehouse.common.entity.User;

public interface UserDao extends GenericDao<User> {
	User getUserByEmail(String email);
}
