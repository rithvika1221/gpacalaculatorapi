package com.fbla.gpacalculatorapi.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fbla.gpacalculatorapi.model.Semester;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface SemesterRepository extends CrudRepository<Semester, Integer> {

}
