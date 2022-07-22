package com.example.triperenceback.controller;


import com.example.triperenceback.service.PlaceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/places")
public class PlaceController {

    private PlaceService placeService;

    @GetMapping("/likes")
    public String favorites() {
        return "즐겨찾기";
    }

    @GetMapping("/place/{contentid}")
    public String detailInfo() {
        return "상세정보";
    }
}
