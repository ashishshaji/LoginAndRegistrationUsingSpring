package com.example.LoginAndRegistration.controller;

import com.example.LoginAndRegistration.Entity.User;
import com.example.LoginAndRegistration.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String Home(){
        return "Home";
    }
    @GetMapping("/user")
    public List<User> fetchUsers(){
        return userService.fetchAllUsers();
    }

    @PostMapping("/register")
    public String saveUser(@RequestBody User userModel,final HttpServletRequest request ){
        return userService.saveUser(userModel);

    }



}
