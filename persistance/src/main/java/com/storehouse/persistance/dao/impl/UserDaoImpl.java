package com.storehouse.persistance.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.storehouse.common.entity.User;
import com.storehouse.persistance.dao.UserDao;

public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	@SuppressWarnings("unchecked")
	public List<User> findAll() {
		List<User> users = null;
		try {
			Criteria criteria = getCurrentSession().createCriteria(User.class);

			users = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	public User getById(Long id) {
		List<User> users = null;
		try {
			Criteria criteria = getCurrentSession().createCriteria(User.class);
			criteria.add(Restrictions.idEq(id));
			users = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users.get(0);
	}
}
