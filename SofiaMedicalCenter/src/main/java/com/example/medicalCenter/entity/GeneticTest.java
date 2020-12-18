package com.example.medicalCenter.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

	@NotNull
	private String result;

	@NotNull
	private String dateOfExecution;

	@Override
	public String toString() {
		return "GeneticTest [ID=" + ID + ", testName=" + testName + ", result=" + result + ", dateOfExecution="
				+ dateOfExecution + "]";
	}
	
}
