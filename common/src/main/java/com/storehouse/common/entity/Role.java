package com.storehouse.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.storehouse.common.enums.UserType;

@Entity
@Table(name = "role")
public class Role extends Model {

	@ManyToMany(mappedBy = "userRoles")
	private Set<User> user = new HashSet<User>();

	@Enumerated(EnumType.STRING)
	private UserType userType;

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

}
