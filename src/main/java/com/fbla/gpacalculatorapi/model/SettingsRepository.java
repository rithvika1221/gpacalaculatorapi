package com.fbla.gpacalculatorapi.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.fbla.gpacalculatorapi.model.Semester;

import jakarta.transaction.Transactional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface SettingsRepository extends JpaRepository<Settings, Integer> {
	
	 List<Settings> findByStudentId(int studentId);
	  
	  @Transactional
	  void deleteByStudentId(int studentId);

}
