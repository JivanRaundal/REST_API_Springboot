package com.psl.training.service;

import java.util.List;

import com.psl.training.model.Employee;

public interface EmployeeService {
	
	
	Employee addEmployee(Employee e);

	Employee getEmployee(Long id);

	List<Employee> getAllEmployees();

	Employee updateEmployee(Employee e);

	void deleteEmployee(Long id);
	
	List<Employee> getAllEmployeesByName(String name);
 	
	List<Employee> getAllEmployeesByNameAndSKill(String name, String skill);
}
