
package com.fbla.gpacalculatorapi.requests;

import java.util.Date;

import com.fbla.gpacalculatorapi.model.Semester;


public record CreateSemesterInput(String semesterName, Double sem_weighted_gpa, Double sem_unweighted_gpa) {
	
   
	// this function takes the parameters which is gets from the request
	// it creates a semester object from the request parameters
	public Semester toSemester() {
		Semester semester = new Semester();

        semester.setSemesterName(semesterName);
        semester.setSemesterWeightedGPA(sem_weighted_gpa);
        semester.setSemesterWeightedGPA(sem_unweighted_gpa);

        return semester;
    }
}
