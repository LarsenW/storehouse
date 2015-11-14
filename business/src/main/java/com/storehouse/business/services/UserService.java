package com.storehouse.business.services;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.storehouse.common.entity.User;

public interface UserService extends UserDetailsService {

	public void persistUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

	public List<User> findAll();

	public User getById(Long id);
}
