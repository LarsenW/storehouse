package com.storehouse.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storehouse.business.services.ItemCreatingService;
import com.storehouse.business.services.ItemService;
import com.storehouse.common.dto.ItemDto;
import com.storehouse.common.mapper.ItemMapper;

@Service
public class ItemCreatingServiceImpl implements ItemCreatingService {

	@Autowired
	ItemService itemService;

	public void createItem(ItemDto itemDto) {
		ItemMapper itemMapper = new ItemMapper();
		itemService.persistItem(itemMapper.dtoToEntity(itemDto));
	}

}
