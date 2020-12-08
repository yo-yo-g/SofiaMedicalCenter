package com.example.medicalCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.medicalCenter.entity.MedicalPhysician;
import com.example.medicalCenter.entity.Patient;
import com.example.medicalCenter.service.MedicalPhysicianService;
import com.example.medicalCenter.service.PatientService;

@RestController
@RequestMapping(value = "/homepage")
public class MedicalCenterController {

	@Autowired
	PatientService patientService;

	@Autowired
	MedicalPhysicianService medicalPhysicianService;
	
	private static final String PATIENT = "Patient";
	
	private static final String PHYSICIAN = "Medical physician";

	public MedicalCenterController(PatientService patientService, MedicalPhysicianService medicalPhysicianService) {
		this.patientService = patientService;
		this.medicalPhysicianService = medicalPhysicianService;
	}

	@PostMapping("/createPatient")
	public ResponseEntity<Object> createPatient(@RequestBody Patient patient) {
		patientService.createPatient(patient);
		return new ResponseEntity<>(PATIENT + " is created successfully", HttpStatus.CREATED);
	}

	@PostMapping("/createMedicalPhysician")
	public ResponseEntity<Object> createProduct(@RequestBody MedicalPhysician medicalPhysician) {
		medicalPhysicianService.createMedicalPhysician(medicalPhysician);
		return new ResponseEntity<>(PHYSICIAN + " is created successfully", HttpStatus.CREATED);
	}
}