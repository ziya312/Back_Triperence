package com.example.triperenceback.service;


import com.example.triperenceback.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteById(String email) {
        userRepository.deleteById(email);
    }
}
