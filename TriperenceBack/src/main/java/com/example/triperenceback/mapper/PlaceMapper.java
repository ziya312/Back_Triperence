package com.example.triperenceback.mapper;

import com.example.triperenceback.dto.placeDTO.Place;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PlaceMapper {
    List<Place> getPlace();
    List<Place> getcontenttypeid(Place dto);

    List<Place> getMyPlace(Long seq);
    List<Place> getChoaPlace();

    List<Place> getMirPlace();

    List<Place> getHimchanPlace();

    List<Place> getPureumPlace();


    List<Place> getSodamPlace();

    List<Place> getNoriPlace();

    List<Place> getFilterPlace(String accom, String restaur);
}
