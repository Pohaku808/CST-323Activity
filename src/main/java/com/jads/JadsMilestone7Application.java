package com.jads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//program is run here
//common.html is where the top bar navigation is configured
//check line 28 of common.html for line where we navigate from
//login page to registration page
//added multiple controllers
//navigate between pages



/*
 * @SpringBootApplication
 */
@SpringBootApplication
public class JadsMilestone7Application {

	public static void main(String[] args) {
		SpringApplication.run(JadsMilestone7Application.class, args);
		
		// The code below is used to get the encoded passwords
		String plainTextPassword = "SMAN";
		String encoded = new BCryptPasswordEncoder().encode(plainTextPassword);
		System.out.println(plainTextPassword + " encoded is: " + encoded);
	}

}
