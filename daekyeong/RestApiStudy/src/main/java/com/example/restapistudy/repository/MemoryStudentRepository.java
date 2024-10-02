package com.example.restapistudy.repository;

import com.example.restapistudy.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryStudentRepository implements StudentRepository {
    private static Map<Long, Student> store = new HashMap<>(); //DB 흉내

    @Override
    public void save(Student student) {
        store.put(student.getId(), student);
    }

    @Override
    public Student findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Student> findAll() {
        return store.values().stream().toList();
    }

    @Override
    public void updateById(Long id, Student student) {
        if(store.containsKey(id)) // id가 없다면 update 불가
            store.put(id, student);
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }
}
