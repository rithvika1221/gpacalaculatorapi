package com.fbla.gpacalculatorapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.fbla.gpacalculatorapi.model.SemesterRepository;
import com.fbla.gpacalculatorapi.model.Semester;

//
@Service
public class SemesterService {

    private final SemesterRepository semesterRepository;

    public SemesterService(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    public Semester create(Semester semester) {
    	
    	// additional logic
        return semesterRepository.save(semester);
    }

    public List<Semester> findAll() {
        List<Semester> semesters = new ArrayList<>();
        semesterRepository.findAll().forEach(semesters::add);

        return semesters;
    }

    public Optional<Semester> findById(int id) {
        return semesterRepository.findById(id);
    }

    public Semester update(Semester semesterToUpdate) {
    	
    	// additional logic goes in here
    	// calculating the GPA goes in here.
        return semesterRepository.save(semesterToUpdate);
    }

    public void delete(int id) {
    	semesterRepository.deleteById(id);
    }
}