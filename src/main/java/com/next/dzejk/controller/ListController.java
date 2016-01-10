package com.next.dzejk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.next.dzejk.model.Candidate;

//Kontroler odpowiedzialny za wyœwietlenie listy kandydatów
@Controller
public class ListController {

			@RequestMapping(value="/listCandidatePresident", method = RequestMethod.GET)
			//Nazwa metody PO RM nie ma wp³ywu na mapowanie
			public ModelAndView list(){
				
				Candidate Candidate = new Candidate();
				ModelAndView model = new ModelAndView("listCandidatePresident");
				
;
				Candidate.setPartyMember(true);
				Candidate.setSlogan("Twoja Polska, moje hajsy!");

				model.addObject("Candidate", Candidate);
				System.out.print(Candidate);
				
				return model;
				
			}
}

//TODO
//http://www.tutorialspoint.com/spring/spring_mvc_form_handling_example.htm