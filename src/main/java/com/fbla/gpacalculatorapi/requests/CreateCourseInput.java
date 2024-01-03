
package com.fbla.gpacalculatorapi.requests;

import java.util.Date;

import com.fbla.gpacalculatorapi.model.Course;


public record CreateCourseInput(String courseName, String courseGrade,  Double courseCredit, String courseType) {
	
   
	// this function takes the parameters which is gets from the request
	// it creates a course object from the request parameters
	public Course toCourse() {
		Course course = new Course();

		course.setCourseName(courseName);
		course.setCourseGrade(courseGrade);
		course.setCourseCredit(courseCredit);
		course.setCourseType(courseType);

        return course;
    }
}
