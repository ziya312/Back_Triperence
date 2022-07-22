package com.example.triperenceback.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Test")
public class TestEntity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -947585423656694361L;

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;

    @Column
    private LocalDateTime createdDateTime;

    @Column
    private Boolean isComplete;

    @Builder
    public TestEntity(Long id, String content, LocalDateTime createdDateTime, Boolean isComplete) {
        this.id = id;
        this.content = content;
        this.createdDateTime = createdDateTime;
        this.isComplete = isComplete;
    }

    @Override
    public String toString() {
        return "TestEntity [id=" + id +
                ", content=" + content +
                ", createdDateTime=" + createdDateTime +
                ", isComplete=" + isComplete + "]";
    }
}
