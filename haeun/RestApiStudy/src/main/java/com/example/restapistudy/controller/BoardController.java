package com.example.restapistudy.controller;


import com.example.restapistudy.dto.BoardDto;
import com.example.restapistudy.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {
    private final BoardService boardService;

    // 생성자 주입
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    // 게시글 저장
    @PostMapping("board")
    public void save(@RequestBody BoardDto boardDto){
        boardService.saveBoard(boardDto);
    }

    // 특정 게시글 조회
    @GetMapping("board/{id}")
    public BoardDto getBoard(@PathVariable Long id){
        return boardService.findBoardById(id);
    }
    // 전체 게시글 조회
    @GetMapping("board/list")
    public List<BoardDto> getBoardList(){
        return boardService.findAllBoards();
    }

    // 게시글 수정
    @PatchMapping("board/{id}")
    public void updateBoard(@PathVariable Long id, @RequestBody BoardDto boardDto){
         boardService.updateBoardById(id,boardDto);
    }

    // 게시글 삭제
    @DeleteMapping("board/{id}")
    public void deleteBoard(@PathVariable Long id){
        boardService.deleteBoardById(id);
    }

}
