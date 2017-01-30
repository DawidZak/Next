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
	// ISettingsService settingsService;
	SettingsService settingsService;

	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	private User user = new User();
	private boolean isValid = false;

	@RequestMapping(value = { "/editUserInfo", "/candidate/editUserInfo" }, method = RequestMethod.GET)
	@ResponseBody
	public User editUser(Model model, HttpSession session) {
		String pesel = session.getAttribute("pesel").toString();
		user = settingsService.changeUserSetings(pesel);
		user.setPassword(null);
		session.setAttribute("user", settingsService.changeUserSetings(pesel));
		;
		model.addAttribute("user", user);
		model.addAttribute("settingsForm", new SettingsForm());
		return user;
	}

	@RequestMapping(value = "/editUserInfoEmail", method = RequestMethod.POST)
	public @ResponseBody String saveChanges(@ModelAttribute("settingsForm") SettingsForm settingsForm,
			BindingResult bindingResult, HttpSession session, Model model) {
		// Extracted method
		validatePasswordTypedByUserWithCurrentPassword(settingsForm, session);
		return "";

	}

	@RequestMapping(value = "/editUserInfoCity", method = RequestMethod.POST)
	@ResponseBody
	public String saveCity(@ModelAttribute("settingsForm") SettingsForm settingsForm, BindingResult bindingResult,
			HttpSession session, Model model) {
		return saveUserCity(settingsForm, session);
	}

	@RequestMapping(value = "/editUserInfoDescription", method = RequestMethod.POST)
	@ResponseBody
	public String saveDescription(@ModelAttribute("settingsForm") SettingsForm settingsForm,
			BindingResult bindingResult, HttpSession session, Model model) {
		return saveDescription2(settingsForm, session);
	}

	private String saveDescription2(SettingsForm settingsForm, HttpSession session) {
		User user = new User();
		user = (User) session.getAttribute("user");
		if (settingsForm.getDescription() != null) {
			user.setCity(settingsForm.getDescription());
			settingsService.saveUserSetings(user);
			return "true";
		}
		return "false";
	}

	@RequestMapping(value = "/editUserInfoPassword", method = RequestMethod.POST)
	@ResponseBody
	public String saveNewPassword(@ModelAttribute("settingsForm") SettingsForm settingsForm, HttpSession session,
			BindingResult bindingResult, Model model) {
		return saveNewPassword(settingsForm, session);
	}

	@RequestMapping(value = "/editUserInfoDecription")
	@ResponseBody
	public String saveNewDescription(@ModelAttribute("settingsForm") SettingsForm settingsForm, HttpSession session,
			BindingResult bindingResult, Model model) {
		// Extracted method
		saveDescription(settingsForm, session);
		return "true";
	}

	private void validatePasswordTypedByUserWithCurrentPassword(SettingsForm settingsForm, HttpSession session) {
		user = (User) session.getAttribute("user");
		isValid = passwordEncoder.matches(settingsForm.getOldPassword(), user.getPassword());
		System.out.println("isValid" + isValid);
		if (passwordEncoder.matches(settingsForm.getOldPassword(), user.getPassword())) {
			if (!settingsForm.getEmail().isEmpty()) {
				user.setEmail(settingsForm.getEmail());
				settingsService.saveUserSetings(user);
			}
		}
	}

	private void saveDescription(SettingsForm settingsForm, HttpSession session) {
		if (!settingsForm.getDescription().isEmpty()) {
			user = (User) session.getAttribute("user");
			user.setDescription(settingsForm.getDescription());
			settingsService.saveUserSetings(user);
		}
	}

	private String saveUserCity(SettingsForm settingsForm, HttpSession session) {
		user = (User) session.getAttribute("user");
		if (!settingsForm.getCity().isEmpty()) {
			user.setCity(settingsForm.getCity());
			settingsService.saveUserSetings(user);
			return "true";
		}
		return "false";
	}

	private String saveNewPassword(SettingsForm settingsForm, HttpSession session) {
		user = (User) session.getAttribute("user");
		if (passwordEncoder.matches(settingsForm.getOldPassword(), user.getPassword())) {
			if (!settingsForm.getNewPassword().isEmpty()) {
				user.setPassword(passwordEncoder.encode(settingsForm.getNewPassword()));
				System.out.println("w ifie" + settingsForm.getNewPassword());
				settingsService.saveUserSetings(user);
				return "true";
			}
		}
		return "false";
	}
}
