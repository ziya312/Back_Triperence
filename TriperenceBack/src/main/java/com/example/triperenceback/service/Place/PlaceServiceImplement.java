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
    public List<Place> getcontenttypeid(Place dto){ return placeMapper.getcontenttypeid(dto);}

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
    public List<Place> getFilterPlace(String accom, String restaur) {
        return placeMapper.getFilterPlace(accom, restaur);
    }

    @Override
    public List<Place> getMyPlace(Long seq) {
        return placeMapper.getMyPlace(seq);
    }


}