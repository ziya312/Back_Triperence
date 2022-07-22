package com.example.controller;


import com.example.dto.TestRequestBodyDTO;
import com.example.service.TestService;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("test")
public class TestController {

    private TestService testService;

    @GetMapping("/hello")
    public String hello() {
        return "hello, world";
    }

    @GetMapping("/{id}")
    public String testControllerWithPathVariables(@PathVariable(required = false) int id) {
        return "Hello World ID" + id;
    }

    @GetMapping("/testRequestParam")
    public String testControllerRequestParam(@RequestParam(required = false) int id) {
        return "Hello World! ID" + id;
    }

    @GetMapping("/testRequestBody")
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
        return "Hello World ID" + testRequestBodyDTO.getId() + " Message : " + testRequestBodyDTO.getMessage();
    }
}
