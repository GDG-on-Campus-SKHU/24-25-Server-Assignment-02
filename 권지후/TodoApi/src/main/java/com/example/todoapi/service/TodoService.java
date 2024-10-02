package com.example.todoapi.service;

import com.example.todoapi.domain.Todo;
import com.example.todoapi.dto.TodoDto;
import com.example.todoapi.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor //생성자 주입
public class TodoService {

    private final TodoRepository todoRepository;

    public void saveTodo(TodoDto todoDto){
        Todo todo = todoDto.toEntity();
        todoRepository.save(todo);
    }

    public TodoDto findTodoById(Long id) {
        Todo todo = todoRepository.findById(id);
    return TodoDto.builder()
            .id(todo.getId())
            .todoTitle(todo.getTodoTitle())
            .description(todo.getDescription())
            .status(todo.getStatus())
            .build();
    }

    public List<TodoDto> findAllTodo() {
    return todoRepository.findAll()
            .stream()
            .map(todo -> {
              return TodoDto.builder()
                      .id(todo.getId())
                      .todoTitle(todo.getTodoTitle())
                      .description(todo.getDescription())
                      .status(todo.getStatus())
                      .build();
            })
            .toList();
    }


public void updateTodoById(Long id, TodoDto updateTodoDto) {
    Todo updateTodo = updateTodoDto.toEntity();
    updateTodo.initId(id);
    todoRepository.updateById(id, updateTodo);
}
    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }



}
