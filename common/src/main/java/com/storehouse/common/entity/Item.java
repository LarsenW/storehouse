package com.storehouse.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.storehouse.common.enums.FileCategory;

@Entity
@Table(name = "item")
public class Item extends Model {

	private String name;

	private String description;

	@Column(columnDefinition = "LONGBLOB")
	private byte[] data;

	private Boolean privacy;

	@ManyToOne
	@JoinColumn
	private User user;

	@Enumerated(EnumType.STRING)
	private FileCategory fileCategory = FileCategory.OTHER;

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

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Boolean getPrivacy() {
		return privacy;
	}

	public void setPrivacy(Boolean privacy) {
		this.privacy = privacy;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public FileCategory getFileCategory() {
		return fileCategory;
	}

	public void setFileCategory(FileCategory fileCategory) {
		this.fileCategory = fileCategory;
	}

	@Override
	public String toString() {
		return name + " " + description;
	}
}
