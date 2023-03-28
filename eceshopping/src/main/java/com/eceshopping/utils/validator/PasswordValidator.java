package com.eceshopping.utils.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * PasswordValidator class is used to validate a password. 
 */
public class PasswordValidator implements Validator {
    public static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    public static final String PASSWORD_LENGTH_PATTERN = "^(?=\\S+$).{8,}$";
    public static final String PASSWORD_DIGIT_PATTERN = "\\d+";
    public static final String PASSWORD_LOWER_CASE_PATTERN = "[a-z]";
    public static final String PASSWORD_UPPER_CASE_PATTERN = "[A-Z]";
    public static final String PASSWORD_SPECIAL_CHARACTER_PATTERN = "[@#$%^&+=]";

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

    /**
     * This method is used to get the errors of a password. It uses a regular
     * expression to check if the password is valid. The password must contain at
     * least one digit, one lowercase letter, one uppercase letter, one special
     * character, and must be at least 8 characters long.
     */
    @Override
    public List<String> getErrors(Object password) throws IllegalArgumentException {
        if(password.getClass() != String.class) {
            throw new IllegalArgumentException("The email must be a String");
        }
        List<String> errors = new ArrayList<String>();
        if(!this.validate(password)) {
            Pattern lengthPattern = Pattern.compile(PASSWORD_LENGTH_PATTERN);
            Pattern digitPattern = Pattern.compile(PASSWORD_DIGIT_PATTERN);
            Pattern lowerCasePattern = Pattern.compile(PASSWORD_LOWER_CASE_PATTERN);
            Pattern upperCasePattern = Pattern.compile(PASSWORD_UPPER_CASE_PATTERN);
            Pattern specialCharacterPattern = Pattern.compile(PASSWORD_SPECIAL_CHARACTER_PATTERN);

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
