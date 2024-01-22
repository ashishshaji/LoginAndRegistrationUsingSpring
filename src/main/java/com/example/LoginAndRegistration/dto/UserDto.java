package com.example.LoginAndRegistration.dto;

import com.example.LoginAndRegistration.validation.ValidEmail;
import com.example.LoginAndRegistration.validation.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
//hence we require both the userDto.getPassword() and userDto.getConfirmPassword()
@ValidPassword
public class UserDto {
    @NonNull
    private String userName;

    @NonNull
    @ValidEmail
    private String email;

    @NonNull
    @NotBlank
    private String password;
    @NonNull
    private String confirmPassword;

}
