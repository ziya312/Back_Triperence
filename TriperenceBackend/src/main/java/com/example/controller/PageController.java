package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class PageController {

    @GetMapping("")
    public String home() {
        return "Test";
    }

    @GetMapping("*")
    public String header() {
        return null;
    }
}
