package com.example.medicalCenter.service;

import com.example.medicalCenter.entity.Patient;

public interface PatientService {
	void createPatient(String name, int age, String phoneNumber, String email, String symptoms, String DNA);
	Patient findByName(String name);
	Patient findByPhoneNumber(String phoneNumber);

}
