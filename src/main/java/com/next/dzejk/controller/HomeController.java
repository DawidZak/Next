package com.next.dzejk.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.h2.engine.SysProperties;
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
import com.next.dzejk.model.PoliticalParty;
import com.next.dzejk.model.User;
import com.next.dzejk.services.ICandidatePartyPresidentService;
import com.next.dzejk.services.IUserService;

/**
 * Handles requests for the application home page.
 */
@Controller 
@Scope("request")

public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	IUserService iUserRepository;
	
	@Autowired
	IPolitcalPartyRepository politicalPartyRepository;
	
	@Autowired
	ICandidatePartyPresidentService icpp;
	
	@Autowired
	User user;
	int i=0;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession session) {
		//System.out.println("Widzisz?" +session.getId());
		
		user.setCity("scope?");
		logger.info("No czeœæ","g");
		System.out.println(user.getCity());
		logger.info("Welcome home! The client locale is {}.", locale);
		if (i==0){
		//politicalPartyRepository.save(new PoliticalParty(0,"Polska Silna", 43, "Right", "Andrew") );	
		iUserRepository.saveInitUser(new User("Imie1", "Nazwisko1","1332","1233","wp.pl","Lodz",4));
		i++;
		}
		logger.info("USER" , user.getCity());
		User user = new User();
		
		logger.info("Uzytkownik"+ user);		  
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		System.out.println("PESEL Z INNEJ SESJI" +session.getAttribute("pesel"));
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	@RequestMapping(value ="/authSuccesful", method = RequestMethod.GET)
	public String authSuccesful(HttpSession session){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		System.out.println("kurwa" + authentication.getName()); 
		session.setAttribute("pesel", authentication.getName());
		return "redirect:/";
	}
	
}
