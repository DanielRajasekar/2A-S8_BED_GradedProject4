package com.greatlearning.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employeeManagement.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsername(String username);

}
