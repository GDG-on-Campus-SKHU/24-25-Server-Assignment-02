package com.example.restapistudy.controller;

import com.example.restapistudy.dto.MusicDto;
import com.example.restapistudy.service.MusicService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MusicController {
    private final MusicService musicService;

    //생성자 주입
    public MusicController(MusicService musicService) {
        this.musicService = musicService;
    }

    @PostMapping("music") //노래 저장
    public void save(@RequestBody MusicDto musicDto) {
        musicService.saveMusic(musicDto);
    }

    @GetMapping("music/{id}") // 노래 찾기
    public MusicDto findMusicById(@PathVariable Long id) {
        return musicService.findMusicById(id);
    }

    @GetMapping("music/list") // 노래 리스트 찾기
    public List<MusicDto> findAllMusic() {
        return musicService.findAllMusic();
    }

    @PatchMapping("music/{id}") // 노래 수정
    public void updateMusicById(@PathVariable Long id, @RequestBody MusicDto musicDto) {
        musicService.updateMusicById(id, musicDto);
    }

    @DeleteMapping("music/{id}") // 노래 삭제
    public void deleteMusicById(@PathVariable Long id) {
        musicService.deleteMusicById(id);
    }
}
