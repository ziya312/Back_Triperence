package com.example.triperenceback.controller;


import com.example.triperenceback.dto.placeDTO.Detail;
import com.example.triperenceback.dto.placeDTO.Place;
import com.example.triperenceback.service.Place.DetailService;
import com.example.triperenceback.service.Place.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/places")
public class PlaceController {

    @Autowired
    private PlaceService placeService;
    @Autowired
    private DetailService detailService;

    @GetMapping("")
    public List<Place> place(){
        return placeService.getPlace();
    }

    @GetMapping("/detail")
    public List<Detail> detail(){
        return detailService.getDetail();
    }

    @GetMapping("/category={contenttypeid}")
    public List<Place> category(@PathVariable(name="contenttypeid") int contenttypeid){
        System.out.println(contenttypeid);
        Place dto = new Place();
        dto.setContenttypeid(contenttypeid);
        return placeService.getcontenttypeid(dto);
    }
    //상세 페이지
    @GetMapping("/detail/{contentid}")
    public List<Detail> detailplace(@PathVariable(name="contentid") int contentid){
        System.out.println(contentid);
        Detail d_dto = new Detail();
        d_dto.setContentid(contentid);
        return detailService.getcontentid(d_dto);
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
