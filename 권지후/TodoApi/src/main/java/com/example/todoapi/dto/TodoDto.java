package com.example.todoapi.dto;

import com.example.todoapi.domain.Todo;
import com.example.todoapi.domain.TodoStatus;
import lombok.Builder;
import lombok.Data;

@Data
public class TodoDto {
    private Long id;
    private String todoTitle;
    private String description;
    private String status;

    @Builder
    public TodoDto(Long id, String todoTitle, String description, String status) {
        this.id = id;
        this.todoTitle = todoTitle;
        this.description = description;
        this.status = status;
    }


    public Todo toEntity() {
        return Todo.builder()
                .id(id)
                .todoTitle(todoTitle)
                .description(description)
                .status(status)
                .build();
    }
}
