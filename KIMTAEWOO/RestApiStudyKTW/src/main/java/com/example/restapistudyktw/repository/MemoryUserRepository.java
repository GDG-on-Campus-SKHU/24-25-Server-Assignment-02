package com.example.restapistudyktw.repository;

import com.example.restapistudyktw.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
레포지토리 게층은 저장소의 역할에 충실해야 하기 때문에 도메인 객체를 있는 그대로 반환한다
단순히 데이터를 저장하거나 불러오는 역할만을 수행하며 이 과정에서 dto로 변환하거나 정보를 가공하지 않는다
 */
@Repository
public class MemoryUserRepository implements UserRepository {
    private static final Map<String, User> users = new HashMap<>();

    @Override
    public void save(User user) {
        users.put(user.getUserId(), user);
    }

    @Override
    public User findByUserId(String userId) {
        return users.get(userId);
    }

    /*
    정렬과 같은 작업은 서비스 게층에서 진행하는 것이 바람직하다고 생각해 정렬 작업은
    서비스 계층으로 넘겼고, 여기서는 리스트를 있는 그대로 반환하도록 함.
     */
    @Override
    public List<User> findAll() {
        return users.values()
                .stream()
                .toList();
    }

    @Override
    public void updateByUserId(String userId, User user) {
        users.put(userId, user);
    }

    @Override
    public void deleteById(String userId) {
        users.remove(userId);
    }

    @Override
    public boolean usersContainsUserId(String userId) {
        return users.containsKey(userId);
    }
}
