package com.example.medicalCenter.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.medicalCenter.algoritm.Algo;
import com.example.medicalCenter.algoritm.Algoritm;
import com.example.medicalCenter.enums.Decease;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "geneticTest")
public class GeneticTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	private String testName;

	private String result;

	private LocalDate dateOfExecution;

	public GeneticTest() {
		this.testName = "";
		this.dateOfExecution = null;
		this.result = "";
	}

	public int getID() {
		return ID;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public LocalDate getDateOfExecution() {
		return dateOfExecution;
	}

	public void setDateOfExecution(LocalDate dateOfExecution) {
		this.dateOfExecution = dateOfExecution;
	}
	public void getPossibilityOfGenerticDisorder(String DNA) {
		Algo algoritm = new Algoritm(DNA);
		if(algoritm.calculate() < 0.2) {
			result = Decease.LOW_RISK.toString();
		}
		if(algoritm.calculate() > 0.2 && algoritm.calculate() < 1.0) {
			result = Decease.MEDIUM_RISK.toString();
		}
		if(algoritm.calculate() < 1.0) {
			result = Decease.HIGH_RISK.toString();
		}
	}
}
