package com.example.triperenceback;

import com.example.triperenceback.entity.TestEntity;
import com.example.triperenceback.repository.TestRepository;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;


@Data
@RunWith(SpringRunner.class)
public class JpaMappingTest {

    private final String content = "내용";

    @Autowired
    private TestRepository testRepository;

    @Autowired
    private TestEntityManager entityManager;

    private TestEntity getSaved() {
        TestEntity test = TestEntity.builder()
                .content(content)
                .createdDateTime(LocalDateTime.now())
                .build();

        return entityManager.persist(test);
    }

    @Test
    public void test_get() {
        // GIVEN
        TestEntity test = getSaved();
        System.out.println("=========================");
        System.out.println(test.getId());
        System.out.println(test.getContent());
        System.out.println(test.getIsComplete());
        System.out.println(test.getCreatedDateTime());
        System.out.println("=========================");
        Long id = test.getId();

        // WHEN
        TestEntity savedTodo = testRepository.getOne(String.valueOf(id));

        // THEN
        assertThat(savedTodo.getContent()).isEqualTo(content);
        assertThat(savedTodo.getContent()).isEqualTo(test.getContent());
    }

    @Test
    public void test_save() {
        // GIVEN
        TestEntity test = TestEntity.builder()
                .content("내용1")
                .isComplete(true)
                .createdDateTime(LocalDateTime.now())
                .build();

        // WHEN
        TestEntity savedTodo = testRepository.save(test);
        System.out.println("=========================");
        System.out.println(savedTodo.getId());
        System.out.println(savedTodo.getContent());
        System.out.println(savedTodo.getIsComplete());
        System.out.println(savedTodo.getCreatedDateTime());
        System.out.println("=========================");

        // THEN
        assertThat(savedTodo.getId()).isGreaterThan(0);
        assertThat(savedTodo.getContent()).isEqualTo("내용1");
        assertThat(savedTodo.getIsComplete()).isEqualTo(true);
    }

    @Test
    public void test_delete() {
        // GIVEN
        TestEntity test = getSaved();
        System.out.println("=========================");
        System.out.println(test.getId());
        System.out.println(test.getContent());
        System.out.println(test.getIsComplete());
        System.out.println(test.getCreatedDateTime());
        System.out.println("=========================");
        Long id = test.getId();

        // WHEN
        testRepository.deleteById(String.valueOf(id));

        // THEN
        assertThat(entityManager.find(TestEntity.class, id)).isNull();
    }
}