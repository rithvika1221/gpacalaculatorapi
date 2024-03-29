package com.fbla.gpacalculatorapi.model;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fbla.gpacalculatorapi.model.Student;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	
 

	List<Student> findByStudentEmail(String email);
	 Optional<Student> findById(int studentId);


}


