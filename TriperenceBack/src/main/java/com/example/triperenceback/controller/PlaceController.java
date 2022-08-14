package com.example.triperenceback.controller;


import com.example.triperenceback.dto.Like;
import com.example.triperenceback.entity.User;
import com.example.triperenceback.dto.placeDTO.Detail;
import com.example.triperenceback.dto.placeDTO.Place;
import com.example.triperenceback.mapper.LikeMapper;
import com.example.triperenceback.mapper.SurveyMapper;
import com.example.triperenceback.repository.UserRepository;
import com.example.triperenceback.service.Like.LikeService;
import com.example.triperenceback.service.Place.DetailService;
import com.example.triperenceback.service.Place.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/places")
@CrossOrigin("*")
public class PlaceController {

    @Autowired
    private PlaceService placeService;
    @Autowired
    private DetailService detailService;

    @Autowired
    private LikeService likeService;

    @Autowired
    private LikeMapper likeMapper;

    @GetMapping("/category=all")
    public List<Place> place(){
        System.out.println("전체 출력");
        return placeService.getPlace();
    }

    @GetMapping("/category={contenttypeid}")
    public List<Place> category(@PathVariable(name="contenttypeid") int contenttypeid){
        System.out.println(contenttypeid);
        Place dto = new Place();
        dto.setContenttypeid(contenttypeid);
        return placeService.getcontenttypeid(dto);
    }



    @GetMapping("/filter")
    public List<Place> filter(@RequestParam(name="accom", required = false, defaultValue = "") String accom,
                              @RequestParam(name="restaur", required = false, defaultValue = "") String restaur){
        return placeService.getFilterPlace(accom, restaur);
    }

    @GetMapping("/detail")
    public List<Detail> detail(){
        return detailService.getDetail();
    }

    //상세 페이지
    @GetMapping("/detail/{contentid}")
    public Detail detailplace(@PathVariable(name="contentid") int contentid){
        System.out.println(contentid);
        Detail d_dto = new Detail();
        d_dto.setContentid(contentid);
        System.out.println("mingi"+detailService.getImageList(d_dto));
        return detailService.getcontentid(d_dto);
    }

    @RequestMapping(value="/likes", method=RequestMethod.POST )
    void insertLike(@RequestBody Like like) {
        likeMapper.insertLike(like);
        System.out.println("like save success");
    }

    @RequestMapping(value="/likes/delete", method=RequestMethod.DELETE)
    void deleteLike(@RequestBody Like like) {
        likeMapper.deleteLike(like);
        System.out.println("like delete success");
    }

    @RequestMapping(value="/likes/list/{seq}", method=RequestMethod.GET )
    public List<Place> likeplaceList(@PathVariable(name="seq") Long seq){
        System.out.println("========wishlist========");
        return placeService.getMyPlace(seq);
    }

}
