package com.next.dzejk.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//import com.next.dzejk.HibernateUtil;
import com.next.dzejk.model.Candidate;


@Repository
public class CandidateDao implements ICandidateDao {

	
	@Autowired
    private SessionFactory sessionFactory ;
	
	
	@Override
	public void addCandidate(Candidate candidate) {
		// TODO Auto-generated method stub
		sessionFactory.openSession();
		
	}

}
