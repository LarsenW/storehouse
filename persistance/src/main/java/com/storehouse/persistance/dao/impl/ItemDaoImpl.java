package com.storehouse.persistance.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.storehouse.common.entity.Item;
import com.storehouse.persistance.dao.ItemDao;


@Repository
public class ItemDaoImpl extends GenericDaoImpl<Item> implements ItemDao {

	@SuppressWarnings("unchecked")
	public List<Item> findAllByUserId(Long id) {
		Query query = entityManager.createQuery("Select i from Item i where i.user.id=" + id);
		return query.getResultList();
	}

}
