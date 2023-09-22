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
			//createStudent(studentDAO);
			//createmultipleStudent(studentDAO);
			readStudent(studentDAO);
		};
	}
	@SuppressWarnings("unused")
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
	@SuppressWarnings("unused")
	private void createmultipleStudent(StudentDAO studentDAO) {
		//create student object
		System.out.println("Creating new student object...");
		student tempStudent1 = new student("Sreeja","Reddy","sreeja26@gmail.com");
		student tempStudent2 = new student("Ram","Krishna","rkrishna1@gmail.com");
		student tempStudent3 = new student("Varun","Chaudhary","varunc02@gmail.com");
		//save the student object
		System.out.println("Saving the student..");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		
		//display id of the saved student
		System.out.println("Saved Student. Generated id: "+ tempStudent1.getId());
		System.out.println("Saved Student. Generated id: "+ tempStudent2.getId());
		System.out.println("Saved Student. Generated id: "+ tempStudent3.getId());
	}
	private void readStudent(StudentDAO studentDAO) {

		// create  a student object
		System.out.println("Creating new student object ...");
		student tempStudent = new student("Daffy", "Duck", "daffy@luv2code.com");

		// save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: " + theId);
		student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}

}
