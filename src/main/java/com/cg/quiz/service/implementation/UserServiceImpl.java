package com.cg.quiz.service.implementation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.quiz.entity.Role;
import com.cg.quiz.entity.User;
import com.cg.quiz.entity.UserRole;
import com.cg.quiz.repository.RoleRepository;
import com.cg.quiz.repository.UserRepository;
import com.cg.quiz.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception{
		
		User local = this.userRepository.findByUsername(user.getUsername());
		if (local!= null) {
			System.out.println("User is already exists !");
			throw new Exception("User already exists !");
		}
		else {
			//create user
			for(UserRole ur: userRoles)
			{
				roleRepository.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
		}
			
		return local;
	}


	//getting user by username
	@Override
	public User getUser(String username) {

		return this.userRepository.findByUsername(username);
	}


	@Override
	public void deleteUser(Long userId) {
		this.userRepository.deleteById(userId);
		
	}

}
