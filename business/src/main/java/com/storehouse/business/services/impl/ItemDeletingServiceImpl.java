package com.storehouse.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.storehouse.business.services.ItemDeletingService;
import com.storehouse.business.services.ItemService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ItemDeletingServiceImpl implements ItemDeletingService {

	@Autowired
	ItemService itemService;

	public void deleteItemById(Long id) {
		itemService.deleteItem(itemService.getById(id));
	}

}
