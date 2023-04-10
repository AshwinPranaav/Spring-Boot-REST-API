package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Optional<LocalDate> dob) {
		if(dob.isPresent()) {
			return studentService.getStudentsByDob(dob.get());
		}
		return studentService.getStudents();
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return studentService.getStudentById(id);
	}
	
	@PutMapping("/student")
	public Student editStudent(@RequestBody Student student) {
		return studentService.editStudent(student);
	}
	
	@PostMapping("/student")
	public Student newStudent(@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable Long id) {
		return studentService.deleteStudent(id);
	}

}
