package com.eceshopping.utils.validator;

import java.util.List;

public interface Validator {
    public boolean validate(Object value) throws IllegalArgumentException;
    public List<String> getErrors(Object value) throws IllegalArgumentException;
}
