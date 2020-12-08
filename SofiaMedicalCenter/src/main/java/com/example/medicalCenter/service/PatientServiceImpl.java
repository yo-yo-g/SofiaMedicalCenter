package com.example.medicalCenter.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.medicalCenter.entity.GeneticTest;
import com.example.medicalCenter.entity.Patient;
import com.example.medicalCenter.repository.PatientRepository;

@Service
@Transactional
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientRepository patientRepository;

	@Override
	public Patient createPatient(Patient patient) {
		return patientRepository.saveAndFlush(patient);

	}

	@Override
	public List<GeneticTest> listAllGeneticTestForPatient(Long id) {
		return patientRepository.getOne(id).getGeneticTest();
	}

}
