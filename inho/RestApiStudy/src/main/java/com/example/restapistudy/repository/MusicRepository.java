package com.example.restapistudy.repository;

import com.example.restapistudy.domain.Music;

import java.util.List;

public interface MusicRepository {
    void save(Music music);

    Music findById(Long id);

    List<Music> findAll();

    void updateById(Long id, Music music);

    void deleteById(Long id);
}
