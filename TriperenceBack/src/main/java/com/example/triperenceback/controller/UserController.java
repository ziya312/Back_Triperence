package com.example.triperenceback.controller;


import com.example.triperenceback.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class UserController {

    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "test";
    }

    @GetMapping("/signup")
    public String signup() {
        return "test2";
    }
}
