package com.ibrahim.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.ibrahim.springdemo.mvc.validation.CourseCode;

public class Customer {
	
	private String firstName;
	
	@NotNull(message="is required")
	@Size(min=1,message="is required")
	private String lastName;
	
	@NotNull(message="is required")
	@Min(value=0,message="must be more than or equals zero")
	@Max(value=10,message="must be less than or equals 10")
	private Integer freePasses;
	
	
	@Pattern(regexp="^[a-zA-Z0-9]{5}",message="must be equals 5 character")
	private String postalCode;
	
	@CourseCode
	private String courseCode;
	
	
	public String getCourseCode() {
		return courseCode;
	}


	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}


	public String getPostalCode() {
		return postalCode;
	}


	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}


	public Integer getFreePasses() {
		return freePasses;
	}


	public void setFreePasses(Integer freePasses) {
		this.freePasses = freePasses;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
