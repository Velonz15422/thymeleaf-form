package com.spring.form.formthymeleaf.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NumeroRequerido implements ConstraintValidator<RequeridoNumeroValidador, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext arg1) {
        if (value == null) {
            return false;
        }
        return true;
    }

}
