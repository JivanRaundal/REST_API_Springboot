package com.psl.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.psl.training.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> { // NOTE: <Model/Entity_Type, Datatype_of_primarykey>

	// NOTE: //No need to implement

	// Derived Queries
	// List<Employee> findAll();
	List<Employee> findByName(String name);

	List<Employee> findByNameAndSkill(String name, String skill);

	// -------------------------------------------------------------------
	// Simple Query

	@Query("SELECT e FROM Employee e") // JPQA (Java Persistence Query Language)
	List<Employee> findAllEmployees();

	// -------------------------------------------------------------------
	// Custom Queries

	// A] Using JPQL (Java Persistence Query Language)
	
		// 1] With Indexed Parameters
		@Query("SELECT e FROM Employee e WHERE e.name = ?1 AND e.skill = ?2")
		List<Employee> findEmployeesByNameAndSkillIndexJpql(String name, String skill);	
		
		// 2] With Named Parameters
		@Query("SELECT e FROM Employee e WHERE e.name = :name1 AND e.skill = :skill1")
		List<Employee> findEmployeesByNameAndSkillNamedJpql(@Param("name1") String name, @Param("skill1") String skill);

	// B] Using Native Query (normal SQL queries)
		
		// 1] With Indexed Parameters
		@Query(value="SELECT * FROM employee WHERE name = ?1 AND skill = ?2", nativeQuery = true)
		List<Employee> findEmployeesByNameAndSkillIndexNative(String name, String skill);
	
		// 2] With Named Parameters
		@Query(value="SELECT * FROM employee WHERE name = :name AND skill = :skill", nativeQuery = true)
		List<Employee> findEmployeesByNameAnsSkillNamedNative(@Param("name")String name, @Param("skill")String skill);
	
}
