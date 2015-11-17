package com.storehouse.business.services.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.storehouse.business.services.RoleService;
import com.storehouse.business.services.UserService;
import com.storehouse.business.utils.PasswordHelper;
import com.storehouse.common.entity.Role;
import com.storehouse.common.entity.User;
import com.storehouse.common.enums.UserType;
import com.storehouse.persistance.dao.UserDao;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private PasswordHelper passwordHelper;
	@Autowired
	private RoleService roleService;

	public void persistUser(User user) {
		user.setPassword(passwordHelper.encode(user.getPassword()));
		Role role = roleService.getRoleByUserType(UserType.ROLE_USER);
		user.getUserRoles().add(role);
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

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userDao.getUserByEmail(email);
		return user;
	}

}
