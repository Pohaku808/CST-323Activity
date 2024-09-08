package com.jads.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jads.business.RegisterBusinessService;
import com.jads.model.UserModel;

import jakarta.validation.Valid;


/**
 * Controller for registering a new user
 */
@Controller
public class RegisterController {

	@Autowired
	private RegisterBusinessService register;
	
	/**
	 * This is your registration page
	 * @param model
	 * @return Display register page
	 */
    @GetMapping("/register")
    public String showRegisterForm(Model model) 
    {
        model.addAttribute("userModel", new UserModel(0L, null, null, null, null, null, null));
        return "register";
    }
	

    /**
     * When the user submits the registration form this method is called.
     * This method checks if the users registration info is valid. 
	 * If the user is valid initialize the products then display the products page 
	 * if not display the register page again so they can re-enter their registration info.
     * @param registerModel The users registration info
     * @param bindingResult
     * @param model
     * @return Display the products page if the user registration info is valid, if not display register page
     */
    @PostMapping("/doRegister")
    public String doRegister(@Valid @ModelAttribute("userModel") UserModel userModel, BindingResult bindingResult, Model model) 
    {
		// check if there are any errors submitting the login form
        if (bindingResult.hasErrors()) 
        {
            model.addAttribute("title", "register Form");
            return "register";
        }
        
		// check if user registration info is valid
        boolean check = register.processRegister(userModel);
        
		//if the user registration info is valid
        if (check == true) 
        {

			// Display the products page
			return "redirect:/products";
        }
        else 
        {
			// Display the register page
        	return "register";
        }
    }
    
 
}
