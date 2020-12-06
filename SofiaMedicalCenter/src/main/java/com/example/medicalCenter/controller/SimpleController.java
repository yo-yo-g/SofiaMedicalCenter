package com.example.medicalCenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.medicalCenter.entity.MedicalPhysician;
import com.example.medicalCenter.entity.Patient;
import com.example.medicalCenter.service.MedicalPhysicianService;
import com.example.medicalCenter.service.PatientService;

@EnableAutoConfiguration
@ComponentScan
@RestController
@RequestMapping(value = "/")
public class SimpleController {

	@Autowired
	PatientService patientService;
	
	@Autowired
	MedicalPhysicianService medicalPhysicianService;

	@PostMapping("/createPatient")
	Patient createPatient(@RequestBody Patient patient) {
		return patientService.createPatient(patient);
	}
	
	@PostMapping("/createMedicalPhysician")
	MedicalPhysician createMedicalPhysician(@RequestBody MedicalPhysician medicalPhysician) {
		return medicalPhysicianService.createMedicalPhysician(medicalPhysician);
	}
}