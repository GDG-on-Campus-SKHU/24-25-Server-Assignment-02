package com.example.restapistudy.dto;

import com.example.restapistudy.domain.Movie;
import lombok.Builder;
import lombok.Data;

@Data
public class MovieDto {
    private Long id;
    private String title;
    private String director;
    private Long audienceCount;

    @Builder
    public MovieDto(Long id, String title, String director, Long audienceCount) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.audienceCount = audienceCount;
    }

    // DTO 객체를 Movie 엔티티로 변환하는 메서드
    // 엔티티란 데이터베이스 테이블과 매핑되어 비즈니스 로직에서 사용하는 구조
    public Movie toEntity() {
        return Movie.builder()
                .id(id)
                .title(title)
                .director(director)
                .audienceCount(audienceCount)
                .build();
    }
}
