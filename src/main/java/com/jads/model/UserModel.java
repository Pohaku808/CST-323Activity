package com.jads.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/** 
 * This class is our UserModel class
 */
public class UserModel 
{
	
	private Long id;
	
	/*
	makes sure First Name is between one and 32 characters
	*/
	@NotNull(message = "First name is a required field")
	@Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters")
	private String firstName;

	/*
	makes sure Last Name is between one and 32 characters
	*/
	@NotNull(message = "Last name is a required field")
	@Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters")
	private String lastName;

	/*
	 * makes sure phone number is between 10 and 15 characters and only uses numbers
	 */
	@NotNull(message = "Phone number is a required field")
	@Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 digits")
	private String phoneNumber;

	/*
	 * makes sure username is between one and 32 characters
	 */
	@NotNull(message = "Username is a required field")
	@Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters")
	private String username;
	
	
	/*
	 * makes sure email is between one and 32 characters
	 */
	@NotNull(message = "Email is a required field")
	@Size(min = 1, max = 32, message = "Email must be between 1 and 32 characters")
	private String email;

	/*
	 * makes sure password is between one and 32 characters
	 */
	@NotNull(message = "Password is a required field")
	@Size(min = 1, max = 32, message = "Password must be between 1 and 32 characters")
	private String password;

	/**
	 * UserModel default constructor
	 */
	public UserModel()
	{
		this.id = 0L;
		this.firstName = "First Name";
		this.lastName = "Last Name";
		this.phoneNumber = "Phone Number";
		this.username = "Username";
		this.email = "Email";
		this.password = "Password";
	}
	
	
	/**
	 * UserModel non default constructor
	 * @param Id
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param username
	 * @param email
	 * @param password
	 */
	public UserModel(Long Id, String firstName, String lastName, String phoneNumber, String username, String email, String password)
	{
		this.id = Id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	 /**
	 * Get Id
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set id
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * Get first name
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Set first name
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Get last name
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Set last name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Get phone number
	 * @return phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Set phone number
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Get email
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Set email
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Get password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Set password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Get username
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/** 
	 * Set username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
}
