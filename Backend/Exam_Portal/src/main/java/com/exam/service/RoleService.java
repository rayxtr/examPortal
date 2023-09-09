package com.exam.service;

import java.util.List;

import com.exam.entity.Role;
import com.exam.exceptions.RoleException;

public interface RoleService  {
	
	public Role addRole(Role role) throws RoleException;
	public Role getRoleByName(String name) throws RoleException;
	public Role getRoleById(Long id) throws RoleException;
	public List<Role> getAllRoles() throws RoleException;
	public String deleteRole(Long roleId) throws RoleException;
	
}
