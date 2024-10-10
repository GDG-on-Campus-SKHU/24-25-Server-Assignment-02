package com.example.restapistudy.domain;

import jdk.jshell.Snippet;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie
{
    private Long id; //아이디
    private String title; //영화제목
    private String director; //감독
    private int releaseYear; //출시연도
    private double rating; //평점

    @Builder
    public Movie(Long id, String title, String director, int releaseYear, double rating)
    {
        this.id = id;
        this.title =title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    public void initId(Long id)
    {this.id = id;}
}
