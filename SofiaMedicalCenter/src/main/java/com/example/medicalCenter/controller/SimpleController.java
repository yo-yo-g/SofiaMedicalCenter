package com.example.medicalCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.medicalCenter.entity.Patient;
import com.example.medicalCenter.service.PatientService;

@RestController
public class SimpleController {
	
	@Autowired
	PatientService patientService;
	
	
	@PostMapping("/createPatient")
    Patient createPatient(@RequestBody Patient patient) {
    	return patientService.createPatient(patient);
    }
}