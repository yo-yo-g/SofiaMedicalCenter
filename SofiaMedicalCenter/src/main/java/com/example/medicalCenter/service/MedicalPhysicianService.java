package com.example.medicalCenter.service;

import java.util.List;

import com.example.medicalCenter.entity.GeneticTest;
import com.example.medicalCenter.entity.MedicalPhysician;
import com.example.medicalCenter.entity.Patient;

public interface MedicalPhysicianService {

	void createMedicalPhysician(MedicalPhysician medicalPhysician);

	List<GeneticTest> listAllGeneticTests();

	GeneticTest getDetailedView(int id);

	List<GeneticTest> findTestsByPatientName(String name);

	List<GeneticTest> findTestsByPatientPhoneNumber(String phoneNumber);

	String startGeneticTestWithParameters(Patient patient, GeneticTest geneticTest);

}
