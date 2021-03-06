package com.next.dzejk.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.next.dzejk.form.RegisterCandidateParty;
import com.next.dzejk.form.SettingsForm;
import com.next.dzejk.model.CandidatePartyPresident;
import com.next.dzejk.model.PoliticalParty;
import com.next.dzejk.services.ICandidatePartyPresidentService;
import com.next.dzejk.services.IPoliticalPartyService;

@Controller
@RequestMapping(value = "/candidate/")
public class PartyPresidentCandidateController {

	@Autowired
	ICandidatePartyPresidentService iCandidatePartyPresident;

	@Autowired
	IPoliticalPartyService iPoliticalPartyService;
	private static final Logger logger = LoggerFactory.getLogger(PartyPresidentCandidateController.class);
	public static final String POLITICAL_PARTY_CANDIDATES_PRESIDENT = "politicalPartyCandidatesPresidents";
	public static final String REDIRECT_TO_POLITICAL_PARTY_CANDIDATES_PRESIDENT = "redirect:/candidate/politicalPartyPresident";

	@RequestMapping(value = "/politicalPartyPresident", method = RequestMethod.GET)
	String partyCandidates(Model model) {
		List<CandidatePartyPresident> candidatePartyPresident = iCandidatePartyPresident.findAllCandidates();
		model.addAttribute("candidatePartyPresident", candidatePartyPresident);
		List<PoliticalParty> politicalParty = iPoliticalPartyService.findAll();
		model.addAttribute("politicalPartyCandidateParty", new RegisterCandidateParty());
		model.addAttribute("politicalPartyCandidatePartyDelete", new RegisterCandidateParty());
		model.addAttribute("politicalPartys", politicalParty);
		model.addAttribute("settingsForm", new SettingsForm());

		return POLITICAL_PARTY_CANDIDATES_PRESIDENT;
	}

	@RequestMapping(value = "/politicalPartyCandidatesPresidentSend", method = RequestMethod.POST)
	String savePartyCandidates(@Valid @ModelAttribute("politicalPartyCandidateParty") RegisterCandidateParty candidate,
			BindingResult result, Model model) {
		// Extracted method
		registerCandidateHasErrors(candidate, result);
		return REDIRECT_TO_POLITICAL_PARTY_CANDIDATES_PRESIDENT;
	}

	@RequestMapping(value = "/politicalPartyCandidatePresidentDelete", method = RequestMethod.POST)
	String deletePartyCandidate(@ModelAttribute("politicalPartyCandidatePartyDelete") RegisterCandidateParty candidate,
			Model model) {
		// Extracted method
		updateCandidatePartyPresident(candidate);
		return REDIRECT_TO_POLITICAL_PARTY_CANDIDATES_PRESIDENT;

	}

	@RequestMapping(value = "/politicalPartyCandidatesPresidentEdit", method = RequestMethod.POST)
	String editPartyCandidate(@ModelAttribute("politicalPartyCandidatePartyEdit") RegisterCandidateParty candidate,
			Model model) throws Exception {
		iCandidatePartyPresident.updateCandidatePartyPresident(candidate);
		return REDIRECT_TO_POLITICAL_PARTY_CANDIDATES_PRESIDENT;

	}

	private void registerCandidateHasErrors(RegisterCandidateParty candidate, BindingResult result) {
		if (!result.hasErrors()) {
			iCandidatePartyPresident.saveCandidatePartyPresident(candidate);
		} else {
			logger.error("ERROR");
		}
	}

	private void updateCandidatePartyPresident(RegisterCandidateParty candidate) {
		try {
			iCandidatePartyPresident.updateCandidatePartyPresident(candidate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Why delete?!
		iCandidatePartyPresident.deleteCandidatePartyPresidentById(candidate.getID());
	}
}
