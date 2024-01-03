package com.fbla.gpacalculatorapi.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name="student", schema = "gpacalculator")
public class Student {
	
	// this variable store the id of the student
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(nullable = false, name = "id")
	    private Integer id;
	 
	
	// this  variable stores the student name
	@Column(name="studentName")
	 private String studentName;
	
	// this  variable stores the student password
	@Column(name="password")
	private String password;
	
	@Column(name="totalWeightedGPA")
	// this  variable stores the weighted GPA
	private double totalWeightedGPA;
	
	// this  variable stores the UnWeighted GPA
	@Column(name="totalUnweightedGPA")
	private double totalUnweightedGPA;
	

	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy="student")
	private List<Semester> semester;
	
	
	// default constructor
	public Student() {
		
	}
	
	
	/**
	 * this method constructs the student with the below parameters
	 * @param studentName
	 * @param studentPassword
	 * @param studentWeightedGPA
	 * @param studentUnweightedGPA
	 */
	public Student(String studentName, String studentPassword, double studentWeightedGPA, double studentUnweightedGPA, List<Semester> semester) {
		
		this.studentName = studentName;
		this.password = studentPassword;
		this.totalWeightedGPA = studentWeightedGPA;
		this.totalUnweightedGPA = studentUnweightedGPA;
		this.semester = semester;
		
	
	}
	
	/**
	 * get method for student name
	 * @return studentId
	 */
	public int getStudentId()
	{
		return id;
		
	}
	
	
	
	/**
	 * @param studentId
	 */
	public void setstudentName1(int studentId)
	{
		this.id = studentId;
	}
	
	/**
	 * get method for student name
	 * @return studentname
	 */
	public String getStudentName()
	{
		return studentName;
		
	}
	
	
	
	/**
	 * @param studentName
	 */
	public void setStudentName(String studentName)
	{
		this.studentName = studentName;
	}
	
	
	/**
	 * @return
	 */
	public String getStudentPassword()
	{
		return password;
		
	}
	
	/**
	 * @param studentPassword
	 */
	public void setStudentPassword(String studentPassword)
	{
		this.password = studentPassword;
	}
	
	/**
	 * @return
	 */
	public double getStudentWeightedGPA()
	{
		return totalWeightedGPA;
		
	}
	
	/**
	 * @param studentWeightedGPA
	 */
	public void setStudentWeightedGPA(double studentWeightedGPA)
	{
		this.totalWeightedGPA = studentWeightedGPA;
	}
	
	
	/**
	 * @return
	 */
	public double getStudentUnweightedGPA()
	{
		return totalUnweightedGPA;
		
	}
	
	
	/**
	 * @param studentUnweightedGPA
	 */
	public void setStudentUnweightedGPA(double studentUnweightedGPA)
	{
		this.totalUnweightedGPA = studentUnweightedGPA;
	}
	
	

}


