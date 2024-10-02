package com.example.restapistudy.service;

import com.example.restapistudy.domain.Board;
import com.example.restapistudy.dto.BoardDto;
import com.example.restapistudy.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    // 생성자 주입
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }
    // 게시글 저장
    public void saveBoard(BoardDto boardDto) {
        Board board = boardDto.toEntity();
        boardRepository.save(board);
    }

    // 특정 게시글 조회
    public BoardDto findBoardById(Long id) {
        Board board = boardRepository.findById(id);
        return BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .date(board.getDate())
                .build();
    }

    // 전체 게시글 조회 - 최신순 정렬
    public List<BoardDto> findAllBoards() {
        return boardRepository.findAll()
                .stream()
                .map(board -> {
                    return BoardDto.builder()
                            .id(board.getId())
                            .title(board.getTitle())
                            .content(board.getContent())
                            .writer(board.getWriter())
                            .date(board.getDate())
                            .build();
                })
                .toList();
    }

    // 게시글 수정
    public void updateBoardById(Long id, BoardDto boardDto) {
        Board board = boardDto.toEntity();
        board.initId(id); // 엔터티로 변환시에 id 값 비어있으므로 재설정해줌
        boardRepository.updateById(id,board);
    }


    // 게시글 삭제
    public void deleteBoardById(Long id) {
        boardRepository.deleteById(id);
    }


}
