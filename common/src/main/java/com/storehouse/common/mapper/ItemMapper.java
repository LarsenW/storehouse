package com.storehouse.common.mapper;

import com.storehouse.common.dto.ItemDto;
import com.storehouse.common.entity.Item;

public class ItemMapper {
	public ItemDto entityToDto(Item item) {
		ItemDto itemDto = new ItemDto();
		itemDto.setName(item.getName());
		item.setDescription(item.getDescription());
		itemDto.setData(item.getData());
		itemDto.setCreated(item.getCreated());
		return itemDto;
	}
}
