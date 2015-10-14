package com.storehouse.persistance.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.storehouse.common.entity.Item;
import com.storehouse.common.entity.User;
import com.storehouse.persistance.dao.ItemDao;

public class ItemDaoImpl extends GenericDaoImpl<Item> implements ItemDao {

	@SuppressWarnings("unchecked")
	public List<Item> findAll() {
		List<Item> items = null;
		Criteria criteria = getCurrentSession().createCriteria(User.class);
		items = criteria.list();
		return items;
	}

	public Item getById(Long id) {
		Item item = null;
		Criteria criteria = getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.idEq(id));
		item = (Item) criteria.uniqueResult();
		return item;
	}

}
