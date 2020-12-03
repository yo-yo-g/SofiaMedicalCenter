package com.example.medicalCenter.dao;

import org.springframework.stereotype.Repository;

import com.example.medicalCenter.entity.Patient;

@Repository
public interface PatientDao{
	
	void createPatient(Patient patient);
	
	Patient findByName(String patientName);

	Patient findByPhoneNumber(String phoneNumber);

}
