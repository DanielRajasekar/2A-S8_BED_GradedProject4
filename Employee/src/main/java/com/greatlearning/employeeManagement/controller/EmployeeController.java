package com.greatlearning.employeeManagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.data.domain.Sort.Direction;
import com.greatlearning.employeeManagement.entity.Employee;
import com.greatlearning.employeeManagement.repository.EmployeeRepository;
import com.greatlearning.employeeManagement.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/employees")
	public List<Employee> getAllEmployee() {
		return employeeService.getAllEmployee();
	}

	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployee(@PathVariable Integer id) {
		return employeeService.getEmployeeByID(id);
	}

	@PostMapping
	public String saveEmployee(@RequestBody Employee employee) {
		Optional<Employee> _employee = employeeService.create(employee);
		if (_employee.isPresent()) {
			return "The employee data  has been saved successfully";
		} else {
			return "Employee already exist in record";
		}
	}

	@DeleteMapping("/employee/{id}")
	public String deleteEmployeeByID(@PathVariable Integer id) {

		return employeeService.delete(id);
	}

	@PutMapping("/employee/{id}")
	public String updateEmployee(@RequestBody Employee employee) {
		Optional<Employee> _employee = employeeService.update(employee);
		if (_employee.isEmpty()) {
			return "The employee does not exist";
		} else {
			return "The employee has been updated";
		}
	}

	@GetMapping("/employee/search/{firstName}")
	public ResponseEntity<List<Employee>> getEmployeeByFirstName(@PathVariable String firstName) {
		List<Employee> emp = employeeService.getEmployeeByFirstName(firstName);
		if (emp.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		}
		return ResponseEntity.of(Optional.of(emp));

	}

	@GetMapping("/sort/{field}")
	public List<Employee> getEmployeeByOrder(@PathVariable String field) {
		List<Employee> allEmployee = employeeService.getEmployeeByOrder(field);
		return allEmployee;
	}
}