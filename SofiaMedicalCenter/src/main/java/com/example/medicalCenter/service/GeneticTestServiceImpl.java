package com.example.medicalCenter.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medicalCenter.entity.GeneticTest;
import com.example.medicalCenter.repository.GeneticTestRepository;
import com.example.medicalCenter.repository.PatientRepository;

@Service
@Transactional
public class GeneticTestServiceImpl implements GeneticTestService {

	@Autowired
	GeneticTestRepository geneticTestRepository;
	
	@Autowired
	PatientRepository patientRepository;

	@Override
	public void createGeneticTest(String symptoms, String patientName, String phoneNumber, String email, int age, String DNA) {
		GeneticTest geneticTest = new GeneticTest(patientRepository.findByPhoneNumber(phoneNumber));
		geneticTest.setDateOfExecution(LocalDate.now());
		geneticTestRepository.saveAndFlush(geneticTest);
		
	}

	@Override
	public List<GeneticTest> listAllGeneticTests() {
		return geneticTestRepository.findAll();
	}

}
