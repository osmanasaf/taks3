package com.example.codefirst.task3.controller;


import com.example.codefirst.task3.UserAlreadyExistsException;
import com.example.codefirst.task3.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegisterController {
    private static final String REDIRECT = "redirect:";

    @Autowired
    private UserController userController;


    @GetMapping("/register")
    public String reqister(final Model model) {

        model.addAttribute("userData", new UserData());
        return "account/register";
    }

    @PostMapping("/register")
    public String registerUser(final @Valid UserData userData, final BindingResult bindingResult, final Model model) throws UserAlreadyExistException, UserAlreadyExistsException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("registerForm", userData);
            return "account/register";
        }
        userController.register(userData);
        return REDIRECT + "/starter";
    }
}
