package com.exam.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.entity.User;
import com.exam.exceptions.UserException;
import com.exam.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
		@PostMapping("/")
	    public ResponseEntity<User> addUser(@RequestBody User user)throws UserException {
	       
		 User savedUser = userService.createUser(user);
	        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	    }
		
		@PutMapping("/update")
		public ResponseEntity<User> updateUser(@RequestBody User user) throws UserException{
		
			return new ResponseEntity<>(userService.updateUser(user),HttpStatus.CREATED);
			
		}
		
		@GetMapping("/")
		public ResponseEntity<List<User>> getAllUser() throws UserException{
			
			return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
			
		}
		
		

		
	  
	
}
