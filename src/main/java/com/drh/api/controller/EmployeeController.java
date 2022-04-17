package com.drh.api.controller;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.drh.api.Model.Employee;
import com.drh.api.Model.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		System.out.println("LIST DES EMPLOYEES : "+employeeService.getlistemployee());
		return employeeService.getlistemployee();

	}

	@GetMapping("/employees/{id}")
	public Employee getEmployeeById(@PathVariable int id){ //(@PathVariable(value= "id") int id, @PathVariable(value= "autre") int deuxieme variable )
		return employeeService.getEmployeeById(id);
	}

	// la on va creer le POST request 

	@PostMapping("/employees")

	public ResponseEntity<Employee> createNewEmployee(@Valid @RequestBody Employee employee ){


		Employee emp = employeeService.addNewEmployee(employee);

		if ( Objects.isNull(emp)
				){
			return ResponseEntity.noContent().build();
		}

		// prend le path de depart et le complete avec le id du nouveau employee 
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(emp.getId()).toUri();

		return ResponseEntity.created(location).build();


	}

	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {

		employeeService.deleteEmployee(id);

	}
	
	
	
	@PutMapping("/employees")
	public Employee updateEmp(@Valid @RequestBody Employee emp){
		return employeeService.addNewEmployee(emp);
	}
	
	//https://www.baeldung.com/spring-response-status

}
