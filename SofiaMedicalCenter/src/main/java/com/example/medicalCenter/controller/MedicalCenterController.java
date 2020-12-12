package com.example.medicalCenter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.medicalCenter.entity.GeneticTest;
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
	
	private static final String PATIENT = "Patient ";
	
	private static final String PHYSICIAN = "Medical physician ";

	public MedicalCenterController(PatientService patientService, MedicalPhysicianService medicalPhysicianService) {
		this.patientService = patientService;
		this.medicalPhysicianService = medicalPhysicianService;
	}

	@PostMapping("/createPatient")
	public ResponseEntity<Object> createPatient(@RequestBody Patient patient) {
		patientService.createPatient(patient);
		return new ResponseEntity<>(PATIENT + "is created successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/listAllTestsForPatient/{id}")
	public List<GeneticTest> listAllTestsForPatient(@PathVariable("id") Long id) {
		return patientService.listAllGeneticTestForPatient(id);
	}

	@PostMapping("/createMedicalPhysician")
	public ResponseEntity<Object> createMedicalPhysician(@RequestBody MedicalPhysician medicalPhysician) {
		medicalPhysicianService.createMedicalPhysician(medicalPhysician);
		return new ResponseEntity<>(PHYSICIAN + "is created successfully", HttpStatus.CREATED);
	}
	
	@GetMapping("/listAllTests")
	public List<GeneticTest> listAllTests() {
		return medicalPhysicianService.listAllGeneticTests();
	}
	
	@GetMapping("/getDetailedViewForTest/{id}")
	public GeneticTest getDetailedViewForTest(@PathVariable("id") Long id) {
		return medicalPhysicianService.getDetailedView(id);
	}
	
	@GetMapping("/findTestByPatientName/{name}")
	public List<GeneticTest> findTestsByPatientName(@PathVariable("name") String name) {
		return medicalPhysicianService.findTestsByPatientName(name);
	}
	
	@GetMapping("/findTestByPatientEmail/{phoneNumber}")
	public List<GeneticTest> findTestsByPatientEmail(@PathVariable("phoneNumber") String phoneNumber) {
		return medicalPhysicianService.findTestsByPatientPhoneNumber(phoneNumber);
	}
	
	@PostMapping("/createGeneticTest")
	public String createGeneticTest(@RequestBody Patient patient,@RequestBody GeneticTest geneticTest) {
		return medicalPhysicianService.startGeneticTestWithParameters(patient, geneticTest);
	}
	
	
	
}