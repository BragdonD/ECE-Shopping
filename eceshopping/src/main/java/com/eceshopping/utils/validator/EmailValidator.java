package com.eceshopping.utils.validator;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to validate an email address.
 */
public class EmailValidator implements Validator {

    public static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    /**
     * This method is used to validate an email address. 
     * @param email the email address to validate 
     * @return true if the email is valid. Otherwise, it returns false.
     */
    @Override
    public boolean validate(Object email) throws IllegalArgumentException {
        if(email.getClass() != String.class) {
            throw new IllegalArgumentException("The email must be a String");
        }
        return ((String)email).matches(EMAIL_REGEX);
    }

    @Override
    public List<String> getErrors(Object email) throws IllegalArgumentException {
        if(email.getClass() != String.class) {
            throw new IllegalArgumentException("The email must be a String");
        }
        List<String> errors = new ArrayList<String>();
        if(!this.validate(email)) {
            errors.add("The email is not valid");
        }
        return errors;
    }
}
