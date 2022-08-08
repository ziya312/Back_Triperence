package com.example.triperenceback.mapper;

import com.example.triperenceback.dto.Like;
import com.example.triperenceback.dto.Survey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LikeMapper {
    void insertLike(Like like);
    Like likeList();
}
