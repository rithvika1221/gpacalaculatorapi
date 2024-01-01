package com.fbla.gpacalculatorapi.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fbla.gpacalculatorapi.model.Course;

import jakarta.transaction.Transactional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete


@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	 List<Course> findBySemesterId(int semesterId);
	  
	  @Transactional
	  void deleteBySemesterId(int semesterId);

}

