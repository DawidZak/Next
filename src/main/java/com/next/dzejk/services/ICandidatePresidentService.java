package com.next.dzejk.services;

import java.util.List;

import com.next.dzejk.form.RegisterCandidatePresident;
import com.next.dzejk.model.CandidatePresident;

public interface ICandidatePresidentService {

	CandidatePresident savePresidentCandidate(RegisterCandidatePresident registerCandidate); 
	List<CandidatePresident> findAll();
	
}
