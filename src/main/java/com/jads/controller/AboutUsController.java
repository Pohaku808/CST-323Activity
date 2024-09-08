package com.jads.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import com.jads.model.AboutUsModel;


/**
 * Controller for the About Us page
 */
@Controller
public class AboutUsController
{
	/**
	 * Display the about us page
	 * @param model
	 * @return Display about us page
	 */
    @GetMapping("/aboutus")
    public String showAboutUsPage(Model model)
    {
        AboutUsModel aboutModel = new AboutUsModel();
        model.addAttribute("aboutModel", aboutModel);
        return "aboutus";
    }
}
