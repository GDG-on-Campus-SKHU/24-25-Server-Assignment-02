package com.example.restapistudy.dto;

import com.example.restapistudy.domain.Music;
import lombok.Builder;
import lombok.Data;

@Data
public class MusicDto {
    private Long id;
    private String name;
    private String singer;
    private Long count;

    @Builder
    public MusicDto(Long id, String name, String singer, Long count) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.count = count;
    }

    public Music toEntity() { // Dio 객체를 Music으로 변환하는 메서드
        return Music.builder()
                .id(id)
                .name(name)
                .singer(singer)
                .count(count)
                .build();
    }
}
