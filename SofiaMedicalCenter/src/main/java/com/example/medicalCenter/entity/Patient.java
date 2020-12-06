package com.example.medicalCenter.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {
	
	private static final String USER_ROLE = "PATIENT";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private int ID;
	
	@OneToMany
	private List<GeneticTest> geneticTest;
	
	private String patientName;

	private int age;

	private String phoneNumber;
	
	private String email;
	
	private String symptoms;

	private String DNA;

	public int getID() {
		return ID;
	}

	public List<GeneticTest> getGeneticTest() {
		return geneticTest;
	}

	public void setGeneticTest(List<GeneticTest> geneticTest) {
		this.geneticTest = geneticTest;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDNA() {
		return this.DNA;
	}

	public void setDNA(String DNA) {
		this.DNA = DNA;
	}

	public static String getUserRole() {
		return USER_ROLE;
	}
	
	@Override
	public String toString() {
		return "Patient [name=" + patientName + ", age=" + age + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", symptoms=" + symptoms + ", DNA=" + DNA + "]";
	}

}
