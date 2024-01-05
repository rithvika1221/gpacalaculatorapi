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
import com.fbla.gpacalculatorapi.model.Course;
import com.fbla.gpacalculatorapi.model.CourseRepository;
import com.fbla.gpacalculatorapi.model.Semester;
import com.fbla.gpacalculatorapi.model.SemesterRepository;
import com.fbla.gpacalculatorapi.model.Student;
import com.fbla.gpacalculatorapi.model.StudentRepository;
import com.fbla.gpacalculatorapi.service.CourseService;
import com.fbla.gpacalculatorapi.requests.CreateCourseInput;
import com.fbla.gpacalculatorapi.requests.CreateSemesterInput;
import com.fbla.gpacalculatorapi.requests.UpdateCourseInput;

@CrossOrigin(maxAge = 3600)
@RestController
public class CourseController {
       
    @Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SemesterRepository semesterRepository;
	
	@Autowired
	private CourseRepository courseRepository;

	@GetMapping("/students/{studentId}/semesters/{semesterId}/courses")
	public ResponseEntity<List<Course>> getAllCoursesBySemesterId(@PathVariable(value = "semesterId") int semesterId) {

		List<Course> courses = courseRepository.findBySemesterId(semesterId);
		// List<Semester> semesters =
		// semesterService.findAllSemestersByStudent(studentId);
		return new ResponseEntity<>(courses, HttpStatus.OK);
	}

	@GetMapping("/courses")
	public ResponseEntity<List<Course>> getCourse() {
		List<Course> courses = courseRepository.findAll();

		return new ResponseEntity<>(courses, HttpStatus.OK);

	}

	@GetMapping("/courses/{id}")
	public ResponseEntity<Course> onestudent(@PathVariable int id) {
		Optional<Course> optionalCourse = courseRepository.findById(id);

		if (optionalCourse.isPresent()) {
			return new ResponseEntity<>(optionalCourse.get(), HttpStatus.OK);
		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/courses")
	public ResponseEntity<Course> createCourse(@RequestBody CreateCourseInput createCourseInput) {

		
		// you can call the repository class directly in the controller but it is good
		// to create a service class
		// service class helps with separation of responsibility

		Course courseCreated = courseRepository.save(createCourseInput.toCourse());
		return new ResponseEntity<>(courseCreated, HttpStatus.CREATED);
	}

	@PostMapping("/students/{studentId}/semesters/{semesterId}/courses")
	public ResponseEntity<Course> createCourse(@PathVariable(value = "semesterId") int semesterId,
			@RequestBody CreateCourseInput createCourseRequest) {
		
			
		Optional<Semester> optionalSemester = semesterRepository.findById(semesterId);
		if (optionalSemester.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Course course =createCourseRequest.toCourse();

		Semester semester = optionalSemester.get();
			course.setCourseSemester(semester);
		
		Course courseCreated = courseRepository.save(course);
		return new ResponseEntity<>(courseCreated, HttpStatus.CREATED);
	}

	@PutMapping("/students/{studentId}/semesters/{semesterId}/courses/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable("id") int id,
			@RequestBody UpdateCourseInput updateCourseInput) {


		Optional<Course> optionalCourse = courseRepository.findById(id);

		if (optionalCourse.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		Course courseToUpdate = optionalCourse.get();

		courseToUpdate.setCourseCredit(updateCourseInput.courseCredit());
		courseToUpdate.setCourseGrade(updateCourseInput.courseGrade());
		courseToUpdate.setCourseName(updateCourseInput.courseName());
		courseToUpdate.setCourseType(updateCourseInput.courseType());
	

		return new ResponseEntity<>(courseRepository.save(courseToUpdate), HttpStatus.OK);
	}

	@DeleteMapping("/students/{studentId}/semesters/{semesterId}/courses/{courseId}")
	public ResponseEntity<Void> deleteCourse(@PathVariable int courseId) {
		courseRepository.deleteById(courseId);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/students/{studentId}/semesters/{semesterId}/courses")
	public ResponseEntity<List<Course>> deleteAllCoursesofSemester(
			@PathVariable(value = "semesterId") int semesterId) {
		Optional<Semester> optionalSemester = semesterRepository.findById(semesterId);
		if (!optionalSemester.isPresent()) {
			throw new ResourceNotFoundException("Not found Semester with id = " + semesterId);
		}

		courseRepository.deleteBySemesterId(semesterId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

       
}








;