package com.example.restapistudyktw.domain;

import lombok.Builder;
import lombok.Getter;


@Getter
public class User {
    private String userId;
    private String userPassword;
    private String userPasswordConfirm;
    private String userName;
    private String userEmail;
    // 01093874115 의 형태로 작성시 1093874115로 처리되어 String 으로 선언
    private String userPhoneNumber;
    private int userAge;
    private String userAddress;

    @Builder
    public User (String userId, String userPassword, String userPasswordConfirm
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

}
