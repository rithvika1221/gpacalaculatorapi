
package com.fbla.gpacalculatorapi.requests;

import java.util.Date;

import com.fbla.gpacalculatorapi.model.Semester;


public record CreateSemesterInput(String semester_name, Double sem_weighted_gpa, Double sem_unweighted_gpa) {
	
   
	// this function takes the parameters which is gets from the request
	// it creates a semester object from the request parameters
	public Semester toSemester() {
		Semester semester = new Semester();

        semester.setSemesterName(semester_name);
        semester.setSemesterWeightedGPA(sem_weighted_gpa);
        semester.setSemesterUnweightedGPA(sem_unweighted_gpa);

        return semester;
    }
}
