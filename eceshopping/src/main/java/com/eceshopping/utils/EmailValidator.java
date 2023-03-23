package com.eceshopping.utils;

/**
 * This class is used to validate an email address.
 */
public class EmailValidator {

    public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    /**
     * This method is used to validate an email address. 
     * @param email the email address to validate 
     * @return true if the email is valid. Otherwise, it returns false.
     */
    public static boolean isValid(String email) {
        return email.matches(EMAIL_REGEX);
    }
}
