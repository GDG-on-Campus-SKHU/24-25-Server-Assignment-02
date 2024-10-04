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
        userService.saveUser(user);
        return new ResponseEntity<>("유저 저장 완료", HttpStatus.CREATED);

    }

    // userID로 유저 찾기
    @GetMapping("/user/{userId}")
    /*
    제네릭 와일드카드인 ? 를 사용해 성공시 User 객체 반환, 실패시 String 메세지 반환
    ? 는 ? extends Object 와 같은 일을 하지만, 스프링이 내부적으로 HttpMessageConverter 컴포넌트를 사용해
    적절한 형식으로 바꿔서 반환 해 준다.
    */
    // 찾기 성공시 userDto 반환, 실패시 안내문구 반환
    // 성공시 객체를 반환하고 실패시 예외 처리 로직을통해 String을 반환해야 하므로 ResponseEntity<?> 을 유지했습니다.
    public ResponseEntity<?> findUserByUserId(@PathVariable String userId) {
        UserDto userDto = userService.findUserByUserId(userId);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    // 전체 유저 조회
    @GetMapping("/user/list")
    // 조회 성공시 List<UserDto> 반환, 실패시 안내문구 반환
    public ResponseEntity<?> findAllUser() {
        List<UserDto> resultUsers = userService.findAllUsers();
        return new ResponseEntity<>(resultUsers, HttpStatus.OK);
    }

    // userId로 유저 정보 업데이트
    @PatchMapping("/user/{userId}")
    public ResponseEntity<String> updateUserByUserId(@PathVariable String userId, @RequestBody UserDto userDto) {
        userService.updateUserByUserId(userId, userDto);
        return new ResponseEntity<>("유저 정보 업데이트 성공", HttpStatus.OK);
    }

    // 유저 삭제
    @DeleteMapping("/user/{userId}")
    public ResponseEntity<String> deleteUserByUserId(@PathVariable String userId) {
        userService.deleteUserByUserId(userId);
        return new ResponseEntity<>("유저 삭제 성공", HttpStatus.OK);
    }
}

