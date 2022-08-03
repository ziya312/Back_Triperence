package com.example.triperenceback.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;


@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_info")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long seq;

    @Column(unique = true, nullable = false, name = "user_email")
    private String email;

    @Column(nullable = false, name = "user_pw")
    private String password;

    @Column(unique = true, nullable = false, name = "user_nickname")
    private String nickname;

    @Column(nullable = false, name = "user_givenname")
    private String givenname;

    @Column(nullable = false, name = "user_familyname")
    private String familyname;

    @Column(nullable = false, name = "user_age")
    private String age;

    @Column(nullable = false, name = "user_nationality")
    private String nationality;

    @Column(nullable = false, name = "user_gender")
    private String gender;

    public User(
            String email,
            String password,
            String nickname,
            String givenname,
            String familyname,
            String age,
            String nationality,
            String gender) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.givenname = givenname;
        this.familyname = familyname;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
    }

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGivenname() {
        return givenname;
    }

    public void setGivenname(String givenname) {
        this.givenname = givenname;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public User() {
        super();
    }

}