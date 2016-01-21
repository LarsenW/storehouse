package com.storehouse.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storehouse.business.services.UserCreatingService;
import com.storehouse.business.services.UserService;
import com.storehouse.common.dto.UserDto;
import com.storehouse.common.mapper.UserMapper;

@Service
public class UserCreatingServiceImpl implements UserCreatingService {
	@Autowired
	UserService userService;

	@Override
	public void createUser(UserDto userDto) {
		UserMapper userMapper = new UserMapper();
		userService.persistUser(userMapper.dtoToEntity(userDto));
	}
}
