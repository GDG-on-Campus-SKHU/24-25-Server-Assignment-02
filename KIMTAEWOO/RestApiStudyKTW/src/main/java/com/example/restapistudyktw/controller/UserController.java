package com.example.restapistudyktw.controller;

import org.springframework.web.bind.annotation.*;
import com.example.restapistudyktw.service.UserService;
import com.example.restapistudyktw.domain.User;
import com.example.restapistudyktw.dto.UserDto;

// ResponseEntity를 사용해 클라이언트에게 안내 문구와 상태 메세지를 직접 반환하기 위해 import함
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    // 생성자를 통한 의존성 주입
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 유저 저장
    @PostMapping("/user")
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        try {
            userService.saveUser(user);
            return new ResponseEntity<>("유저 저장 완료", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("서버 에러가 발생해 저장에 실패했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // userID로 유저 찾기
    @GetMapping("/user/{userId}")
    /*
    제네릭 와일드카드인 ? 를 사용해 성공시 User 객체 반환, 실패시 String 메세지 반환
    ? 는 ? extends Object 와 같은 일을 하지만, 스프링이 내부적으로 HttpMessageConverter 컴포넌트를 사용해
    적절한 형식으로 바꿔서 반환 해 준다.
    */
    // 찾기 성공시 userDto 반환, 실패시 안내문구 반환
    public ResponseEntity<?> findUserByUserId(@PathVariable String userId) {
        try {
            UserDto userDto = userService.findUserByUserId(userId);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            // 그외 오류시 공통 로유 메세지 반환
            return new ResponseEntity<>("서버 에러가 발생해 조회에 실패했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    // 전체 유저 조회
    @GetMapping("/user/list")
    // 조회 성공시 List<UserDto> 반환, 실패시 안내문구 반환
    public ResponseEntity<?> findAllUser() {
        try {
            List<UserDto> resultUsers = userService.findAllUsers();
            return new ResponseEntity<>(resultUsers, HttpStatus.OK);
        } catch(IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("서버 에러가 발생해 찾기에 실패했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // userId로 유저 정보 업데이트
    @PatchMapping("/user/{userId}")
    public ResponseEntity<String> updateUserByUserId(@PathVariable String userId, @RequestBody UserDto userDto) {
        try {
            userService.updateUserByUserId(userId, userDto);
            return new ResponseEntity<>("유저 정보 업데이트 성공", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("서버 에러가 발생해 업데이트에 실패했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 유저 삭제
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> deleteUserByUserId(@PathVariable String userId) {
        try {
            userService.deleteUserByUserId(userId);
            return new ResponseEntity<>("유저 삭제 성공", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("서버 에러가 발생해 삭제 실패했습니다", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

