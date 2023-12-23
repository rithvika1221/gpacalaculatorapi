package com.fbla.gpacalculatorapi.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;




/**
 * @author rithvikadevisetti
 *
 */

@Entity
@Table(name="semester", schema = "dashboard")
public class Semester {
	
	// this variable store the id of the Semester
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(nullable = false, name="semester_id")
	    private Integer semid;
	 
	
	 
	// this  variable stores the semester name
	@Column(name="semester_name") 
	private String semesterName;
	
	
	
	@Column(name="sem_weighted_gpa")
	// this  variable stores the weighted GPA
	private double semWeightedGPA;
	
	// this  variable stores the UnWeighted GPA
	@Column(name="sem_unweighted_gpa")
	private double semUnweightedGPA;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_semester_id", referencedColumnName = "semester_id")
	private List<Course> course;
	
	// default constructor
	public Semester() {
		
	}
	
	
	/**
	 * this method constructs the student with  parameters
	 */
	public Semester(String semesterName, double semWeightedGPA, double semUnweightedGPA, List<Course> course) {
		
		this.semesterName = semesterName;
		this.semWeightedGPA = semWeightedGPA;
		this.semUnweightedGPA = semUnweightedGPA;
		this.course = course;
	
	}
	
	
	/**
	 * get method for semester name
	 * @return semesterName
	 */
	public String getSemesterName()
	{
		return semesterName;
		
	}
	
	
	
	/**
	 * @param studentName
	 */
	public void setSemesterName(String semesterName)
	{
		this.semesterName = semesterName;
	}
	
	
	

	public double getSemesterWeightedGPA()
	{
		return semWeightedGPA;
		
	}
	
	/**
	 * @param getSemesterWeightedGPA
	 */
	public void setSemesterWeightedGPA(double semWeightedGPA)
	{
		this.semWeightedGPA = semWeightedGPA;
	}
	
	
	/**
	 * @return
	 */
	public double getSemesterUnweightedGPA()
	{
		return semUnweightedGPA;
		
	}
	
	
	/**
	 * @param studentUnweightedGPA
	 */
	public void setSemesterUnweightedGPA(double semUnweightedGPA)
	{
		this.semUnweightedGPA = semUnweightedGPA;
	}
	
	

}


