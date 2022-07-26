package com.example.triperenceback.controller;

import com.example.triperenceback.service.SurveyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/survey")
public class SurveyController {

    private SurveyService surveyService;

    @GetMapping("/save")
    public String saveSurvey() {

        return "취향 테스트 저장";
    }

    @GetMapping("/survey/result/{id}")
    public String resultSurvey() {
        return "취향 테스트 결과";
    }

    @GetMapping("/{id}")
    public String thingPlace() {
        return "취향 반영 장소 추천";
    }
}
