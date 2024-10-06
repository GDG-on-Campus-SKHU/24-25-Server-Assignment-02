package com.example.restapistudy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {
    private long id;                     //조회할 영화 id
    private String title;               //상영 영화 이름
    private String director;            //영화 감독
    private int year;                   //개봉 연도
    private String genre;               //영화 장르
    private int rating;                 //평가 점수


    @Builder
    public Movie(long id, String title, String director, int year, String genre, int rating) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    public void initID(Long id) { this.id = id;}
}
