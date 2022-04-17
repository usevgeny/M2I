package com.drh.api.Model.DAL;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.drh.api.Model.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer>{



	
}
