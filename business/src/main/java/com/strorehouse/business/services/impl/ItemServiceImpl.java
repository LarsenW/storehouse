package com.strorehouse.business.services.impl;

import java.util.List;

import com.storehouse.common.entity.Item;
import com.storehouse.persistance.dao.impl.ItemDaoImpl;
import com.strorehouse.business.services.ItemService;

public class ItemServiceImpl implements ItemService {

	private static ItemDaoImpl itemDaoImpl;

	static {
		itemDaoImpl = new ItemDaoImpl();
	}

	public void persistItem(Item item) {
		itemDaoImpl.openCurrentSessionWithTransaction();
		itemDaoImpl.persist(item);
		itemDaoImpl.closeCurrentSessionWithTransaction();

	}

	public void updateItem(Item item) {
		itemDaoImpl.openCurrentSessionWithTransaction();
		itemDaoImpl.update(item);
		itemDaoImpl.closeCurrentSessionWithTransaction();
	}

	public void deleteItem(Item item) {
		itemDaoImpl.openCurrentSessionWithTransaction();
		itemDaoImpl.delete(item);
		itemDaoImpl.closeCurrentSessionWithTransaction();
	}

	public List<Item> findAll() {
		itemDaoImpl.openCurrentSessionWithTransaction();
		List<Item> items = itemDaoImpl.findAll();
		itemDaoImpl.closeCurrentSessionWithTransaction();
		return items;
	}

	public Item getById(Long id) {
		itemDaoImpl.openCurrentSessionWithTransaction();
		Item item = itemDaoImpl.getById(id);
		itemDaoImpl.closeCurrentSessionWithTransaction();
		return item;
	}

	public List<Item> findAllByUserId(Long id) {
		itemDaoImpl.openCurrentSessionWithTransaction();
		List<Item> items = itemDaoImpl.findAllByUserId(id);
		itemDaoImpl.closeCurrentSessionWithTransaction();
		return items;
	}

}
