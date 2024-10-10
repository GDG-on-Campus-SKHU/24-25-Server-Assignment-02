package net.skhu.restapistudy.dto;

import lombok.Builder;
import lombok.Data;
import net.skhu.restapistudy.domain.Movie;

@Data //클래스의 모든 필드에 대한 getter, setter 메서드 자동으로 만들어준다.
public class MovieDto {
    private Long id;
    private String name;
    private String genre;
    private Long count;

    @Builder
    public MovieDto(Long id, String name, String genre, Long count){
        this.id=id;
        this.name=name;
        this.genre=genre;
        this.count=count;
    }
    public Movie toEntity(){
        //DTO -> Entity 변환 메서드
        return Movie.builder()
                .id(id)
                .name(name)
                .genre(genre)
                .count(count)
                .build();
    }
    //return Movie(id, name, genre, count)
}