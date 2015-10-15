package com.next.dzejk.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.next.dzejk.dao.ICandidateDao;
import com.next.dzejk.model.Candidate;

@Service
public class CandidateManager9 implements ICandidateManager9 {

	@Autowired
	private ICandidateDao iCandidateDao;
	@Override
	public void addCandidate(Candidate candidate) {
		// TODO Auto-generated method stub
		
	}

}
