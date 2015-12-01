package com.storehouse.persistance.dao;

import java.util.List;

import com.storehouse.common.entity.Item;

public interface ItemDao extends GenericDao<Item> {
	List<Item> findAllByUserId(Long id);

	List<Item> findAllByUserId(Long id, Boolean privacy);
}
