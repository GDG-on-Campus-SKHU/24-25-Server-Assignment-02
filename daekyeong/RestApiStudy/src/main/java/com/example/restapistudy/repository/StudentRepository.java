package com.example.restapistudy.repository;

import com.example.restapistudy.domain.Student;

import java.util.List;

public interface StudentRepository {
    void save(Student student);

    Student findById(Long id);

    List<Student> findAll();

    void updateById(Long id, Student student);

    void deleteById(Long id);
}
