package com.drh.api.Model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drh.api.Model.Employee;
import com.drh.api.Model.DAL.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeerepository;
	
	public List<Employee> getlistemployee(){
		List<Employee> listedesemployees = new ArrayList<>();
		System.out.println("LA JE CHERCHE LES EMPLOYEES: ");
		employeerepository.findAll().forEach(listedesemployees::add);
		
		for (Employee emp: listedesemployees) {
			
			emp.getNom().toUpperCase();
			
		}
		return listedesemployees;
	}
	
	public Employee getEmployeeById(int id) {
		
		return employeerepository.findById(id).get();
		
	}
	
	
	// creer des employees
	public Employee addNewEmployee(Employee newemployee) {
		
		return employeerepository.save(newemployee);
	}
	
	public void deleteEmployee(int id) {
		
		employeerepository.deleteById(id);
	}
	
}
