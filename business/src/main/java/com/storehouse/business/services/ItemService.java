package com.storehouse.business.services;

import java.util.List;

import com.storehouse.common.entity.Item;

public interface ItemService {
	public void persistItem(Item item);

	public void updateItem(Item item);

	public void deleteItem(Item item);

	public List<Item> findAll();

	public Item getById(Long id);
}
