package com.next.dzejk;


import java.util.ArrayList;
import java.util.List;

import com.next.dzejk.model.CandidateModel;
import com.next.dzejk.services.CandidateMethods;

public class CandidateManager implements CandidateMethods {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	List<CandidateModel> list = new ArrayList<CandidateModel>();
	
	@Override
	public List<CandidateModel> saveCandidate(CandidateModel candidate) {
		
		list.add(candidate);
		return null;
	}

	@Override
	public List<CandidateModel> deleteCandidate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CandidateModel> getCandidate() {
	
		for(CandidateModel candidate : list) {
		    System.out.println("Zaczynam" + candidate);
		}
		return null;
	}

	
}
