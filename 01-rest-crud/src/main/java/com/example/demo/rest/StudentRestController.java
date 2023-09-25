package com.example.demo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	 private List<Student> theStudents;
	 
	 @PostConstruct
	 public void loadData() {
	 theStudents = new ArrayList<>();
	 theStudents.add(new Student("Sakshi","Sharma"));
	 theStudents.add(new Student("Arjun","Mehra"));
	theStudents.add(new Student("Utkarsh","Gupta"));
	 }
	 @GetMapping("/students")
	public List<Student> getStudents() {
		return theStudents;
	}
	 //define endpoint - return student at index
	 @GetMapping("/students/{studentId}")
	 public Student getstudent(@PathVariable int studentId) {
		 
		 if(studentId >= theStudents.size() || studentId < 0) {
			 throw new StudentNotFoundException("Student id is not found-"+studentId);
		 }
		 
		 return theStudents.get(studentId); 
	 }

	 //add an exception handler using @ExceptionHandler
	 
	 /*@ExceptionHandler
	 public ResponseEntity<StudenterrorResponse> handleException(StudentNotFoundException exc){
		 
		 StudenterrorResponse error = new StudenterrorResponse();
		 error.setStatus(HttpStatus.NOT_FOUND.value());
		 error.setMessage(exc.getMessage());
		 error.setTimestamp(System.currentTimeMillis());
		 
		 return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
		 
	 }
	 //add another exception handler to catch any exception
	 @ExceptionHandler
	 public ResponseEntity<StudenterrorResponse> handleexception(Exception exc){
		 StudenterrorResponse error = new StudenterrorResponse();
		 error.setStatus(HttpStatus.BAD_REQUEST.value());
		 error.setMessage("String not allowed");
		 error.setTimestamp(System.currentTimeMillis());
		 
		 return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		 
	 }*/
	 
}
