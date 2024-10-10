package com.example.restapistudy.controller;

import com.example.restapistudy.dto.MovieDto;
import com.example.restapistudy.service.MovieService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RestController
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("movie") // 상영영화 저장
    public void save(@RequestBody MovieDto movieDto) {
        movieService.saveMovie(movieDto);
    }

    @GetMapping("movie/{id}") // 상영영화 검색
    public MovieDto findMovieById(@PathVariable Long id) {
        return movieService.findMovieById(id);
    }

    @GetMapping("movie/list") // 상영영화 전체 검색
    public List<MovieDto> findAllMovie() {
        return movieService.findAllMovies();
    }
    @PatchMapping("movie/{id}") // 상영영화 수정
    public void updateMovieById(@PathVariable Long id, @RequestBody MovieDto movieDto) {
        movieService.updateMovieById(id, movieDto);
    }

    @DeleteMapping("movie/{id}") // 상영영화 삭제
    public void deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovieById(id);
    }
}
