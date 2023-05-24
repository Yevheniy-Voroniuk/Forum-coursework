package com.example.Forum.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForumController {

    @GetMapping("/")
    public String index() {
        return "Welcome to the home page!";
    }

}