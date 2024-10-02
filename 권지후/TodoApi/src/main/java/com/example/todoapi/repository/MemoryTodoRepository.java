package com.example.todoapi.repository;

import com.example.todoapi.domain.Todo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryTodoRepository implements TodoRepository {
    private static Map<Long, Todo> todoMemory = new HashMap<>();

    @Override
    public void save(Todo todo) {
        todoMemory.put(todo.getId(), todo);
    }

    @Override
    public Todo findById(Long id) {
        return todoMemory.get(id);
    }

    @Override
    public List<Todo> findAll() {
        return todoMemory.values().stream().toList();
    }

    @Override
    public void updateById(Long id, Todo todo) {
        todoMemory.put(id, todo);
    }

    @Override
    public void deleteById(Long id) {
        todoMemory.remove(id);
    }
}
