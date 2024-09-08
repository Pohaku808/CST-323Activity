package com.jads.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.jads.business.LoginBusinessService;

import com.jads.model.UserModel;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.BindingResult;
import org.springframework.ui.Model;



/**
 * Controller for login authentication
 */
@Controller
public class LoginController {

	@Autowired
	private LoginBusinessService login;

	/**
	 * This is your login page
	 * @param model The users login credentials
	 * @return Display login page
	 */
	@GetMapping("/login")
	public String showLoginForm(Model model) {
		model.addAttribute("userModel", new UserModel(0L,"First Name", "Last Name", "Phone Number", "Username", null, null));
		return "login";
	}

}
