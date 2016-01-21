package com.storehouse.common.mapper;

import com.storehouse.common.dto.UserDto;
import com.storehouse.common.entity.User;

public class UserMapper {
	public User dtoToEntity(UserDto userDto) {
		User user = new User();
		user.setName(userDto.getUsername());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		return user;
	}
}
