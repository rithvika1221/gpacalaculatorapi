
package com.fbla.gpacalculatorapi.requests;

import java.util.Date;

import com.fbla.gpacalculatorapi.model.Semester;


public record CreateSemesterInput(String semesterName, Double semWeightedGPA, Double semUnweightedGPA) {
	
   
	// this function takes the parameters which is gets from the request
	// it creates a semester object from the request parameters
	public Semester toSemester() {
		Semester semester = new Semester();

        semester.setSemesterName(semesterName);
        semester.setSemWeightedGPA(semWeightedGPA);
        semester.setSemUnweightedGPA(semUnweightedGPA);

        return semester;
    }
}
