package com.storehouse.business.services;

import com.storehouse.common.entity.User;

public interface AccountUpdatingService {

	public boolean updateEmail(User user, String email);

	public boolean updatePassword(User user, String newPassword, String oldPassword);
}
