package com.example.todoapi.repository;

import com.example.todoapi.domain.Todo;

import java.util.List;

public interface TodoRepository {
    void save(Todo todo);

    Todo findById(Long id);

    List<Todo> findAll();

    void updateById(Long id, Todo todo);

    void deleteById(Long id);
}
