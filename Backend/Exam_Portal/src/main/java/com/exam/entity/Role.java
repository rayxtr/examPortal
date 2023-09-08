package com.exam.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Role {

	@Id
	private Long role_id;
	
	private String roleName;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "role")
	private Set<UserRole> userRoles = new HashSet<>();
}
