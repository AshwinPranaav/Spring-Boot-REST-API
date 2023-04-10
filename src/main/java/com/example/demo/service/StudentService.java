package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.example.demo.domain.Student;

public interface StudentService {
	public List<Student> getStudents();

	public Student saveStudent(Student student);
	
	public Student editStudent(Student student);

	public Student getStudentById(Long id);
	
	public String deleteStudent(Long id);
	
	public List<Student> getStudentsByDob(LocalDate dob);
	
}
