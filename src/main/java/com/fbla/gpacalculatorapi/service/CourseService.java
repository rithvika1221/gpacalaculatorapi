package com.fbla.gpacalculatorapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.fbla.gpacalculatorapi.model.CourseRepository;
import com.fbla.gpacalculatorapi.model.Course;

//
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course create(Course course) {
    	
    	// additional logic
        return courseRepository.save(course);
    }

    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        courseRepository.findAll().forEach(courses::add);

        return courses;
    }

    public Optional<Course> findById(int id) {
        return courseRepository.findById(id);
    }

    public Course update(Course courseToUpdate) {
    	
    	// additional logic goes in here
    	// calculating the GPA goes in here.
        return courseRepository.save(courseToUpdate);
    }

    public void delete(int id) {
    	courseRepository.deleteById(id);
    }
}