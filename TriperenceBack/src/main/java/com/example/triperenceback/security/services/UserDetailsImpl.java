package com.example.triperenceback.security.services;

import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.triperenceback.entity.User;

public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;

    private Long seq;

    private String email;

    @JsonIgnore
    private String password;

    private String nickname;

    private String givenname;

    private String familyname;

    private String age;

    private String nationality;

    private String gender;

    public UserDetailsImpl(Long seq,
                           String email,
                           String password,
                           String nickname,
                           String givenname,
                           String familyname,
                           String age,
                           String nationality,
                           String gender) {
        this.seq = seq;
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.givenname = givenname;
        this.familyname = familyname;
        this.age = age;
        this.nationality =nationality;
        this.gender = gender;
    }

    public static UserDetailsImpl build(User user) {

        return new UserDetailsImpl(user.getSeq(),
                user.getEmail(),
                user.getPassword(),
                user.getNickname(),
                user.getGivenname(),
                user.getFamilyname(),
                user.getAge(),
                user.getNationality(),
                user.getGender());
    }

    public Long getSeq() {
        return seq;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }


    public String getNickname() {return nickname; }

    public String getGivenname() {return givenname; }

    public String getFamilyname() {return familyname; }

    public String getAge() {return age; }

    public String getNationality() {return  nationality; }

    public String getGender() { return  gender;}

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(seq, user.seq);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return null;
    }
}
