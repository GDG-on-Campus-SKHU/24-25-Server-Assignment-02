package com.example.restapihomework.dto; //Data Transfer Object 데이터 전송 객체 패키지

import com.example.restapihomework.domain.Member;
import lombok.Builder;
import lombok.Data;

// API요청/응답에서 사용되는 데이터 포맷을 정의
@Data //lombok에서 제공하는 어노테이션으로 Getter Setter등 메서드를 자동으로 생성해줌
public class MemberDto {
    private Long id;
    private String name;
    private String phoneNumber;
    private Boolean isEnrolled;
    private String ptTeacherName;

    @Builder //빌더 패턴을 생성, 객체를 가독성있게 작성하도록 도와줌 필드값을 메서드 체이닝 방식으로 사용할 수 있음
    public MemberDto(Long id, String name, String phoneNumber, Boolean isEnrolled, String ptTeacherName) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.isEnrolled = isEnrolled;
        this.ptTeacherName = ptTeacherName;
    }

    //DTO 객체를 엔티티 객체로 변환
    public Member toEntity(){
        return Member.builder()
                .id(id)
                .name(name)
                .phoneNumber(phoneNumber)
                .isEnrolled(isEnrolled)
                .ptTeacherName(ptTeacherName)
                .build();

    }

}
