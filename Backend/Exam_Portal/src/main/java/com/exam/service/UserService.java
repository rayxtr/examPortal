package com.exam.service;


import java.util.List;

import com.exam.entity.User;
import com.exam.exceptions.UserException;

public interface UserService {

	public User createUser(User user) throws UserException;

	public User getUserByUserName(String username) throws UserException;
	
	public List<User> getAllUsers() throws UserException;
	
	public User updateUser(User user) throws UserException;
	
	public User deleteUser(String username) throws UserException; 

}
