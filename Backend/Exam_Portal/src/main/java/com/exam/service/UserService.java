package com.exam.service;

import java.util.Set;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.exceptions.UserException;

public interface UserService {

	public User createUser(User user, Set<UserRole>userroles) throws UserException;
	
	
}
