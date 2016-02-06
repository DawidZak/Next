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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.next.dzejk.model.CandidatePresident;
import com.next.dzejk.services.ICandidatePresidentService;

@Controller
public class ApiController {

	@Autowired 
	ICandidatePresidentService iCandidatePresidentService;
	
	
		@RequestMapping(value="/PresidentCandidateAPI",  method=RequestMethod.GET)
		@ResponseBody String apiForDevelopers(Model model) throws JsonGenerationException, JsonMappingException, IOException{
		
		List<CandidatePresident> candidates  = iCandidatePresidentService.findAll();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(candidates);
		model.addAttribute("json", json);
		return json;
		
		
	}
}
