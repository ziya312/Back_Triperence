package com.example.triperenceback.service.Place;

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

    @Override
    public List<Place> getCategoryPlace(int contenttypeid, String accom, String restaur, String cat2) {
        return placeMapper.getCategoryPlace(contenttypeid, accom, restaur, cat2);
    }


    @Override
    public List<Place> getChoaPlace() {
        return placeMapper.getChoaPlace();
    }

    @Override
    public List<Place> getMirPlace() {
        return placeMapper.getMirPlace();
    }

    @Override
    public List<Place> getHimchanPlace() {
        return placeMapper.getHimchanPlace();
    }

    @Override
    public List<Place> getPureumPlace() {
        return placeMapper.getPureumPlace();
    }

    @Override
    public List<Place> getSodamPlace() {
        return placeMapper.getSodamPlace();
    }

    @Override
    public List<Place> getNoriPlace() {
        return placeMapper.getNoriPlace();
    }

    @Override
    public List<Place> getFilterPlace(String accom, String restaur, String cat2) {
        return placeMapper.getFilterPlace(accom, restaur, cat2);
    }

    @Override
    public List<Place> getMyPlace(Long seq) {
        return placeMapper.getMyPlace(seq);
    }


}