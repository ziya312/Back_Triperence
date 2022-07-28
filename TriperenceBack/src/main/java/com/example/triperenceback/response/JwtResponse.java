package com.example.triperenceback.response;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;

    private String email;

    private String nickname;

    private String givenname;

    private String familyname;

    private String age;

    private String nationality;

    private String gender;

    public JwtResponse(String accessToken,
                       Long id,
                       String email,
                       String nickname,
                       String givenname,
                       String familyname,
                       String age,
                       String nationality,
                       String gender) {
        this.token = accessToken;
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.givenname = givenname;
        this.familyname = familyname;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getNationality() { return  nationality; }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getGender() { return gender; }

    public void setGender(String gender) {
        this.gender = gender;
    }
}


