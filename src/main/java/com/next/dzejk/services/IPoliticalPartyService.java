package com.next.dzejk.services;

import java.util.List;

import com.next.dzejk.form.AddParty;
import com.next.dzejk.model.PoliticalParty;

public interface IPoliticalPartyService {

	PoliticalParty addPoliticalParty(AddParty party);
	List<PoliticalParty>  findAll();
	PoliticalParty saveCandidateById (String candidate, int id);
}
