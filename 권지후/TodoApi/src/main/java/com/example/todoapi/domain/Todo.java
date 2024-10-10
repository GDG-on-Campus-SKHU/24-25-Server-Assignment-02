package com.example.todoapi.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Todo {

    private Long id;
    private String todoTitle;
    private String description;
    private String status;

    @Builder
    public Todo(Long id, String todoTitle, String description, String status) {
        this.id = id;
        this.todoTitle = todoTitle;
        this.description = description;
        this.status = status;
    }

    public void initId(Long id) {
        this.id = id;
    }
}
