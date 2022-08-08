package com.example.triperenceback.dto.placeDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Detail {
    //기본정보
    private int contentid;
    private int contenttypeid;
    private String title;
    private String addr1; // 주소
    private float mapx;
    private float mapy;
    private int areacode;
    private String overview;
    private List<String> originimgurl;

    //Culture, Landmark, Food
    private String tel;
    private String directions;
    private String homepage; // Festival
    private String infocenter;
    private String restdate; // Leports, Shopping
    private String usetime; // Fetival, Leports, 운영 시간

    private String expagerange; // Landmark, 체험가능 연령
    private String parking; // Landmark, Food, Leports, Lodging, Shopping
    private String parkingculture; // Culture
    private String parkingfee; // Culture, 주차요금

    // Fetival
    private String eventstartdate;
    private String eventenddate;
    private String playtime; // 운영시간
    private String placeinfo; // 찾아오시는 길

    //Food
    private String treatmenu; // 메뉴

    //Leports
    private String usefee;

    //Lodging
    private String checkintime;
    private String checkouttime;
    private String chkcooking; // 요리가능여부
    private String foodplace; // 식음료장
    private String subfacility; // 부대시설
    private String pickup;
    private String reservation;
    private int goodstay;
    private int hanok;
    private int benikia; // 베니키아 여부

    //Shopping
    private String fairday; // 장서는날
    private String opentime;
}
