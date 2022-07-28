package com.example.triperenceback.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String token;
    private String user_id;
    private String user_email;
    private String user_pw;
    private String user_givenname;
    private String user_familyname;
    private String user_nickname;
    private String user_gender;
    private String user_age;
    private String user_nationality;
    private LocalDateTime createddate;
//    private Date expiredate;
//    private String gradecode;
}
