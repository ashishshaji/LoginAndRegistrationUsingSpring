package com.example.LoginAndRegistration.service;

import com.example.LoginAndRegistration.entity.User;
import com.example.LoginAndRegistration.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public List<User> fetchAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public String saveUser(User userModel) {
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        userRepo.save(userModel);
        return "Success";
    }
}
