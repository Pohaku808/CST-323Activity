package com.jads.model;

/**
 * This class is our about us model
 */
public class AboutUsModel {
    private String aboutText;

    /**
     * This is our default constructor for our about us model
     */
    public AboutUsModel() {
        aboutText = "At J.A.D.S. Gym, we strive to bring only the best exercise for our patrons. " +
                    "We were founded in 2024 and strive to help you achieve your fitness goals.";
    }

    /**
     * Get about text
     * @return
     */
    public String getAboutText() {
        return aboutText;
    }
}
