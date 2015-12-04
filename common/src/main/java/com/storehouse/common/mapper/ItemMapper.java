package com.storehouse.common.mapper;

import com.storehouse.common.dto.ItemDto;
import com.storehouse.common.entity.Item;

public class ItemMapper {
	public ItemDto entityToDto(Item item) {
		ItemDto itemDto = new ItemDto();
		itemDto.setName(item.getName());
		itemDto.setDescription(item.getDescription());
		itemDto.setData(item.getData());
		itemDto.setCreated(item.getCreated());
		itemDto.setFileCategory(item.getFileCategory());
		return itemDto;
	}

	public Item dtoToEntity(ItemDto itemDto) {
		Item item = new Item();
		item.setName(itemDto.getName());
		item.setDescription(itemDto.getDescription());
		item.setPrivacy(itemDto.getPrivacy());
		item.setData(itemDto.getData());
		item.setFileCategory(itemDto.getFileCategory());
		item.setUser(itemDto.getUser());
		return item;
	}
}
