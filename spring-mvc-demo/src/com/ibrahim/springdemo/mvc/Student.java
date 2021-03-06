package com.ibrahim.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstName;
	
	private String lastName;
	
	private String country;
	
	private String favoriteLanguage;
	
	private String[] operatingSystems;
	
	public String[] getOperatingSystems() {
		return operatingSystems;
	}


	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}


	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}


	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public LinkedHashMap getCountryOptions() {
		return countryOptions;
	}


	private LinkedHashMap countryOptions;
	
	



	public Student() {
		countryOptions=new LinkedHashMap<String,String>();
		
		countryOptions.put("TR", "TURKEY");
		countryOptions.put("BR", "BRAZIL");
		countryOptions.put("USA", "AMER?CA");
		countryOptions.put("FR", "FRANCE");
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
