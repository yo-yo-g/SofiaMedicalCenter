package com.example.medicalCenter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.medicalCenter.algoritm.Algo;
import com.example.medicalCenter.algoritm.Algoritm;
import com.example.medicalCenter.enums.Decease;
import com.sun.istack.NotNull;

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
	private Long ID;

	@NotNull
	private String testName;

	private String result;

	private String dateOfExecution;

	public void getPossibilityOfGenerticDisorder(String DNA) {
		Algo algoritm = new Algoritm(DNA);
		if(algoritm.calculate() < 0.2) {
			this.result = Decease.LOW_RISK.toString();
		}
		if(algoritm.calculate() > 0.2 && algoritm.calculate() < 1.0) {
			this.result = Decease.MEDIUM_RISK.toString();
		}
		if(algoritm.calculate() < 1.0) {
			this.result = Decease.HIGH_RISK.toString();
		}
	}

	@Override
	public String toString() {
		return "GeneticTest [ID=" + ID + ", testName=" + testName + ", result=" + result + ", dateOfExecution="
				+ dateOfExecution + "]";
	}
	
}
