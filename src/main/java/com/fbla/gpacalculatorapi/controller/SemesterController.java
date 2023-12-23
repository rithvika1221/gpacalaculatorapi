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

import com.fbla.gpacalculatorapi.model.Semester;
import com.fbla.gpacalculatorapi.service.SemesterService;
import com.fbla.gpacalculatorapi.requests.CreateSemesterInput;
import com.fbla.gpacalculatorapi.requests.UpdateSemesterInput;

@RestController
public class SemesterController {
	public SemesterService semesterService;

	public SemesterController(SemesterService semesterService) {

		this.semesterService = semesterService;
	}

	@PostMapping("/semesters")
	public ResponseEntity<Semester> createSemester(@RequestBody CreateSemesterInput createSemesterInput) {

		// Student studentCreated =
		// studentRepository.save(createStudentInput.toStudent());
		// you can call the repository class directly in the controller but it is good
		// to create a service class
		// service class helps with separation of responsibility

		Semester semesterCreated = semesterService.create(createSemesterInput.toSemester());
		return new ResponseEntity<>(semesterCreated, HttpStatus.CREATED);
	}

	@GetMapping("/semesters")
	public ResponseEntity<List<Semester>> getSemester() {
		List<Semester> semesters = semesterService.findAll();

		return new ResponseEntity<>(semesters, HttpStatus.OK);

	}

	@GetMapping("/semesters/{id}")
	public ResponseEntity<Semester> onestudent(@PathVariable int id) {
		Optional<Semester> optionalSemester = semesterService.findById(id);

		if (optionalSemester.isPresent()) {
			return new ResponseEntity<>(optionalSemester.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PatchMapping("/semesters/{id}")
	public ResponseEntity<Semester> updateSemester(@PathVariable int id,
			@RequestBody UpdateSemesterInput updateSemesterInput) {
		Optional<Semester> optionalSemester = semesterService.findById(id);

		if (optionalSemester.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Semester semesterToUpdate = optionalSemester.get();

		semesterToUpdate.setSemesterUnweightedGPA(updateSemesterInput.semWeightedGPA());
		semesterToUpdate.setSemesterUnweightedGPA(updateSemesterInput.semUnweightedGPA());

		Semester semesterUpdated = semesterService.update(semesterToUpdate);

		return new ResponseEntity<>(semesterUpdated, HttpStatus.OK);
	}

	@DeleteMapping("/semesters/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable int id) {
		semesterService.delete(id);

		return ResponseEntity.noContent().build();
	}

}
