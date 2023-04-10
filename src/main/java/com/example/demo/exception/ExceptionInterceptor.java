package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException studentNotFoundException) {
		StudentNotFoundExceptionSchema response = new StudentNotFoundExceptionSchema(
				studentNotFoundException.getId(), 
				studentNotFoundException.getMessage());
		return new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
	}
	
}
