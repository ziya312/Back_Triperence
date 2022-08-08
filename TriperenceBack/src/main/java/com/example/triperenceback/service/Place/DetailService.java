package com.example.triperenceback.service.Place;

import com.example.triperenceback.dto.placeDTO.Detail;

import java.util.List;

public interface DetailService {

    Detail getcontentid(Detail d_dto);

    List<Detail> getDetail();

    List<String> getImageList(Detail dto);
}
