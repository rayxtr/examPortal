package com.exam.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.exceptions.UserException;
import com.exam.repo.RoleRepo;
import com.exam.repo.UserRepo;
import com.exam.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepo ur;
	
	@Autowired
	private RoleRepo rr;
	
	@Override
	public User createUser(User user, Set<UserRole> userroles) throws UserException {
		
	User exist = ur.findByUsername(user.getUsername());
		
	if(exist!=null) {
		System.out.println("User is already Present");
		throw new UserException("User already Exists..");
	}else {
		for(UserRole u: userroles) {
			rr.save(u.getRole());
		}
		user.getUserRoles().addAll(userroles);
	   exist = ur.save(user);
	}
	
	
		
		return exist;
	}

}
