package net.skhu.restapistudy.service;

import net.skhu.restapistudy.domain.Movie;
import net.skhu.restapistudy.dto.MovieDto;
import net.skhu.restapistudy.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
//for문 쓰는 곳
@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }

    public void saveMovie(MovieDto movieDto){
        Movie movie = movieDto.toEntity();

        movieRepository.save(movie);
    }
    public MovieDto findMovieById(Long id){
        Movie movie = movieRepository.findById(id);
        return MovieDto.builder()
                .id(movie.getId()) //movie 객체에 getId()
                .name(movie.getName())
                .genre(movie.getGenre())
                .count(movie.getCount())
                .build();
    }

    public List<MovieDto> findAllMovie(){
        return movieRepository.findAll()//데이터베이스에 저장된 영화 데이터 조회
                .stream()
                .map(movie -> {
                    return MovieDto.builder()
                            .id(movie.getId())
                            .name(movie.getName())
                            .genre(movie.getGenre())
                            .count(movie.getCount())
                            .build();
                })
                .toList(); //최종 결과를 리스트로 반환해줘야함. 꼭
    }

    public void updateMovieById(Long id, MovieDto movieDto){
        Movie movie = movieDto.toEntity();
        movie.initId(id);

        movieRepository.updateById(id, movie);
    }

    public void deleteMovieById(Long id){
        movieRepository.deleteById(id);
    }
}