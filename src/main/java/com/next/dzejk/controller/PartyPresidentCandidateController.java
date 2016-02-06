package com.next.dzejk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.next.dzejk.form.RegisterCandidateParty;
import com.next.dzejk.model.CandidatePartyPresident;
import com.next.dzejk.model.PoliticalParty;
import com.next.dzejk.services.ICandidatePartyPresidentService;
import com.next.dzejk.services.IPoliticalPartyService;

@Controller
public class PartyPresidentCandidateController {

	@Autowired
	ICandidatePartyPresidentService iCandidatePartyPresident;
	
	@Autowired
	IPoliticalPartyService iPoliticalPartyService;
	
	public static final String POLITICAL_PARTY_CANDIDATES_PRESIDENT = "politicalPartyCandidatesPresidents";	
	public static final String REDIRECT_TO_POLITICAL_PARTY_CANDIDATES_PRESIDENT ="redirect:/politicalPartyCandidatesPresident" ;
	
	@RequestMapping(value="/politicalPartyCandidatesPresident", method=RequestMethod.GET)
	String partyCandidates(Model model){
		List<CandidatePartyPresident>  candidatePartyPresident = iCandidatePartyPresident.findAllCandidates();
		model.addAttribute("candidatePartyPresident",candidatePartyPresident );
		List<PoliticalParty> politicalParty = iPoliticalPartyService.findAll();  
		model.addAttribute("politicalPartyCandidateParty", new RegisterCandidateParty());
		model.addAttribute("politicalPartyCandidatePartyDelete", new RegisterCandidateParty());
		model.addAttribute("politicalPartys", politicalParty);
		return POLITICAL_PARTY_CANDIDATES_PRESIDENT;
	}
	
	@RequestMapping(value="/politicalPartyCandidatesPresidentSend", method=RequestMethod.POST)
	String savePartyCandidates(@Valid @ModelAttribute("politicalPartyCandidateParty")RegisterCandidateParty candidate,BindingResult result, Model model){
		if(!result.hasErrors()){
		iCandidatePartyPresident.saveCandidatePartyPresident(candidate);
		}
		else{
			//obsluga;
		}
		return REDIRECT_TO_POLITICAL_PARTY_CANDIDATES_PRESIDENT;
	}
	
	@RequestMapping(value="/politicalPartyCandidatePresidentDelete", method=RequestMethod.POST)
	String deletePartyCandidate(@ModelAttribute("politicalPartyCandidatePartyDelete")RegisterCandidateParty candidate, Model model){
		
		System.out.println(candidate.getID());
		
		//iCandidatePartyPresident.updateCandidatePartyPresidentById(candidate.getID());
		iCandidatePartyPresident.deleteCandidatePartyPresidentById(candidate.getID());
		return REDIRECT_TO_POLITICAL_PARTY_CANDIDATES_PRESIDENT;

		
		
	}
}
