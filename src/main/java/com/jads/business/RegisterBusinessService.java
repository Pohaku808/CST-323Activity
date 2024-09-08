package com.jads.business;

import com.jads.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jads.data.UserDataService;
import com.jads.data.entity.UserEntity;

/**
 * RegisterBusinessService class : This class handles all of our logic for registering a new user to the sql database.
 */
public class RegisterBusinessService 
{
    @Autowired
    private UserDataService service;

	/**
	 * This method makes sure the user doesn't enter null registration info
	 * @param registerModel The users registration information.
	 * @return A boolean if the user registration info is valid
	 */
	public boolean processRegister(UserModel userModel) 
	{

		// get encoded password first in order to register user
		String plainTextPassword = userModel.getPassword();
		String encodedPassword = new BCryptPasswordEncoder().encode(plainTextPassword);
		System.out.println("new user password - " + plainTextPassword + " encoded is: " + encodedPassword);
		
    	UserEntity newUser = new UserEntity(
    			userModel.getId(),
    			userModel.getFirstName(),
    			userModel.getLastName(),
    			userModel.getPhoneNumber(),
    			userModel.getUsername(),
    			userModel.getEmail(),
    			encodedPassword
    			);
    	
    	boolean check = service.create(newUser);
    	
    	return check;
		
		
	}
 
    /**
     * Initialize method for registerBusinessService Spring Bean
     */
	public void init() 
	{
        System.out.println("Hello from registerBusinessService's init() method.");
    }

    /**
     * Initialize method for registerBusinessService Spring Bean
     */
    public void destroy() 
    {
        System.out.println("Hello from registerBusinessService's destroy() method.");
    }
}
