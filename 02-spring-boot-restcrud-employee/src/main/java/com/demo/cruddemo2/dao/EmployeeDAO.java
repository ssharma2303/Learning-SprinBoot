package com.demo.cruddemo2.dao;

import java.util.List;

import com.demo.cruddemo2.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();

}
