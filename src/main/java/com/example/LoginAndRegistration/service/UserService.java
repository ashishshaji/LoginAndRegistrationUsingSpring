package com.example.LoginAndRegistration.service;

import com.example.LoginAndRegistration.Entity.User;

import java.util.List;

public interface UserService {
    List<User> fetchAllUsers();

    String saveUser(User userModel);
}
