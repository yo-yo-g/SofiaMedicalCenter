package com.example.medicalCenter.service;

import java.util.List;

import com.example.medicalCenter.entity.GeneticTest;

public interface GeneticTestService {
	void createGeneticTest(String symptoms , String patientName, String phoneNumber, String email, int age, String DNA);
	List<GeneticTest> listAllGeneticTests();
}
