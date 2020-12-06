package com.example.medicalCenter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "physician")
public class MedicalPhysician {
	private static final String USER_ROLE = "Medical_Physician";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	private String name;
	
	public MedicalPhysician() {
		this.name = "";
	}

	public String getUserRole() {
		return USER_ROLE;
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

}
