package com.example.restapistudy.dto;

import com.example.restapistudy.domain.Movie;

import lombok.Builder;
import lombok.Data;

@Data
public class MovieDto {
    private long id;
    private String title;
    private String director;
    private int year;
    private String genre;
    private int rating;

    @Builder
    public MovieDto(long id, String title, String director, int year, String genre, int rating) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    public Movie toEntity() {
        return Movie.builder()
                .id(id)
                .title(title)
                .director(director)
                .year(year)
                .genre(genre)
                .rating(rating)
                .build();

    }
}

