package com.exam.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.Role;
import com.exam.exceptions.RoleException;
import com.exam.repo.RoleRepo;
import com.exam.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepo rr;
	
	@Override
	public Role getRoleByName(String name) throws RoleException {
		
		Role role = rr.findByroleName(name);
		if(role==null) {
			throw new RoleException("NO role found!!!!!!!");
		}else {
			
			return role;
		}
		
		
		
	}

	@Override
	public Role getRoleById(Long id) throws RoleException {
		
		Role role = rr.findById(id).orElseThrow(()->new RoleException("NO role found"));
		
		return role;
	
	}

	@Override
	public Role addRole(Role role) throws RoleException {
		
		Role existing = rr.findByroleName(role.getRoleName());
		
		if(existing!=null) {
			throw new RoleException("No duplicate role allowed");
		}
		
		return rr.save(role);
	}

	@Override
	public List<Role> getAllRoles() throws RoleException {
		List<Role> roles = rr.findAll();
		if(roles.isEmpty()) {
			throw new RoleException("NO roles added...Please add one");
		}
		return roles;
	}

	@Override
	public String deleteRole(Long roleId) throws RoleException {
		Role role = getRoleById(roleId);
		
		if(role==null) {
			throw new RoleException("No role with this Id");
		}
		
		rr.delete(role);
		return "Role Deleted Successfull";
	}

}
