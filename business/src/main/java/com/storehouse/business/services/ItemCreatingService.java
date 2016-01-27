package com.storehouse.business.services;

import java.io.InputStream;

import com.storehouse.common.dto.ItemDto;

public interface ItemCreatingService {
	public void createItem(ItemDto itemDto, InputStream inputStream);
}
