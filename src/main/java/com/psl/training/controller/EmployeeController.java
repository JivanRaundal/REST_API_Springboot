package com.psl.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.psl.training.model.Employee;
import com.psl.training.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/*
 * As the name suggest @RequestBody annotation is used to parse the incoming HTTP request while 
 * @ResponseBody annotation is used to convert your object into HTTP response in the form client 
 * is expecting like JSON, XML, or simply text.
 * */

@RestController
@Tag(name = "Employee REST API")
public class EmployeeController {

	// controller -> service -> DAO -> DB
	@Autowired
	private EmployeeService service;
	
	/*
	 * Tages for swagger-ui
	 * 1) @OpenAPIDefinition, 2) @Tag, 3) @Operation, 4) @ApiResponse 5) @Parameter
	 */

	// @RequestMapping(value="/employees", method=RequestMethod.POST)
	@PostMapping("/employees")
	@Operation(summary = "Adds an Employee", description = "Takes an employee object as parameter and returns it")
	public @ApiResponse(description = "returns an object") Employee addEmployee(
			@Parameter(description = "Employee Object") @RequestBody Employee e) { // Create/Insert employee
		return service.addEmployee(e);
	}

	// @RequestMapping(value="/employees/{id}", method=RequestMethod.GET)
	@GetMapping("/employees/{id}")
	public Employee getEmployee(@PathVariable Long id) { // Read/Select 1 employee by id
		return service.getEmployee(id);
	}

	/*
	 * NOTE: Reading all employees - Ideally supplied with boundary condition
	 */

	// @RequestMapping(value="/employees", method=RequestMethod.GET)
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}

	// @RequestMapping(value="/employees", method=RequestMethod.PUT)
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee e) {
		return service.updateEmployee(e);
	}

	// @RequestMapping(value="/employees/{id}", method=RequestMethod.DELETE)
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		service.deleteEmployee(id);
	}

	@GetMapping("/employees/name/{name}")
	public List<Employee> getAllEmployeesByName(@PathVariable("name") String name) {
		return service.getAllEmployeesByName(name);
	}

	// @RequestMapping(value="/employees/name/{name}", method=RequestMethod.GET)
	@GetMapping("/employees/nameskill/{name}")
	public List<Employee> getAllEmployeesByNameAndSkill(@PathVariable String name, @RequestParam String skill) {
		return service.getAllEmployeesByNameAndSKill(name, skill);
	}

}
