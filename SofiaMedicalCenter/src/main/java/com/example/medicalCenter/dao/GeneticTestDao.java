package com.example.medicalCenter.dao;

import java.util.List;

import com.example.medicalCenter.entity.GeneticTest;

public interface GeneticTestDao{
	void createGeneticTest(GeneticTest geneticTest);
	List<GeneticTest> listAllGeneticTests();
	
}
