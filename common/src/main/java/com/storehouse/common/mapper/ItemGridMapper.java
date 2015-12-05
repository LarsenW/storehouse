package com.storehouse.common.mapper;

import com.storehouse.common.dto.ItemGridDto;
import com.storehouse.common.entity.Item;

public class ItemGridMapper {
	public ItemGridDto entityToDto(Item item) {
		ItemGridDto itemgridDto = new ItemGridDto();
		itemgridDto.setId(item.getId());
		itemgridDto.setName(item.getName());
		itemgridDto.setDescription(item.getDescription());
		itemgridDto.setCreated(item.getCreated());
		itemgridDto.setFileCategory(item.getFileCategory());
		itemgridDto.setPrivacy(item.getPrivacy());
		return itemgridDto;
	}

}
