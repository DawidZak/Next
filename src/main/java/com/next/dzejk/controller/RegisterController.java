package com.next.dzejk.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.next.dzejk.dao.IRegionRepository;
import com.next.dzejk.form.RegisterUser;
import com.next.dzejk.model.Region;
import com.next.dzejk.services.IUserService;

@Controller
public class RegisterController { // extends CandidateManager
	
	@Autowired
	IRegionRepository regionName;

	//@Autowired
	//private ICandidateService iCandidate; // private CandidateService bylo

	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String addCandidate(Model model) {
		List<Region> regions = regionName.findAll();

		model.addAttribute("registerUser",new RegisterUser()); //ta wartosc jest do view i nizej
		model.addAttribute("regions", regions);
		
		logger.info("Dzia³am1");

		return "register";
	}
	@Autowired
	IUserService iUserRepository;
	
	@RequestMapping(value = "/addSubmit", method = RequestMethod.POST)
		public @ResponseBody  List<String> saveUser(@Valid @ModelAttribute("registerUser")   RegisterUser registerUser,BindingResult result, Model model){
			List<String> errors = new ArrayList<String>();
			if (!result.hasErrors()){	
				iUserRepository.saveUser(registerUser);
				errors.add("SUCCESS");
				return errors;
			}else{
				List<FieldError> lista;// =  new ArrayList<FieldError>();
				lista = result.getFieldErrors();
				for (FieldError error : lista) {
					System.out.println(error);
					errors.add(error.getField());
					logger.info("Blad" + error.getField());
				}
				return errors;
			} //end else

	} //end saveUser

} //end class



