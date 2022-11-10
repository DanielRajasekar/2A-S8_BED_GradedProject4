package com.greatlearning.employeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employeeManagement.entity.Role;
import com.greatlearning.employeeManagement.service.RoleService;

@RestController
@RequestMapping("/api")
public class RoleController {

	@Autowired
	RoleService roleService;
	
	@PostMapping("/role")
	public Role addRole(@RequestBody Role role) {
		return roleService.addRole(role);
	}
	@GetMapping("/role")
	public List<Role> getRole(){
		return roleService.getRole();
	}
}