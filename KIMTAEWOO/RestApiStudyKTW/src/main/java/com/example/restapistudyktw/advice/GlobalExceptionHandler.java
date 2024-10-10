package com.example.restapistudyktw.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
advice 디렉토리 : 횡단 관심사(cross-cutting concerns) 즉, 공통 관심사 처리를 담당하는 계층
Exception Handling 디렉토리로 만들기도 한다.
 */

// 스프링 어플리케이션 전반에 걸쳐 발생하는 예외를 처리할 수 있도록 해주는 어노테이션, @ControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler {

    // 개발자가 원하는 특정 예외를 잡아 처리할 수 있도록 해주는 어노테이션, @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleGeneralException(Exception e) {
        return new ResponseEntity<>("서버 에러가 발생해 작업을 실패했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
