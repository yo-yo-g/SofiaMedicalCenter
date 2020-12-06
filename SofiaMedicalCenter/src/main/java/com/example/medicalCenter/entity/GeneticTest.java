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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "geneticTest")
public class GeneticTest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID;

	private String testName;

	private String result;

	private LocalDate dateOfExecution;

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
