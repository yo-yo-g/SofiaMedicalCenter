package com.example.medicalCenter.service;

import com.example.medicalCenter.entity.Patient;

public interface PatientService {
	Patient findByName(String name);
	Patient findByPhoneNumber(String phoneNumber);

}
