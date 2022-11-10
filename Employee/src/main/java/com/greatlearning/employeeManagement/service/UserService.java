package com.greatlearning.employeeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.greatlearning.employeeManagement.entity.User;
import com.greatlearning.employeeManagement.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public User addUser(@RequestBody User user) {
		return userRepository.saveAndFlush(user);
	}
	
	public List<User> getUser() {
		return userRepository.findAll();
	}
}
