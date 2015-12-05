package com.storehouse.business.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.storehouse.business.services.ItemsGridService;
import com.storehouse.common.dto.ItemGridDto;
import com.storehouse.common.entity.Item;
import com.storehouse.common.mapper.ItemGridMapper;
import com.storehouse.persistance.dao.ItemDao;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ItemsGridServiceImpl implements ItemsGridService {
	@Autowired
	ItemDao itemDao;

	public List<ItemGridDto> findAllByUserId(Long id) {
		ItemGridMapper itemGridMapper = new ItemGridMapper();
		List<ItemGridDto> itemGridDtos = new ArrayList<ItemGridDto>();
		for (Item item : itemDao.findAllByUserId(id)) {
			itemGridDtos.add(itemGridMapper.entityToDto(item));
		}
		return itemGridDtos;
	}

	public List<ItemGridDto> findAllByUserId(Long id, Boolean privacy) {
		ItemGridMapper itemGridMapper = new ItemGridMapper();
		List<ItemGridDto> itemGridDtos = new ArrayList<ItemGridDto>();
		for (Item item : itemDao.findAllByUserId(id, privacy)) {
			itemGridDtos.add(itemGridMapper.entityToDto(item));
		}
		return itemGridDtos;
	}
}
