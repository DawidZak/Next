package com.next.dzejk.services;

import java.util.List;


import com.next.dzejk.form.RegisterCandidateParty;
import com.next.dzejk.model.CandidatePartyPresident;


public interface ICandidatePartyPresidentService {
	CandidatePartyPresident saveCandidatePartyPresident(RegisterCandidateParty cpp);
	List<CandidatePartyPresident> findAllCandidates();
	void deleteCandidatePartyPresidentById(int id);
	void updateCandidatePartyPresident(RegisterCandidateParty cpp) throws Exception;
}
