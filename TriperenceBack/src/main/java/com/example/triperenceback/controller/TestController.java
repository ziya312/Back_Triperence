package com.example.triperenceback.controller;

import java.time.LocalDateTime;
import java.util.List;


import com.example.triperenceback.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.triperenceback.entity.TestEntity;
import com.example.triperenceback.service.TestService;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    private TestService testService;

    /*
     *     목록 조회
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTest() throws Exception {
        List<TestEntity> tests = testService.getTest(Sort.by(Direction.ASC, "id"));
        return ResponseEntity.ok(tests);
    }

    /*
     *     등록
     */
    @PostMapping
    public ResponseEntity<String> postTest(@RequestBody TestEntity test) throws Exception {
        test.setCreatedDateTime(LocalDateTime.now());
        test.setIsComplete(false);
        testService.postTest(test);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }

    /*
     *     수정
     */
    @PutMapping("/{id}")
    public ResponseEntity<String> putTest(@PathVariable("id") Long id) throws Exception {
        TestEntity test = testService.findTestEntityById(id);

        Boolean isComplete = test.getIsComplete() ? false : true;
        test.setIsComplete(isComplete);
        testService.postTest(test);

        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }

    /*
     *     삭제
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long id) throws Exception {
        testService.deleteTest(id);

        return new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
    }

}

