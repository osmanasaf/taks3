package com.example.codefirst.task3;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Index {

    @GetMapping("/")
    public String indexMessage() {
        return ("<h1 align=center> Login Successful </h1>");
    }

}
