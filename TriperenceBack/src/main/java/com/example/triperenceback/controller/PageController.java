package com.example.triperenceback.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class PageController {

    @GetMapping("*")
    public String header() {
        return null;
    }

    @GetMapping("/home")
    public String home() { return "homepage"; }
}
