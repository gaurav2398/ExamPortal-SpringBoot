package com.cg.quiz;

import java.util.HashSet;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.cg.quiz.controller.UserController;
import com.cg.quiz.entity.Role;
import com.cg.quiz.entity.User;
import com.cg.quiz.entity.UserRole;
import com.cg.quiz.repository.UserRepository;
import com.cg.quiz.service.UserService;

import net.bytebuddy.asm.Advice.This;

@SpringBootApplication
public class QuizSpringProjectApplication {

	@Autowired
	UserService userService;
	
		
	public static void main(String[] args) {
		 SpringApplication.run(QuizSpringProjectApplication.class, args);
//		ApplicationContext context =  SpringApplication.run(QuizSpringProjectApplication.class, args);
//		UserRepository userRepository = context.getBean(UserRepository.class);
		 			
	}	

	@Component
	public class CommandLineAppStartupRunner implements CommandLineRunner {
	    @Override
	    public void run(String...args) throws Exception {
	    	try {				
				 User user = new User();
				 user.setFirstName("admin");
				 user.setLastName("admin");
				 user.setUsername("admin");
				 user.setPassword("admin");
				 user.setEmail("admin@gmail.com");
				 user.setProfile("default.png");
				 
				 Role role1 = new Role();
				 role1.setRoleId(44L);
				 role1.setRoleName("ADMIN");
				 
				 Set<UserRole> userRoleSet = new HashSet<UserRole>();
				 UserRole userRole = new UserRole();
				 
				 userRole.setRole(role1);
				 userRole.setUser(user);
				 userRoleSet.add(userRole);
				 
				 
				 User user1 = userService.createUser(user, userRoleSet);
				 System.out.println(user.getUsername());
				}
				catch (Exception e) {
					System.out.println("Already Exists : "+ e.getMessage());
					e.printStackTrace();
					
				}
	    }
	}
}
