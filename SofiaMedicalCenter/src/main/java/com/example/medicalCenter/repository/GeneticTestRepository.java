package com.example.medicalCenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.medicalCenter.entity.GeneticTest;

@Repository
public interface GeneticTestRepository extends JpaRepository<GeneticTest, Long>{
	
}
