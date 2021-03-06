package com.next.dzejk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.next.dzejk.form.AddParty;
import com.next.dzejk.form.SettingsForm;
import com.next.dzejk.model.PoliticalParty;
import com.next.dzejk.services.IPoliticalPartyService;

@Controller
public class PoliticalPartyController {

	@Autowired
	IPoliticalPartyService iPoliticalPartyService;

	public static final String POLITICAL_PARTY_LIST = "politicalParty";
	public static final String REDIRECT_TO_POLITICAL_PARTY_LIST = "redirect:/politicalParty";

	@RequestMapping(value = "/politicalParty", method = RequestMethod.GET)
	String partyPresident(Model model) {
		List<PoliticalParty> politicParty = iPoliticalPartyService.findAll();
		model.addAttribute("politicParty", politicParty);
		model.addAttribute("partyForm", new AddParty());
		model.addAttribute("settingsForm", new SettingsForm());
		return POLITICAL_PARTY_LIST;

	}

	@RequestMapping(value = "/politicalPartySend", method = RequestMethod.POST)
	String partyPresidsentSave(@ModelAttribute("partyForm") AddParty party) {
		iPoliticalPartyService.addPoliticalParty(party);
		return REDIRECT_TO_POLITICAL_PARTY_LIST;
	}
}
