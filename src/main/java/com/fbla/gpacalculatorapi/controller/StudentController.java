package com.fbla.gpacalculatorapi.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fbla.gpacalculatorapi.model.Student;
import com.fbla.gpacalculatorapi.service.StudentService;
import com.fbla.gpacalculatorapi.requests.CreateStudentInput;
import com.fbla.gpacalculatorapi.requests.UpdateStudentInput;

@RestController
public class StudentController {
    public StudentService studentService;
  
    

    
    public StudentController(StudentService studentService) {

		this.studentService = studentService;
    }
    
    
    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody CreateStudentInput createStudentInput) {
       
    	//	Student studentCreated = studentRepository.save(createStudentInput.toStudent());
    	// you can call the repository class directly in the controller but it is good to create a service class 
    	// service class helps with separation of responsibility
    	
        Student studentCreated = studentService.create(createStudentInput.toStudent());
        return new ResponseEntity<>(studentCreated, HttpStatus.CREATED);
    }
    
     
    
    @GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents() {
    	 List<Student> students = studentService.findAll();

    	    return new ResponseEntity<>(students, HttpStatus.OK);

	}
	
    
   
    
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> onestudent(@PathVariable int id) {
        Optional<Student> optionalStudent = studentService.findById(id);

        if (optionalStudent.isPresent()) {
            return new ResponseEntity<>(optionalStudent.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    

@PatchMapping("/students/{id}")
public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody UpdateStudentInput updateStudentInput) {
    Optional<Student> optionalStudent = studentService.findById(id);

    if (optionalStudent.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    Student studentToUpdate = optionalStudent.get();

    studentToUpdate.setStudentWeightedGPA(updateStudentInput.studentWeightedGPA());
    studentToUpdate.setStudentUnweightedGPA(updateStudentInput.studentUnweightedGPA());

    Student studentUpdated = studentService.update(studentToUpdate);

    return new ResponseEntity<>(studentUpdated, HttpStatus.OK);
}


@DeleteMapping("/students/{id}")
public ResponseEntity<Void> deleteTask(@PathVariable int id) {
    studentService.delete(id);

    return ResponseEntity.noContent().build();
}
   
    
}

