package com.example.medicalCenter.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medicalCenter.entity.Patient;
import com.example.medicalCenter.repository.PatientRepository;


@Service
@Transactional
public class PatientServiceImpl implements PatientService {
	
	@Autowired
	PatientRepository patientRepository;

	@Override
	public void createPatient(String name, int age, String phoneNumber, String email, String symptoms, String DNA) {
		Patient patient = new Patient(name, age, phoneNumber, email, symptoms, DNA);
		patientRepository.saveAndFlush(patient);

	}

	@Override
	public Patient findByName(String name) {
		Patient patient = null;
		List<Patient> allPatients = patientRepository.findAll();
		for(Patient p : allPatients) {
			if(p.getName().equals(name)) {
				patient = p;
			}
		}
		return patient;
	}

	@Override
	public Patient findByPhoneNumber(String phoneNumber) {
		Patient patient = null;
		List<Patient> allPatients = patientRepository.findAll();
		for(Patient p : allPatients) {
			if(p.getPhoneNumber().equals(phoneNumber)) {
				patient = p;
			}
		}
		return patient;
	}

}
