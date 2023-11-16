package com.example.lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
    @GetMapping
    public String showLoginPage(Model model) {
        //model.addAttribute("error", AppError.INCORRECT_ID);
        return "login-page";
    }

    @GetMapping("/about")
    public String showAboutPage(Model model) {
        model.addAttribute("loggedIn", false);
        return "about-page";
    }
}
