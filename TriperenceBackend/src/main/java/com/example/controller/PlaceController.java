package com.example.controller;


import com.example.service.PlaceService;
import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private PlaceService placeService;

    public Response<List<String>> getCategory(@RequestParam(name="category", required = false) String category){

    }

    @GetMapping("/likes")
    public String favorites() {
        return "즐겨찾기";
    }

    @GetMapping("/place/{contentid}")
    public String detailInfo() {
        return "상세정보";
    }
}
