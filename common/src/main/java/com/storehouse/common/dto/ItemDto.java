package com.storehouse.common.dto;

import com.storehouse.common.entity.User;
import com.storehouse.common.enums.FileCategory;

public class ItemDto {
	private String name;

	private String description;

	private Boolean privacy = false;

	private FileCategory fileCategory = FileCategory.OTHER;

	private User user;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getPrivacy() {
		return privacy;
	}

	public void setPrivacy(Boolean privacy) {
		this.privacy = privacy;
	}

	public FileCategory getFileCategory() {
		return fileCategory;
	}

	public void setFileCategory(FileCategory fileCategory) {
		this.fileCategory = fileCategory;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
