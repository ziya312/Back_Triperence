package com.example.triperenceback.dto.placeDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Place {
    private int contentid;
    private int contenttypeid; // 76:landmark, 78:culture, 85:festival
    private String title;
    private String addr1;
    private float mapx;
    private float mapy;
    private String firstimage;
    private String cat1;
    private String cat2;
    private String cat3;
    private int sigungucode;
    private String tel;
}
