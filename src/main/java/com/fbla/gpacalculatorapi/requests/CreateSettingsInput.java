package com.fbla.gpacalculatorapi.requests;

import java.util.Date;

import com.fbla.gpacalculatorapi.model.Semester;
import com.fbla.gpacalculatorapi.model.Settings;




public record CreateSettingsInput(String letter, String percent, Double gpa) {
	
   
	// this function takes the parameters which is gets from the request
	// it creates a semester object from the request parameters
	public Settings toSettings() {
		Settings settings = new Settings();

		settings.setLetter(letter);
		settings.setPercent(percent);
		settings.setGpa(gpa);

        return settings;
    }
}

