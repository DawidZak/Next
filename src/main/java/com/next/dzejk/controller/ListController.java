package com.next.dzejk.controller;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.next.dzejk.dao.ICandidatePartyPresidentRepository;
import com.next.dzejk.dao.ICandidatePresidentRepository;
import com.next.dzejk.form.AddParty;
import com.next.dzejk.form.RegisterCandidateParty;
import com.next.dzejk.form.RegisterCandidatePresident;
import com.next.dzejk.form.RegisterUser;
import com.next.dzejk.model.Candidate;
import com.next.dzejk.model.CandidatePartyPresident;
import com.next.dzejk.model.CandidatePresident;
import com.next.dzejk.model.PoliticalParty;
import com.next.dzejk.services.ICandidatePartyPresidentService;
import com.next.dzejk.services.ICandidatePresidentService;
import com.next.dzejk.services.IPoliticalPartyService;

//Kontroler odpowiedzialny za wyœwietlenie listy kandydatów
@Controller
public class ListController {

		@Autowired 
		ICandidatePresidentService iCandidatePresidentService;
		
		@Autowired
		IPoliticalPartyService iPoliticalPartyService;
		
		@Autowired
		ICandidatePartyPresidentService iCandidatePartyPresident;
		

		
		public static final String POLITICAL_PARTY_LIST = "politicalParty";
		public static final String POLITICAL_PARTY_CANDIDATES_PRESIDENT = "politicalPartyCandidatesPresidents";	
			
		@RequestMapping(value="/listCandidatePresident", method = RequestMethod.GET)
			//Nazwa metody PO RM nie ma wp³ywu na mapowanie
			public String list(Model model){
				List<CandidatePresident> candidates = iCandidatePresidentService.findAll();
				List<PoliticalParty> politicalParty = iPoliticalPartyService.findAll();  
				model.addAttribute("registerCandidate", new RegisterCandidatePresident());
				model.addAttribute("politicalPartys", politicalParty);
				model.addAttribute("candidates", candidates);
				return "listCandidatePresident";
				
			}
			
			@RequestMapping(value="/sendCandidateData", method=RequestMethod.POST)
			 String savePresidentCanidate(@Valid @ModelAttribute("registerCandidate") RegisterCandidatePresident registerCandidate,BindingResult result, Model model){
				System.out.println(registerCandidate.getFirstName());
				System.out.println(registerCandidate.getAge());
				if (!result.hasErrors()){
					iCandidatePresidentService.savePresidentCandidate(registerCandidate);	
				}else
				{	
					result.addError(new FieldError("registerCandidate", "degree", "defaultMessage"));
				}
				
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
			@RequestMapping(value="/politicalParty", method=RequestMethod.GET)
			String partyPresident(Model model ){
				List<PoliticalParty> politicParty = iPoliticalPartyService.findAll();
				model.addAttribute("politicParty", politicParty);
				//iPoliticalPartyService.saveCandidateById("sadas", 0);
				model.addAttribute("partyForm", new AddParty());
				return POLITICAL_PARTY_LIST;

				
			}
			@RequestMapping(value="/politicalPartySend", method=RequestMethod.POST)
			String partyPresidsent(@Valid @ModelAttribute("partyForm") AddParty party, Model model, BindingResult result  ){
				//List<PoliticalParty> politicParty = iPoliticalPartyService.findAll();
				System.out.println(result.getErrorCount());
				if(result.hasErrors()){
				//Obsluga
				}else {
				iPoliticalPartyService.addPoliticalParty(party);	
				}
				return "redirect:/politicalParty";
			}
			
			@RequestMapping(value="/politicalPartyCandidatesPresident", method=RequestMethod.GET)
			String partyCandidates(Model model){
				List<CandidatePartyPresident>  candidatePartyPresident = iCandidatePartyPresident.findAllCandidates();
				model.addAttribute("candidatePartyPresident",candidatePartyPresident );
				List<PoliticalParty> politicalParty = iPoliticalPartyService.findAll();  
				model.addAttribute("politicalPartyCandidateParty", new RegisterCandidateParty());
				model.addAttribute("politicalPartys", politicalParty);
				return POLITICAL_PARTY_CANDIDATES_PRESIDENT;
			}
			
			@RequestMapping(value="/politicalPartyCandidatesPresidentSend", method=RequestMethod.POST)
			String savePartyCandidates(@Valid @ModelAttribute("politicalPartyCandidateParty")RegisterCandidateParty candidate,BindingResult result, Model model){
				if(!result.hasErrors()){
				iCandidatePartyPresident.saveCandidatePartyPresident(candidate);
				}
				else{
					//obsluga;
				}
				return "redirect:/" + "politicalPartyCandidatesPresident";
			}
}

//TODO
//http://www.tutorialspoint.com/spring/spring_mvc_form_handling_example.htm