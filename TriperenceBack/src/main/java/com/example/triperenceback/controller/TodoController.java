package com.example.triperenceback.controller;

import com.example.triperenceback.entity.TodoEntity;
import com.example.triperenceback.dto.ResponseDTO;
import com.example.triperenceback.dto.TodoDTO;
import com.example.triperenceback.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
 

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService service;

    @GetMapping("/test")
    public ResponseEntity<?> testTodo() {
        String str = service.testService(); // 테스트 서비스 사용
        List<String> list = new ArrayList<>();
        list.add(str);
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<?> createTodo
            (@AuthenticationPrincipal String userId,
             @RequestBody TodoDTO dto) {
        try {
            // (1) TodoEntity로 변환한다.
            TodoEntity entity = TodoDTO.todoEntity(dto);

            // (2) id를 null로 초기화한다. 생성 당시에는 id가 없어야 하기 때문이다.
            entity.setId(null);

            // (3) 임시 사용자 아이디를 설정해 준다. 이 부분은 4장 인증과 인가에서 수정할 예정이다. 지금은 인증과 인가
            // 기능이 없으므로 한 사용자(temporay-user)만 로그인 없이 사용할 수 있는 애플리케이션인 셈이다.
            entity.setUserId(userId);

            // (4) 서비스를 이용해 Todo 엔티티를 생성한다.
            List<TodoEntity> entities = service.create(entity);

            // (5) 자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO 리스트로 변환한다.

            List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());

            // (6) 변환된 TodoDTO 리스트를 이용해 ResponseDTO를 초기화한다.

            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();

            // (7) ResponseDTO를 리턴한다.

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            // (8) 혹시 예외가 있는 경우 dto 대신 error에 메시지를 넣어 리턴한다.
            String error = e.getMessage();
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
    @GetMapping
    public ResponseEntity<?> retrieveTodoList(@AuthenticationPrincipal String userId) {
        // (1) 서비스 메서드의 retrieve() 메서드를 사용해 Todo 리스트를 가져온다.
        List<TodoEntity> entities = service.retrieve(userId);
        // (2) 자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO 리스트로 변환한다.
        List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
        // (3) 변환된 TodoDTO 리스트를 이용해 ResponseDTO를 초기화한다.
        ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
        // (4) ResponseDTO
        return ResponseEntity.ok().body(response);
    }
    @PutMapping
    public ResponseEntity<?> updateTodo(@AuthenticationPrincipal String userId,
                                        @RequestBody TodoDTO dto) {
        //(1) dto를 entity로 변환한다.
        TodoEntity entity = TodoDTO.todoEntity(dto);
        //(2) id를 temporaryUserId로 초기화한다. 여기는 4장 인증과 인가에서 수정할 예정이다.
        entity.setUserId(userId);
        //(3) 서비스를 이용해 entity를 업데이트한다.
        List<TodoEntity> entities = service.update(entity);
        //(4) 자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO 리스트로 변환한다.
        List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
        //(5) 변환된 Todo 리스트를 이용해 ResponseDTO를 초기화 한다.
        ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
        //(6) ResponseDTO를 리턴한다.
        return  ResponseEntity.ok(response);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteTodo(@AuthenticationPrincipal String userId,
                                        @RequestBody TodoDTO dto) {
        try {
            // (1) TodoEntity로 변환한다.
            TodoEntity entity = TodoDTO.todoEntity(dto);
            // (2) 임시 사용자 아이디를 설정해 준다. 이 부분은 4장, '인증과 인가'에서 수정할 예정이다. 지금은인증과
            //인가 기능이 없으므로 한 사용자(temporary-user)만 로그인 없이 사용할 수 있는 애플리케이션인 셈이다.
            entity.setUserId(userId);
            // (3) 서비스를 이용해 entity를 삭제한다.
            List<TodoEntity> entities = service.delete(entity);
            // (4) 자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO 리스트로 변환한다.
            List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
            // (5) 변환된 TodoDTO 리스트를 이용해 ResponseDTO를 초기화한다.
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();
            // (6) ResponseDTO를 리턴한다.
            return  ResponseEntity.ok(response);
        } catch (Exception e) {
            // (7) 혹시 예외가 있는 경우 dto 대신 error에 메시지를 넣어 리턴한다.
            String error = e.getMessage();
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
//    @PostMapping("/todo")
//    public ResponseDTO<TodoDTO> createTodo(@RequestBody TodoDTO dto) {
//        // 예를 들어 요청 바디에 token을 항상 포함시킨다고 해보자.
//        if(dto.getToken() != null) {
//            authService.rejectIfNotAuthorized(dto.getToken());
//        }
//    }
}