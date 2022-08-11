package com.example.triperenceback.controller;

import com.example.triperenceback.dto.Survey;
import com.example.triperenceback.dto.placeDTO.Detail;
import com.example.triperenceback.dto.placeDTO.Place;
import com.example.triperenceback.mapper.SurveyMapper;
import com.example.triperenceback.service.Place.PlaceService;
import com.example.triperenceback.service.Survey.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/survey")
@CrossOrigin("*")
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    @Autowired
    private SurveyMapper surveyMapper;

    @Autowired
    private PlaceService placeService;

    @GetMapping("/list")
    public List<Survey> surveyList(){
        System.out.println(surveyService.surveyList());
        System.out.println("리스트 출력성공");
        return surveyService.surveyList();
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    void insertSurvey(@RequestBody Survey survey) {
        surveyMapper.insertSurvey(survey);
        System.out.println("survey 저장 성공");
    }

    @GetMapping("/result/type=choa")
    public List<Place> surveyChoa(){
        System.out.println("!!CHOA!!");
        return placeService.getChoaPlace();
    }

    @GetMapping("/{id}")
    public String thingPlace() {
        return "취향 반영 장소 추천";
    }
}
