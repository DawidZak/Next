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
import org.springframework.web.bind.annotation.RestController;

import com.next.dzejk.model.CandidatePresident;
import com.next.dzejk.services.ICandidatePresidentService;

@RestController
@RequestMapping("/api/")
public class ApiController {

	@Autowired
	ICandidatePresidentService iCandidatePresidentService;

	@RequestMapping(value = "/PresidentCandidate", method = RequestMethod.GET)
	List<CandidatePresident> apiForDevelopers(Model model)
			throws JsonGenerationException, JsonMappingException, IOException {
		List<CandidatePresident> candidates = iCandidatePresidentService.findAll();
		return candidates;

	}
}
