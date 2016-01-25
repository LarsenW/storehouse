package com.storehouse.business.services;

import com.storehouse.common.dto.UserDto;

public interface UserCreatingService {
	public boolean createUser(UserDto userDto);
}
