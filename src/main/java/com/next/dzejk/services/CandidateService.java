package com.next.dzejk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.next.dzejk.model.Candidate;
import com.next.dzejk.model.CandidateRepository;
@Service

public class CandidateService implements ICandidateService {
	
	
	@Autowired
	CandidateRepository candidateRepository;

	@Override
	public Candidate saveCandidate(Candidate candidate) {
		return candidateRepository.save(candidate);
		 
	}





}
