package com.example.triperenceback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Survey {
//    private Long user_id;
//    private String user_email;
    private Date testtime;
    private String transportation;
    private String stay;
    private String destination;
//    private ArrayList<String> allergie;
//    private ArrayList<String> eat;
    private String category;
    /** k-culture **/
//    private ArrayList<String> k_pop;
    private String k_movie_drama;
    /** photo **/
    private String shoot;
    private String subject;
    /** history **/
    private String era;
    private String historyPlace;
    /** nature **/
    private String naturePlace;
    /** nori **/
    private String placeOne;
    private String placeTwo;
    /** food **/
    private String foodOne;
    private String foodTwo;


}
