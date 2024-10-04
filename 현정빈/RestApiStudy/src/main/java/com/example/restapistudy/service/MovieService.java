package com.example.restapistudy.service;

import com.example.restapistudy.domain.Movie;
import com.example.restapistudy.dto.MovieDto;
import com.example.restapistudy.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MovieService {
    private final MovieRepository movieRepository;
    //변경 불가능한 MovieRepository 타입으로 데이터 접근을 위한 의존성을 주입받기 위해 사용되는 필드

    //MovieService 생성자, MovieRepository 인터페이스 주입받아서 초기화
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository; // 생성자를 통해 의존성 주입
    }

    // 영화 정보 저장 메서드
    public void saveMovie(MovieDto movieDto) {
        Movie movie = movieDto.toEntity(); //Movie 객체 movie에 MovieDto 객체 movieDto 객체를 엔티티로 변환하여 저장
        movieRepository.save(movie); //review라는 저장소(hashmap)에 객체 movie 변환한 엔티티 저장
    }

    // 영화 찾기 메서드
    public MovieDto findMovieById(Long id) { //주어진 id로 영화 조회하여 MovieDto 타입 객체 반환
        Movie movie = movieRepository.findById(id); // movieRepository의 findById 메서드를 사용하여 review에 저장된 Movie 객체를 id로 조회하여 movie에 저장
        return MovieDto.builder() //MovieDto 객체 빌더 생성
                .id(movie.getId()) //movie의 id 값을 MovieDto의 id필드에 설정
                .title(movie.getTitle()) //movie의 title 값을 MovieDto의 title필드에 설정
                .director(movie.getDirector()) //movie의 director 값을 MovieDto의 director필드에 설정
                .releaseYear(movie.getReleaseYear()) //movie의 releaseyear 값을 MovieDto의 releaseyear필드에 설정
                .rating(movie.getRating()) //movie의 rating 값을 MovieDto의 releaseyear필드에 설정
                .build(); //설정된 값을 바탕으로 MovieDto 객체 생성 및 반환
    }

    // 영화 리스트 메서드
    public List<MovieDto> findAllMovies()
    { //저장소에 있는 모든 영화를 조회하여, MovieDto 객체의 리스트로 반환
        return movieRepository.findAll() //모든 Movie 객체를 조회
                .stream()
                .map(movie -> { //.map은 스트림의 각 요소를 지정된 방식으로 변환하여 새로운 스트림을 반환하는 메서드
                    return MovieDto.builder()
                            .id(movie.getId())
                            .title(movie.getTitle())
                            .director(movie.getDirector())
                            .releaseYear(movie.getReleaseYear())
                            .rating(movie.getRating())
                            .build();
                })//Movie 객체를 MovieDto 객체로 변환한 결과를 반환
                .toList(); //리스트 형태로 최종 반환
    }

    // 영화 업데이트 메서드
    public void updateMovieById(Long id, MovieDto movieDto)
    { //주어진 id와 movieDto를 사용하여 기존 객체를 업데이트
        Movie movie = movieDto.toEntity(); //Movie의 객체 movie에 MovieDto 객체인 movieDto를 엔티티로 변환하여 저장
        movie.initId(id); // 변환된 Movie 엔티티의 id 값을 주어진 id로 설정
        movieRepository.updateById(id, movie); // MovieRepository의 updateById() 메서드를 사용하여 id에 해당하는 Movie 엔티티를 새로운 값으로 업데이트
    }

    // 영화 삭제 메서드
    public void deleteMovieById(Long id)
    {
        movieRepository.deleteById(id); //movieRepository의 deleteById 메서드를 활용하여 주어진 id에 해당하는 객체를 review에서 삭제
    }
}
