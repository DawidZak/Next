package com.next.dzejk.services;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.Entity;
import javax.persistence.EntityManager;

import org.h2.engine.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.next.dzejk.dao.IPolitcalPartyRepository;
import com.next.dzejk.model.PoliticalParty;
@Service
public class PoliticalPartyService implements IPoliticalPartyService {


	@Autowired
	IPolitcalPartyRepository politicalPartyRepository;
	
	@Override
	public PoliticalParty addPoliticalParty(PoliticalParty party) {
		return 	politicalPartyRepository.save(party);
		
	}
	
	@Override
	public List<PoliticalParty> findAll() {
		return politicalPartyRepository.findAll();
	}
	
	
	@Override
	public PoliticalParty saveCandidateById(String candidate, int id) {
		
		return null;
	}
	
	@PostConstruct
	void init() {
		politicalPartyRepository.save(new PoliticalParty("Polska Silna", 43, "Right", "Andrew") );
		//Pobieram sobie po partie po ID
		PoliticalParty a = politicalPartyRepository.findOne(0);
		//Sprawdzam czy dobrze pobralem
		System.out.println(a.getPartyName());
		//Kasuje a
		//politicalPartyRepository.delete(a);
		//Ustawiam sobie kandytdata
		//a.setCandidatePresident("dasdasdasd1a");
		//Zapisuje od nowa z nowa wartoscia
		politicalPartyRepository.save(politicalPartyRepository.findOne(0));
	}

	



}	