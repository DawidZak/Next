package com.next.dzejk.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.next.dzejk.model.CandidatePartyPresident;


public interface ICandidatePartyPresidentService {
	CandidatePartyPresident saveCandidatePartyPresident(CandidatePartyPresident cpp);
	List<CandidatePartyPresident> findAll();
	
}
