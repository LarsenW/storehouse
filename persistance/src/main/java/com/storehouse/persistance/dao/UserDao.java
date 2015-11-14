package com.storehouse.persistance.dao;

import com.storehouse.common.entity.User;

public interface UserDao extends GenericDao<User> {
	User getUserByName(String name);
}
