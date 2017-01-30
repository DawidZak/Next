package com.next.dzejk.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.next.dzejk.form.RegisterCandidatePresident;
import com.next.dzejk.form.SettingsForm;
import com.next.dzejk.model.CandidatePresident;
import com.next.dzejk.model.PoliticalParty;
import com.next.dzejk.services.ICandidatePartyPresidentService;
import com.next.dzejk.services.ICandidatePresidentService;
import com.next.dzejk.services.IPoliticalPartyService;

@Controller
@RequestMapping(value = "/candidate/")
public class CandidatePresidentController {

	private static final Logger logger = LoggerFactory.getLogger(CandidatePresidentController.class);

	private static final String NAZWA_RETURNA = "";

	public static final String POLITICAL_PARTY_LIST = "politicalParty";

	@Autowired
	ICandidatePresidentService iCandidatePresidentService;

	@Autowired
	ICandidatePartyPresidentService iCandidatePartyPresident;

	@Autowired
	IPoliticalPartyService iPoliticalPartyService;

	@RequestMapping(value = "/listPresident", method = RequestMethod.GET)
	public final String list(Model model) {
		List<CandidatePresident> candidates = iCandidatePresidentService.findAll();
		List<PoliticalParty> politicalParty = iPoliticalPartyService.findAll();
		model.addAttribute("registerCandidate", new RegisterCandidatePresident());
		model.addAttribute("politicalPartys", politicalParty);
		model.addAttribute("candidates", candidates);
		model.addAttribute("settingsForm", new SettingsForm());

		return "listCandidatePresident";

	}

	@RequestMapping(value = "/sendCandidateData", method = RequestMethod.POST)
	String savePresidentCanidate(
			@Valid @ModelAttribute("registerCandidate") RegisterCandidatePresident registerCandidate,
			BindingResult result, Model model) {
		logger.info("Wiek:" + registerCandidate.getAge());
		logger.info(registerCandidate.getFirstName());
		if (result.hasErrors()) {
			result.addError(new FieldError("registerCandidate", "degree", "defaultMessage"));
		}

		iCandidatePresidentService.savePresidentCandidate(registerCandidate);

		return "redirect:/candidate/listPresident";

	}

}
