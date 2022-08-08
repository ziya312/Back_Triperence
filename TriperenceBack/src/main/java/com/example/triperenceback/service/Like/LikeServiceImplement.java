package com.example.triperenceback.service.Like;

import com.example.triperenceback.dto.Like;
import com.example.triperenceback.dto.Survey;
import com.example.triperenceback.mapper.LikeMapper;
import com.example.triperenceback.mapper.SurveyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeServiceImplement implements LikeService {
    @Autowired
    private LikeMapper likeMapper;


    @Override
    public Like likeList() {
        return likeMapper.likeList();
    }
}
