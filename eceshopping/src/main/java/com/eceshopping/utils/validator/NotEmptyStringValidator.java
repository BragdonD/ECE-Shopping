package com.eceshopping.utils.validator;

import java.util.List;

public class NotEmptyStringValidator implements Validator {
    
    /** 
     * @param value
     * @return boolean
     */
    @Override
    public boolean validate(Object value) {
        return value != null && ((String) (value)).length() > 0;
    }

    
    /** 
     * @param value
     * @return List<String>
     */
    @Override
    public List<String> getErrors(Object value) {
        if (!(value != null && ((String) (value)).length() > 0))
            return List.of("This field is required");
        else
            return List.of();
    }
}
