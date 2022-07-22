package com.example.triperenceback.service;



import java.util.List;

import com.example.triperenceback.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.triperenceback.repository.TestRepository;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public List<TestEntity> getTest(Sort sort) throws Exception {
        return testRepository.findAll(sort);
    }

    @Override
    public void postTest(TestEntity test) throws Exception {
        testRepository.save(test);
    }

    @Override
    public void deleteTest(Long id) throws Exception {
        testRepository.deleteById(String.valueOf(id));
    }

    @Override
    public TestEntity findTestEntityById(Long Id) throws Exception {
        return testRepository.findById(String.valueOf(Id)).orElse(new TestEntity());
    }

}
