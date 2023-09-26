package com.demo.cruddemo2.service;

import java.util.List;
import com.demo.cruddemo2.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);
}
