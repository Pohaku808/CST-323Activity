package com.jads.model;

/**
 * This class is our help model 
 */
public class HelpModel {
    private String phoneNumber;
    private String email;

    /**
     * help model non-default constructor
     */
    public HelpModel() {
        this.phoneNumber = "000-000-0000";
        this.email = "NotRealEmail@my.gcu.edu";
    }

    /**
     * Get phone number
     * @return phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Get email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Get phone number
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Set email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}