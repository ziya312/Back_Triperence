package com.example.triperenceback.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.triperenceback.entity.User;

public interface UserRepository extends JpaRepository<User, String> {


    static Optional<User> findByid(Long seq) {
        return null;
    }

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

    Boolean existsByNickname(String nickname);
}
