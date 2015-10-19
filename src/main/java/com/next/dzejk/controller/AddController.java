package com.next.dzejk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.next.dzejk.CandidateManager;
import com.next.dzejk.model.Candidate;
import com.next.dzejk.services.ICandidateService;
import com.next.dzejk.services.CandidateService;

@Controller
public class AddController extends CandidateManager {
			
			@Autowired
			private ICandidateService iCandidate; //private CandidateService bylo
			
			@RequestMapping(value="/add", method = RequestMethod.GET)
			public ModelAndView AddCandidate(){
			
			ModelAndView model = new ModelAndView("add");
			System.out.print("Dzia³am1");
			return model;
			}
			
			@RequestMapping(value="/addSubmit", method=RequestMethod.POST)
			public ModelAndView submitForm(@ModelAttribute("candidate") Candidate candidate){
			
				System.out.print(candidate);
				
				ModelAndView model = new ModelAndView("addSubmit");
				//iCandidate.saveCandidate(candidate);	
				model.addObject("candidate", candidate);
				
				return model;
					
			}
}

//https://www.youtube.com/watch?v=8V4ArtwNuwk
