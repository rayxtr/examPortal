package com.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Role;
import com.exam.exceptions.RoleException;
import com.exam.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleService;
	
	
	 @PostMapping("/")
	    public ResponseEntity<Role> addRole(@RequestBody Role role) throws RoleException {
	        Role savedRole = roleService.addRole(role);
	        return new ResponseEntity<>(savedRole, HttpStatus.CREATED);
	    }

	    @GetMapping("/{name}")
	    public ResponseEntity<Role> getRoleByName(@PathVariable String name) throws RoleException {
	        Role role = roleService.getRoleByName(name);
	        if (role != null) {
	            return new ResponseEntity<>(role, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @GetMapping("/allRoles")
	    public ResponseEntity<List<Role>> getAllRoles() throws RoleException{
	        List<Role> roles = roleService.getAllRoles();
	        return new ResponseEntity<>(roles, HttpStatus.OK);
	    }
	    
	    
	    @DeleteMapping("/{id}")
	    public ResponseEntity<String>deleteRole(@PathVariable Long id) throws RoleException{
	    	
	    	return new ResponseEntity<>(roleService.deleteRole(id),HttpStatus.OK);
	    	
	    }
	    
}
