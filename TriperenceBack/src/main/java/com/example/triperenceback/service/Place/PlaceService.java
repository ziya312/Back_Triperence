package com.example.triperenceback.service.Place;

import com.example.triperenceback.dto.placeDTO.Place;

import java.util.List;

public interface PlaceService {
    List<Place> getPlace();
    List<Place> getcontenttypeid(Place dto);
    List<Place> getChoaPlace();
    List<Place> getMyPlace(Long seq);
}
