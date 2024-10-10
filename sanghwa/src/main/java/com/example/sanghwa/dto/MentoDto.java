package com.example.sanghwa.dto;

import com.example.sanghwa.domain.Mento;
import lombok.Builder;
import lombok.Data;

@Data
public class MentoDto {
    private Long id;
    private String name;
    private String job;

    @Builder
    public MentoDto(Long id, String name, String job) {
        this.id = id;
        this.name = name;
        this.job = job;
    }

    public Mento dtoToMento() {
        return Mento.builder()
                .id(id)
                .name(name)
                .job(job)
                .build();
    }

}
