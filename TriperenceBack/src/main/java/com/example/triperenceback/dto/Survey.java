package com.example.triperenceback.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Survey {
    private Long user_id;
    private String user_email;
    private Date testtime;
    private String transportation;
    private String stay;
    private String destination;
    private String allergie;
    private String eat;
    private String category;
    /** k-culture **/
    private String k_pop;
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
