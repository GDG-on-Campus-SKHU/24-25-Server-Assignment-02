package com.example.sanghwa.dto;

import com.example.sanghwa.domain.Mentee;
import lombok.Builder;
import lombok.Data;

@Data
public class MenteeDto {
    private Long id;
    private String name;
    private String major;

    @Builder
    public MenteeDto(Long id, String name, String major) {
        this.id = id;
        this.name = name;
        this.major = major;
    }

    public Mentee dtoToMentee() {
        return Mentee.builder() //Mentee mentee = new Mentee(id,name,major); 대신?
                .id(id)
                .name(name)
                .major(major)
                .build();
    }
}
