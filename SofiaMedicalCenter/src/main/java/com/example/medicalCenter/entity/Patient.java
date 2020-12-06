package com.example.medicalCenter.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "patient")
public class Patient {

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
	
	@Override
	public String toString() {
		return "Patient [name=" + patientName + ", age=" + age + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", symptoms=" + symptoms + ", DNA=" + DNA + "]";
	}

}
