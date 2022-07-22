package com.example.controller;


import com.example.service.PlaceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private PlaceService placeService;

    @GetMapping("?category=")
    public String categoryInfo() {
        return "카테고리 정보";
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
