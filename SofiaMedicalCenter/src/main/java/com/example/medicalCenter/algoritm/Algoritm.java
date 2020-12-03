package com.example.medicalCenter.algoritm;

public class Algoritm implements Algo{
	
	private String dna;

	public String getAlgoritm() {
		return dna;
	}

	public void setAlgoritm(String dna) {
		this.dna = dna;
	}

	public Algoritm(String dna) {
		this.dna = dna;
	}
	
	private double calculateChance() {
		return 0;
	}

	@Override
	public double calculate() {
		// TODO Auto-generated method stub
		return calculateChance();
	}
	

}
