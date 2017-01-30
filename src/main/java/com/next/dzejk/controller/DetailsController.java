package com.next.dzejk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.next.dzejk.form.SettingsForm;

@Controller
@RequestMapping("/candidate/details/")
public class DetailsController {

	private static final Logger logger = LoggerFactory.getLogger(DetailsController.class);

	@RequestMapping(value = "/{Id}", method = RequestMethod.GET)
	public String getDetails(@PathVariable int Id, Model model) {

		model.addAttribute("settingsForm", new SettingsForm());
		logger.info("Id " + Id);
		return "candidateDetails";

	}
}