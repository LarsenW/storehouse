package com.storehouse.persistance.dao;

import com.storehouse.common.entity.User;

public interface UserDao extends GenericDao<User> {
	
	public User getUserByEmail(String email);
	
	public User getUserByName(String name);
}
