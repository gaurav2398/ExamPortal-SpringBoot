package com.cg.quiz.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.cg.quiz.entity.Role;
import com.cg.quiz.entity.User;
import com.cg.quiz.entity.UserRole;

public interface UserService {
	
	//creating user : userrole can be admin/user
	public User createUser(User user,Set<UserRole> role) throws Exception;
	
	//get user by username
	public User getUser(String username);

	//delete user by id
	public void deleteUser(Long userId);
}
