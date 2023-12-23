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

import com.fbla.gpacalculatorapi.model.Course;
import com.fbla.gpacalculatorapi.service.CourseService;
import com.fbla.gpacalculatorapi.requests.CreateCourseInput;
import com.fbla.gpacalculatorapi.requests.UpdateCourseInput;

@RestController
public class CourseController {
    public CourseService courseService;
  
    

    
    public CourseController(CourseService courseService) {

		this.courseService = courseService;
    }
    
    
    @PostMapping("/courses")
    public ResponseEntity<Course> createCourse(@RequestBody CreateCourseInput createCourseInput) {
       
    	//	Course studentCreated = studentRepository.save(createStudentInput.toStudent());
    	// you can call the repository class directly in the controller but it is good to create a service class 
    	// service class helps with separation of responsibility
    	
    	Course courseCreated = courseService.create(createCourseInput.toCourse());
        return new ResponseEntity<>(courseCreated, HttpStatus.CREATED);
    }
    
     
    
    @GetMapping("/courses")
	public ResponseEntity<List<Course>> getCourse() {
    	 List<Course> courses = courseService.findAll();

    	    return new ResponseEntity<>(courses, HttpStatus.OK);

	}
	
    
   
    
    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> onestudent(@PathVariable int id) {
        Optional<Course> optionalCourse = courseService.findById(id);

        if (optionalCourse.isPresent()) {
            return new ResponseEntity<>(optionalCourse.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    

@PatchMapping("/courses/{id}")
public ResponseEntity<Course> updateStudent(@PathVariable int id, @RequestBody UpdateCourseInput updateCourseInput) {
    Optional<Course> optionalCourse = courseService.findById(id);

    if (optionalCourse.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    Course courseToUpdate = optionalCourse.get();

   courseToUpdate.setCourseName(updateCourseInput.courseGrade());
   courseToUpdate.setCourseCredit(updateCourseInput.courseCredit());
   courseToUpdate.setCourseType(updateCourseInput.courseType());

    Course courseUpdated =courseService.update(courseToUpdate);

    return new ResponseEntity<>(courseUpdated, HttpStatus.OK);
}


@DeleteMapping("/courses/{id}")
public ResponseEntity<Void> deleteTask(@PathVariable int id) {
	courseService.delete(id);

    return ResponseEntity.noContent().build();
}
   
    
}








