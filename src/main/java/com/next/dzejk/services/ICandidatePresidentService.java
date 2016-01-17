package com.next.dzejk.services;

import java.util.List;

import com.next.dzejk.form.RegisterCandidate;
import com.next.dzejk.model.CandidatePresident;

public interface ICandidatePresidentService {

	CandidatePresident savePresidentCandidate(RegisterCandidate registerCandidate); 
	List<CandidatePresident> findAll();
	
}
