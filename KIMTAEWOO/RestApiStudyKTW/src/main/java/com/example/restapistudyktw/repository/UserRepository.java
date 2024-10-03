package com.example.restapistudyktw.repository;

import com.example.restapistudyktw.domain.User;

import java.util.List;

public interface UserRepository {
    void save(User user);

    User findByUserId(String userId);

    List<User> findAll();

    void updateByUserId(String userId, User user);

    void deleteById(String userId);

    boolean usersContainsUserId(String userId);
}
