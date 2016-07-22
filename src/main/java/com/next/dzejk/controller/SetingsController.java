package com.next.dzejk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.next.dzejk.model.User;
import com.next.dzejk.services.SetingsService;

@Controller
public class SetingsController {

	@Autowired
	SetingsService setingsService;
	
	@RequestMapping(value="/editUserInfo", method = RequestMethod.GET)
	@ResponseBody public User editUser(@RequestParam("pesel") String pesel, Model model){
		System.out.println("PESEL to: " + pesel);
		User user = setingsService.changeUserSetings(pesel);
		user.setPassword(null);
		model.addAttribute("user", user);
		
		return user;
	}
}
