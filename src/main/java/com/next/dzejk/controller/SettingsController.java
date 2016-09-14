package com.next.dzejk.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.next.dzejk.form.SettingsForm;
import com.next.dzejk.model.User;
import com.next.dzejk.services.ISettingsService;
import com.next.dzejk.services.SettingsService;

@Controller
public class SettingsController {

	@Autowired
	//ISettingsService settingsService;
	SettingsService settingsService;
	
	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	User user = new User();
	boolean isValid = false; 
	@RequestMapping(value="/editUserInfo", method = RequestMethod.GET)
	@ResponseBody public User editUser(Model model, HttpSession session){
		/*
		 * Rozwi¹zanie, ¿e pobieram pesel ze strony jest zle
		 *  - ktos moze po prostu wporwadzic inna wartosc tam (zbadaj element etc)
		 *  zostawiam to rozwi¹zanie bo mi siê mo¿e kiedyœ przydac
		 *  bêde z peselu korzysta³ pobierajac go z session.getAttributes("pesel")
		 *  Wykasowa³em z editUser @RequestParam("pesel") String pesel,
		*/
		
		String pesel = session.getAttribute("pesel").toString();
		System.out.println("PESEL to: " + pesel);
		User user = settingsService.changeUserSetings(pesel);
		user.setPassword(null);
		session.setAttribute("user", settingsService.changeUserSetings(pesel));

		System.out.println("PESEL z sesji" + session.getAttribute("pesel"));
		model.addAttribute("user", user);
		model.addAttribute("settingsForm", new SettingsForm());
		return user;
	}
	@RequestMapping(value="/editUserInfoEmail", method = RequestMethod.POST)
	public @ResponseBody String saveChanges(@ModelAttribute("settingsForm") SettingsForm settingsForm,BindingResult bindingResult,HttpSession session, Model model){
		user = (User) session.getAttribute("user");
		isValid = passwordEncoder.matches(settingsForm.getOldPassword(), user.getPassword()); 
		System.out.println("isValid" + isValid);
		if(passwordEncoder.matches(settingsForm.getOldPassword(), user.getPassword())){
			if(!settingsForm.getEmail().isEmpty()){
				user.setEmail(settingsForm.getEmail());
				settingsService.saveUserSetings(user);
			}
		}	
		return "dasd";
		
	}
	@RequestMapping(value="/editUserInfoCity",method = RequestMethod.POST)
	@ResponseBody public String saveCity(@ModelAttribute("settingsForm") SettingsForm settingsForm,BindingResult bindingResult,HttpSession session, Model model){
		user = (User)session.getAttribute("user");
		if(!settingsForm.getCity().isEmpty()){
			user.setCity(settingsForm.getCity());
			settingsService.saveUserSetings(user);
			return "true";
		}
		return "false";
	}
	@RequestMapping(value = "/editUserInfoDescription",method = RequestMethod.POST)
	@ResponseBody public String saveDescription(@ModelAttribute("settingsForm") SettingsForm settingsForm,BindingResult bindingResult,HttpSession session, Model model){
		User user = new User();
		user = (User)session.getAttribute("user");
		if(settingsForm.getDescription() != null){
			user.setCity(settingsForm.getDescription());
			settingsService.saveUserSetings(user);
			return "true";
		}
		return "false";
	}
	@RequestMapping(value = "/editUserInfoPassword",method = RequestMethod.POST)
	@ResponseBody public String saveNewPassword (@ModelAttribute("settingsForm") SettingsForm settingsForm ,HttpSession session,BindingResult bindingResult,Model model){
		User user = new User();
		user = (User)session.getAttribute("user");
		if(passwordEncoder.matches(settingsForm.getOldPassword(), user.getPassword())){
			if(!settingsForm.getNewPassword().isEmpty()){
				user.setPassword(passwordEncoder.encode(settingsForm.getNewPassword()));
				System.out.println("w ifie" + settingsForm.getNewPassword());
				settingsService.saveUserSetings(user);
				return "true";
			}
		}
		return "false";
	}
	@RequestMapping(value="/editUserInfoDecription")
	@ResponseBody public String saveNewDescription(@ModelAttribute("settingsForm") SettingsForm settingsForm ,HttpSession session,BindingResult bindingResult,Model model){
		if(!settingsForm.getDescription().isEmpty()){
			user = (User)session.getAttribute("user");
			user.setDescription(settingsForm.getDescription());
			settingsService.saveUserSetings(user);
		}
		return "true";
	}
}
