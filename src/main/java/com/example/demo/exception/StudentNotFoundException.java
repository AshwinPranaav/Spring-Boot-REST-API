package com.example.demo.exception;

public class StudentNotFoundException extends RuntimeException {
	
	private Long id;
	private String message;
	
	public StudentNotFoundException() {}
	
	public StudentNotFoundException(Long id) {
		this.id = id;
		this.message = "Could not find Student " + id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
