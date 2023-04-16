package com.eceshopping.utils.validator;

import java.util.List;

/**
 * Validator interface is used to validate an object.
 */
public interface Validator {
    public boolean validate(Object value) throws IllegalArgumentException;

    public List<String> getErrors(Object value) throws IllegalArgumentException;
}
