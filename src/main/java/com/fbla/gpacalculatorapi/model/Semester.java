package com.fbla.gpacalculatorapi.model;

import java.util.List;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;




/**
 * @author rithvikadevisetti
 *
 */

@Entity
@Table(name="semester", schema = "dashboard_updated")
public class Semester {
	
	// this variable store the id of the Semester
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(nullable = false, name="id")
	    private Integer id;
	 
	 
	// this  variable stores the semester name
	@Column(name="semesterName") 
	private String semesterName;
	
	
	
	@Column(name="semWeightedGPA")
	// this  variable stores the weighted GPA
	private double semWeightedGPA;
	
	// this  variable stores the UnWeighted GPA
	@Column(name="semUnweightedGPA")
	private double semUnweightedGPA;
	
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "studentId", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Student student;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "semesterId", referencedColumnName = "id")
	private List<Course> course;
	
	// default constructor
	public Semester() {
		
	}
	
	
	/**
	 * this method constructs the semester with  parameters
	 */
	public Semester(String semesterName, double semWeightedGPA, double semUnweightedGPA, List<Course> course) {
		
		this.semesterName = semesterName;
		this.semWeightedGPA = semWeightedGPA;
		this.semUnweightedGPA = semUnweightedGPA;
		this.course = course;
	
	}
	

	/**
	 * get method for semester id
	 * @return semesterName
	 */
	public int getSemesterId()
	{
		return id;
		
	}
	
	
	
	/**
	 * @param studentId
	 */
	public void setSemesterId(int semesterId)
	{
		this.id = semesterId;
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
	 * @param semesterName
	 */
	public void setSemesterName(String semesterName)
	{
		this.semesterName = semesterName;
	}
	
	
	

	public double getSemWeightedGPA()
	{
		return semWeightedGPA;
		
	}
	
	/**
	 * @param getSemesterWeightedGPA
	 */
	public void setSemWeightedGPA(double semWeightedGPA)
	{
		this.semWeightedGPA = semWeightedGPA;
	}
	
	
	/**
	 * @return
	 */
	public double getSemUnweightedGPA()
	{
		return semUnweightedGPA;
		
	}
	
	
	/**
	 * @param SemesterUnweightedGPA
	 */
	public void SetSemUnweightedGPA(double semUnweightedGPA)
	{
		this.semUnweightedGPA = semUnweightedGPA;
	}
	
	/**
	 * @return
	 */
	public Student getSemesterStudent()
	{
		return student;
		
	}
	
	
	/**
	 * @param SemesterUnweightedGPA
	 */
	public void setSemesterStudent(Student student)
	{
		this.student = student;
	}
	
		

}


