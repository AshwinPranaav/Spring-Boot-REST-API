package com.example.demo.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.demo.domain.Student;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.service.StudentService;
import com.example.demo.service.StudentServiceImpl;

public class StudentServiceTest {
	
	private static final StudentService studentService = mock(StudentServiceImpl.class);
	
	@Test
	public void getStudents_Returns_List_Of_Students() {
		List<Student> students = studentService.getStudents();
		assertEquals(List.of(), students);
	}
	
	@Test
	public void addNewStudent_Returns_Student() {
		// mocking saveStudent
		when(studentService.saveStudent(any(Student.class))).thenReturn(new Student("Student 1", LocalDate.now(), "student1@aaa.com"));
		
		Student student = studentService.saveStudent(new Student("Student 1", LocalDate.now(), "student1@aaa.com"));
		assertEquals("Student 1", student.getName());
		assertEquals(LocalDate.class, student.getDob().getClass());
		assertEquals("student1@aaa.com", student.getEmail());
	}
	
	@Test
	public void deleteInvalidStudent_Throws_StudentNotFoundException() {
		// mocking deleteStudent by just verifying if the method was called
		when(studentService.deleteStudent(Long.MAX_VALUE)).thenThrow(StudentNotFoundException.class);
	}
	
}
