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
	@Override
	public Employee findById(int theId) {
		//get the employee
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		//return employee
		return theEmployee;
	}
	@Override
	public Employee save(Employee theEmployee) {
		//save employee
		Employee dbEmployee = entityManager.merge(theEmployee);
		
		
		return dbEmployee;
	}
	@Override
	public void deleteById(int theId) {
		//get employee 
		Employee theEmployee = entityManager.find(Employee.class, theId);
		
		//delete employee
		entityManager.remove(theEmployee);
	
		
	}
	
}
