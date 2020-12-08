package com.example.medicalCenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.medicalCenter.entity.MedicalPhysician;

@Repository
public interface MedicalPhysicianRepository extends JpaRepository<MedicalPhysician, Long>{
	
}
