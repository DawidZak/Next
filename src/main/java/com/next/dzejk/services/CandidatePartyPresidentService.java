package com.next.dzejk.services;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.next.dzejk.dao.ICandidatePartyPresidentRepository;
import com.next.dzejk.form.RegisterCandidateParty;
import com.next.dzejk.model.CandidatePartyPresident;

@Service
public class CandidatePartyPresidentService implements ICandidatePartyPresidentService {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	ICandidatePartyPresidentRepository iCandidatePartyPresident;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public List<CandidatePartyPresident> findAllCandidates() {
		return iCandidatePartyPresident.findAll();
	}

	@Override
	public void updateCandidatePartyPresident(RegisterCandidateParty cpp) throws Exception {
		CandidatePartyPresident candidatePresidentParty = new CandidatePartyPresident();
		candidatePresidentParty.setID(cpp.getID());
		candidatePresidentParty.setFirstName(cpp.getFirstName());
		candidatePresidentParty.setLastName(cpp.getLastName());
		candidatePresidentParty.setPartyMember(cpp.getPartyMember());
		System.out.println("Update");
		Session sess = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = sess.beginTransaction();
			sess.update(candidatePresidentParty);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			sess.close();
		}

	}

	@Override
	public CandidatePartyPresident saveCandidatePartyPresident(RegisterCandidateParty cpp) {
		// TODO Auto-generated method stub
		com.next.dzejk.model.CandidatePartyPresident candidatePresidentParty = new com.next.dzejk.model.CandidatePartyPresident();
		candidatePresidentParty.setFirstName(cpp.getFirstName());
		candidatePresidentParty.setLastName(cpp.getLastName());
		candidatePresidentParty.setPartyMember(cpp.getPartyMember());

		return iCandidatePartyPresident.save(candidatePresidentParty);
	}

	@Override
	public void deleteCandidatePartyPresidentById(int id) {
		iCandidatePartyPresident.delete(id);

	}

}
