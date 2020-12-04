package com.example.medicalCenter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "patient")
public class Patient {
	private static final String PATIENT_ROLE = "PATIENT";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private int ID;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "phoneNumber", unique=true)
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "symptoms")
	private String symptoms;
	
	@Column(name = "dna")
	private String DNA;

	public String getRole() {
		return PATIENT_ROLE;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getDNA() {
		return DNA;
	}

	public void setDNA(String dNA) {
		DNA = dNA;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	public Patient(String name, int age, String phoneNumber, String email, String symptoms, String dNA) {
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.symptoms = symptoms;
		DNA = dNA;
	}
}
