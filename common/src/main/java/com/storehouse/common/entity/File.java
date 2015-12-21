package com.storehouse.common.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "file")
public class File extends Model {

	@OneToOne
	@JoinColumn
	private Item item;

	@Column(columnDefinition = "LONGBLOB")
	private byte[] data;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
