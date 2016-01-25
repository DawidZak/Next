package com.next.dzejk.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.next.dzejk.dao.ICandidatePresidentRepository;
import com.next.dzejk.form.RegisterCandidatePresident;
import com.next.dzejk.model.CandidatePresident;

@Service
public class CandidatePresidentService implements ICandidatePresidentService {

	@Autowired
	ICandidatePresidentRepository iCandiatePresitentRepository;
	
	
	@Override
	public CandidatePresident savePresidentCandidate(RegisterCandidatePresident registerCandidate) {
		CandidatePresident candidatePresident = new CandidatePresident() ;
		candidatePresident.setFirstName(registerCandidate.getFirstName());
		candidatePresident.setLastName(registerCandidate.getLastName());
		candidatePresident.setAge(registerCandidate.getAge());
		candidatePresident.setDegree(registerCandidate.getDegree());
		candidatePresident.setPartyMember(registerCandidate.getPartyName() );
		
		
		return iCandiatePresitentRepository.save(candidatePresident);
	}

	@Override
	public List<CandidatePresident> findAll() {
		
		return iCandiatePresitentRepository.findAll();
	}
	
	@PostConstruct
	void init(){
	//savePresidentCandidate(new RegisterCandidate());
	}
}
