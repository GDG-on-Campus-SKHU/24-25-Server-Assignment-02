package com.example.restapistudy.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Music {
    private Long id; // 조회할 music 번호
    private String name; // 노래 이름
    private String singer; // 가수
    private Long count; // 노래를 실행한 횟수

    @Builder
    public Music(Long id, String name,String singer, Long count){
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.count = count;
    }

    public void initId(Long id) { this.id = id;} // 노래 번호 초기화 메서드
}
