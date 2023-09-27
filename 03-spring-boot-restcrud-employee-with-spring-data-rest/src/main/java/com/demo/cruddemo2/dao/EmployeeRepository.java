package com.demo.cruddemo2.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.cruddemo2.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
