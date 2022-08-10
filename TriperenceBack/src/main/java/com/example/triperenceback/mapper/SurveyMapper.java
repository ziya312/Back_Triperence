package com.example.triperenceback.mapper;

import com.example.triperenceback.dto.Survey;
import com.example.triperenceback.dto.placeDTO.Place;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SurveyMapper {
    List<Survey> surveyList();
    void insertSurvey(Survey survey);

}
