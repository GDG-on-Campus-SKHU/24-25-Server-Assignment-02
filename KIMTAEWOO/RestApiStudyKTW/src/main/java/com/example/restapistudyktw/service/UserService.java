package com.example.restapistudyktw.service;

import com.example.restapistudyktw.domain.User;
import com.example.restapistudyktw.dto.UserDto;
import org.springframework.stereotype.Service;
import com.example.restapistudyktw.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {

    /*
    - 제어의 역전(IOC) -
    인터페이스만 의존성 주입을 해 놓으면 스프링 컨테이너가 알아서 구현체를 찾아서 그것을 의존성 주입 해 준다.
    나중에 구현체만 갈아낄 수 있기 떄문에, 이로 인해 유연성이 엄청 좋아진다.
    이것은 개방-폐쇄 원칙(OCP)의 구현이기도 하다.
    - 개방-폐쇄 원칙 -
    기능 확장에는 열려 있고, 기존 코드 수정은 최소화하는 방식으로 코드를 설계한다는 원칙
     */
    UserRepository userRepository;

    //생성자를 통한 의존성 주입
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 유저 저장 혹은 정보 변경 전 정보를 검증하는 메서드
    /*
    verification : 무엇을 만드는 '과정' 을 잘 지켰는가?
    validation : 무언가를 최종적으로 만든 결과물이 잘 나왔는가?
     */
    public void verification(User user) {
        User existingUser = userRepository.findByUserId(user.getUserId());

        // 1. ID 중복 여부 확인 (똑같은 ID로 변경을 요청하는 경우는 허용)
        // 1-1. existingUser != null : 해당 userId가 이미 저장소에 존재하는지 확인. null이라면 이미 유저가 존재한다는 뜻이므로 예외 던짐
        // 1-2. !existingUser.getUserId().equals(user.getUserId())) : existingUser 와 user의 userId가 같다면, 이는 자기 자신의 userId를 수정하려는 경우이므로 통과시킴
        if (existingUser != null && !existingUser.getUserId().equals(user.getUserId())) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다");
        }

        // 2. 비밀번호, 비밀번호 확인 일치여부 확인
        if (!user.getUserPassword().equals(user.getUserPasswordConfirm())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }

    //유저 객체를 UserDto 객체로 변환해주는 메서드
    public UserDto UserToUserDto(User user) {
        return UserDto.builder()
                .userId(user.getUserId())
                .userPassword(user.getUserPassword())
                .userPasswordConfirm(user.getUserPasswordConfirm())
                .userName(user.getUserName())
                .userEmail(user.getUserEmail())
                .userPhoneNumber(user.getUserPhoneNumber())
                .userAge(user.getUserAge())
                .userAddress(user.getUserAddress())
                .build();
    }

    public void saveUser(User user) {
        verification(user);
        if(userRepository.usersContainsUserId(user.getUserId())) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다");
        }
        userRepository.save(user);
    }

    public UserDto findUserByUserId(String userId) {
        User user = userRepository.findByUserId(userId);
        if(user == null) {
            throw new IllegalArgumentException("유저를 찾을 수 없습니다");
        }

        return UserToUserDto(user);
    }

    /*
    책임의 분리를 위해 서비스 객체에서 정렬 과정 실행
     */
    public List<UserDto> findAllUsers() {
        List<UserDto> resultUsers = userRepository.findAll()
                .stream()
                // 계층 간 책임 분리를 위해 서비스 객체에서 정렬, UserId 기준 자연순
                .sorted(Comparator.comparing(User::getUserId))
                // 여기서 this 는 UserService를 의미한다.
                // 스트림의 각 요소를 User -> UserDto 로 변환
                .map(this::UserToUserDto)
                .toList();
        if(resultUsers.isEmpty()) {
            throw new IllegalArgumentException("조회되 유저가 없습니다");
        }

        return resultUsers;

    }

    public void updateUserByUserId(String userId, UserDto userDto) {
        User user = userDto.toEntity();
        if(!userRepository.usersContainsUserId(userId)) {
            throw new IllegalArgumentException("유저를 찾을 수 없습니다.");
        }
        verification(user);
        userRepository.updateByUserId(userId, user);

    }

    public void deleteUserByUserId(String userId) {
        if(userRepository.findByUserId(userId) == null) {
            throw new IllegalArgumentException("유저를 찾을 수 없습니다.");
        }
        userRepository.deleteById(userId);
    }
}
