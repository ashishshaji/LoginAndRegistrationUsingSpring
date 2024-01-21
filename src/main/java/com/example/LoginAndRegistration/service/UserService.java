package com.example.LoginAndRegistration.service;

import com.example.LoginAndRegistration.dto.UserDto;
import com.example.LoginAndRegistration.entity.User;

import java.util.List;

public interface UserService {
    List<User> fetchAllUsers();

    String saveUser(UserDto userDto);
}
