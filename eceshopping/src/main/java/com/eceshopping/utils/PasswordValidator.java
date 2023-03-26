package com.eceshopping.utils;

/**
 * PasswordValidator class is used to validate a password. It uses a regular
 * expression to check if the password is valid. The password must contain at
 * least one digit, one lowercase letter, one uppercase letter, one special
 * character, and must be at least 8 characters long.
 */
public class PasswordValidator {
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";

    /**
     * This method is used to validate a password. It uses a regular expression to
     * check if the password is valid. The password must contain at least one digit,
     * one lowercase letter, one uppercase letter, one special character, and must be
     * at least 8 characters long.
     * 
     * @param password The password to validate.
     * @return True if the password is valid, false otherwise.
     */
    public static boolean validate(String password) {
        return password.matches(PASSWORD_PATTERN);
    }
}
