package com.next.dzejk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.next.dzejk.dao.ICandidatePartyPresidentRepository;
import com.next.dzejk.form.RegisterCandidateParty;
import com.next.dzejk.model.CandidatePartyPresident;
@Service
public class CandidatePartyPresidentService implements ICandidatePartyPresidentService {

	@Autowired
	ICandidatePartyPresidentRepository iCandidatePartyPresident;

	


	@Override
	public List<CandidatePartyPresident> findAllCandidates() {
		return iCandidatePartyPresident.findAll();
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
	


}
