package com.storehouse.persistance.dao.impl;

import javax.persistence.Query;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.storehouse.common.entity.User;
import com.storehouse.persistance.dao.UserDao;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public User getUserByEmail(String email) {
		Query query = entityManager.createQuery("Select u FROM User u WHERE u.email = :email AND u.active = true");
		query.setParameter("email", email);
		User user;
		try {
			user = (User) query.getSingleResult();
		} catch (javax.persistence.NoResultException e) {
			throw new UsernameNotFoundException(email);
		}
		return user;
	}

	public User getUserByName(String name) {
		Query query = entityManager.createQuery("Select u FROM User u WHERE u.name = :name AND u.active = true");
		query.setParameter("name", name);
		User user;
		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
		return user;
	}
}