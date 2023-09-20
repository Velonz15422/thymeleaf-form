package com.spring.form.formthymeleaf.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequeridoValidador implements ConstraintValidator<Requerido, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext arg1) {
        if (value == null || value.isEmpty() || value.isBlank()) {
            return false;
        }
        return true;
    }

}
