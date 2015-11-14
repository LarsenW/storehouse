package com.storehouse.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.storehouse.business.services.UserService;
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
		return userDao.findAll();
	}

	public User getById(Long id) {
		return userDao.getById(id);
	}

	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		User user = userDao.getUserByName(name);
		return user;
	}

}
