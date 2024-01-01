package com.fbla.gpacalculatorapi.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author rithvikadevisetti
 *
 */

@Entity
@Table(name = "course", schema = "dashboard")
public class Course {

	// this variable store the id of the course
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, name = "course_id")
	private Integer id;

	// this variable stores the course name
	@Column(name = "course_name")
	private String courseName;

	@Column(name = "course_grade")
	// this variable stores the course grade
	private String courseGrade;

	// this variable stores the course credit
	@Column(name = "course_credit")
	private double courseCredit;

	// this variable stores the course credit
	@Column(name = "course_type")
	private String courseType;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Semester semester;

	// default constructor
	public Course() {

	}

	/**
	 * this method constructs the course with parameters
	 */
	public Course(String courseName, String courseGrade, double courseCredit, String courseType) {

		this.courseName = courseName;
		this.courseGrade = courseGrade;
		this.courseCredit = courseCredit;
		this.courseType = courseType;

	}

	/**
	 * get method for course name
	 * 
	 * @return courseName
	 */
	public String getCourseName() {
		return courseName;

	}

	/**
	 * @param courseName
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * get method for course name
	 * 
	 * @return courseId
	 */
	public int getCourseId() {
		return id;

	}

	/**
	 * @param courseId
	 */
	public void setCourseName(int courseId) {
		this.id = courseId;
	}

	public String getCourseGrade() {
		return courseGrade;

	}

	/**
	 * @param setCourseGrade
	 */
	public void setCourseGrade(String courseGrade) {
		this.courseGrade = courseGrade;
	}

	/**
	 * @return
	 */
	public double getCourseCredit() {
		return courseCredit;

	}

	/**
	 * @param CourseCredit
	 */
	public void setCourseCredit(double courseCredit) {
		this.courseCredit = courseCredit;
	}

	public String getCourseType() {
		return courseType;

	}

	/**
	 * @param setCourseGrade
	 */
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public Semester getCourseSemester() {
		return semester;

	}

	/**
	 * @param setCourseSemester
	 */
	public void setCourseSemester(Semester courseSemester) {
		this.semester = courseSemester;
	}


}
