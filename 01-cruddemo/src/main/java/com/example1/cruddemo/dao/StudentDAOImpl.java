package com.example1.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example1.cruddemo.entity.student;
import jakarta.persistence.EntityManager;

@Repository
public class StudentDAOImpl implements StudentDAO{

	//define field for the entity managee
	private EntityManager entityManager;
	
	//inject entity manager using constructor injection
	@Autowired
	public StudentDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public void save(student theStudent) {
		entityManager.persist(theStudent);	
	}

	@Override
	public student findById(Integer id) {
		return entityManager.find(student.class, id);	
		}
	

	
}
