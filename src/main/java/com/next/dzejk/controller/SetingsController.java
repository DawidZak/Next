package com.next.dzejk.controller;

import javax.servlet.http.HttpSession;

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
	@ResponseBody public User editUser(@RequestParam("pesel") String pesel, Model model, HttpSession session){
		/*
		 * Rozwi¹zanie, ¿e pobieram pesel ze strony jest zle
		 *  - ktos moze po prostu wporwadzic inna wartosc tam (zbadaj element etc)
		 *  zostawiam to rozwi¹zanie bo mi siê mo¿e kiedyœ przydac
		 *  bêde z peselu korzysta³ pobierajac go z session.getAttributes("pesel")
		*/
		System.out.println("PESEL to: " + pesel);
		User user = setingsService.changeUserSetings(pesel);
		user.setPassword(null);
		session.setAttribute("pesel", pesel);
		System.out.println("PESEL z sesji" + session.getAttribute("pesel"));
		model.addAttribute("user", user);
		
		return user;
	}
	@RequestMapping(value="/editUserInfo", method = RequestMethod.POST)
	public void saveChanges(@RequestParam("pesel") String pesel ,Model model){
		
		
	}
}
