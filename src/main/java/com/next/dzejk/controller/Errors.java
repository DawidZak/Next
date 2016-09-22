package com.next.dzejk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Errors {

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public final String error() {

		return "403";
	}
	
	@RequestMapping(value="/errorLogin", method = RequestMethod.GET)
	public final String loginError(RedirectAttributes redirectAttributes){
		redirectAttributes.addAttribute("error", "SprawdŸ poprawnoœæ danych do logowania");
        return "redirect:/login";
		
	}
}
