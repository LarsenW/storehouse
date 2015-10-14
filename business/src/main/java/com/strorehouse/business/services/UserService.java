package com.strorehouse.business.services;

import java.util.List;

import com.storehouse.common.entity.User;

public interface UserService {

	public void persistUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

	public List<User> findAll();

	public User getById(Long id);
}
