package com.example.triperenceback.service;

import com.example.triperenceback.dto.placeDTO.Place;
import com.example.triperenceback.mapper.PlaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceServiceImplement implements PlaceService {
    @Autowired
    private PlaceMapper placeMapper;


    @Override
    public List<Place> getPlace() {
        return placeMapper.getPlace();
    }
}