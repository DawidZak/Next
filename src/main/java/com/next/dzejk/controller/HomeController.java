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



import com.next.dzejk.model.Candidate;
import com.next.dzejk.model.User;
import com.next.dzejk.services.IUserService;
import com.next.dzejk.services.UserService;

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
	IUserService iUserRepository;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		User user = new User();

//		user.setBornDate("dsdsds");
//		user.setPESEL("123456789");
//		user.setPassword("12");
//		user.setIdR(2);
		

		System.out.println(user);
		//iUserRepository.saveUser(user);
		  
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(){
		
		return "login";
	}
	
}
