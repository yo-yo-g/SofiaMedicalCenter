package com.example.medicalCenter.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

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
	private Long ID;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<GeneticTest> geneticTest;
	
	@Column(name="patient_name", unique=true)
	@NotNull
	private String patientName;

	@NotNull
	private int age;

	@NotNull
	private String phoneNumber;
	
	@NotNull
	private String email;
	
	@NotNull
	private String symptoms;

	@NotNull
	private String DNA;

	@Override
	public String toString() {
		return "Patient [geneticTest=" + geneticTest + ", patientName=" + patientName + ", age=" + age
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", symptoms=" + symptoms + ", DNA=" + DNA + "]";
	}

}
