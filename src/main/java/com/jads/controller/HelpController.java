package com.jads.controller;

import com.jads.model.HelpModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for the Help page
 */
@Controller
public class HelpController 
{
	/**
	 * Displays help page
	 * @param model
	 * @return Display help page
	 */
    @GetMapping("/help")
    public String showHelpPage(Model model) {
        HelpModel helpModel = new HelpModel();
        model.addAttribute("helpModel", helpModel);
        return "help";
    }
}
