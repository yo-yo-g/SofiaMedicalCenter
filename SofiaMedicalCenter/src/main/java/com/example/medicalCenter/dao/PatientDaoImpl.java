package com.example.medicalCenter.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.medicalCenter.entity.Patient;

@Repository
public class PatientDaoImpl implements PatientDao{
	
	@Autowired  
    private SessionFactory sessionFactory;  

	@Override
	public void createPatient(Patient patient) {
		sessionFactory.getCurrentSession().save(patient);
		
	}

	@Override
	public Patient findByName(String patientName) {
		Session currentSession = sessionFactory.getCurrentSession();  
        Query<Patient> query=currentSession.createQuery("from Patient where patientName=:patientName", Patient.class);  
        query.setParameter("patientName", patientName);  
        List<Patient> list=query.getResultList();  
		return list.get(0);
	}

	@Override
	public Patient findByPhoneNumber(String phoneNumber) {
		Session currentSession = sessionFactory.getCurrentSession();  
        Query<Patient> query=currentSession.createQuery("from Patient where phoneNumber=:phoneNumber", Patient.class);  
        query.setParameter("patientName", phoneNumber);  
        List<Patient> list=query.getResultList();  
		return list.get(0);
	}

}
