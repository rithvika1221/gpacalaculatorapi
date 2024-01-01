package com.fbla.gpacalculatorapi.requests;

import java.util.Date;

public record UpdateCourseInput(String course_name, String course_grade,  Double course_credit, String course_type) {
    
}
