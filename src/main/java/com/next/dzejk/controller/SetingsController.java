package com.next.dzejk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.next.dzejk.services.SetingsService;

@Controller
public class SetingsController {

	@Autowired
	SetingsService setingsService;
	
	@RequestMapping(value="/editUserInfo", method = RequestMethod.GET)
	@ResponseBody public String editUser(@RequestParam("pesel") String pesel){
		System.out.println("PESEL to: " + pesel);
		setingsService.changeUserSetings(pesel);
		
		return "done";
	}
}
