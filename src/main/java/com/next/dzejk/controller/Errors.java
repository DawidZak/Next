package com.next.dzejk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Errors {

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String error() {

		return "403";
	}
}
