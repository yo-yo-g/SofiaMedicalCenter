package com.example.medicalCenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.medicalCenter.entity.MedicalPhysician;
import com.example.medicalCenter.entity.Patient;

@Repository
public interface MedicalPhysicianRepository extends JpaRepository<MedicalPhysician, Long> {

	@Query("FROM Patient WHERE patient_name = ?1")
	Patient findByName(String name);

	@Query("FROM Patient WHERE phoneNumber = ?1")
	Patient findByPhoneNumber(String phoneNumber);

}
