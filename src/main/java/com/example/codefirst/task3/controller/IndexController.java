package com.example.codefirst.task3.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/login")
    public String showLogin() {
        return ("views/loginForm");
    }

}
