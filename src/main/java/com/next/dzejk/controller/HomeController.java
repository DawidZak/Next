package com.next.dzejk.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.next.dzejk.dao.CandidateDao;
import com.next.dzejk.dao.ICandidateDao;
import com.next.dzejk.model.Candidate;
import com.next.dzejk.model.CandidateRepository;
import com.next.dzejk.services.ICandidateService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@Autowired
	ICandidateDao iCandidate;
	
	@Autowired
	ICandidateService iCandidateRepo;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Candidate candidate = new Candidate();
		candidate.setAge(1);
		candidate.setBornDate("dsdsds");
		candidate.setBornPlace("Lodz");
		
		candidate.setName("AAA");
		candidate.setPartyMember(false);
		candidate.setSlogan("dasdasdasda");
		candidate.setSurename("dsds");
		System.out.println(candidate);
		iCandidateRepo.saveCandidate(candidate);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
}
