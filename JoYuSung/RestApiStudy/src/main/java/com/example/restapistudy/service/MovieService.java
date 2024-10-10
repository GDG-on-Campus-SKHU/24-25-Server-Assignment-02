package com.example.restapistudy.service;

import com.example.restapistudy.domain.Movie;
import com.example.restapistudy.dto.MovieDto;
import com.example.restapistudy.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

// 비즈니스 로직을 처리하는 서비스계층, Repository계층의 중간다리 역할을 함
@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) { // 생성자
        this.movieRepository = movieRepository;
    }

    public void saveMovie(MovieDto movieDto) { // 영화 정보 저장 메서드
        Movie movie = movieDto.toEntity();

        movieRepository.save(movie);
    }

    public MovieDto findMovieById(Long id) { // 영화 찾기 메서드
        Movie movie = movieRepository.findById(id);

        return MovieDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .director(movie.getDirector())
                .audienceCount(movie.getAudienceCount()) // 관객 수를 audienceCount로 표현
                .build();
    }

    public List<MovieDto> findAllMovies() { // 영화 리스트 찾기 메서드
        return movieRepository.findAll()
                .stream()
                .map(movie -> {
                    return MovieDto.builder()
                            .id(movie.getId())
                            .title(movie.getTitle())
                            .director(movie.getDirector())
                            .audienceCount(movie.getAudienceCount()) // 관객 수
                            .build();
                })
                .toList();
    }

    public void updateMovieById(Long id, MovieDto movieDto) { // 영화 업데이트 메서드
        Movie movie = movieDto.toEntity();
        movie.initId(id);

        movieRepository.updateById(id, movie);
    }

    public void deleteMovieById(Long id) { // 영화 삭제 메서드
        movieRepository.deleteById(id);
    }
}
