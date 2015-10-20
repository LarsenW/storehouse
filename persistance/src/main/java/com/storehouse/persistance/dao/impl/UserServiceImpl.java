package com.storehouse.persistance.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storehouse.common.entity.User;
import com.storehouse.persistance.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	public void persistUser(User user) {
		userDao.persist(user);

	}

	public void updateUser(User user) {
		userDao.update(user);
	}

	public void deleteUser(User user) {
		userDao.delete(user);
	}

	public List<User> findAll() {
		List<User> users = userDao.findAll();
		return users;
	}

	public User getById(Long id) {
		User user = userDao.getById(id);
		return user;
	}

}