package com.storehouse.business.services;

import java.util.List;

import com.storehouse.common.dto.ItemGridDto;

public interface ItemsGridService {
	public List<ItemGridDto> findAllByUserId(Long id);

	public List<ItemGridDto> findAllByUserId(Long id, Boolean privacy);
}
