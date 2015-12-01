package com.storehouse.business.services;

import java.util.List;

import com.storehouse.common.dto.ItemDto;

public interface ItemsGridService {
	public List<ItemDto> findAllByUserId(Long id);

	public List<ItemDto> findAllByUserId(Long id, Boolean privacy);
}
