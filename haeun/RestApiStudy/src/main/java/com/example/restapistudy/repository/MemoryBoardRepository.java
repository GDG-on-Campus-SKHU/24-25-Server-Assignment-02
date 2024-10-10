package com.example.restapistudy.repository;

import com.example.restapistudy.domain.Board;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BoardRepository 인터페이스 구현체
@Repository
public class MemoryBoardRepository implements BoardRepository{

    // 글 목록들을 저장할 컬렉션
    private static Map<Long,Board> store = new HashMap<>();

    @Override
    public void save(Board board) {
        store.put(board.getId(), board);
    }

    @Override
    public Board findById(Long id) {
       return store.get(id);
    }

    @Override
    public List<Board> findAll() { // 최신순으로 정렬
        return store.values().stream().sorted(Comparator.comparing(Board::getDate).reversed()).toList();
    }

    @Override
    public void updateById(Long id, Board board) {
        store.put(id, board);
    }

    @Override
    public void deleteById(Long id) {
        store.remove(id);
    }
}
