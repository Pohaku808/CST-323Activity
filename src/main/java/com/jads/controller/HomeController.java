package com.jads.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the Home page
 */
@Controller
public class HomeController {

	/**
	 * Display Home Page
	 * @param model
	 * @return Display Home Page
	 */
    @GetMapping("/")
    public String showHomePage(Model model) {
        return "home";
    }
}
