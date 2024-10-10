package com.example.restapistudy.repository;

import com.example.restapistudy.domain.Board;

import java.util.List;

public interface BoardRepository {

    void save(Board board); // 글 저장

    Board findById(Long id); // id 로 글 조회

    List<Board> findAll(); // 전체 글 목록 불러오기

    void updateById(Long id, Board board); // 글 수정

    void deleteById(Long id); // 글 삭제
}
