package com.example.LoginAndRegistration.controller;

import com.example.LoginAndRegistration.entity.User;
import com.example.LoginAndRegistration.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
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
    public String saveUser(@RequestBody User userModel,final HttpServletRequest request ){
        return userService.saveUser(userModel);

    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model){

        User user = new User();

        model.addAttribute("user", user);

        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") User user,
                               BindingResult result,
                               Model model){

        userService.saveUser(user);
        return "redirect:/register?success";

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
