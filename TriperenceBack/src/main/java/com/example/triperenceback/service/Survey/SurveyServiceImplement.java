package com.example.triperenceback.service.Survey;

import com.example.triperenceback.dto.Survey;
import com.example.triperenceback.mapper.SurveyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveyServiceImplement implements SurveyService{
    @Autowired
    private SurveyMapper surveyMapper;


    @Override
    public List<Survey> surveyList() {
        return surveyMapper.surveyList();
    }

}
