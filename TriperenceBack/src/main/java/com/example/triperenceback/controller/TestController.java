package com.example.triperenceback.controller;


import com.example.triperenceback.dto.TestRequestBodyDTO;
import com.example.triperenceback.service.TestService;
import org.springframework.web.bind.annotation.*;

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
