package com.next.dzejk.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.next.dzejk.dao.ICandidatePartyPresidentRepository;
@Service
public class CandidatePartyPresident implements ICandidatePartyPresidentService {

	@Autowired
	ICandidatePartyPresidentRepository iCandidatePartyPresident;

	@Override
	public com.next.dzejk.model.CandidatePartyPresident saveCandidatePartyPresident(
			com.next.dzejk.model.CandidatePartyPresident cpp) {
		return iCandidatePartyPresident.save(cpp);
		 
	}

	@Override
	public List<com.next.dzejk.model.CandidatePartyPresident> findAll() {
		return iCandidatePartyPresident.findAll();
	}
	


}
