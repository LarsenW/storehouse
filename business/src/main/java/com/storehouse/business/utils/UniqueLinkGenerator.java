package com.storehouse.business.utils;

import java.util.UUID;

public class UniqueLinkGenerator {

	public String generate() {
		return UUID.randomUUID().toString();
	}
}
