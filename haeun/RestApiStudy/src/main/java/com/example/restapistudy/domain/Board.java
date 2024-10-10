package com.example.restapistudy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Board {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private Date date;

    @Builder
    public Board(Long id, String title, String content, String writer, Date date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.date = date;
    }
    public void initId(Long id) { this.id = id; }
}
