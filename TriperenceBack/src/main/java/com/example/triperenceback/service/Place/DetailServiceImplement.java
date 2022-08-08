package com.example.triperenceback.service.Place;

import com.example.triperenceback.dto.placeDTO.Detail;
import com.example.triperenceback.mapper.DetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImplement implements DetailService {
    @Autowired
    private DetailMapper detailMapper;

    @Override
    public List<Detail> getDetail() {
        return detailMapper.getDetail();
    }

    @Override
    public List<String> getImageList(Detail dto) {
        return detailMapper.getImageList(dto);
    }

    @Override
    public Detail getcontentid(Detail d_dto){
        Detail detail = detailMapper.getcontentid(d_dto);
        detail.setOriginimgurl(detailMapper.getImageList(d_dto));
        return detail;
    }
}
