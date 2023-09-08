package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.Role;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.exceptions.UserException;
import com.exam.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userservice;
	@PostMapping("/")
	public ResponseEntity<User> createUser(@RequestBody User user)throws UserException{
		
		
		Set<UserRole> roles = new HashSet<>();
		Role role1 = new Role();
		role1.setRole_id(44L);
		role1.setRoleName("ADMIN");
		UserRole userRole = new UserRole();
		userRole.setUser(user);
		userRole.setRole(role1);
		roles.add(userRole);
		
		
		return new ResponseEntity<>(userservice.createUser(user, roles),HttpStatus.OK);
	}
	
}
