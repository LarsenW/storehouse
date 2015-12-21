package com.storehouse.common.mapper;

import com.storehouse.common.dto.FileDto;
import com.storehouse.common.entity.File;

public class FileMapper {
	public File dtoToEntity(FileDto fileDto) {
		File file = new File();
		file.setData(fileDto.getData());
		return file;

	}
}
