package com.fbla.gpacalculatorapi.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Settings {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String letter;
    private String percent;
    private double gpa;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "studentId", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
   private Student student;

    // Constructors
    public Settings() {
    }

    public Settings(String letter, String percent, double gpa) {
        this.letter = letter;
        this.percent = percent;
        this.gpa = gpa;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    
	/**
	 * @return
	 */
	public Student getSettingsStudent()
	{
		return student;
		
	}
	
	
	/**
	 * @param SemesterUnweightedGPA
	 */
	public void setSettingsStudent(Student student)
	{
		this.student = student;
	}
}

