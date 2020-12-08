package com.example.medicalCenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.medicalCenter.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long>{

}
