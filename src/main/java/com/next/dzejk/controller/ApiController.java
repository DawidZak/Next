package com.next.dzejk.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.next.dzejk.model.CandidatePresident;
import com.next.dzejk.services.ICandidatePresidentService;

/**
 * @author Dawid
 * Rest contoller which contains mapping to /api/ 
 */

@RestController
@RequestMapping("/api/")
public class ApiController {

	@Autowired
	ICandidatePresidentService iCandidatePresidentService;

	@RequestMapping(value = "/PresidentCandidate", method = RequestMethod.GET)
	List<CandidatePresident> apiForDevelopers(Model model)
			throws  IOException {
		
		return iCandidatePresidentService.findAll();

	}
}
