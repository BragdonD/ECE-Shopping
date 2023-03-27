package com.eceshopping.utils.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * PasswordValidator class is used to validate a password. It uses a regular
 * expression to check if the password is valid. The password must contain at
 * least one digit, one lowercase letter, one uppercase letter, one special
 * character, and must be at least 8 characters long.
 */
public class PasswordValidator implements Validator {
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
    @Override
    public boolean validate(Object password) throws IllegalArgumentException {
        if(password.getClass() != String.class) {
            throw new IllegalArgumentException("The password must be a String");
        }
        return ((String)password).matches(PASSWORD_PATTERN);
    }

    @Override
    public List<String> getErrors(Object password) throws IllegalArgumentException {
        if(password.getClass() != String.class) {
            throw new IllegalArgumentException("The email must be a String");
        }
        List<String> errors = new ArrayList<String>();
        if(!this.validate(password)) {
            Pattern lengthPattern = Pattern.compile("^(?=\\S+$).{8,}$");
            Pattern digitPattern = Pattern.compile("\\d+");
            Pattern lowerCasePattern = Pattern.compile("[a-z]");
            Pattern upperCasePattern = Pattern.compile("[A-Z]");
            Pattern specialCharacterPattern = Pattern.compile("[@#$%^&+=]");

            if(!lengthPattern.matcher((String)password).find()) {
                errors.add("The password must be at least 8 characters long");
            }
            if(!digitPattern.matcher((String)password).find()) {
                errors.add("The password must contain at least one digit");
            }
            if(!lowerCasePattern.matcher((String)password).find()) {
                errors.add("The password must contain at least one lowercase letter");
            }
            if(!upperCasePattern.matcher((String)password).find()) {
                errors.add("The password must contain at least one uppercase letter");
            }
            if(!specialCharacterPattern.matcher((String)password).find()) {
                errors.add("The password must contain at least one special character");
            }
        }
        return errors;
    }
}
