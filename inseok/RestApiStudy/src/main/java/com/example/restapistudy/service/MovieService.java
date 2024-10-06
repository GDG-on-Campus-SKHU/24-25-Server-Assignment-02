package com.example.restapistudy.service;

import com.example.restapistudy.domain.Movie;
import com.example.restapistudy.repository.MovieRepository;
import com.example.restapistudy.dto.MovieDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public void saveMovie(MovieDto movieDto) {
        Movie movie = movieDto.toEntity();

        movieRepository.save(movie);
    }

    public MovieDto findMovieById(long id) {
        Movie movie = movieRepository.findById(id);

        return MovieDto.builder()
                .id(movie.getId())
                .title(movie.getTitle())
                .director(movie.getDirector())
                .year(movie.getYear())
                .genre(movie.getGenre())
                .rating(movie.getRating())
                .build();
    }

    public List<MovieDto> findAllMovies() {
        return movieRepository.findAll()
                .stream()
                .map(movie -> {
                    return MovieDto.builder()
                            .id(movie.getId())
                            .title(movie.getTitle())
                            .director(movie.getDirector())
                            .year(movie.getYear())
                            .genre(movie.getGenre())
                            .rating(movie.getRating())
                            .build();
                })
                .toList();
    }

    public void updateMovieById(long id, MovieDto movieDto) {
        Movie movie = movieDto.toEntity();
        movie.initID(id);

        movieRepository.updateById(id, movie);
    }

    public void deleteMovieById(long id) {
        movieRepository.deleteById(id);
    }
}
