package com.example.medicalCenter.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.medicalCenter.entity.MedicalPhysician;

@Repository
public class MedicalPhysicianDaoImpl implements MedicalPhysicianDao{
	
	@Autowired  
    private SessionFactory sessionFactory;  

	@Override
	public void createMedicalPhysicianDao(MedicalPhysician medicalPhysician) {
		sessionFactory.getCurrentSession().save(medicalPhysician);
		
	}

}
