package com.example.restapistudy.dto;

import com.example.restapistudy.domain.Movie;
import lombok.Builder;
import lombok.Data;

@Data
public class MovieDto
{
    private Long id; //아이디
    private String title; //영화제목
    private String director; //감독
    private int releaseYear; //출시일
    private double rating; //평점

    @Builder
    public MovieDto(Long id, String title, String director,int releaseYear, double rating)
    {
        this.id = id;
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    //DTO 객체를 엔티티 객체로 변환
    public Movie toEntity()
    { //Movie라는 엔티티 객체로 반환
        return Movie.builder() //Movie 클래스에 정의된 빌더 패턴을 사용하여 새로운 Movie 객체를 생성
                .id(id)
                .title(title)
                .director(director)
                .releaseYear(releaseYear)
                .rating(rating)
                .build();
    }
}
