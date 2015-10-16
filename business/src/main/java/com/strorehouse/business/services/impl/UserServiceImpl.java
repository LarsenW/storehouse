package com.strorehouse.business.services.impl;

import java.util.List;
import com.storehouse.common.entity.User;
import com.storehouse.persistance.dao.impl.UserDaoImpl;
import com.strorehouse.business.services.UserService;

public class UserServiceImpl implements UserService {

	private static UserDaoImpl userDaoImpl;

	static {
		userDaoImpl = new UserDaoImpl();
	}

	public void persistUser(User user) {
		userDaoImpl.beginTransaction();
		userDaoImpl.persist(user);
		userDaoImpl.closeTransaction();

	}

	public void updateUser(User user) {
		userDaoImpl.beginTransaction();
		userDaoImpl.update(user);
		userDaoImpl.closeTransaction();
	}

	public void deleteUser(User user) {
		userDaoImpl.beginTransaction();
		userDaoImpl.delete(user);
		userDaoImpl.closeTransaction();
	}

	public List<User> findAll() {
		userDaoImpl.beginTransaction();
		List<User> users = userDaoImpl.findAll();
		userDaoImpl.closeTransaction();
		return users;
	}

	public User getById(Long id) {
		userDaoImpl.beginTransaction();
		User user = userDaoImpl.getById(id);
		userDaoImpl.closeTransaction();
		return user;
	}
}
