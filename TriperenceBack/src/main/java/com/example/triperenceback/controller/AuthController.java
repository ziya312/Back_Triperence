package com.example.triperenceback.controller;

import com.example.triperenceback.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.triperenceback.entity.User;
import com.example.triperenceback.repository.UserRepository;
import com.example.triperenceback.request.LoginRequest;
import com.example.triperenceback.request.SignupRequest;
import com.example.triperenceback.response.JwtResponse;
import com.example.triperenceback.response.MessageResponse;
import com.example.triperenceback.security.jwt.JwtUtils;
import com.example.triperenceback.security.services.UserDetailsImpl;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserService userService;
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateuser(@RequestBody LoginRequest loginRequest) {

        System.out.println("로그인 "+loginRequest);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity
                .ok(new JwtResponse(jwt,
                        userDetails.getSeq(),
                        userDetails.getEmail(),
                        userDetails.getNickname(),
                        userDetails.getGivenname(),
                        userDetails.getFamilyname(),
                        userDetails.getAge(),
                        userDetails.getNationality(),
                        userDetails.getGender()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        System.out.println("사인업"+signUpRequest);
        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
        }

        if (userRepository.existsByNickname(signUpRequest.getNickname())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Nickname is already in use!"));
        }


        // test
//        {
//            "email" : "cwj123@gmail.com",
//            "password" : "root1234",
//            "nickname" : "rickchoi",
//            "givenname" : "wonjae",
//            "familyname" : "choi",
//            "age" : "29",
//            "nationality" : "korea",
//            "gender" : "male"
//        }


        // Create new user account
        User user = new User(
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getNickname(),
                signUpRequest.getGivenname(),
                signUpRequest.getFamilyname(),
                signUpRequest.getAge(),
                signUpRequest.getNationality(),
                signUpRequest.getGender());

        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("user registered successfully!"));
    }

    // 비밀번호 수정
    @PutMapping("update/{seq}")
    public ResponseEntity<User> updatePassword(@PathVariable("seq") Long seq, @RequestBody User user) {
        Optional<User> userData = userRepository.findBySeq(seq);

        if (userData.isPresent()) {
            User _user = userData.get();
            _user.setPassword(encoder.encode(user.getPassword()));
            _user.setNickname(user.getNickname());
            _user.setGivenname(user.getGivenname());
            _user.setFamilyname(user.getFamilyname());
            _user.setGender(user.getGender());
            _user.setAge(user.getAge());
            _user.setNationality(user.getNationality());
            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//    // 이름 수정
//    @PutMapping("/givenname/{email}")
//    public ResponseEntity<User> updateGivenName(@PathVariable("email") String email, @RequestBody User user) {
//        Optional<User> userData = userRepository.findByEmail(email);
//
//        if (userData.isPresent()) {
//            User _user = userData.get();
//            _user.setGivenname(user.getGivenname());
//            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//    // 성 수정
//    @PutMapping("/familyname/{email}")
//    public ResponseEntity<User> updateFamilyName(@PathVariable("email") String email, @RequestBody User user) {
//        Optional<User> userData = userRepository.findByEmail(email);
//
//        if (userData.isPresent()) {
//            User _user = userData.get();
//            _user.setFamilyname(user.getFamilyname());
//            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//    //닉네임 수정
//    @PutMapping("/nickname/{email}")
//    public ResponseEntity<User> updateNickName(@PathVariable("email") String email, @RequestBody User user) {
//        Optional<User> userData = userRepository.findByEmail(email);
//
//        if (userData.isPresent()) {
//            User _user = userData.get();
//            _user.setNickname(user.getNickname());
//            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//    //성별 수정
//    @PutMapping("/gender/{email}")
//    public ResponseEntity<User> updateGender(@PathVariable("email") String email, @RequestBody User user) {
//        Optional<User> userData = userRepository.findByEmail(email);
//
//        if (userData.isPresent()) {
//            User _user = userData.get();
//            _user.setGender(user.getGender());
//            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//    //나이 수정
//    @PutMapping("/age/{email}")
//    public ResponseEntity<User> updateAge(@PathVariable("email") String email, @RequestBody User user) {
//        Optional<User> userData = userRepository.findByEmail(email);
//
//        if (userData.isPresent()) {
//            User _user = userData.get();
//            _user.setAge(user.getAge());
//            return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
    // 회원 정보 삭제
    @DeleteMapping("/delete/{seq}")
    public void delete(@PathVariable("seq") Long seq) {
        Optional<User> user = userRepository.findBySeq(seq);
        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });
    }
}
