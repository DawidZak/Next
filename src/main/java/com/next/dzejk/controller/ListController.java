package com.next.dzejk.controller;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.next.dzejk.dao.ICandidatePresidentRepository;
import com.next.dzejk.form.RegisterCandidate;
import com.next.dzejk.form.RegisterUser;
import com.next.dzejk.model.Candidate;
import com.next.dzejk.model.CandidatePresident;
import com.next.dzejk.services.ICandidatePresidentService;

//Kontroler odpowiedzialny za wyœwietlenie listy kandydatów
@Controller
public class ListController {

		@Autowired 
		ICandidatePresidentService iCandidatePresidentService;	
			
			@RequestMapping(value="/listCandidatePresident", method = RequestMethod.GET)
			//Nazwa metody PO RM nie ma wp³ywu na mapowanie
			public String list(Model model){
				List<CandidatePresident> candidates = iCandidatePresidentService.findAll();
				model.addAttribute("registerCandidate", new RegisterCandidate());
				model.addAttribute("candidates", candidates);
				return "listCandidatePresident";
				
			}
			
			@RequestMapping(value="/sendCandidateData", method=RequestMethod.POST)
			 String savePresidentCanidate(@ModelAttribute("registerCandidate") RegisterCandidate registerCandidate,BindingResult result, Model model){
				System.out.println(registerCandidate.getFirstName());
				
				iCandidatePresidentService.savePresidentCandidate(registerCandidate);
				return "redirect:/listCandidatePresident";

			}
			@RequestMapping(value="/PresidentCandidateAPI",  method=RequestMethod.GET)
			@ResponseBody String apiForDevelopers(Model model) throws JsonGenerationException, JsonMappingException, IOException{
				
				List<CandidatePresident> candidates  = iCandidatePresidentService.findAll();
				ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(candidates);
				model.addAttribute("json", json);
				return json;
				
				
			}
}

//TODO
//http://www.tutorialspoint.com/spring/spring_mvc_form_handling_example.htm