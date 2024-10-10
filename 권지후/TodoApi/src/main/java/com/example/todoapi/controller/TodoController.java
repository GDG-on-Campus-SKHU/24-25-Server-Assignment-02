package com.example.todoapi.controller;

import com.example.todoapi.dto.TodoDto;
import com.example.todoapi.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor //생성자 주입
@RequestMapping("/todo")
@Slf4j
public class TodoController {
    private final TodoService todoService;

    //할일 등록
    @PostMapping
    public void save(@RequestBody TodoDto todoDto) {
        log.info("할일 등록 요청 들어옴 -{}", todoDto.getId());
        todoService.saveTodo(todoDto);
    }

    //할일 상세 보기
    @GetMapping("/{id}")
    public TodoDto findTodoById(@PathVariable Long id) {
        log.info("할일 상세 요청 들어옴 -{}", id);
        return todoService.findTodoById(id);
    }

    //할일 리스트
    @GetMapping("/list")
    public List<TodoDto> findAllTodo() {
        log.info("할일 리스트 요청 들어옴");
        return todoService.findAllTodo();
    }

    @PatchMapping("/{id}")
    public void updateTodoById(@PathVariable Long id, @RequestBody TodoDto updateTodoDto) {
        log.info("할일 업데이트 요청 들어옴 -{}", id);
        todoService.updateTodoById(id, updateTodoDto);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable Long id) {
        log.info("할일 삭제 요청 들어옴 -{}", id);
        todoService.deleteTodoById(id);
    }
}
