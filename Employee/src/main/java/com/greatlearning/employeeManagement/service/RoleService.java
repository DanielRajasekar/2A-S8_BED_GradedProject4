package com.greatlearning.employeeManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeeManagement.entity.Role;
import com.greatlearning.employeeManagement.repository.RoleRepository;


@Service
public class RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	public Role addRole(Role role) {
		return roleRepository.saveAndFlush(role);
	}
	public List<Role> getRole() {
		return roleRepository.findAll();
	}
}
