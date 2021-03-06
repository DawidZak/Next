package com.next.dzejk.services;

import java.util.List;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.next.dzejk.dao.IPolitcalPartyRepository;
import com.next.dzejk.form.AddParty;
import com.next.dzejk.model.PoliticalParty;
import com.next.dzejk.model.User;

@Service
public class PoliticalPartyService implements IPoliticalPartyService {

	@Autowired
	IPolitcalPartyRepository politicalPartyRepository;

	@Override
	public PoliticalParty addPoliticalParty(AddParty partyForm) {
		User user = new User();
		user.setFirstName(partyForm.getPartyPresidentFirstName());
		user.setLastName(partyForm.getPartyPresidentLastName());
		PoliticalParty party = new PoliticalParty();
		party.setKind(partyForm.getWing());
		party.setPartyName(partyForm.getPartyName());
		party.setUserPartyPresident(user);// (partyForm.getPartyPresident());
		party.setCountMembers(partyForm.getCountMembers());
		return politicalPartyRepository.save(party);

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
		User user = new User();
		user.setFirstName("Karol");
		user.setLastName("Kordecki");
		politicalPartyRepository.save(new PoliticalParty(1, "Polska Silna", 43, "Right", user));
		user.setFirstName("Dominik");
		user.setLastName("Michalski");
		politicalPartyRepository.save(new PoliticalParty(2, "Nowoczesna Polska", 143, "Left", user));

	}

}