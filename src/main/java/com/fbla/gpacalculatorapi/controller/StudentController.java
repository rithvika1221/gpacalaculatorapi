package com.fbla.gpacalculatorapi.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fbla.gpacalculatorapi.model.Student;
import com.fbla.gpacalculatorapi.model.StudentRepository;
import com.fbla.gpacalculatorapi.service.StudentService;
import com.fbla.gpacalculatorapi.requests.CreateStudentInput;
import com.fbla.gpacalculatorapi.requests.UpdateStudentInput;

@RestController
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepository;

	public StudentController()
	{}
	
	@PostMapping("/students")
	public ResponseEntity<Student> createStudent(@RequestBody CreateStudentInput createStudentInput) {

		Student studentCreated = studentRepository.save(createStudentInput.toStudent());
		return new ResponseEntity<>(studentCreated, HttpStatus.CREATED);
	}

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> students = studentRepository.findAll();

		return new ResponseEntity<>(students, HttpStatus.OK);

	}

	@GetMapping("/students/{id}")
	public ResponseEntity<Student> onestudent(@PathVariable int id) {
		Optional<Student> optionalStudent = studentRepository.findById(id);

		if (optionalStudent.isPresent()) {
			return new ResponseEntity<>(optionalStudent.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id,
			@RequestBody UpdateStudentInput updateStudentInput) {
		Optional<Student> optionalStudent = studentRepository.findById(id);

		if (optionalStudent.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Student studentToUpdate = optionalStudent.get();

		studentToUpdate.setStudentWeightedGPA(updateStudentInput.total_weighted_gpa());
		studentToUpdate.setStudentUnweightedGPA(updateStudentInput.total_unweighted_gpa());

		Student studentUpdated = studentRepository.save(studentToUpdate);

		return new ResponseEntity<>(studentUpdated, HttpStatus.OK);
	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable int id) {
		 studentRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

}
