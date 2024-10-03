package com.example.restapistudy.service;

import com.example.restapistudy.domain.Music;
import com.example.restapistudy.dto.MusicDto;
import com.example.restapistudy.repository.MusicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {
    private final MusicRepository musicRepository;

    public MusicService(MusicRepository musicRepository) { // 생성자
        this.musicRepository = musicRepository;
    }

    public void saveMusic(MusicDto musicDto) { // 노래 정보 저장 메서드
        Music music = musicDto.toEntity();

        musicRepository.save(music);
    }

    public MusicDto findMusicById(Long id) { // 노래 찾기 메서드
        Music music = musicRepository.findById(id);

        return MusicDto.builder()
                .id(music.getId())
                .name(music.getName())
                .singer(music.getSinger())
                .count(music.getCount())
                .build();
    }

    // 여기서 왜 굳이 Music 객체의 리스트를 MusicDto 객체의 리스트로 바꿔서 다시 던지는거지?
    public List<MusicDto> findAllMusic() { // 노래 리스트 찾기 메서드
        return musicRepository.findAll()
                .stream()
                .map(music -> {
                    return MusicDto.builder()
                            .id(music.getId())
                            .name(music.getName())
                            .singer(music.getSinger())
                            .count(music.getCount())
                            .build();
                })
                .toList();
    }

    public void updateMusicById(Long id, MusicDto musicDto) { // 노래 업데이트 메서드
        Music music = musicDto.toEntity();
        music.initId(id);

        musicRepository.updateById(id, music);
    }

    public void deleteMusicById(Long id) { // 노래 삭제 메서드
        musicRepository.deleteById(id);
    }
}
