package com.example.medicalCenter.service;

import java.util.List;

import com.example.medicalCenter.entity.GeneticTest;
import com.example.medicalCenter.entity.MedicalPhysician;
import com.example.medicalCenter.entity.Patient;

public interface MedicalPhysicianService {

	MedicalPhysician createMedicalPhysician(MedicalPhysician medicalPhysician);

	List<GeneticTest> listAllGeneticTests();

	GeneticTest getDetailedView(Long id);
	
	GeneticTest redoGeneticTest(GeneticTest geneticTest);

	List<GeneticTest> findTestsByPatientName(String name);

	List<GeneticTest> findTestsByPatientPhoneNumber(String phoneNumber);

	String startGeneticTestWithParameters(Patient patient, GeneticTest geneticTest);

}
