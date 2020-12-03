package com.example.medicalCenter.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.medicalCenter.algoritm.Algo;
import com.example.medicalCenter.algoritm.Algoritm;
import com.example.medicalCenter.enums.Decease;

@Entity
@Table(name = "geneticTest")
public class GeneticTest {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	private int ID;
	
	@Column(name = "testName")
	private String testName;
	
	@Column(name = "result")
	private String result;
	
	@Column(name = "dateOfExecution")
	private LocalDate dateOfExecution;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Patient patient;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}
	
	public String getEvaluatedResult() {
		String evaluatedResult = "";
		Algo algoritm = new Algoritm(this.patient.getDNA());
		if(algoritm.calculate() < 0.2) {
			evaluatedResult = Decease.LOW_RISK.toString();
		}
		if(algoritm.calculate() > 0.2 && algoritm.calculate() < 1.0) {
			evaluatedResult = Decease.MEDIUM_RISK.toString();
		}
		if(algoritm.calculate() > 1.0) {
			evaluatedResult = Decease.HIGH_RISK.toString();
		}
		this.setResult(evaluatedResult);
		return evaluatedResult;
	}
	
	

}
