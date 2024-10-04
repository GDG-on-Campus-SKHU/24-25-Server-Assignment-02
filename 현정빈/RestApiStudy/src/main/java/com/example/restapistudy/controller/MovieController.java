package com.example.restapistudy.controller;

import com.example.restapistudy.dto.MovieDto;
import com.example.restapistudy.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController
{
    private final MovieService movieService;

    // 생성자 주입
    public MovieController(MovieService movieService)
    {
        this.movieService = movieService;
    }

    // 영화 저장 post
    @PostMapping ("/movie")
    public void saveMovie(@RequestBody MovieDto movieDto)
    { //requestbody에 포함된 json 데이터를 Movie 객체로 변환하여 메서드 인수로 전달
        movieService.saveMovie(movieDto);
    }

    // 특정 영화 찾기 get
    @GetMapping("movie/{id}")
    public MovieDto findMovieById(@PathVariable Long id)
    { //@PathVariable은 URL 경로의 변수 값을 메서드의 파라미터로 매핑
        return movieService.findMovieById(id);
    }

    // 모든 영화 리스트 찾기 get
    @GetMapping("movie/list")
    public List<MovieDto> findAllMovies()
    {
        return movieService.findAllMovies();
    }

    // 특정 영화 수정 patch
    @PatchMapping("movie/{id}")
    public void updateMovieById(@PathVariable Long id, @RequestBody MovieDto movieDto)
    {
        movieService.updateMovieById(id, movieDto);
    }

    // 특정 영화 삭제 delete
    @DeleteMapping("movie/{id}")
    public void deleteMovieById(@PathVariable Long id)
    {
        movieService.deleteMovieById(id);
    }
}
