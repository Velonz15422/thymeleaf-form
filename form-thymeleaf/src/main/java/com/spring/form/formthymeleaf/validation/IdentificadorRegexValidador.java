package com.spring.form.formthymeleaf.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdentificadorRegexValidador implements ConstraintValidator<IdentificadorRegex, String>{

    @Override
    public boolean isValid(String value, ConstraintValidatorContext arg1) {
        if(value.matches("[0-9]{2}[.][0-9]{3}[.][0-9]{3}[-][A-Z]{1}") ){
            return true;
        }    

        return false;
    }
    
}
