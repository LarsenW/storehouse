package com.strorehouse.business.services.impl;

import java.util.List;

import com.storehouse.common.entity.User;
import com.storehouse.persistance.dao.UserDao;
import com.storehouse.persistance.dao.impl.UserDaoImpl;
import com.strorehouse.business.services.UserService;

public class UserServiceImpl implements UserService {

	private static UserDaoImpl userDaoImpl;

	static {
		userDaoImpl = new UserDaoImpl();
	}

	public void persistUser(User user) {
		userDaoImpl.openCurrentSession();
		userDaoImpl.persist(user);
		userDaoImpl.closeCurrentSession();

	}

	public void updateUser(User user) {
		userDaoImpl.openCurrentSession();
		userDaoImpl.update(user);
		userDaoImpl.closeCurrentSession();
	}

	public void deleteUser(User user) {
		userDaoImpl.openCurrentSession();
		userDaoImpl.delete(user);
		userDaoImpl.closeCurrentSession();
	}

	public List<User> findAll() {
		userDaoImpl.openCurrentSession();
		List<User> users = userDaoImpl.findAll();
		userDaoImpl.closeCurrentSession();
		return users;
	}

	public User getById(Long id) {
		userDaoImpl.openCurrentSession();
		User user = userDaoImpl.getById(id);
		userDaoImpl.closeCurrentSession();
		return user;
	}
}
