package net.skhu.restapistudy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movie {
    private Long id;
    private String name;
    private String genre;
    private Long count;

    @Builder
    public Movie(Long id, String name, String genre, Long count){
        this.id = id;
        this.name=name;
        this.genre=genre;
        this.count=count;
    }
    public void initId(Long id)
    {this.id=id;}
}
