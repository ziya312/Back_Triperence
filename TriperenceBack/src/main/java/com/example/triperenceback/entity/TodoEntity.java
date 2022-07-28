package com.example.triperenceback.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Todo")
public class TodoEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id; // 이 오브젝트의 아이디
    private String userId; // 이 오브젝트를 생성한 사용자의 아이디
    private String title; // Todo타이틀(예: 운동하기)
    private boolean done; // true - todo를 완료한 경우(checked)

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id=id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId=userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title=title;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done=done;
    }
}

