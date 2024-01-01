
package com.fbla.gpacalculatorapi.requests;

import java.util.Date;

import com.fbla.gpacalculatorapi.model.Course;


public record CreateCourseInput(String course_name, String course_grade,  Double course_credit, String course_type) {
	
   
	// this function takes the parameters which is gets from the request
	// it creates a course object from the request parameters
	public Course toCourse() {
		Course course = new Course();

		course.setCourseName(course_name);
		course.setCourseGrade(course_grade);
		course.setCourseCredit(course_credit);
		course.setCourseType(course_type);

        return course;
    }
}
