package com.example.restapistudy.repository;

import com.example.restapistudy.domain.Food;

import java.util.List;

/* 데이터에 접근하기 위한 구현할 메소드를 정의한다.
* 데이터를 처리하기 위해 CRUD메소드(save, findById, findAll, updateById, deleteById)를 정의한다.*/
public interface FoodRepository {
    void save(Food food); // Food객체를 저장한다. food는 Food의 객체를 가리킨다.

    Food findById(Long id); // ID로 Food객체를 조회한다.

    List<Food> findAll(); // 모든 Food객체를 조회한다.

    void updateById(Long id, Food food); //ID로 Food객체를 수정한다.

    void deleteById(Long id); // ID로 Foo객체를 삭제한다.

}
