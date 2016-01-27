package com.storehouse.business.services.impl;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storehouse.business.services.ItemCreatingService;
import com.storehouse.business.services.ItemService;
import com.storehouse.common.dto.ItemDto;
import com.storehouse.common.entity.Item;
import com.storehouse.common.mapper.ItemMapper;

@Service
public class ItemCreatingServiceImpl implements ItemCreatingService {

	@Autowired
	ItemService itemService;

	@Autowired
	FTPClient ftpClient;

	public void createItem(ItemDto itemDto, InputStream inputStream) {
		ItemMapper itemMapper = new ItemMapper();
		Item item = itemMapper.dtoToEntity(itemDto);
		itemService.persistItem(item);
		try {
			ftpClient.storeFile(item.getName(), inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
