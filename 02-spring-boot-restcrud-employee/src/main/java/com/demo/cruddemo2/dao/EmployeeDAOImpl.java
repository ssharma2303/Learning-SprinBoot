package com.demo.cruddemo2.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.demo.cruddemo2.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
@Repository
public class EmployeeDAOImpl  implements EmployeeDAO{

	
	//define field for entitymanager
	private EntityManager entityManager;
	//set up contructor injection
	@Autowired
	public EmployeeDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	@Override
	public List<Employee> findAll() {
		
		//create query

		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		//return the results
		return employees;
	}
	
}
