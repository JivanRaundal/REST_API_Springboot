package com.psl.training.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.training.model.Employee;
import com.psl.training.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public Employee addEmployee(Employee e) {
		return repo.save(e);
	}

	@Override
	public Employee getEmployee(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmployees() {
		//return (ArrayList<Employee>) repo.findAll();
		return repo.findAllEmployees();
	}

	@Override
	public Employee updateEmployee(Employee e) {
		return repo.save(e);
	}

	@Override
	public void deleteEmployee(Long id) {
		repo.deleteById(id);
	}

	@Override
	public List<Employee> getAllEmployeesByNameAndSKill(String name, String skill) {
		//return repo.findByNameAndSkill(name, skill);
		
		//return repo.findEmployeesByNameAndSkillIndexJpql(name, skill);
		//return repo.findEmployeesByNameAndSkillNamedJpql(name, skill);
		
		//return repo.findEmployeesByNameAndSkillIndexNative(name, skill);
		return repo.findEmployeesByNameAnsSkillNamedNative(name, skill);
	}

	@Override
	public List<Employee> getAllEmployeesByName(String name) {
		return repo.findByName(name);
	}
	

}
