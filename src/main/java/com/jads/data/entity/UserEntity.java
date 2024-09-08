package com.jads.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


/** 
 * This class is our UserEntity class
 */
@Table("users")
public class UserEntity 
{
	@Id
	Long id;
	
	@Column("FirstName")
	String firstName;

	@Column("lastName")
	String lastName;

	@Column("PhoneNumber")
	String phoneNumber;

	@Column("Username")
	String username;
	
	@Column("Email")
	String email;

	@Column("Password")
	String password;

	/**
	 * UserEntity default constructor
	 */
	public UserEntity()
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
	 * UserEntity non default constructor
	 * @param Id
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 * @param username
	 * @param email
	 * @param password
	 */
	public UserEntity(Long Id, String firstName, String lastName, String phoneNumber, String username, String email, String password)
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
