package com.storehouse.business.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.storehouse.business.services.ItemService;
import com.storehouse.common.entity.Item;
import com.storehouse.persistance.dao.ItemDao;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemDao itemDao;

	public void persistItem(Item item) {
		itemDao.persist(item);

	}

	public void updateItem(Item item) {
		itemDao.update(item);

	}

	public void deleteItem(Item item) {
		itemDao.delete(item);

	}

	public List<Item> findAll() {

		return itemDao.findAll();
	}

	public Item getById(Long id) {

		return itemDao.getById(id);
	}

	public List<Item> findAllByUserId(Long id) {

		return itemDao.findAllByUserId(id);
	}

}
