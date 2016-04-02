package com.next.dzejk.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.next.dzejk.form.RegisterCandidatePresident;
import com.next.dzejk.model.CandidatePresident;
import com.next.dzejk.model.PoliticalParty;
import com.next.dzejk.services.ICandidatePartyPresidentService;
import com.next.dzejk.services.ICandidatePresidentService;
import com.next.dzejk.services.IPoliticalPartyService;

//Kontroler odpowiedzialny za wyœwietlenie listy kandydatów
@Controller
public class CandidatePresidentController {
	
	private static final String NAZWA_RETURNA = "";

	@Autowired
	ICandidatePresidentService iCandidatePresidentService;

	@Autowired
	ICandidatePartyPresidentService iCandidatePartyPresident;

	@Autowired
	IPoliticalPartyService iPoliticalPartyService;

	public static final String POLITICAL_PARTY_LIST = "politicalParty";

	@RequestMapping(value = "/listCandidatePresident", method = RequestMethod.GET)
	// Nazwa metody PO RM nie ma wp³ywu na mapowanie
	public String list(Model model) {
		List<CandidatePresident> candidates = iCandidatePresidentService.findAll();
		List<PoliticalParty> politicalParty = iPoliticalPartyService.findAll();
		model.addAttribute("registerCandidate", new RegisterCandidatePresident());
		model.addAttribute("politicalPartys", politicalParty);
		model.addAttribute("candidates", candidates);
		return "listCandidatePresident";

	}

	@RequestMapping(value = "/sendCandidateData", method = RequestMethod.POST)
	String savePresidentCanidate(
			@Valid @ModelAttribute("registerCandidate") RegisterCandidatePresident registerCandidate,
			BindingResult result, Model model) {
		System.out.println(registerCandidate.getFirstName());
		System.out.println(registerCandidate.getAge());

		
		if (result.hasErrors()) {
			result.addError(new FieldError("registerCandidate", "degree", "defaultMessage"));
		}
		
		iCandidatePresidentService.savePresidentCandidate(registerCandidate);

		return "redirect:/listCandidatePresident";

	}

}

// TODO:
// http://www.tutorialspoint.com/spring/spring_mvc_form_handling_example.htm