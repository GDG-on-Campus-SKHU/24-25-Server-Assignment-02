package com.example.restapistudyktw.dto;

import com.example.restapistudyktw.domain.User;
import lombok.Builder;


/*
DTO 객체는 계층 간에 데이터를 전달하기 위해 사용되는 객체이다. DTO를 사용하는 이유는
1. 도메인 모델을 최대한 외부로 노출하지 않고, 필요한 데이터만 안전하게 전달하기 위해서이다.
2. 데이터의 구조가 변경되어도 도메인 객체를 건드리지 않을 수 있어 유연성과 확장성이 좋다
3. 클린 코드 관점에서 도메인 객체와 책임이 분리되 있기 때문에 사용하면 좋다
 */
public class UserDto {
    private String userId;
    private String userPassword;
    private String userPasswordConfirm;
    private String userName;
    private String userEmail;
    private String userPhoneNumber;
    private int userAge;
    private String userAddress;

    /*
    @Builder 어노테이션이 해주는 역할
    필드들을 단계별로 설정할 수 있는 '빌더 클래스' 생성
    이로 인해 원하는 필드의 값만 선택적으로 초기화한 객체 생성 가능
 G    */
    @Builder
    public UserDto (String userId, String userPassword, String userPasswordConfirm
            , String userName, String userEmail, String userPhoneNumber, int userAge, String userAddress) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userPasswordConfirm = userPasswordConfirm;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhoneNumber = userPhoneNumber;
        this.userAge = userAge;
        this.userAddress = userAddress;
    }

    // DIO(DTO) 객체를 User 객체로 변환하는 메소드.
    public User toEntity() {
        return User.builder()
                .userId(userId)
                .userPassword(userPassword)
                .userPasswordConfirm(userPasswordConfirm)
                .userName(userName)
                .userEmail(userEmail)
                .userPhoneNumber(userPhoneNumber)
                .userAge(userAge)
                .userAddress(userAddress)
                .build();
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserPasswordConfirm() {
        return userPasswordConfirm;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public int getUserAge() {
        return userAge;
    }

    public String getUserAddress() {
        return userAddress;
    }
}

