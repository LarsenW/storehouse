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
		userDaoImpl.openCurrentSessionWithTransaction();
		userDaoImpl.persist(user);
		userDaoImpl.closeCurrentSessionWithTransaction();

	}

	public void updateUser(User user) {
		userDaoImpl.openCurrentSessionWithTransaction();
		userDaoImpl.update(user);
		userDaoImpl.closeCurrentSessionWithTransaction();
	}

	public void deleteUser(User user) {
		userDaoImpl.openCurrentSessionWithTransaction();
		userDaoImpl.delete(user);
		userDaoImpl.closeCurrentSessionWithTransaction();
	}

	public List<User> findAll() {
		userDaoImpl.openCurrentSessionWithTransaction();
		List<User> users = userDaoImpl.findAll();
		userDaoImpl.closeCurrentSessionWithTransaction();
		return users;
	}

	public User getById(Long id) {
		userDaoImpl.openCurrentSessionWithTransaction();
		User user = userDaoImpl.getById(id);
		userDaoImpl.closeCurrentSessionWithTransaction();
		return user;
	}
}
