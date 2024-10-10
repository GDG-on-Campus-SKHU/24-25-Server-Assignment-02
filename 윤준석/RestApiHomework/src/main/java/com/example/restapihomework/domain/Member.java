package com.example.restapihomework.domain;

import lombok.Builder;
import lombok.Data;

@Data //Data 애노테이션을 사용하면 게터와 세터를 사용하지 않아도 됨.
public class Member {
    private Long id; //회원 아이디
    private String name; //회원 이름
    private String phoneNumber; //회원 전화번호
    private Boolean isEnrolled; //회원의 피티 신청 유무 True=="신청함"
    private String ptTeacherName; //회원의 담당 피티 선생님 이름

    @Builder
    public Member(Long id, String name, String phoneNumber, Boolean isEnrolled, String ptTeacherName){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isEnrolled = isEnrolled;
        this.ptTeacherName = ptTeacherName;
    }

    public void initId(Long id){ this.id = id; }
}