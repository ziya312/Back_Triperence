package com.example.triperenceback.mapper;

import com.example.triperenceback.dto.placeDTO.Detail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DetailMapper {
    List<Detail> getDetail();

    List<Detail> getcontentid(Detail d_dto);
}
