package com.storehouse.business.services;

import com.storehouse.common.dto.FileDto;
import com.storehouse.common.dto.ItemDto;

public interface ItemCreatingService {
	public void createItemWithFile(ItemDto itemDto,FileDto fileDto);
}
