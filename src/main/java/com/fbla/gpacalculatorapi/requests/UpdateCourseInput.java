package com.fbla.gpacalculatorapi.requests;

import java.util.Date;

public record UpdateCourseInput(String courseName, String courseGrade,  Double courseCredit, String courseType) {
    
}
