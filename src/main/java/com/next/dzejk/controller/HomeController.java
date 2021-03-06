package com.next.dzejk.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.next.dzejk.dao.IPolitcalPartyRepository;
import com.next.dzejk.form.SettingsForm;
import com.next.dzejk.model.User;
import com.next.dzejk.services.ICandidatePartyPresidentService;
import com.next.dzejk.services.IUserService;

/**
 * Handles requests for the application home page.
 */
@Controller
// @Scope("request")
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	User user = new User();
	@Autowired
	IUserService iUserService;

	// Change to service, not repository
	@Autowired
	IPolitcalPartyRepository politicalPartyRepository;

	@Autowired
	ICandidatePartyPresidentService icpp;

//	@Autowired
	//User user;
//	int i = 0;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		iUserService.saveInitUser(new User("Imie1", "Nazwisko1", "1332", "1233", "wp.pl", "Lodz", 4));

		logger.info("User City", user.getCity());
		User user = new User();

		logger.info("User " + user);
		/*
		 * Without line below settings don't work beacouse don't know what is
		 * th:object ="${settingsForm}"
		 */
		model.addAttribute("settingsForm", new SettingsForm());

		return "home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/authSuccesful", method = RequestMethod.GET)
	public String authSuccesful(HttpSession session, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		session.setAttribute("pesel", authentication.getName());

		return "redirect:/";
	}

}
