package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.domain.Student;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		Optional<Student> optionalStudent = studentRepository.getStudentByEmail(student.getEmail());
		if(optionalStudent.isPresent()) {
			throw new IllegalStateException("Email " + student.getEmail() + " already taken");
		}
		return studentRepository.save(student);
	}

	@Override
	public Student editStudent(Student studentToEdit) {
		return studentRepository.findById(studentToEdit.getId())
				.map(student -> {
					student.setName(studentToEdit.getName());
					student.setDob(studentToEdit.getDob());
					student.setAge(studentToEdit.getAge());
					student.setEmail(studentToEdit.getEmail());
					return studentRepository.save(studentToEdit);
				})
				.orElseThrow(() -> new StudentNotFoundException(studentToEdit.getId()));
//				.orElseGet(() -> {
//					studentToEdit.setId(studentToEdit.getId());
//					return studentRepository.save(studentToEdit);
//				});
	}
	
	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
	}

	@Override
	public String deleteStudent(Long id) {
		if(!studentRepository.existsById(id)) {
			throw new StudentNotFoundException(id);
		} else {
			studentRepository.deleteById(id);
			return "Successfully deleted Student " + id;
		}
	}

	@Override
	public List<Student> getStudentsByDob(LocalDate dob) {
		return studentRepository.findStudentsByDob(dob);
	}
	
}
