package com.fbla.gpacalculatorapi.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fbla.gpacalculatorapi.exception.ResourceNotFoundException;
import com.fbla.gpacalculatorapi.model.Semester;
import com.fbla.gpacalculatorapi.model.SemesterRepository;
import com.fbla.gpacalculatorapi.model.Student;
import com.fbla.gpacalculatorapi.model.StudentRepository;
import com.fbla.gpacalculatorapi.service.SemesterService;
import com.fbla.gpacalculatorapi.requests.CreateSemesterInput;
import com.fbla.gpacalculatorapi.requests.UpdateSemesterInput;

@CrossOrigin(maxAge = 3600)
@RestController
public class SemesterController {
	
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SemesterRepository semesterRepository;

	@GetMapping("/students/{studentId}/semesters")
	public ResponseEntity<List<Semester>> getAllSemestersByStudentId(@PathVariable(value = "studentId") int studentId) {

		List<Semester> semesters = semesterRepository.findByStudentId(studentId);
		// List<Semester> semesters =
		// semesterService.findAllSemestersByStudent(studentId);
		return new ResponseEntity<>(semesters, HttpStatus.OK);
	}

	@GetMapping("/semesters")
	public ResponseEntity<List<Semester>> getSemester() {
		List<Semester> semesters = semesterRepository.findAll();

		return new ResponseEntity<>(semesters, HttpStatus.OK);

	}

	@GetMapping("/semesters/{id}")
	public ResponseEntity<Semester> onestudent(@PathVariable int id) {
		Optional<Semester> optionalSemester = semesterRepository.findById(id);

		if (optionalSemester.isPresent()) {
			return new ResponseEntity<>(optionalSemester.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/semesters")
	public ResponseEntity<Semester> createSemester(@RequestBody CreateSemesterInput createSemesterInput) {

		// Semester semesterCreated =
		// semesterRepository.save(createSemesterInput.toSemester());
		// you can call the repository class directly in the controller but it is good
		// to create a service class
		// service class helps with separation of responsibility

		Semester semesterCreated = semesterRepository.save(createSemesterInput.toSemester());
		return new ResponseEntity<>(semesterCreated, HttpStatus.CREATED);
	}

	@PostMapping("/students/{studentId}/semesters")
	public ResponseEntity<Semester> createSemester(@PathVariable(value = "studentId") int studentId,
			@RequestBody CreateSemesterInput semesterRequest) {
		
		Optional<Student> optionalStudent = studentRepository.findById(studentId);
		if (optionalStudent.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Student student = optionalStudent.get();
		Semester semester = semesterRequest.toSemester();
		semester.setSemesterStudent(student);
		
		Semester semesterCreated = semesterRepository.save(semester);
		return new ResponseEntity<>(semesterCreated, HttpStatus.CREATED);
	
		}

	@PutMapping("/students/{studentId}/semesters/{id}")
	public ResponseEntity<Semester> updateSemester(@PathVariable("id") int id,
			@RequestBody UpdateSemesterInput updateSemesterInput) {
//	    Semester semester = semesterRepository.findById(id)
//	        .orElseThrow(() -> new ResourceNotFoundException("CommentId " + id + "not found"));

		Optional<Semester> optionalSemester = semesterRepository.findById(id);

		if (optionalSemester.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Semester semesterToUpdate = optionalSemester.get();

		semesterToUpdate.setSemUnweightedGPA(updateSemesterInput.semUnweightedGPA());
		semesterToUpdate.setSemWeightedGPA(updateSemesterInput.semWeightedGPA());

		return new ResponseEntity<>(semesterRepository.save(semesterToUpdate), HttpStatus.OK);
	}

	@DeleteMapping("/students/{studentId}/semesters/{id}")
	public ResponseEntity<Void> deleteSemster(@PathVariable int id) {
		semesterRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/students/{studentId}/semesters")
	public ResponseEntity<List<Semester>> deleteAllSemestersofStudent(
			@PathVariable(value = "studentId") int studentId) {
		Optional<Student> optionalStudent = studentRepository.findById(studentId);
		if (!optionalStudent.isPresent()) {
			throw new ResourceNotFoundException("Not found Student with id = " + studentId);
		}

		semesterRepository.deleteByStudentId(studentId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
