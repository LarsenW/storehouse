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
		itemDaoImpl.openCurrentSession();
		itemDaoImpl.persist(item);
		itemDaoImpl.closeCurrentSession();

	}

	public void updateItem(Item item) {
		itemDaoImpl.openCurrentSession();
		itemDaoImpl.update(item);
		itemDaoImpl.closeCurrentSession();
	}

	public void deleteItem(Item item) {
		itemDaoImpl.openCurrentSession();
		itemDaoImpl.delete(item);
		itemDaoImpl.closeCurrentSession();
	}

	public List<Item> findAll() {
		itemDaoImpl.openCurrentSession();
		List<Item> items = itemDaoImpl.findAll();
		itemDaoImpl.closeCurrentSession();
		return items;
	}

	public Item getById(Long id) {
		itemDaoImpl.openCurrentSession();
		Item item = itemDaoImpl.getById(id);
		itemDaoImpl.closeCurrentSession();
		return item;
	}

}
