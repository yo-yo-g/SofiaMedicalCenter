package com.example.medicalCenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.medicalCenter.entity.MedicalPhysician;

public interface MedicalPhysicianRepository extends JpaRepository<MedicalPhysician, Integer> {

}
