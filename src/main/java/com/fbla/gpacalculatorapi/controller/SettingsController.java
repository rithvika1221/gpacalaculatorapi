package com.fbla.gpacalculatorapi.controller;


import com.fbla.gpacalculatorapi.model.Semester;
import com.fbla.gpacalculatorapi.model.SemesterRepository;
import com.fbla.gpacalculatorapi.model.Settings;
import com.fbla.gpacalculatorapi.model.SettingsRepository;
import com.fbla.gpacalculatorapi.model.Student;
import com.fbla.gpacalculatorapi.model.StudentRepository;
import com.fbla.gpacalculatorapi.requests.CreateSemesterInput;
import com.fbla.gpacalculatorapi.requests.CreateSettingsInput;
import com.fbla.gpacalculatorapi.requests.UpdateSemesterInput;
import com.fbla.gpacalculatorapi.requests.UpdateSettingsInput;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
public class SettingsController {

	
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SettingsRepository settingsRepository;


    // Get all settings
    @GetMapping
    public List<Settings> getAllSettings() {
        return settingsRepository.findAll();
    }

	@GetMapping("/students/{studentId}/settings")
	public ResponseEntity<List<Settings>> getAllSemestersByStudentId(@PathVariable(value = "studentId") int studentId) {

		List<Settings> settings = settingsRepository.findByStudentId(studentId);
		return new ResponseEntity<>(settings, HttpStatus.OK);
	}
	
	@PostMapping("/students/{studentId}/settings")
	public ResponseEntity<Settings> createSettings(@PathVariable(value = "studentId") int studentId,
			@RequestBody CreateSettingsInput settingsRequest) {
		
		Optional<Student> optionalStudent = studentRepository.findById(studentId);
		if (optionalStudent.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		Student student = optionalStudent.get();
		
		Settings settings = settingsRequest.toSettings();
		settings.setSettingsStudent(student);
		
		Settings settingsCreated = settingsRepository.save(settings);
		return new ResponseEntity<>(settingsCreated, HttpStatus.CREATED);
	
		}

	@PutMapping("/students/{studentId}/settings/{id}")
	public ResponseEntity<Settings> updateSettings(@PathVariable("id") int id,
			@RequestBody UpdateSettingsInput updateSettingsInput) {

		Optional<Settings> optionalSettings = settingsRepository.findById(id);

		if (optionalSettings.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Settings settingsToUpdate = optionalSettings.get();
		
		settingsToUpdate.setGpa(updateSettingsInput.gpa());


	

		return new ResponseEntity<>(settingsRepository.save(settingsToUpdate), HttpStatus.OK);
	}


}
