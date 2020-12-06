package com.example.medicalCenter.service;

import java.util.List;

import com.example.medicalCenter.entity.GeneticTest;
import com.example.medicalCenter.entity.Patient;

public interface PatientService {
	Patient createPatient(Patient patient);
	List<GeneticTest> listAllGeneticTestForPatient(int id);
}
