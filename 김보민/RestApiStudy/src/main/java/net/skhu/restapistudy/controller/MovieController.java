package net.skhu.restapistudy.controller;
//클라이언트에게 데이터를 받아서 서비스한테 넘겨줌

import net.skhu.restapistudy.domain.Movie;
import net.skhu.restapistudy.dto.MovieDto;
import net.skhu.restapistudy.service.MovieService;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//Controller에 ResponseBody가 추가된 것
//Json 형태로 데이터를 반환하는것
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService=movieService;
    }

    @PostMapping("movie")
    public void save(@RequestBody MovieDto movieDto){
        movieService.saveMovie(movieDto);
    }

    @GetMapping("movie/{id}")
    public MovieDto findMovieDto(@PathVariable Long id){
        return movieService.findMovieById(id);
    }

    @GetMapping("movie/list")
    public List<MovieDto> findAllMovie(){
        return movieService.findAllMovie();
    }

    @PatchMapping("movie/{id}")
    public void updateMovieById(@PathVariable Long id, @RequestBody MovieDto movieDto){
        movieService.updateMovieById(id, movieDto);
    }

    @DeleteMapping("movie/{id}")
    public void deleteMovieById(@PathVariable Long id){
        movieService.deleteMovieById(id);
    }
}
