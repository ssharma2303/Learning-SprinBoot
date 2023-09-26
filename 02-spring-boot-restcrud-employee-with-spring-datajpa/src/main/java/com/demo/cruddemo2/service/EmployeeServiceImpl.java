package com.demo.cruddemo2.service;




import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demo.cruddemo2.dao.EmployeeRepository;
import com.demo.cruddemo2.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl( EmployeeRepository theEmployeeRepository) {
		  employeeRepository = theEmployeeRepository;
	}
	
	@Override
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		if(result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			throw new RuntimeException("Did not find employee id - "+ theId);
		}
		return theEmployee;
	}
	
	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		return employeeRepository.save(theEmployee);
	}

	@Transactional
	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
		
	}

	
	

}
