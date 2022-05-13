package com.ibrahim.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode,String> {
		
	private String coursePrefix;
	
	@Override
	public void initialize(CourseCode constraintAnnotation) {
		coursePrefix=constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext theConstraint) {
		
		boolean result=theCode.startsWith(coursePrefix);
		
		return result;
	}

	
	

}
