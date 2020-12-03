package com.example.medicalCenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.medicalCenter.entity.GeneticTest;

public interface GeneticTestRepository extends JpaRepository<GeneticTest, Integer> {

}
