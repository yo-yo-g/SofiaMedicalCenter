package com.example.medicalCenter.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.medicalCenter.entity.GeneticTest;

@Repository
public class GeneticTestDaoImpl implements GeneticTestDao{
	
	@Autowired
    private SessionFactory sessionFactory;  

	@Override
	public void createGeneticTest(GeneticTest geneticTest) {
		sessionFactory.getCurrentSession().save(geneticTest);
		
	}

	@Override
	public List<GeneticTest> listAllGeneticTests() {
		Session currentSession = sessionFactory.getCurrentSession();  
        Query<GeneticTest> query=currentSession.createQuery("from GeneticTest", GeneticTest.class);  
        List<GeneticTest> list=query.getResultList();  
        return list; 
	}


}
