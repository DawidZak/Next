package com.next.dzejk;


import java.util.ArrayList;
import java.util.List;

import com.next.dzejk.model.Candidate;
import com.next.dzejk.services.ICandidateService;

public class CandidateManager implements ICandidateService {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	List<Candidate> list = new ArrayList<Candidate>();
	
	@Override
	public List<Candidate> saveCandidate(Candidate candidate) {
		
		list.add(candidate);
		return null;
	}

	@Override
	public List<Candidate> deleteCandidate(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Candidate> getCandidate(int id) {
	
		for(Candidate candidate : list) {
		    System.out.println("Zaczynam" + candidate);
		}
		return null;
	}

	
}
