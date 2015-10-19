package com.next.dzejk.services;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
@Service
@Repository
public class CandidateService implements ICandidateService {
	
	@Override
	public List<com.next.dzejk.model.Candidate> saveCandidate(com.next.dzejk.model.Candidate candidate) {
		// TODO Auto-generated method stub
		
		System.out.println("Serwis dzial;");
		return null;
	}

	@Override
	public List<com.next.dzejk.model.Candidate> deleteCandidate(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<com.next.dzejk.model.Candidate> getCandidate(int id) {
		// TODO Auto-generated method stub
		return null;
	}



}
