package com.example.restapistudy.dto;

import com.example.restapistudy.domain.Board;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
public class BoardDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private Date date;

    @Builder
    public BoardDto(Long id, String title, String content, String writer, Date date) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.date = date;
    }
    public Board toEntity() {
        return Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .writer(writer)
                .date(date)
                .build();
    }
}
