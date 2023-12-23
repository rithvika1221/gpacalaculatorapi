package com.fbla.gpacalculatorapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;




/**
 * @author rithvikadevisetti
 *
 */

@Entity
@Table(name="course", schema = "dashboard")
public class Course {
	
	// this variable store the id of the Semester
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(nullable = false, name="course_id")
	    private Integer courseid;
	 
	 
	// this  variable stores the course name
	@Column(name="course_name") 
	private String courseName;
	
	
	
	@Column(name="course_grade")
	// this  variable stores the course grade
	private String courseGrade;
	
	// this  variable stores the course credit
	@Column(name="course_credit")
	private double courseCredit;
	
	// this  variable stores the course credit
		@Column(name="course_type")
		private String courseType;
	
	// default constructor
	public Course() {
		
	}
	
	
	/**
	 * this method constructs the student with  parameters
	 */
	public Course(String courseName, String courseGrade, double courseCredit, String courseType) {
		
		this.courseName = courseName;
		this.courseGrade = courseGrade;
		this.courseCredit = courseCredit;
		this.courseType = courseType;
	
	}
	
	
	/**
	 * get method for course name
	 * @return courseName
	 */
	public String getCourseName()
	{
		return courseName;
		
	}
	
	
	
	/**
	 * @param courseName
	 */
	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}
	
	
	

	public String getCourseGrade()
	{
		return courseGrade;
		
	}
	
	/**
	 * @param setCourseGrade
	 */
	public void setCourseGrade(String courseGrade)
	{
		this.courseGrade = courseGrade;
	}
	
	
	/**
	 * @return
	 */
	public double getCourseCredit()
	{
		return courseCredit;
		
	}
	
	
	/**
	 * @param CourseCredit
	 */
	public void setCourseCredit(double courseCredit)
	{
		this.courseCredit = courseCredit;
	}
	

	public String getCourseType()
	{
		return courseType;
		
	}
	
	/**
	 * @param setCourseGrade
	 */
	public void setCourseType(String courseType)
	{
		this.courseType = courseType;
	}
	
	
	/**
	 * @return
	 */
	

}


