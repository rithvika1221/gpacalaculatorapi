package com.fbla.gpacalculatorapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.fbla.gpacalculatorapi.model.StudentRepository;
import com.fbla.gpacalculatorapi.model.Student;

//
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(Student student) {
    	
    	// additional logic
        return studentRepository.save(student);
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);

        return students;
    }

    public Optional<Student> findById(int id) {
        return studentRepository.findById(id);
    }

    public Student update(Student studentToUpdate) {
    	
    	// additional logic goes in here
    	// calculating the GPA goes in here.
        return studentRepository.save(studentToUpdate);
    }

    public void delete(int id) {
        studentRepository.deleteById(id);
    }
}