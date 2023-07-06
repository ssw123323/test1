package com.example.demo.service;

import com.example.demo.domain.Board;
import com.example.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.processor.SpringUErrorsTagProcessor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    //글 작성
    public void writeBoard(Board board){
        boardRepository.save(board);
    }
    //글 수정
    public void editBoard(int id, String contents) {
        Board board=boardRepository.findById(id);
        board.setContents(contents);
        LocalDateTime now=LocalDateTime.now();
        String formatDate=now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        board.setDate(formatDate);
        boardRepository.edit(id, board);
    }
    //글 삭제
    public void deleteBoard(int id) {
        Board board=boardRepository.findById(id);
        boardRepository.delete(id);
    }
    //글 전체 조회
    public List<Board> getAll(){
        return boardRepository.findAll();
    }
    //글 하나만 id값으로 조회
    public Board getOne(int id){
        return boardRepository.findById(id);
    }
}
