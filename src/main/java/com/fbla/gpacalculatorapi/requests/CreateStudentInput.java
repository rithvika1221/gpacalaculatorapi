
package com.fbla.gpacalculatorapi.requests;

import java.util.Date;

import com.fbla.gpacalculatorapi.model.Student;


public record CreateStudentInput(String studentName, String password, Double total_weighted_gpa, Double total_unweighted_gpa) {
	
   
	// this function takes the parameters which is gets from the request
	// it creates a student object from the request parameters
	public Student toStudent() {
        Student student = new Student();

        student.setstudentName(studentName);
        student.setStudentPassword(password);
        student.setStudentWeightedGPA(total_weighted_gpa);
        student.setStudentWeightedGPA(total_unweighted_gpa);

        return student;
    }
}
