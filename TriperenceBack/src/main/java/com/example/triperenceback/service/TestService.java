package com.example.triperenceback.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.example.triperenceback.entity.TestEntity;

public interface TestService {

    List<TestEntity> getTest(Sort sort) throws Exception;

    void postTest(TestEntity test) throws Exception;

    void deleteTest(Long Id) throws Exception;

    TestEntity findTestEntityById(Long Id) throws Exception;
}