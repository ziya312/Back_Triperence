package com.example.triperenceback.service.Place;

import com.example.triperenceback.dto.placeDTO.Detail;
import com.example.triperenceback.mapper.DetailMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DetailServiceImplement implements DetailService {
    @Autowired
    private DetailMapper detailMapper;


    @Override
    public List<Detail> getDetail() {
        return detailMapper.getDetail();
    }
}
