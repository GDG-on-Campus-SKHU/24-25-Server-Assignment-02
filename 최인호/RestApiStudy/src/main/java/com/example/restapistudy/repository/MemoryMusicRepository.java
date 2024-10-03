package com.example.restapistudy.repository;

import com.example.restapistudy.domain.Music;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MemoryMusicRepository implements MusicRepository {
    private static Map<Long, Music> store = new HashMap<>(); //DB 흉내

    @Override // 입력 받은 id로 노래 저장.
    public void save(Music music) {
        store.put(music.getId(), music);
    }

    @Override // id(key)로 노래 찾기
    public Music findById(Long id) {
        return store.get(id);
    }

    @Override // 전체 리스트 찾기 (count 내림차순)
    public List<Music> findAll() {
        return store.values().stream().sorted(Comparator.comparing(Music::getCount).reversed()).toList();
    }

    @Override // 새로운 내용으로 초기화
    public void updateById(Long id, Music music) {
        store.put(id, music);
    }

    @Override // id(key)로 노래 삭제
    public void deleteById(Long id) {
        store.remove(id);
    }
}
