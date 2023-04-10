package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.domain.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	/**
	 * StudentRepository is same like Dao, and it can extend JpaRepository<T, ID> where T is type and ID is primary key type
	 * Extending JpaRepository gives us the ready to use features of Spring Data JPA 
	 * We can create an instance of this interface in service layer to get data
	 */
	
	@Query("SELECT s from Student s where s.dob = :dob")
	List<Student> findStudentsByDob(LocalDate dob);

	@Query("SELECT s from Student s where s.email = :email")
	Optional<Student> getStudentByEmail(String email);
	
}
