//package com.strorehouse.business.services.impl;
//
//import java.util.List;
//
//import com.storehouse.common.entity.Item;
//import com.storehouse.persistance.dao.impl.ItemDaoImpl;
//import com.strorehouse.business.services.ItemService;
//
//public class ItemServiceImpl implements ItemService {
//
//	private static ItemDaoImpl itemDaoImpl;
//
//	static {
//		itemDaoImpl = new ItemDaoImpl();
//	}
//
//	public void persistItem(Item item) {
//		itemDaoImpl.beginTransaction();
//		itemDaoImpl.persist(item);
//		itemDaoImpl.closeTransaction();
//
//	}
//
//	public void updateItem(Item item) {
//		itemDaoImpl.beginTransaction();
//		itemDaoImpl.update(item);
//		itemDaoImpl.closeTransaction();
//	}
//
//	public void deleteItem(Item item) {
//		itemDaoImpl.beginTransaction();
//		itemDaoImpl.delete(item);
//		itemDaoImpl.closeTransaction();
//	}
//
//	public List<Item> findAll() {
//		itemDaoImpl.beginTransaction();
//		List<Item> items = itemDaoImpl.findAll();
//		itemDaoImpl.closeTransaction();
//		return items;
//	}
//
//	public Item getById(Long id) {
//		itemDaoImpl.beginTransaction();
//		Item item = itemDaoImpl.getById(id);
//		itemDaoImpl.closeTransaction();
//		return item;
//	}
//
//	public List<Item> findAllByUserId(Long id) {
//		itemDaoImpl.beginTransaction();
//		List<Item> items = itemDaoImpl.findAllByUserId(id);
//		itemDaoImpl.closeTransaction();
//		return items;
//	}
//
//}
