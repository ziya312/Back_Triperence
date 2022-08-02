package com.example.triperenceback.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
}
