package com.example.LoginAndRegistration.controller;

import com.example.LoginAndRegistration.dto.UserDto;
import com.example.LoginAndRegistration.entity.User;
import com.example.LoginAndRegistration.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@Validated
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/index")
    public String Home(){
        return "index";
    }
    @GetMapping("/user")
    public List<User> fetchUsers(){
        return userService.fetchAllUsers();
    }

    @PostMapping("/signup")
    public String saveUser(@RequestBody UserDto userDto,final HttpServletRequest request ){
        return userService.saveUser(userDto);

    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model){

        UserDto user = new UserDto();

        model.addAttribute("user", user);

        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){

        if(userService.saveUser(userDto).equals("Success"))  return "redirect:/register?success";
        else return "redirect:/register?fail";

    }



    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @GetMapping("/users")
    public String listRegisteredUsers(Model model){
        List<User> users = userService.fetchAllUsers();
        // model.addAttribute is related to thymeleaf, which is required to render templates correctly
        model.addAttribute("users", users);
        return "users";
    }



}
