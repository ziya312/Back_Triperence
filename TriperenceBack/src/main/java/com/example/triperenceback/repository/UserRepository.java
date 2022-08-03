package com.example.triperenceback.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.triperenceback.entity.User;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findBySeq(Long seq);

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

    Boolean existsByNickname(String nickname);
}
