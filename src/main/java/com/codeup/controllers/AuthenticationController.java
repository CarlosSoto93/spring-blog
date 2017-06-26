package com.codeup.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Carlos on 6/26/17.
 */
@Controller
public class AuthenticationController {
    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
//
//    @GetMapping("/register")
//    public String showRegisterForm(Model model){
//        model.addAttribute("user", new User());
//        return "register";
//    }
}