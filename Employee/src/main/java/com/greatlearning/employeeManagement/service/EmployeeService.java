package com.greatlearning.employeeManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.data.domain.Sort.Direction;

import com.greatlearning.employeeManagement.entity.Employee;
import com.greatlearning.employeeManagement.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmployeeByID(int id) {
		return employeeRepository.findById(id);
	}

	public Optional<Employee> create(Employee employee) {
		if (employeeRepository.existsById(employee.getId())) {
			return Optional.empty();
		} else {
			return Optional.of(employeeRepository.save(employee));
		}
	}

	public String delete(int id) {
		if (employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
			return "Employee" + id + "has been deleted";
		} else {
			return "The Employee does not exists";
		}
	}

	public Optional<Employee> update(Employee employee) {
		if (employeeRepository.existsById(employee.getId())) {
			return Optional.of(employeeRepository.save(employee));
		} else {
			return Optional.empty();
		}
	}

	public List<Employee> getEmployeeByFirstName(String firstName) {
		return employeeRepository.findByFirstName(firstName);
	}

	public List<Employee> getEmployeeByOrder(String field) {
		return employeeRepository.findAll(Sort.by(Sort.Direction.ASC, field));
	}
}
