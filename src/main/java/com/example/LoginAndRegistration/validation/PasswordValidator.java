package com.example.LoginAndRegistration.validation;

import com.example.LoginAndRegistration.dto.UserDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<ValidPassword,Object> {
    @Override
    public void initialize(ValidPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext constraintValidatorContext) {
        UserDto userDto= (UserDto) obj;
        return userDto.getPassword().equals(userDto.getConfirmPassword());
    }
}
