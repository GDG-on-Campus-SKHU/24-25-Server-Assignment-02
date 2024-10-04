package com.example.restapistudy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {
    private Long id; // 조회할 movie 번호
    private String title; // 영화 제목
    private String director; // 감독
    private Long audienceCount; // 관객 수

    @Builder
    public Movie(Long id, String title, String director, Long audienceCount) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.audienceCount = audienceCount;
    }

    public void initId(Long id) {
        this.id = id;
    } // 영화 번호 초기화 메서드
}
