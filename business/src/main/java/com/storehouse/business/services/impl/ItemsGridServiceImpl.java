package com.storehouse.business.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.storehouse.business.services.ItemsGridService;
import com.storehouse.common.dto.ItemDto;
import com.storehouse.common.entity.Item;
import com.storehouse.common.mapper.ItemMapper;
import com.storehouse.persistance.dao.ItemDao;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ItemsGridServiceImpl implements ItemsGridService {
	@Autowired
	ItemDao itemDao;

	public List<ItemDto> findAllByUserId(Long id) {
		ItemMapper itemMapper = new ItemMapper();
		List<ItemDto> itemDtos = new ArrayList<ItemDto>();
		for (Item item : itemDao.findAllByUserId(id)) {
			itemDtos.add(itemMapper.entityToDto(item));
		}
		return itemDtos;
	}

	public List<ItemDto> findAllByUserId(Long id, Boolean privacy) {
		ItemMapper itemMapper = new ItemMapper();
		List<ItemDto> itemDtos = new ArrayList<ItemDto>();
		for (Item item : itemDao.findAllByUserId(id, privacy)) {
			itemDtos.add(itemMapper.entityToDto(item));
		}
		return itemDtos;
	}
}
