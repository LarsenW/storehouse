package com.storehouse.persistance.dao.impl;

import org.springframework.stereotype.Repository;

import com.storehouse.common.entity.User;
import com.storehouse.persistance.dao.UserDao;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

}