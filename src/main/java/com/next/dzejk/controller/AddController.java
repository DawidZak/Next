package com.next.dzejk.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.next.dzejk.dao.IRegionRepository;
import com.next.dzejk.form.RegisterUser;
//import com.next.dzejk.CandidateManager;
import com.next.dzejk.model.Candidate;
import com.next.dzejk.model.Region;
import com.next.dzejk.model.User;
import com.next.dzejk.services.ICandidateService;
import com.next.dzejk.services.IUserService;
import com.next.dzejk.services.CandidateService;

@Controller
public class AddController { // extends CandidateManager
	
	@Autowired
	IRegionRepository regionName;

	@Autowired
	private ICandidateService iCandidate; // private CandidateService bylo

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String AddCandidate(Model model) {
		List<Region> regions = regionName.findAll();

		model.addAttribute("registerUser",new RegisterUser()); //ta wartosc jest do view i nizej
		model.addAttribute("regions", regions);
		
		System.out.print("Dzia³am1");

		return "register";
	}
	@Autowired
	IUserService iUserRepository;
	
	@RequestMapping(value = "/addSubmit", method = RequestMethod.POST)
	//public String submitForm(@ModelAttribute("registerUser") RegisterUser registerUser, BindingResult result, Model model ) {
		public @ResponseBody  String saveUser(@Valid @ModelAttribute("registerUser")   RegisterUser registerUser,BindingResult result, HttpServletRequest request,  Model model){
			System.out.println(result);
			if (!result.hasErrors()){
				//ValidationUtils.
				User user = new User();
				user.setFirstName(registerUser.getFirstName());
				user.setLastName(registerUser.getLastName());
				user.setCity(registerUser.getCity());
				user.setPassword(registerUser.getPassword());
				user.setIdD(registerUser.getIdD());
				user.setEmail(registerUser.getEmail());
				user.setPESEL(registerUser.getPESEL());
				user.setIdR(1);
				iUserRepository.saveUser(user);
	
			}
			//ValidationUtils.
		    System.out.println(registerUser.getIdD());
		    System.out.println(registerUser.getCity());
			User user = new User();
			user.setFirstName(registerUser.getFirstName());
			user.setLastName(registerUser.getLastName());
			user.setCity(registerUser.getCity());
			System.out.println("Cos powinno byc " + registerUser);
			//System.out.println(user);
			user.setPassword(registerUser.getPassword());
			user.setIdD(registerUser.getIdR());
			user.setEmail(registerUser.getEmail());
			user.setPESEL(registerUser.getPESEL());
			user.setIdR(1);
			//System.out.print(result.hasErrors());
			iUserRepository.saveUser(user);
		 
		 return "/list";
}


	}


// https://www.youtube.com/watch?v=8V4ArtwNuwk
