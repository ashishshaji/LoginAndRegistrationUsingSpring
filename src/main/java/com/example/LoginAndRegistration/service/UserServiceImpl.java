package com.example.LoginAndRegistration.service;

import com.example.LoginAndRegistration.dto.UserDto;
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
    public String saveUser(UserDto userDto) {
        if(userRepo.findByEmail(userDto.getEmail())!=null) return "user already exists";
        User user =new User();
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepo.save(user);
        return "Success";
    }
}
