package com.example.triperenceback.request;

public class SignupRequest {


    private String email;

    private String password;

    private String nickname;

    private String givenname;

    private String familyname;

    private String age;

    private String nationality;

    private String gender;


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

    public void setNationality() {
        this.nationality = nationality;
    }

    public String getGender() {
        return gender;
    }

    public void setGender() {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "SignupRequest{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", givenname='" + givenname + '\'' +
                ", familyname='" + familyname + '\'' +
                ", age='" + age + '\'' +
                ", nationality='" + nationality + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}

