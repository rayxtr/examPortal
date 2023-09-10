package com.exam.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.exam.entity.User;

import com.exam.exceptions.UserException;

import com.exam.repo.UserRepo;
import com.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo ur;
	

	
	

	@Override
	public User createUser(User user) throws UserException {
		
		User alreadyUser = ur.findByUsername(user.getUsername());
		
		if(alreadyUser!=null) {
			throw new UserException("this user name is not available Please try with different one..");
		}
			
		
		
		return ur.save(user);
	}

	@Override
	public User getUserByUserName(String username) throws UserException {
		
		User user = ur.findByUsername(username);
		if(user==null) {
			throw new UserException("No user found with this username");
		
		}
		
		return user;
	}

	@Override
	public List<User> getAllUsers() throws UserException {
		List<User> users = ur.findAll();
		if(users.isEmpty()) {
			throw new UserException("List is empty Ooops no user in the database");
		}
		return users;
	}

	@Override
	public User updateUser(User user) throws UserException {
		
		return ur.save(user);
	}

	@Override
	public User deleteUser(String username) throws UserException {
	
		return null;
	}
	

}
