package com.example1.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example1.cruddemo.dao.StudentDAO;
import com.example1.cruddemo.entity.student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}
	private void createStudent(StudentDAO studentDAO) {
		//create student object
		System.out.println("Creating new student object...");
		student tempStudent = new student("Sakshi","Sharma","sakshi23@gmail.com");
		
		//save the student object
		System.out.println("Saving the student..");
		studentDAO.save(tempStudent);
		
		//display id of the saved student
		System.out.println("Saved Student. Generated id: "+ tempStudent.getId());
	}
}
