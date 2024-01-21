package com.example.LoginAndRegistration.dto;

import com.example.LoginAndRegistration.validation.ValidEmail;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    @NonNull
    private String userName;

    @NonNull
    @ValidEmail
    private String email;

    @NonNull
    @NotBlank
    private String password;
    private String confirmPassword;

}
