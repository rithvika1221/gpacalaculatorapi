
package com.fbla.gpacalculatorapi.requests;

import java.util.Date;

import com.fbla.gpacalculatorapi.model.Student;


public record CreateStudentInput(String studentName, String studentPassword, String studentEmail, Double studentWeightedGPA, Double studentUnweightedGPA) {
	
   
	// this function takes the parameters which is gets from the request
	// it creates a student object from the request parameters
	public Student toStudent() {
        Student student = new Student();

        student.setStudentName(studentName);
        student.setStudentPassword(studentPassword);
        student.setStudentEmail(studentEmail);
        student.setStudentWeightedGPA(studentWeightedGPA);
        student.setStudentUnweightedGPA(studentUnweightedGPA);

        return student;
    }
}
