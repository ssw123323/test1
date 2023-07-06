package com.example.demo.controller;

import com.example.demo.domain.Board;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
    //홈 화면 구성
    @GetMapping(value="/")
    public String home(Model model) {
        model.addAttribute("list", boardService.getAll());
        return "home";
    }
    //글쓰기 화면
    @GetMapping("/content/write")
    public String writePage(){
        return "write";
    }
    @PostMapping("/content/write")
    public String writeContent(Board board){
        LocalDateTime now=LocalDateTime.now();
        String formatDate=now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        board.setDate(formatDate);
        boardService.writeBoard(board);
        return "redirect:/";
    }
    //한 개의 글 보기 화면
    @GetMapping("/content/{id}")
    public String showBoard(@PathVariable int id, Model model){
        model.addAttribute("board", boardService.getOne(id));
        return "read";
    }
    //글 수정 화면
    @PostMapping("/content/{id}")
    public String editBoard(@PathVariable int id, Board board){
        boardService.editBoard(id, board.getContents());
        return "redirect:/";
    }
    //글 삭제
    @PostMapping("/content/delete/{id}")
    public String deleteBoard(@PathVariable int id, Board board) {
        boardService.deleteBoard(id);
        return "redirect:/";
    }
}
