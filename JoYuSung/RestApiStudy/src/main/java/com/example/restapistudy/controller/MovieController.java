package com.example.restapistudy.controller;

import com.example.restapistudy.dto.MovieDto;
import com.example.restapistudy.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 컨트롤러는 클라이언트의 요청을 받아 처리하는 클래스지만 실질적인 데이터는 service계층에서 처리
// 컨트롤러는 요청과 응답에만 집중, 서비스계층은 비즈니스 로직에만 집중
@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    // 생성자 주입을 통해 의존성 주입
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // 영화 저장
    @PostMapping
    public void saveMovie(@RequestBody MovieDto movieDto) {
        movieService.saveMovie(movieDto);
    }

    // ID로 영화 찾기
    @GetMapping("/{id}")
    public MovieDto findMovieById(@PathVariable Long id) {
        return movieService.findMovieById(id);
    }

    // 모든 영화 리스트 찾기
    @GetMapping("/list")
    public List<MovieDto> findAllMovies() {
        return movieService.findAllMovies();
    }

    // 영화 수정
    @PatchMapping("/{id}")
    public void updateMovieById(@PathVariable Long id, @RequestBody MovieDto movieDto) {
        movieService.updateMovieById(id, movieDto);
    }

    // 영화 삭제
    @DeleteMapping("/{id}")
    public void deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovieById(id);
    }
}
