package com.storehouse.business.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storehouse.business.services.ItemCreatingService;
import com.storehouse.business.services.ItemService;
import com.storehouse.common.dto.FileDto;
import com.storehouse.common.dto.ItemDto;
import com.storehouse.common.entity.File;
import com.storehouse.common.entity.Item;
import com.storehouse.common.mapper.FileMapper;
import com.storehouse.common.mapper.ItemMapper;

@Service
public class ItemCreatingServiceImpl implements ItemCreatingService {

	@Autowired
	ItemService itemService;

	public void createItemWithFile(ItemDto itemDto,FileDto fileDto) {
		ItemMapper itemMapper = new ItemMapper();
		FileMapper fileMapper=new FileMapper();
		Item item=itemMapper.dtoToEntity(itemDto);
		File file=fileMapper.dtoToEntity(fileDto);
		file.setItem(item);
		item.setFile(file);
		
		itemService.persistItem(item);
	}

}
