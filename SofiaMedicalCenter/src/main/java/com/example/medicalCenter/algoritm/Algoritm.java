package com.example.medicalCenter.algoritm;

public class Algoritm implements Algo {

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
		int maxLength = 1;
		int low, high;
		for (int i = 1; i < dna.length(); ++i) {

			low = i - 1;
			high = i;
			while (low >= 0 && high < dna.length() && dna.charAt(low) == dna.charAt(high)) {
				if (high - low + 1 > maxLength) {
					maxLength = high - low + 1;
				}
				--low;
				++high;
			}

			low = i - 1;
			high = i + 1;
			while (low >= 0 && high < dna.length() && dna.charAt(low) == dna.charAt(high)) {
				if (high - low + 1 > maxLength) {
					maxLength = high - low + 1;
				}
				--low;
				++high;
			}
		}

		return (double) maxLength / (double) dna.length();
	}

	@Override
	public double calculate() {
		return calculateChance();
	}

}
