package com.example.medicalCenter.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medicalCenter.entity.GeneticTest;
import com.example.medicalCenter.entity.MedicalPhysician;
import com.example.medicalCenter.entity.Patient;
import com.example.medicalCenter.repository.GeneticTestRepository;
import com.example.medicalCenter.repository.MedicalPhysicianRepository;
import com.example.medicalCenter.repository.PatientRepository;

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
		List<Patient> patients = patientRepository.findAll();
		for(Patient p : patients) {
			if(p.getPatientName().equals(name)) {
				return p.getGeneticTest();
			}
		}
		
		return null;
	}

	@Override
	public List<GeneticTest> findTestsByPatientPhoneNumber(String phoneNumber) {
		List<Patient> patients = patientRepository.findAll();
		for(Patient p : patients) {
			if(p.getPhoneNumber().equals(phoneNumber)) {
				return p.getGeneticTest();
			}
		}
		
		return null;
	}

	@Override
	public String startGeneticTestWithParameters(Patient patient, GeneticTest geneticTest) {
		List<Patient> patients = patientRepository.findAll();
		if(!patients.contains(patient)) {
			return "There is no such patient";
		}
		geneticTest.getPossibilityOfGenerticDisorder(patient.getDNA());
		patient.getGeneticTest().add(geneticTest);
		return geneticTest.getResult();
	}

}
