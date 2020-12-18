package com.example.medicalCenter.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medicalCenter.algoritm.Algo;
import com.example.medicalCenter.algoritm.Algoritm;
import com.example.medicalCenter.entity.GeneticTest;
import com.example.medicalCenter.entity.MedicalPhysician;
import com.example.medicalCenter.entity.Patient;
import com.example.medicalCenter.enums.Decease;
import com.example.medicalCenter.repository.GeneticTestRepository;
import com.example.medicalCenter.repository.MedicalPhysicianRepository;
import com.example.medicalCenter.repository.PatientRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Transactional
@Service
public class MedicalPhysicianServiceImpl implements MedicalPhysicianService {

	@Autowired
	PatientRepository patientRepository;

	@Autowired
	GeneticTestRepository geneticTestRepository;

	@Autowired
	MedicalPhysicianRepository medicalPhysicianRepository;

	@Override
	public MedicalPhysician createMedicalPhysician(MedicalPhysician medicalPhysician) {
		return medicalPhysicianRepository.saveAndFlush(medicalPhysician);
	}

	@Override
	public List<GeneticTest> listAllGeneticTests() {
		return geneticTestRepository.findAll();
	}

	@Override
	public GeneticTest getDetailedView(Long id) {
		return geneticTestRepository.getOne(id);
	}

	@Override
	public List<GeneticTest> findTestsByPatientName(String name) {
		if (!checkConditionForName(name)) {
			log.error("Patient with this name" + name + " is not found");
		}

		return medicalPhysicianRepository.findByName(name).getGeneticTest();
	}

	@Override
	public List<GeneticTest> findTestsByPatientPhoneNumber(String phoneNumber) {
		if (!checkConditionForPhoneNumber(phoneNumber)) {
			log.error("Patient with this phone number" + phoneNumber +" is not found");
		}
		
		return medicalPhysicianRepository.findByPhoneNumber(phoneNumber).getGeneticTest();
	}

	@Override
	public String startGeneticTestWithParameters(Patient patient, GeneticTest geneticTest) {
		List<Patient> patients = patientRepository.findAll();
		if (!patients.contains(patient)) {
			log.error("No such patient");
		}
		getPossibilityOfGenerticDisorder(geneticTest, patient.getDNA());
		patient.getGeneticTest().add(geneticTest);
		return geneticTest.getResult();
	}
	
	@Override
	public GeneticTest redoGeneticTest(GeneticTest geneticTest) {
		return geneticTestRepository.getOne(geneticTest.getID());
	}

	private boolean checkConditionForPhoneNumber(String phoneNumber) {
		boolean result = false;
		List<Patient> patients = patientRepository.findAll();
		for (Patient p : patients) {
			if (p.getPhoneNumber().equals(phoneNumber)) {
				result = true;
			}
		}
		return result;
	}

	private boolean checkConditionForName(String name) {
		boolean result = false;
		List<Patient> patients = patientRepository.findAll();
		for (Patient p : patients) {
			if (p.getPatientName().equals(name)) {
				result = true;
			}
		}
		return result;
	}

	private void getPossibilityOfGenerticDisorder(GeneticTest geneticTest, String DNA) {
		Algo algoritm = new Algoritm(DNA);
		if(algoritm.calculate() < 0.2) {
			geneticTest.setResult(Decease.LOW_RISK.toString());
		}
		if(algoritm.calculate() > 0.2 && algoritm.calculate() < 1.0) {
			geneticTest.setResult(Decease.MEDIUM_RISK.toString());
		}
		if(algoritm.calculate() < 1.0) {
			geneticTest.setResult(Decease.HIGH_RISK.toString());
		}
	}

}
